package archipelagoon.data;

import legend.game.inventory.Item;
import legend.game.inventory.ItemIcon;
import legend.game.inventory.ItemStack;
import legend.game.inventory.UseItemResponse;
import legend.game.modding.coremod.CoreMod;
import org.legendofdragoon.modloader.registries.RegistryId;

public class APStack extends ItemStack {
  private final APGood good;
  public APStack(final APGood good, final APPriorityItem item) {
    super(item, 1, 1);
    this.good = good;
  }

  @Override
  public RegistryId getRegistryId() {
    return this.good.getRegistryId();
  }

  @Override
  public int getSize() {
    return 1;
  }

  @Override
  public int getMaxSize() {
    return 1;
  }

  @Override
  public ItemStack setSize(final int size) {
    if(this.isEmpty()) {
      return EMPTY;
    }

    return this;
  }

  @Override
  public boolean hasDurability() {
    return false;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }


  @Override
  public ItemIcon getIcon() {
    return this.good.getIcon();
  }

  @Override
  public String getNameTranslationKey() {
    return this.good.getNameTranslationKey();
  }

  @Override
  public String getDescriptionTranslationKey() {
    return this.good.getDescriptionTranslationKey();
  }

  @Override
  public int getBuyPrice() {
    return this.good.getBuyPrice();
  }

  @Override
  public int getSellPrice() {
    return this.good.getSellPrice();
  }

  /** Item can't be stolen by enemies */
  @Override
  public boolean isProtected() {
    return true;
  }

  /** Item is returned after battle */
  @Override
  public boolean isRepeat() {
    return true;
  }

  /** Check if an item can ever be used in this location */
  @Override
  public boolean canBeUsed(final Item.UsageLocation location) {
    return false;
  }

  /** Check if an item can be used in this location right now */
  @Override
  public boolean canBeUsedNow(final Item.UsageLocation location) {
    return false;
  }

  @Override
  public boolean canTarget(final Item.TargetType type) {
    return false;
  }

  @Override
  public void useInMenu(final UseItemResponse response, final int charId) {  }

  /** If you implement this, you have to implement {@link #calculateStatMod} */
  @Override
  public boolean isStatMod() {
    return false;
  }

  private static final class Empty extends ItemStack {
    public Empty() {
      super(CoreMod.NOTHING.get());
    }

    @Override
    public boolean isEmpty() {
      return true;
    }
  }
}
