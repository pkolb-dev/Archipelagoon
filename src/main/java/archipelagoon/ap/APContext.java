package archipelagoon.ap;

import archipelagoon.ap.mapping.LocationState;
import archipelagoon.ap.mapping.goals.Goals;
import archipelagoon.ap.mapping.locations.Additions;
import archipelagoon.ap.mapping.locations.Enemies;
import archipelagoon.ap.mapping.locations.Locations;
import archipelagoon.data.SlotData;
import archipelagoon.randomizer.MessageManager;
import io.github.archipelagomw.ClientStatus;
import io.github.archipelagomw.flags.ItemsHandling;
import io.github.archipelagomw.network.client.CreateAsHint;
import legend.core.GameEngine;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static archipelagoon.Archipelagoon.ADDRESS_CONFIG;
import static archipelagoon.Archipelagoon.LOCATION_STATE_REGISTRY;
import static archipelagoon.Archipelagoon.PASSWORD_CONFIG;
import static archipelagoon.Archipelagoon.SLOT_NAME_CONFIG;
public class APContext {
  private static final APContext INSTANCE = new APContext();
  private APClient client;
  private SlotData slotData;

  public APContext () {}

  public static APContext getContext() {
    return INSTANCE;
  }

  public void displayMessage(final String message) {
    MessageManager.displayMessage(message);
  }

  public void reconnect() throws URISyntaxException {
    this.client = new APClient();
    final String address = GameEngine.CONFIG.getConfig(ADDRESS_CONFIG.get());
    final String slotName = GameEngine.CONFIG.getConfig(SLOT_NAME_CONFIG.get());
    final String password = GameEngine.CONFIG.getConfig(PASSWORD_CONFIG.get());
    this.connect(address, slotName, password);
  }

  public void connect(final String address, final String slotName, final String password) throws URISyntaxException {
    this.client = new APClient();
    this.client.connectToServer(address, slotName, password);
    this.client.setItemsHandlingFlags(ItemsHandling.SEND_ITEMS + ItemsHandling.SEND_OWN_ITEMS + ItemsHandling.SEND_STARTING_INVENTORY);
  }

  public boolean isConnected() {
    if (this.client == null) {
      return false;
    }

    return this.client.isConnected();
  }

  public void triggerDeathFromAP() {
    // TODO: figure out how to deathlink
  }

  public void checkAdditionLocation(final RegistryId event_id) {
    this.client.checkLocation(Additions.getAPLocationIdFromRegistryId(event_id));
  }

  public void retrieveLocations() {
    final ArrayList<Long> locationIDs = new ArrayList<>(Locations.getStaticMap().keySet());
    final var result = this.client.scoutLocations(locationIDs, CreateAsHint.NO);
  }

  public SlotData getSlotData() {
    return this.slotData;
  }

  public void setSlotData(final SlotData slotData) {
    this.slotData = slotData;
  }

  public void checkEncounter(final RegistryId encounterRegistryId) {
    if (encounterRegistryId == null) {
      return;
    }

    final Map<String, Long> thing = Enemies.getStaticReverseMap();

    if (!thing.containsKey(encounterRegistryId.entryId())) {
      return;
    }

    final long apId = Enemies.getAPLocationIdFromRegistryId(encounterRegistryId);
    final List<LocationState> locationStates = GameEngine.CONFIG.getConfig(LOCATION_STATE_REGISTRY.get());
    final LocationState locationState = locationStates.stream()
      .filter(ls -> ls.getLocationID() == apId)
      .findFirst()
      .orElse(null);

    if (locationState == null) {
      return;
    }

    if (locationState.isApplied()) {
      return;
    }

    final Long location = Enemies.getAPLocationIdFromRegistryId(encounterRegistryId);
    if (location != null) {
      this.client.checkLocation(location);
    }

    final Map<Integer, String> goals = Goals.getStaticMap();
    final int goalId = APContext.getContext().getSlotData().completionCondition;

    if (Objects.equals(goals.get(goalId), encounterRegistryId.entryId())) {
      this.client.setGameState(ClientStatus.CLIENT_GOAL);
    }
  }

  public List<Long> getReceivedItemIDs() {
    return this.client.getItemManager().getReceivedItemIDs();
  }
}
