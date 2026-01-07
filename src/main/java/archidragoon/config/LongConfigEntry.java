package archidragoon.config;
import legend.core.MathHelper;
import legend.game.saves.ConfigCategory;
import legend.game.saves.ConfigEntry;
import legend.game.saves.ConfigStorageLocation;

/** Convenience class for simple long-backed configs */
public class LongConfigEntry extends ConfigEntry<Long> {
  public LongConfigEntry(final long defaultValue, final long minValue, final long maxValue, final ConfigStorageLocation storageLocation, final ConfigCategory category) {
    super(
      defaultValue,
      storageLocation,
      category,
      LongConfigEntry::serialize,
      bytes -> deserialize(bytes, defaultValue)
    );
  }

  private static byte[] serialize(final long val) {
    final byte[] out = new byte[8];
    MathHelper.set(out, 0, 8, val);
    return out;
  }

  private static long deserialize(final byte[] bytes, final long defaultValue) {
    if(bytes.length == 8) {
      return (Long)MathHelper.get(bytes, 0, 8);
    }

    return defaultValue;
  }
}
