package archipelagoon.config;

import legend.game.saves.ConfigCategory;
import legend.game.saves.ConfigStorageLocation;

public class ItemIndexConfigEntry extends LongConfigEntry {
  public ItemIndexConfigEntry(final long index) {
    super(index, Long.MIN_VALUE, Long.MAX_VALUE, ConfigStorageLocation.SAVE, ConfigCategory.OTHER);
  }
}