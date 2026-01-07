package archidragoon.ap.mapping.locations;

import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Enemies {
  private static final Map<Long, String> ENEMY_LOCATIONS = new HashMap<>();
  private static final Map<String, Long> ENEMY_LOCATIONS_REVERSE = new HashMap<>();

  static {
    ENEMY_LOCATIONS.put(22L, "");


    for(final Map.Entry<Long, String> entry :ENEMY_LOCATIONS.entrySet()) {
      ENEMY_LOCATIONS_REVERSE.put(entry.getValue(), entry.getKey());
    }
    assert ENEMY_LOCATIONS.size() == ENEMY_LOCATIONS_REVERSE.size();
  }

  private Enemies() {
  }

  public static Map<Long, String> getStaticMap() {
    return Collections.unmodifiableMap(ENEMY_LOCATIONS);
  }

  private static Map<String, Long> getStaticReverseMap() {
    return Collections.unmodifiableMap(ENEMY_LOCATIONS_REVERSE);
  }

  public static Long getAPLocationIdFromRegistryId(final RegistryId registryId) {
    return getStaticReverseMap().get(registryId.entryId());
  }

  public static String getEntryIdFromAPLocationId (final Long locationId) {
    return getStaticMap().get(locationId);
  }
}
