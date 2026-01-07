package archidragoon.ap.mapping.locations;

import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Additions {
  private static final Map<Long, String> ADDITION_LOCATIONS = new HashMap<>();
  private static final Map<String, Long> ADDITION_LOCATIONS_REVERSE = new HashMap<>();

  static {
    // dart additions
//  TODO: add double_slash later
    ADDITION_LOCATIONS.put(10860000L, "double_slash");
    ADDITION_LOCATIONS.put(10860001L, "volcano");
    ADDITION_LOCATIONS.put(10860002L, "burning_rush");
    ADDITION_LOCATIONS.put(10860003L, "crush_dance");
    ADDITION_LOCATIONS.put(10860004L, "madness_hero");
    ADDITION_LOCATIONS.put(10860005L, "moon_strike");
    ADDITION_LOCATIONS.put(10860006L, "blazing_dynamo");

    for(final Map.Entry<Long, String> entry :ADDITION_LOCATIONS.entrySet()) {
      ADDITION_LOCATIONS_REVERSE.put(entry.getValue(), entry.getKey());
    }
    assert ADDITION_LOCATIONS.size() == ADDITION_LOCATIONS_REVERSE.size();
  }

  private Additions() {
  }

  public static Map<Long, String> getStaticMap() {
    return Collections.unmodifiableMap(ADDITION_LOCATIONS);
  }

  private static Map<String, Long> getStaticReverseMap() {
    return Collections.unmodifiableMap(ADDITION_LOCATIONS_REVERSE);
  }

  public static Long getAPLocationIdFromRegistryId(final RegistryId registryId) {
    return getStaticReverseMap().get(registryId.entryId());
  }

  public static String getEntryIdFromAPLocationId (final Long locationId) {
    return getStaticMap().get(locationId);
  }
}
