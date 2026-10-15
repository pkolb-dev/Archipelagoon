package archipelagoon.ap.mapping.items;

import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Items {
  private static final Map<Long, RegistryId> ITEM_MAP = new HashMap<>();

  static {
    ITEM_MAP.putAll(Consumables.getStaticMap());
    ITEM_MAP.putAll(Equipment.getStaticMap());
    ITEM_MAP.putAll(Goods.getStaticMap());
    ITEM_MAP.putAll(Additions.getStaticMap());
    ITEM_MAP.putAll(Magic.getStaticMap());
    ITEM_MAP.putAll(Characters.getStaticMap());
  }

  private Items() {
  }

  public static Map<Long, RegistryId> getStaticMap() {
    return Collections.unmodifiableMap(ITEM_MAP);
  }
}
