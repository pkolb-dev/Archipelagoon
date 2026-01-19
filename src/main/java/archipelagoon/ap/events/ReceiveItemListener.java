package archipelagoon.ap.events;

import archipelagoon.ap.APContext;
import archipelagoon.ap.mapping.items.Items;
import io.github.archipelagomw.events.ArchipelagoEventListener;
import io.github.archipelagomw.events.ReceiveItemEvent;
import legend.core.GameEngine;
import legend.game.SItem;
import legend.game.additions.Addition;
import legend.game.additions.CharacterAdditionStats;
import legend.game.inventory.Equipment;
import legend.game.inventory.Good;
import legend.game.inventory.Item;
import legend.game.types.CharacterData2c;
import legend.lodmod.LodMod;
import org.legendofdragoon.modloader.registries.RegistryId;

import static archipelagoon.Archipelagoon.LAST_ITEM_INDEX;
import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;

public class ReceiveItemListener {
  @ArchipelagoEventListener
  public void onReceiveItem(final ReceiveItemEvent event) {

    final long lastItemReceivedIndex = GameEngine.CONFIG.getConfig(LAST_ITEM_INDEX.get());
    if (event.getIndex() > lastItemReceivedIndex) {
      final long apItemId = event.getItemID();
      final String itemId = Items.getEntryIdFromAPItemId(apItemId);
      final RegistryId registryId = new RegistryId(LodMod.MOD_ID, itemId);

      // update index
      GameEngine.CONFIG.setConfig(LAST_ITEM_INDEX.get(), event.getIndex());

      // give to player
      if (GameEngine.REGISTRIES.items.hasEntry(registryId)) {
        final Item item = GameEngine.REGISTRIES.items.getEntry(registryId).get();
        SItem.giveItem(item);
      } else if (GameEngine.REGISTRIES.equipment.hasEntry(registryId)) {
        final Equipment equipment = GameEngine.REGISTRIES.equipment.getEntry(registryId).get();
        SItem.giveEquipment(equipment);
      } else if (GameEngine.REGISTRIES.goods.hasEntry(registryId)) {
        final Good good = GameEngine.REGISTRIES.goods.getEntry(registryId).get();
        gameState_800babc8.goods_19c.give(good);
      } else if (GameEngine.REGISTRIES.additions.hasEntry(registryId)) {
        for(int charIndex = 0; charIndex < 9; charIndex++) {
          final CharacterData2c charData = gameState_800babc8.charData_32c[charIndex];
          if (charData.additionStats.get(registryId) == null) {
            continue;
          }

          final Addition addition = GameEngine.REGISTRIES.additions.getEntry(registryId).get();
          final CharacterAdditionStats additionStats = charData.additionStats.get(addition.getRegistryId());

          additionStats.unlocked = true;
        }
      }

      // queue message
      final String message = String.format("Received %s\nfrom %s", event.getItemName(), event.getPlayerName());
      APContext.getContext().displayMessage(message);
    }
  }
}
