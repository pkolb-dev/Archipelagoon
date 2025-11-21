package archidragoon;

import legend.core.GameEngine;
import legend.game.characters.Element;
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

import static legend.game.combat.Battle.characterElements_800c706c;

import static legend.core.GameEngine.EVENTS;

@Mod(id = ArchiDragoon.MOD_ID, version = "^3.0.0")
public class ArchiDragoon {
  public static final String MOD_ID = "archidragoon";
  public static RegistryId id(final String entryId) {
    return new RegistryId(MOD_ID, entryId);
  }

  private static final Registrar<ConfigEntry<?>, ConfigRegistryEvent> CONFIG_REGISTRAR = new Registrar<>(GameEngine.REGISTRIES.config, MOD_ID);

  private final RegistryDelegate<Element>[] characterElementsUnmodified = characterElements_800c706c.clone();

  public ArchiDragoon() {
    EVENTS.register(this);
  }

  @EventListener
  public void registerItems(final ItemRegistryEvent event) {
    // do stuff when registering items
  }

  @EventListener
  public void gameConfig(final ConfigRegistryEvent event) {
    CONFIG_REGISTRAR.registryEvent(event);
  }

  @EventListener
  public void newGame(final NewGameEvent event) {
    // do stuff for new game
  }

  @EventListener
  public void gameLoaded(final GameLoadedEvent game) {
    // try to connect to AP here?
    // do stuff on game load
  }

  @EventListener
  public void giveItem(final GiveItemEvent event) {
    // check given items in AP?
  }

  @EventListener
  public void additionUnlock(final AdditionUnlockEvent addition) {
    // perform check!
  }
}
