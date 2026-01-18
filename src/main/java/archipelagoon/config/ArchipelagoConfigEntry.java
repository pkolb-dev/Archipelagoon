package archipelagoon.config;

import archipelagoon.Archipelagoon;
import archipelagoon.screens.ArchipelagoConnectScreen;
import legend.game.SItem;
import legend.game.i18n.I18n;
import legend.game.inventory.screens.controls.Button;
import legend.game.saves.ConfigCategory;
import legend.game.saves.ConfigEntry;
import legend.game.saves.ConfigStorageLocation;
import legend.game.saves.StringConfigEntry;
import org.legendofdragoon.modloader.registries.RegistryDelegate;

import java.util.List;
import java.util.Map;

import static legend.game.FullScreenEffects.startFadeEffect;

public class ArchipelagoConfigEntry extends ConfigEntry<Map<RegistryDelegate<StringConfigEntry>, List<String>>>{
  public ArchipelagoConfigEntry() {
    super(Map.of(), ConfigStorageLocation.CAMPAIGN, ConfigCategory.OTHER, ArchipelagoConfigEntry::serializer, ArchipelagoConfigEntry::deserializer);

    this.setEditControl((current, configCollection) -> {
      final Button button = new Button(I18n.translate(Archipelagoon.MOD_ID + ".config.archipelago.configure"));
      button.onPressed(() -> button.getScreen().getStack().pushScreen(new ArchipelagoConnectScreen(configCollection, () -> {
        startFadeEffect(2, 10);
        SItem.menuStack.popScreen();
      })));

      return button;
    });
  }

  private static byte[] serializer(final Map<RegistryDelegate<StringConfigEntry>, List<String>> registryDelegateListMap) {
    return new byte[0];
  }

  private static Map<RegistryDelegate<StringConfigEntry>, List<String>> deserializer( final byte[] data) {
    return Map.of();
  };

  @Override
  public boolean availableInBattle() {
    return false;
  }
}
