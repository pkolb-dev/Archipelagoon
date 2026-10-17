package archipelagoon.ap.events;

import archipelagoon.ap.APContext;
import archipelagoon.data.SlotData;
import archipelagoon.screens.ArchipelagoConnectScreen;
import io.github.archipelagomw.events.ArchipelagoEventListener;
import io.github.archipelagomw.events.ConnectionResultEvent;
import io.github.archipelagomw.network.ConnectionResult;
import legend.core.GameEngine;
import legend.game.SItem;
import legend.game.i18n.I18n;

import java.math.BigInteger;

import static legend.game.FullScreenEffects.startFadeEffect;

public class ConnectionResultListener {

  @ArchipelagoEventListener
  public void onConnectionResult(final ConnectionResultEvent event) {
    if(event.getResult() == null) {
      return;
    }

    final String msg = switch(event.getResult()) {
      case SlotAlreadyTaken -> "archipelagoon.connection.slot_already_taken";
      case Success -> "archipelagoon.connection.success"; // unused
      case InvalidSlot -> "archipelagoon.connection.invalid_slot";
      case InvalidPassword -> "archipelagoon.connection.invalid_password";
      case IncompatibleVersion -> "archipelagoon.connection.incompatible_version";
      case InvalidGame -> "archipelagoon.connection.invalid_game";
      default -> "archipelagoon.connection.unknown_error";
    };

    final APContext ctx = APContext.getContext();
    if(event.getResult() != ConnectionResult.Success) {
      SItem.menuStack.pushScreen(new ArchipelagoConnectScreen(GameEngine.CONFIG, () -> {
        startFadeEffect(2, 10);
        SItem.menuStack.popScreen();
      }));

      ctx.displayMessage(I18n.translate(msg));
      ctx.disconnect();
      return;
    }

    final SlotData slotData = event.getSlotData(SlotData.class);

    if(!SlotData.EXPECTED_MOD_VERSIONS.contains(slotData.getVersion())) {
      final String versionMessage = I18n.translate("archipelagoon.connection.unexpected_version") + slotData.getVersion();
      ctx.displayMessage(versionMessage);
      ctx.disconnect();
      return;
    }

    long seedName = new BigInteger(event.getSeedName()).longValue();
    seedName += event.getSlot();

    slotData.slotSeed = seedName;

    ctx.setSlotData(slotData);
    if(slotData.deathLink == 1) {
      ctx.enableDeathlink();
    }

    ctx.retrieveLocations();
    ctx.initAdditions(null);
    ctx.initMagic(null);
  }
}
