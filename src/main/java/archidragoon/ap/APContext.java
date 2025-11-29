package archidragoon.ap;

public class APContext {
  private static final APContext INSTANCE = new APContext();

  public static APContext getContext() {
    return INSTANCE;
  }

  private APClient client;

  public APClient getClient() {
    return this.client;
  }

  public void connect(final String address, final String slotName, final String password) {
    try {
      this.client = new APClient();
      this.client.connectToServer(address, slotName, password);
    } catch(final Exception e){
      // TODO handle
    }
  }
}
