package archipelagoon.data;

import legend.game.inventory.InventoryEntry;
import legend.game.inventory.Item;
import legend.game.inventory.ItemIcon;
import legend.game.inventory.ItemStack;
import org.legendofdragoon.modloader.registries.RegistryId;

import io.github.archipelagomw.flags.NetworkItem;

public class APPriorityItem extends Item implements InventoryEntry<APPriorityItem> {
  private final int price;

  public APPriorityItem(final int price) {
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

  @Override
  public ItemIcon getIcon() {
    return APIcon.PRIORITY;
  }

  @Override
  public String getNameTranslationKey() {

    return "archipelagoon.ap.priority.item";
  }

  @Override
  public String getDescriptionTranslationKey() {
    return "archipelagoon.ap.priority.item.description";
  }
//    // TODO: move this to string file
//    if ((this.apFlags & NetworkItem.ADVANCEMENT) != 0) {

//      return "This item is considered an advancement for another player";

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
