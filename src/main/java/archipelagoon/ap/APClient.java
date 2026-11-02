package archipelagoon.ap;

import archipelagoon.ap.events.ConnectionResultListener;
import archipelagoon.ap.events.DeathLinkListener;
import archipelagoon.ap.events.LocationInfoListener;
import archipelagoon.ap.events.ReceiveItemListener;
import io.github.archipelagomw.Client;

import java.net.URISyntaxException;

public class APClient extends Client {

  public APClient() {
    super();
    final String gameName = "The Legend of Dragoon";
    this.setGame(gameName);
    this.registerDefaultListeners();
  }

  @Override
  public void onError(final Exception ex) {
    final String message = "An error has occurred:\n" + ex.getLocalizedMessage();
    APContext.getContext().displayMessage(message);
  }

  @Override
  public void onClose(final String Reason, final int attemptingReconnect) {
    client.disconnect();
  }

  public void connectToServer(final String host, final String slotName, final String password) throws URISyntaxException {
    this.setName(slotName);
    this.setPassword(password);
    this.connect(host);
  }

  public boolean isAlreadyChecked(final Long location) {
    return this.getLocationManager().getCheckedLocations().contains(location);
  }

  private void registerDefaultListeners() {
    this.getEventManager().registerListener(new ConnectionResultListener());
    this.getEventManager().registerListener(new DeathLinkListener());
    this.getEventManager().registerListener(new ReceiveItemListener());
    this.getEventManager().registerListener(new LocationInfoListener());
  }
}