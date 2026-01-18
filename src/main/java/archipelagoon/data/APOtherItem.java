package archipelagoon.data;

import legend.game.inventory.InventoryEntry;
import legend.game.inventory.Item;
import legend.game.inventory.ItemIcon;
import legend.game.inventory.ItemStack;
import org.legendofdragoon.modloader.registries.RegistryId;

import io.github.archipelagomw.flags.NetworkItem;

public class APOtherItem extends Item implements InventoryEntry<APOtherItem> {
  private final int price;

  public APOtherItem(final int price) {
    super(APIcon.PRIORITY, price);
    this.price = price;
  }

  @Override
  public boolean canBeUsed(final ItemStack _stack,  final UsageLocation _location) {
    return false;
  }

  @Override
  public boolean canTarget(final ItemStack _stack,  final TargetType _type) {
    return false;
  }

  //  public ItemIcon getIcon() {
  //    // is this considered an advancement?
  //    if ((this.apFlags & NetworkItem.ADVANCEMENT) != 0) {
  //      return APIcon.PRIORITY;
  //    }
  //
  //    return APIcon.OTHER;
  //  }

  @Override
  public ItemIcon getIcon() {
    return APIcon.OTHER;
  }

  @Override
  public String getNameTranslationKey() {
    return "archipelago.ap.other.item";
  }

  @Override
  public String getDescriptionTranslationKey() {
    return "archipelago.ap.other.item.description";
  }

  //    if ((this.apFlags & NetworkItem.USEFUL) != 0) {
  //      return "This item is considered Useful for %s".formatted(this.playerName);
  //    }
  //  }

  @Override
  public int getBuyPrice() { return this.price; }

  @Override
  public int getSellPrice() { return this.price; }

  @Override
  public int getSize() {
    return 1;
  }

  @Override
  public int getMaxSize() {
    return 1;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }
}
