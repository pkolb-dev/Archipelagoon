package archidragoon;

import archidragoon.ap.APContext;
import archidragoon.ap.mapping.LocationState;
import archidragoon.ap.mapping.items.Items;
import archidragoon.ap.mapping.locations.Additions;
import archidragoon.ap.mapping.locations.Shops;
import archidragoon.config.ArchipelagoConfigEntry;
import archidragoon.config.ItemIndexConfigEntry;
import archidragoon.config.LocationStateRegistry;
import archidragoon.data.APGood;
import archidragoon.data.APItem;
import legend.core.GameEngine;
import legend.game.additions.Addition;
import legend.game.inventory.Equipment;
import legend.game.inventory.Good;
import legend.game.inventory.InventoryEntry;
import legend.game.inventory.Item;
import legend.game.inventory.ItemRegistryEvent;
import legend.game.inventory.ItemStack;
import legend.game.inventory.screens.ShopScreen;
import legend.game.modding.events.battle.BattleEndedEvent;
import legend.game.modding.events.battle.BattleStartedEvent;
import legend.game.modding.events.characters.AdditionUnlockEvent;
import legend.game.modding.events.gamestate.GameLoadedEvent;
import legend.game.modding.events.gamestate.GameStateEvent;
import legend.game.modding.events.gamestate.NewGameEvent;
import legend.game.modding.events.inventory.GiveGoodsEvent;
import legend.game.modding.events.inventory.GiveItemEvent;
import legend.game.modding.events.inventory.ScriptFlags1ChangedEvent;
import legend.game.modding.events.inventory.ScriptFlags2ChangedEvent;
import legend.game.modding.events.inventory.ShopContentsEvent;
import legend.game.modding.events.inventory.TakeGoodsEvent;
import legend.game.saves.ConfigCategory;
import legend.game.saves.ConfigEntry;
import legend.game.saves.ConfigRegistryEvent;
import legend.game.saves.ConfigStorageLocation;
import legend.game.saves.StringConfigEntry;
import legend.game.types.GameState52c;
import legend.lodmod.LodMod;
import org.legendofdragoon.modloader.Mod;
import org.legendofdragoon.modloader.events.EventListener;
import org.legendofdragoon.modloader.registries.Registrar;
import org.legendofdragoon.modloader.registries.RegistryDelegate;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.StreamSupport;

import static legend.core.GameEngine.EVENTS;

@Mod(id = ArchiDragoon.MOD_ID, version = "^3.0.0")
public class ArchiDragoon {

  public static final String MOD_ID = "archidragoon";
  public static RegistryId id(final String entryId) {
    return new RegistryId(MOD_ID, entryId);
  }

  private static final Registrar<ConfigEntry<?>, ConfigRegistryEvent> CONFIG_REGISTRAR = new Registrar<>(GameEngine.REGISTRIES.config, MOD_ID);
  private static final Registrar<Item, ItemRegistryEvent> ITEM_REGISTRAR = new Registrar<>(GameEngine.REGISTRIES.items, MOD_ID);

  public static final RegistryDelegate<ArchipelagoConfigEntry> ARCHIPELAGO_CONFIG = CONFIG_REGISTRAR.register("archipelago_config", ArchipelagoConfigEntry::new);
  public static final RegistryDelegate<StringConfigEntry> ADDRESS_CONFIG = CONFIG_REGISTRAR.register("address", () -> new StringConfigEntry("archipelago.gg:12345", 1, ConfigStorageLocation.CAMPAIGN, ConfigCategory.OTHER));
  public static final RegistryDelegate<StringConfigEntry> SLOT_NAME_CONFIG = CONFIG_REGISTRAR.register("slot_name", () -> new StringConfigEntry("", 1, ConfigStorageLocation.CAMPAIGN, ConfigCategory.OTHER));
  public static final RegistryDelegate<StringConfigEntry> PASSWORD_CONFIG = CONFIG_REGISTRAR.register("password", () -> new StringConfigEntry("", 1, ConfigStorageLocation.CAMPAIGN, ConfigCategory.OTHER));
  public static final RegistryDelegate<ItemIndexConfigEntry> LAST_ITEM_INDEX = CONFIG_REGISTRAR.register("last_item_index", () -> new ItemIndexConfigEntry(0));
  public static final RegistryDelegate<LocationStateRegistry> LOCATION_STATE_REGISTRY = CONFIG_REGISTRAR.register("location_states", LocationStateRegistry::new);

  private static final Logger LOGGER = Logger.getLogger(ArchiDragoon.class.getName());

