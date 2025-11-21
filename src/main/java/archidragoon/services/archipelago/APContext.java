package archidragoon.services.archipelago;

import io.github.archipelagomw.ItemManager;
import io.github.archipelagomw.LocationManager;

public class APContext {
  private static final APContext INSTANCE = new APContext();

  public static APContext getContext() {
    return INSTANCE;
  }

  private APClient client;


  public APClient getClient() {
    return this.client;
  }

  public void setClient(final APClient client) {
    if (client == this.client) {
      return;
    }

    this.client = client;
  }

  public ItemManager getItemManager() {
    return this.client.getItemManager();
  }

  public LocationManager getLocationManager() {
    return this.client.getLocationManager();
  }

  public int getTeam() {
    return this.client.getTeam();
  }

  public int getSlot() {
    return this.client.getSlot();
  }

  public SlotData getSlotData() {
    return this.client.getSlotData();
  }

  public boolean shouldRelease() {
    return false;
  }
}
