package archipelagoon.ap.mapping;

import io.github.archipelagomw.parts.NetworkItem;

public class LocationState {
  private long itemID;
  private final long locationID;
  private int playerID;
  private int flags;
  private boolean applied; // optional, tracks if game logic has consumed it
  private final String playerName;
  private final String itemName;

  public LocationState(final long locationID, final long itemID, final int playerID, final int flags, final boolean applied, final String playerName, final String itemName) {
    this.itemID = itemID;
    this.locationID = locationID;
    this.playerID = playerID;
    this.flags = flags;
    this.applied = applied;
    this.playerName = playerName;
    this.itemName = itemName;
  }

  public LocationState(final NetworkItem item, final boolean applied) {
    this.itemID = item.itemID;
    this.locationID = item.locationID;
    this.playerID = item.playerID;
    this.flags = item.flags;
    this.applied = applied;
    this.playerName = item.playerName;
    this.itemName = item.itemName;
  }

  // getters and setters
  public long getLocationID() { return this.locationID; }
  public long getItemID() { return this.itemID; }
  public int getPlayerID() { return this.playerID; }
  public int getFlags() { return this.flags; }
  public boolean isApplied() { return this.applied; }
  public void setApplied(final boolean applied) { this.applied = applied; }
  public String getPlayerName() { return this.playerName; }
  public String getItemName() { return this.itemName;  }

  // optional: update state from new event
  public void updateFromEvent(final long locationID, final long itemID, final int playerID, final int flags) {
    this.itemID = itemID;
    this.playerID = playerID;
    this.flags = flags;
  }
}
