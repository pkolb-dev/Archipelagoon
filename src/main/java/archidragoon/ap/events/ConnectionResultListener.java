package archidragoon.ap.events;
import archidragoon.ap.APContext;
import archidragoon.screens.ArchipelagoConnectScreen;
import io.github.archipelagomw.events.ArchipelagoEventListener;
import io.github.archipelagomw.events.ConnectionResultEvent;
import io.github.archipelagomw.network.ConnectionResult;
import legend.core.GameEngine;
import legend.game.SItem;

import static legend.game.FullScreenEffects.startFadeEffect;

public class ConnectionResultListener {

  @ArchipelagoEventListener
  public void onConnectionResult(final ConnectionResultEvent event) {
    if (event.getResult() == null) {
      return;
    }

    // TODO - I18n these strings
    final String msg = switch(event.getResult()) {
      case SlotAlreadyTaken -> "Slot already in use.";
      case Success -> "Connection Successful.";
      case InvalidSlot -> "Invalid Slot Name. Please make sure you typed it correctly.";
      case InvalidPassword -> "Invalid Password";
      case IncompatibleVersion -> "Server Rejected our connection due to an incompatible communication protocol.";
      case InvalidGame -> "Invalid Game. Check your slot.";
      default -> "Unknown Error";
    };

    if (event.getResult() != ConnectionResult.Success) {
      SItem.menuStack.pushScreen(new ArchipelagoConnectScreen(GameEngine.CONFIG, () -> {
        startFadeEffect(2, 10);
        SItem.menuStack.popScreen();
      }));
      return;
    }

    final APContext ctx = APContext.getContext();
    // TODO: fetch slot data from client later
    ctx.retrieveLocations();
  }
}
