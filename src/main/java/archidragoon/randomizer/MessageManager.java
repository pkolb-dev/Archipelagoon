package archidragoon.randomizer;

import archidragoon.ap.APContext;
import legend.game.SItem;
import legend.game.inventory.screens.MessageBoxScreen;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import static legend.game.SItem.menuStack;

public final class MessageManager {
  private MessageManager () {
  }

  private static final Deque<String> messageQueue = new ArrayDeque<>();
  private static boolean messageActive = false;

  public static void displayMessage(final String message) {
    if(message.isEmpty()) return;

    messageQueue.add(message);
    tryShowNextMessage();
  }

  private static void tryShowNextMessage() {
    if(messageActive || messageQueue.isEmpty()) return;

    messageActive = true;

    menuStack.pushScreen(new MessageBoxScreen(
      messageQueue.poll(),
      0,
      result -> {
        messageActive = false;
        tryShowNextMessage();
      }
    ));
  }
}
