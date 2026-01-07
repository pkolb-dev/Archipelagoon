package archidragoon.ap.mapping.locations;

import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// PK - use this to look up item ID from AP item id
public final class Locations {
  private static final Map<Long, String> LOCATION_MAP = new HashMap<>();
  private static final Map<String, Long> LOCATION_MAP_REVERSE = new HashMap<>();

  static {
    LOCATION_MAP.putAll(Additions.getStaticMap());
//    LOCATION_MAP.putAll(Chests.getStaticMap());
//    LOCATION_MAP.putAll(Events.getStaticMap());
    LOCATION_MAP.putAll(Shops.getStaticFlatMap()); // TODO: make flat map of... things.

    for (final Map.Entry<Long, String> entry :LOCATION_MAP.entrySet()) {
      LOCATION_MAP_REVERSE.put(entry.getValue(), entry.getKey());
    }
//    assert LOCATION_MAP.size() == LOCATION_MAP_REVERSE.size();
//    assert LOCATION_MAP.size() == (Consumables.getStaticMap().size() + Equipment.getStaticMap().size() + Goods.getStaticMap().size());
  }
  private Locations() {}

  public static Map<Long, String> getStaticMap() {
    return Collections.unmodifiableMap(LOCATION_MAP);
  }

  private static Map<String, Long> getStaticReverseMap() {
    return Collections.unmodifiableMap(LOCATION_MAP_REVERSE);
  }

  public static Long getAPItemIdFromRegistryId(final RegistryId registryId) {
    return getStaticReverseMap().get(registryId.entryId());
  }

  public static String getEntryIdFromAPItemId (final Long itemId) {
    return getStaticMap().get(itemId);
  }
}
