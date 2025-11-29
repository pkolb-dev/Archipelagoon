package archidragoon;

import archidragoon.config.AddressConfigEntry;
import archidragoon.config.ArchipelagoConfigEntry;
import archidragoon.config.PasswordConfigEntry;
import archidragoon.config.SlotNameConfigEntry;
import legend.core.GameEngine;
import legend.game.inventory.ItemRegistryEvent;
import legend.game.modding.events.characters.AdditionUnlockEvent;
import legend.game.modding.events.gamestate.GameLoadedEvent;
import legend.game.modding.events.gamestate.NewGameEvent;
import legend.game.modding.events.inventory.GiveItemEvent;
import legend.game.saves.ConfigEntry;
import legend.game.saves.ConfigRegistryEvent;
import org.legendofdragoon.modloader.Mod;
import org.legendofdragoon.modloader.events.EventListener;
import org.legendofdragoon.modloader.registries.Registrar;
import org.legendofdragoon.modloader.registries.RegistryDelegate;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.logging.Logger;

import static legend.core.GameEngine.EVENTS;

@Mod(id = ArchiDragoon.MOD_ID, version = "^3.0.0")
public class ArchiDragoon {

  public static final String MOD_ID = "archidragoon";
  public static RegistryId id(final String entryId) {
    return new RegistryId(MOD_ID, entryId);
  }

  private static final Registrar<ConfigEntry<?>, ConfigRegistryEvent> CONFIG_REGISTRAR = new Registrar<>(GameEngine.REGISTRIES.config, MOD_ID);

  public static final RegistryDelegate<ArchipelagoConfigEntry> ARCHIPELAGO_CONFIG = CONFIG_REGISTRAR.register("archipelago_config", ArchipelagoConfigEntry::new);
  public static final RegistryDelegate<AddressConfigEntry> ADDRESS_CONFIG = CONFIG_REGISTRAR.register("address", () -> new AddressConfigEntry(""));
  public static final RegistryDelegate<SlotNameConfigEntry> SLOT_NAME_CONFIG = CONFIG_REGISTRAR.register("slot_name", () -> new SlotNameConfigEntry(""));
  public static final RegistryDelegate<PasswordConfigEntry> PASSWORD_CONFIG = CONFIG_REGISTRAR.register("password", () -> new PasswordConfigEntry(""));

  private static final Logger LOGGER = Logger.getLogger(ArchiDragoon.class.getName());

  public ArchiDragoon() {
    EVENTS.register(this);
  }

  @EventListener
  public void registerItems(final ItemRegistryEvent event) {
    // do stuff when registering items
    // TODO
  }

  @EventListener
  public void gameConfig(final ConfigRegistryEvent event) {
    CONFIG_REGISTRAR.registryEvent(event);
  }

  @EventListener
  public void newGame(final NewGameEvent event) {
    // TODO
    // do stuff for new game
  }

  @EventListener
  public void gameLoaded(final GameLoadedEvent game) {
    // TODO
    // try to connect to AP here?
    // show ArchipelagoConnectScreen
    // do stuff on game load
  }

  @EventListener
  public void giveItem(final GiveItemEvent event) {
    // TODO
    // check given items in AP?
  }

  @EventListener
  public void additionUnlock(final AdditionUnlockEvent addition) {
    // TODO
    // perform check!
  }
}
