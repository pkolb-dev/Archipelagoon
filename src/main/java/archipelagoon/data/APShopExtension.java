package archipelagoon.data;

import legend.game.SItem;
import legend.game.i18n.I18n;
import legend.game.inventory.screens.MessageBoxScreen;
import legend.game.inventory.screens.ShopExtension;
import legend.game.inventory.screens.ShopScreen;
import legend.game.modding.events.inventory.ShopBuyEvent;
import legend.game.types.GameState52c;
import legend.game.types.MessageBoxResult;
import legend.game.types.MessageBoxType;
import legend.game.types.Shop;

import static legend.core.GameEngine.EVENTS;
import static legend.game.SItem.UI_TEXT;
import static legend.game.SItem.UI_TEXT_DISABLED;
import static legend.game.SItem.menuStack;
import static legend.game.SItem.renderNumber;
import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;
import static legend.game.Text.renderText;

public class APShopExtension extends ShopExtension<APInventoryEntry> {
  @Override
  public String getName(final ShopScreen.ShopEntry<APInventoryEntry> entry) {
    return "AP Item Store";
  }

  @Override
  public boolean accepts(final ShopScreen.ShopEntry<?> entry) {
    return entry.item instanceof APInventoryEntry;
  }

  @Override
  public void drawShopRow(final ShopScreen screen, final Shop shop, final GameState52c gameState, final ShopScreen.ShopEntry<APInventoryEntry> entry, final int index, final int x, final int y) {
    // TODO: this isn't updated after purchase.
    if(entry.item.isApplied) {
      renderText(I18n.translate(entry.item.getNameTranslationKey()), x + 20, y + 2, UI_TEXT_DISABLED);
    } else {
      renderText(I18n.translate(entry.item.getNameTranslationKey()), x + 20, y + 2, UI_TEXT);
    }

    renderNumber(x + 176, y + 4, entry.price, 2, 6);
    entry.item.renderIcon(x + 3, y, 0x8);
  }

  @Override
  public void drawShopDescription(final ShopScreen screen, final Shop shop, final GameState52c gameState, final ShopScreen.ShopEntry<APInventoryEntry> entry, final int x, final int y) {
    final String message = I18n.translate(entry.item.getDescriptionTranslationKey(), entry.item.playerName, entry.item.itemName);
    SItem.renderString(x, y, message, false);
  }

  @Override
  public boolean selectEntry(final ShopScreen screen, final Shop shop, final GameState52c gameState, final ShopScreen.ShopEntry<APInventoryEntry> entry, final int index) {
    if(entry.item.isApplied) {
      screen.deferAction(() -> menuStack.pushScreen(new MessageBoxScreen("Already purchased this item", MessageBoxType.ALERT, result -> {})));
    } else if(gameState_800babc8.gold_94 < entry.price) {
      screen.deferAction(() -> menuStack.pushScreen(new MessageBoxScreen(I18n.translate("lod_core.ui.shop.not_enough_gold"), MessageBoxType.ALERT, result -> {})));
    } else {
      menuStack.pushScreen(new MessageBoxScreen(I18n.translate("lod_core.ui.shop.buy", I18n.translate(entry.item.getNameTranslationKey())), MessageBoxType.CONFIRMATION, result -> {
        if(result == MessageBoxResult.YES) {
          entry.item.isApplied = true;
          gameState_800babc8.gold_94 -= entry.price;
          EVENTS.postEvent(new ShopBuyEvent(shop, entry.item));
        }
      }));
    }

    return false;
  }
}
