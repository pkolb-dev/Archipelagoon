package archidragoon.services.archipelago.events;
import io.github.archipelagomw.events.ArchipelagoEventListener;
import io.github.archipelagomw.events.ConnectionResultEvent;

public class ConnectionResult {

  @ArchipelagoEventListener
  public void onConnectionResult(final ConnectionResultEvent event) {
    if (event.getResult() == null) {
      return;
    }

    final String msg = switch(event.getResult()) {
      case SlotAlreadyTaken -> "Slot already in use.";
      case Success -> "Connection Successful.";
      case InvalidSlot -> "Invalid Slot Name. Please make sure you typed it correctly.";
      case InvalidPassword -> "Invalid Password";
      case IncompatibleVersion -> "Server Rejected our connection due to an incompatible communication protocol.";
      default -> "Unknown Error";
    };

    // display msg in UI somehow.
    // print(msg);

    if (event.getResult() != io.github.archipelagomw.network.ConnectionResult.Success) {
      return;
    }

    // after connection, sync game state with slot data settings
    // SlotData slotData = event.getSlotData(SlotData.class);
  }
}
