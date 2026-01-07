package archidragoon.ap.mapping.items;

import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


// PK - use this to look up item ID from AP item id
public final class Items {
  private static final Map<Long, String> ITEM_MAP = new HashMap<>();
  private static final Map<String, Long> ITEM_MAP_REVERSE = new HashMap<>();

  static {
    ITEM_MAP.putAll(Consumables.getStaticMap());
    ITEM_MAP.putAll(Equipment.getStaticMap());
    ITEM_MAP.putAll(Goods.getStaticMap());
    ITEM_MAP.putAll(Additions.getStaticMap());

    for (final Map.Entry<Long, String> entry :ITEM_MAP.entrySet()) {
      ITEM_MAP_REVERSE.put(entry.getValue(), entry.getKey());
    }
    assert ITEM_MAP.size() == ITEM_MAP_REVERSE.size();
    assert ITEM_MAP.size() == (Consumables.getStaticMap().size() + Equipment.getStaticMap().size() + Goods.getStaticMap().size() + Additions.getStaticMap().size());
  }
  private Items() {}

  public static Map<Long, String> getStaticMap() {
    return Collections.unmodifiableMap(ITEM_MAP);
  }

  private static Map<String, Long> getStaticReverseMap() {
    return Collections.unmodifiableMap(ITEM_MAP_REVERSE);
  }

  public static Long getAPItemIdFromRegistryId(final RegistryId registryId) {
    return getStaticReverseMap().get(registryId.entryId());
  }

  public static String getEntryIdFromAPItemId (final Long itemId) {
    return getStaticMap().get(itemId);
  }
}
