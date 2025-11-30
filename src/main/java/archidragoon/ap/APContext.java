package archidragoon.ap;

import java.net.URISyntaxException;

public class APContext {
  private static final APContext INSTANCE = new APContext();

  public static APContext getContext() {
    return INSTANCE;
  }

  private APClient client;

  public APClient getClient() {
    return this.client;
  }

  public void connect(final String address, final String slotName, final String password) throws URISyntaxException {
    this.client = new APClient();
    this.client.connectToServer(address, slotName, password);
  }

  public boolean isConnected() {
    if (this.client == null ) {
      return false;
    }

    return this.client.isConnected();
  }
}
