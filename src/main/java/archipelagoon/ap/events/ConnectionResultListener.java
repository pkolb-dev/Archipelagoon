package archipelagoon.ap.events;
import archipelagoon.ap.APContext;
import archipelagoon.data.SlotData;
import archipelagoon.screens.ArchipelagoConnectScreen;
import io.github.archipelagomw.events.ArchipelagoEventListener;
import io.github.archipelagomw.events.ConnectionResultEvent;
import io.github.archipelagomw.network.ConnectionResult;
import legend.core.GameEngine;
import legend.game.SItem;

import java.util.stream.Collectors;

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
    final SlotData slotData = event.getSlotData(SlotData.class);

    // TODO: once we pass mod version in, we can do this
//    if (!SlotData.EXPECTED_MOD_VERSIONS.contains(slotData.modVersion)) {
//      ctx.displayMessage("Mod is not compatible with generated world. Generated world version: " +
//        slotData.modVersion + ". Expected version one of " + SlotData.EXPECTED_MOD_VERSIONS.stream().map(Object::toString).collect(Collectors.joining(" or ")));
//      return;
//    }

    ctx.setSlotData(slotData);
    ctx.retrieveLocations();
  }
}
