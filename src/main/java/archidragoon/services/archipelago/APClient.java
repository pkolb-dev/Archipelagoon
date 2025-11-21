package archidragoon.services.archipelago;


import archidragoon.services.archipelago.events.ConnectionResult;
import io.github.archipelagomw.Client;
import io.github.archipelagomw.flags.ItemsHandling;

import java.net.URISyntaxException;


public class APClient extends Client {

  private final String gameName = "The Legend of Dragoon";
  private SlotData slotData;

  public APClient(final String address, final String slotName, final String password){
    super();
    this.setGame(this.gameName);
    this.setPassword(password);
    this.setName(slotName);
    try {
      this.connect(address);
    } catch(final URISyntaxException e) {
      // do nothing
    }
  }

  @Override
  public void onError(Exception e) {
    this.disconnect();
  }

  @Override
  public void onClose(String s, int i) {
    this.disconnect();
  }

  public SlotData getSlotData() {
    return this.slotData;
  }

  public void setSlotData(final SlotData slotData) {
    this.slotData = slotData;
  }
}