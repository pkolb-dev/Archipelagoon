package archidragoon.ap;


import archidragoon.ap.events.ConnectionResult;
import io.github.archipelagomw.Client;

import java.net.URISyntaxException;


public class APClient extends Client {
  public APClient(){
    super();
    final String gameName = "The Legend of Dragoon";
    this.setGame(gameName);
    this.registerDefaultListeners();
  }

  @Override
  public void onError(final Exception ex) {
    // TODO pk
  }

  @Override
  public void onClose(final String Reason, final int attemptingReconnect) {
   // TODO pk
  }

  public void connectToServer(final String host, final String slotName, final String password) {
    this.setName(slotName);
    this.setPassword(password);
    try {
      this.connect(host);
    } catch (final URISyntaxException e) {
      // TODO handle this
    }
  }

  private void registerDefaultListeners() {
    this.getEventManager().registerListener(new ConnectionResult());
  }
}