package archidragoon.config;

import legend.game.saves.ConfigCategory;
import legend.game.saves.ConfigStorageLocation;
import legend.game.saves.StringConfigEntry;

public class PasswordConfigEntry extends StringConfigEntry {
  public PasswordConfigEntry(final String password) {
    super(password, 1, ConfigStorageLocation.CAMPAIGN, ConfigCategory.OTHER);
  }
}
