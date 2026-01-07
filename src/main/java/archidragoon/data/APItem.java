package archidragoon.data;

import legend.game.inventory.InventoryEntry;
import legend.game.inventory.Item;
import legend.game.inventory.ItemIcon;
import legend.game.inventory.ItemStack;
import org.legendofdragoon.modloader.registries.RegistryId;

import io.github.archipelagomw.flags.NetworkItem;

public class APItem extends Item implements InventoryEntry<APItem> {
  public final RegistryId severedChainsId;
  public final int apFlags;
  private final int price;
  private final String name;
  private final String playerName;

  public APItem(final int price, final RegistryId id, final int itemFlag, final String name, final String playerName) {
    super(APIcon.PRIORITY, price);
    this.severedChainsId = id;
    this.apFlags = itemFlag;
    this.price = price;
    this.name = name;
    this.playerName = playerName;
  }

  @Override
  public boolean canBeUsed( final ItemStack _stack,  final UsageLocation _location) {
    return false;
  }

  @Override
  public boolean canTarget( final ItemStack _stack,  final TargetType _type) {
    return false;
  }

  @Override
  public ItemIcon getIcon() {
    // is this considered an advancement?
    if ((this.apFlags & NetworkItem.ADVANCEMENT) != 0) {
      return APIcon.PRIORITY;
    }

    return APIcon.OTHER;
  }

  @Override
  public String getNameTranslationKey() {
    // this cannot be translated as this comes from other games potentially
    return this.name;
  }

  @Override
  public String getDescriptionTranslationKey() {
    // TODO: move this to string file
    if ((this.apFlags & NetworkItem.ADVANCEMENT) != 0) {
      // TODO: I18n this
      return "This item is considered an Advancement for %s".formatted(this.playerName);
    }

    if ((this.apFlags & NetworkItem.USEFUL) != 0) {
      return "This item is considered Useful for %s".formatted(this.playerName);
    }

    return "This item belongs to %s".formatted(this.playerName);
  }

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
