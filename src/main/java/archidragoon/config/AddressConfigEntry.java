package archidragoon.config;

import legend.game.saves.ConfigCategory;
import legend.game.saves.ConfigStorageLocation;
import legend.game.saves.StringConfigEntry;

public class AddressConfigEntry extends StringConfigEntry {

  public AddressConfigEntry(final String address) {
    super(address, 1, ConfigStorageLocation.CAMPAIGN, ConfigCategory.OTHER);
  }
}
