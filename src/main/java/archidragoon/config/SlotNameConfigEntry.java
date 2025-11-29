package archidragoon.config;

import legend.game.saves.ConfigCategory;
import legend.game.saves.ConfigStorageLocation;
import legend.game.saves.StringConfigEntry;

public class SlotNameConfigEntry extends StringConfigEntry {
  public SlotNameConfigEntry(final String slot) {
    super(slot, 1, ConfigStorageLocation.CAMPAIGN, ConfigCategory.OTHER);
  }
}
