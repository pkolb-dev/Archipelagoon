package archidragoon.data;

import legend.game.inventory.Good;
import legend.game.inventory.InventoryEntry;
import legend.game.inventory.ItemIcon;
import org.legendofdragoon.modloader.registries.RegistryId;

public class APGood implements InventoryEntry<APGood> {
  private final Good good;
  private final int price;

  public APGood (final Good good, final int price) {
    this.good = good;
    this.price = price;
  }

  @Override
  public RegistryId getRegistryId() {
    return this.good.getRegistryId();
  }

  @Override
  public ItemIcon getIcon() {
    return this.good.getIcon();
  }

  @Override
  public String getNameTranslationKey() {
    return this.good.getTranslationKey();
  }

  @Override
  public String getDescriptionTranslationKey() {
    return this.good.getTranslationKey();
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
