package archidragoon.randomizer;

import legend.game.Menus;
import legend.game.SItem;
import legend.game.inventory.WhichMenu;
import legend.game.inventory.screens.MenuStack;
import legend.game.inventory.screens.MessageBoxScreen;

import java.util.List;

public class MessageManager {
  private List<String> messages;
  private boolean currentlyDisplaying;

  public MessageManager () {
    this.messages = List.of();
    this. currentlyDisplaying = false;
  }

  private void addMessage (final String message) {
    this.messages.add(message);

    if (this.currentlyDisplaying) {
      return;
    }

    // otherwise display message
    this.displayMessage(message);
  }

  public void displayMessage (final String message) {
    if (this.currentlyDisplaying) {
      return;
    }

    this.currentlyDisplaying = true;
    SItem.menuStack.pushScreen(new MessageBoxScreen(message, 0, _ -> {
      this.messages.removeFirst();
      if (!this.messages.isEmpty()) {
        // pop screen
        SItem.menuStack.popScreen();
        this.currentlyDisplaying = false;
        this.displayMessage(this.messages.getFirst());
      }

    }));
//    Menus.initMenu(WhichMenu.RENDER_NEW_MENU, () -> new MessageBoxScreen(message, 0, _ -> {
//      Menus.whichMenu_800bdc38 = WhichMenu.UNLOAD;
//    }));
  }
}