  private GameState52c state;
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
    this.state = game.gameState;
    try {
      APContext.getContext().reconnect();
      // initialize shops?
    } catch(final URISyntaxException e) {
      // TODO ?
    }
  }

  @EventListener
  public void giveItem(final GiveItemEvent event) {
    final List<ItemStack> inventoryItems = StreamSupport
      .stream(event.inventory.spliterator(), false)
      .toList();

//    final List<ItemStack> limitedItems = randomizer.doItemCarryingLimit(inventoryItems, event.givenItems);
//
//    event.givenItems.clear();
//    event.givenItems.addAll(limitedItems);
  }

  @EventListener
  public void additionUnlock(final AdditionUnlockEvent event) {
    if (!event.additionStats.unlocked) {
      return;
    }

    final long apId = Additions.getAPLocationIdFromRegistryId(event.addition.getRegistryId());
    final List<LocationState> locationStates =GameEngine.CONFIG.getConfig(LOCATION_STATE_REGISTRY.get());
    final LocationState locationState = locationStates.stream()
      .filter(ls -> ls.getLocationID() == apId)
      .findFirst()
      .orElse(null);

    if (locationState == null || locationState.isApplied()) {
      return;
    }

    if (event.addition.isUnlocked(event.charData, event.additionStats)) {
      locationState.setApplied(true);
      APContext.getContext().checkAdditionLocation(event.addition.getRegistryId());
    }
  }

  @EventListener
  public void shopContents(final ShopContentsEvent event) {
    final List<Long> shopSlots = Shops.getShopLocationIds(event.shop.getRegistryId().entryId()).stream().toList();
    final List<LocationState> locationStates = GameEngine.CONFIG.getConfig(LOCATION_STATE_REGISTRY.get());
    final List<LocationState> slots = locationStates.stream()
      .filter(ls -> shopSlots.contains(ls.getLocationID())).toList();

    final List<ShopScreen.ShopEntry<InventoryEntry<?>>> adjustedContents = new ArrayList<>();
    int index = 0;
    for (final LocationState locationState : slots) {
      final String itemId = Items.getEntryIdFromAPItemId(locationState.getItemID());
      final RegistryId registryId = new RegistryId(LodMod.MOD_ID, itemId);
      final int price = event.contents.get(index).price;

      if (GameEngine.REGISTRIES.items.hasEntry(registryId)) {
        // this is an item from legend of dragoon
        final Item item = GameEngine.REGISTRIES.items.getEntry(registryId).get();
        adjustedContents.add(new ShopScreen.ShopEntry<>(new ItemStack(item), price));
      } else if (GameEngine.REGISTRIES.equipment.hasEntry(registryId)) {
        // this is equipment from legend of dragoon
        final Equipment equipment = GameEngine.REGISTRIES.equipment.getEntry(registryId).get();
        adjustedContents.add(new ShopScreen.ShopEntry<>(equipment, price));
      } else if (GameEngine.REGISTRIES.goods.hasEntry(registryId)) {
        // this is a good from legend of dragoon
        final Good good = GameEngine.REGISTRIES.goods.getEntry(registryId).get();
        adjustedContents.add(new ShopScreen.ShopEntry<>(new APGood(good, price), price));
      } else if (GameEngine.REGISTRIES.additions.hasEntry(registryId)) {
        // this is an addition from legend of dragoon
        final Addition addition = GameEngine.REGISTRIES.additions.getEntry(registryId).get();
        final APItem apItem = new APItem(price, registryId, locationState.getFlags(), locationState.getItemName(), locationState.getPlayerName());
        adjustedContents.add(new ShopScreen.ShopEntry<>(apItem, price));
      } else {
       // item exists outside of legend of dragoon
        final APItem apItem = new APItem(price, registryId, locationState.getFlags(), locationState.getItemName(), locationState.getPlayerName());
        adjustedContents.add(new ShopScreen.ShopEntry<>(apItem, price));
      }

      index++;
    }

    event.contents.clear();
    event.contents.addAll(adjustedContents);
  }

  @EventListener
  public void giveGood(final GiveGoodsEvent event) {
    // TODO: performCheck on good
  }

  @EventListener
  public void takeGood(final TakeGoodsEvent event) {
    // PK: goods can't be taken as archipelago doesn't let that happen
    event.takenGoods.clear();
  }

  @EventListener
  public void scriptFlag1(final ScriptFlags1ChangedEvent event) {
    // TODO: what are these flags?
  }

  @EventListener
  public void scriptFlag2(final ScriptFlags2ChangedEvent event) {
    // TODO: cross reference this with list of flags.
    // Supposedly contains chest data, might be able to cross-reference for checks?
  }

  @EventListener
  public void battleStarted(final BattleStartedEvent event) {
  }

  @EventListener
  public void battleEnded(final BattleEndedEvent event) {
//    print(event.battle.currentEnemyNames_800c69d0)
    // check currentEnemyNames_800c69d0 for "Commander" or other names
    // compare to current boss goal
    // if goal achieved,
     APContext.getContext().checkGoal();
  }

  @EventListener
  public void gameStateChanged(final GameStateEvent event) {
    this.state = event.gameState;
  }
}
