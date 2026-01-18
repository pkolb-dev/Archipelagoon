package archipelagoon.config;

import archipelagoon.ap.mapping.LocationState;
import legend.core.memory.types.IntRef;
import legend.game.saves.ConfigCategory;
import legend.game.saves.ConfigEntry;
import legend.game.saves.ConfigStorageLocation;

import legend.game.unpacker.ExpandableFileData;
import legend.game.unpacker.FileData;

import java.util.ArrayList;
import java.util.List;


public class LocationStateRegistry extends ConfigEntry<List<LocationState>> {
  public LocationStateRegistry() {
    super(List.of(), ConfigStorageLocation.CAMPAIGN, ConfigCategory.OTHER, LocationStateRegistry::serializer, LocationStateRegistry::deserializer);
  }


  private static byte[] serializer(final List<LocationState> states) {
    final FileData out = new ExpandableFileData(100);
    final IntRef offset = new IntRef();

    out.writeInt(offset, states.size());

    for(final LocationState locationState : states) {
      out.writeLong(offset, locationState.getItemID());
      out.writeLong(offset, locationState.getLocationID());
      out.writeInt(offset, locationState.getPlayerID());
      out.writeInt(offset, locationState.getFlags());
      out.writeByte(offset, locationState.isApplied() ? 1 : 0);
      out.writeAscii(offset, locationState.getPlayerName());
      out.writeAscii(offset, locationState.getItemName());
    }

    return out.getBytes();
  }

  private static List<LocationState> deserializer( final byte[] data) {
    if (data.length < 1) {
      return List.of();
    }

    final List<LocationState> out = new ArrayList<>();

    final FileData in = new FileData(data);
    final IntRef offset = new IntRef();

    final int statesSize = in.readInt(offset);

    for(int index = 0; index < statesSize; index++) {
      final long itemID = in.readLong(offset);
      final long locationID = in.readLong(offset);

      final int playerID = in.readInt(offset);
      final int flags = in.readInt(offset);
      final boolean applied = in.readByte(offset) != 0;

      final String playerName = in.readAscii(offset);
      final String itemName = in.readAscii(offset);

      out.add(new LocationState(locationID, itemID, playerID, flags, applied, playerName, itemName));
    }

    return out;
  }

  @Override
  public boolean availableInBattle() {
    return false;
  }
}
