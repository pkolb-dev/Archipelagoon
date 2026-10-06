package archipelagoon.randomizer;

import archipelagoon.ap.APContext;
import archipelagoon.ap.mapping.LocationState;
import archipelagoon.ap.mapping.locations.Shops;
import archipelagoon.data.APInventoryEntry;
import archipelagoon.data.APShopEntry;
import archipelagoon.data.SlotData;
import legend.core.GameEngine;
import legend.game.inventory.InventoryEntry;
import legend.game.inventory.ItemStack;
import legend.game.inventory.screens.ShopScreen;
import legend.game.types.Shop;
import legend.lodmod.LodShops;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static archipelagoon.Archipelagoon.LOCATION_STATE_REGISTRY;
import static legend.lodmod.LodItems.ANGELS_PRAYER;
import static legend.lodmod.LodItems.BODY_PURIFIER;
import static legend.lodmod.LodItems.HEALING_POTION;
import static legend.lodmod.LodItems.MIND_PURIFIER;

public final class ShopManager {
  private static final ShopManager INSTANCE = new ShopManager();

  private ShopManager() {
  }

  public static ShopManager getInstance() {
    return INSTANCE;
  }

  public static int getItemPrice(final Random rand, final double weight) {
    final APContext ctx = APContext.getContext();
    final SlotData slotData = ctx.getSlotData();

    final int min = slotData.minimumShopPrice;
    final int max = slotData.maximumShopPrice + 1;

    return (int)(rand.nextInt(min, max) * weight);
  }

  public static int getItemPrice(final Random rand) {
    return getItemPrice(rand, 1);
  }

  public List<ShopScreen.ShopEntry<?>> getRepeatConsumables() {
    final APContext ctx = APContext.getContext();
    final SlotData slotData = ctx.getSlotData();
    if(slotData.allowRepeatConsumables == 0) {
      return List.of();
    }

    final List<ShopScreen.ShopEntry<?>> entries = new ArrayList<>();

    final InventoryEntry<?> angelsPrayer = new ItemStack(ANGELS_PRAYER.get());
    final InventoryEntry<?> healingPotion = new ItemStack(HEALING_POTION.get());
    final InventoryEntry<?> mindPurifier = new ItemStack(MIND_PURIFIER.get());
    final InventoryEntry<?> bodyPurifier = new ItemStack(BODY_PURIFIER.get());

    entries.add(new ShopScreen.ShopEntry<>(angelsPrayer, angelsPrayer.getBuyPrice()));
    entries.add(new ShopScreen.ShopEntry<>(healingPotion, healingPotion.getBuyPrice()));
    entries.add(new ShopScreen.ShopEntry<>(mindPurifier, mindPurifier.getBuyPrice()));
    entries.add(new ShopScreen.ShopEntry<>(bodyPurifier, bodyPurifier.getBuyPrice()));
    return entries;
  }

  public List<ShopScreen.ShopEntry<?>> getShopItems(final Shop shop) {
    final APContext ctx = APContext.getContext();
    final SlotData slotData = ctx.getSlotData();

    final int numberOfSlots = slotData.getShopSlots(shop.getRegistryId());
    final List<Long> shopSlots = Shops.getShopLocationIds(shop.getRegistryId().toString()).stream().limit(numberOfSlots).toList();
    final List<LocationState> slots = GameEngine.CONFIG.getConfig(LOCATION_STATE_REGISTRY.get()).stream()
      .filter(ls -> shopSlots.contains(ls.getLocationID())).toList();

    final List<ShopScreen.ShopEntry<?>> entries = new ArrayList<>();

    final int shopSeed = Shops.getShopIndex(shop.getRegistryId().toString());
    final Random rand = new Random(slotData.slotSeed + shopSeed);
    final double weight = Math.pow(rand.nextDouble(), 3);

    for(final LocationState locationState : slots) {
      final int price;

      if(shop.getRegistryId() == LodShops.FOREST_ITEM_SHOP.getId()) {
        price = getItemPrice(rand, weight);
      } else if(shop.getRegistryId() == LodShops.HELLENA_01_ITEM_SHOP.getId()) {
        price = getItemPrice(rand, weight);
      } else if(shop.getRegistryId() == LodShops.HELLENA_02_ITEM_SHOP.getId()) {
        price = getItemPrice(rand, weight);
      } else {
        price = getItemPrice(rand);
      }

      // moved down here to keep costs matched with the appropriate item
      if(locationState.isApplied()) {
        continue;
      }

      final APInventoryEntry entry = new APInventoryEntry(locationState);
      entries.add(new APShopEntry(entry, price));
    }

    return entries;
  }
}
