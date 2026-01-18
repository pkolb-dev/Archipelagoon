package archidragoon.ap;

import archidragoon.ap.mapping.goals.Goals;
import archidragoon.ap.mapping.locations.Additions;
import archidragoon.ap.mapping.locations.Enemies;
import archidragoon.ap.mapping.locations.Locations;
import archidragoon.data.SlotData;
import archidragoon.randomizer.MessageManager;
import io.github.archipelagomw.ClientStatus;
import io.github.archipelagomw.flags.ItemsHandling;
import io.github.archipelagomw.network.client.CreateAsHint;
import legend.core.GameEngine;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

import static archidragoon.ArchiDragoon.ADDRESS_CONFIG;
import static archidragoon.ArchiDragoon.PASSWORD_CONFIG;
import static archidragoon.ArchiDragoon.SLOT_NAME_CONFIG;
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

    final Map<Integer, String> goals = Goals.getStaticMap();
    final int goalId = APContext.getContext().getSlotData().completionCondition;
    if (Objects.equals(goals.get(goalId), encounterRegistryId.entryId())) {
      this.client.setGameState(ClientStatus.CLIENT_GOAL);
      return;
    }

    Enemies.findAPLocationId(encounterRegistryId)
      .ifPresent(this.client::checkLocation);
  }
}
