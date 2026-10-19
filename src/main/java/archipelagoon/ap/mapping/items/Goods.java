package archipelagoon.ap.mapping.items;

import archipelagoon.APGoods;
import legend.lodmod.LodGoods;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Goods {
  private static final Map<Long, RegistryId> GOOD_MAP = new HashMap<>();
  private static final Map<RegistryId, Long> GOOD_MAP_REVERSE = new HashMap<>();

  static {
    GOOD_MAP.put(108_20002L, LodGoods.BLUE_DRAGOON_SPIRIT.getId());
    GOOD_MAP.put(108_20003L, LodGoods.JADE_DRAGOON_SPIRIT.getId());
    GOOD_MAP.put(108_20004L, LodGoods.GOLD_DRAGOON_SPIRIT.getId());
    GOOD_MAP.put(108_20005L, LodGoods.VIOLET_DRAGOON_SPIRIT.getId());
    GOOD_MAP.put(108_20006L, LodGoods.SILVER_DRAGOON_SPIRIT.getId());
    GOOD_MAP.put(108_20007L, LodGoods.DARK_DRAGOON_SPIRIT.getId());
    GOOD_MAP.put(108_20011L, LodGoods.PRISON_KEY.getId());
    GOOD_MAP.put(108_20012L, LodGoods.AXE_FROM_THE_SHACK.getId());
    GOOD_MAP.put(108_20013L, LodGoods.GOOD_SPIRITS.getId());
    GOOD_MAP.put(108_20015L, LodGoods.WATER_BOTTLE.getId());
    GOOD_MAP.put(108_20016L, LodGoods.LIFE_WATER.getId());
    GOOD_MAP.put(108_20017L, LodGoods.MAGIC_OIL.getId());
    GOOD_MAP.put(108_20018L, LodGoods.YELLOW_STONE.getId());
    GOOD_MAP.put(108_20019L, LodGoods.BLUE_STONE.getId());
    GOOD_MAP.put(108_20020L, LodGoods.RED_STONE.getId());
    GOOD_MAP.put(108_20021L, LodGoods.LETTER_FROM_LYNN.getId());
    GOOD_MAP.put(108_20022L, LodGoods.PASS_FOR_VALLEY.getId());
    GOOD_MAP.put(108_20023L, LodGoods.KATES_BOUQUET.getId());
    GOOD_MAP.put(108_20024L, LodGoods.KEY_TO_SHIP.getId());
    GOOD_MAP.put(108_20025L, LodGoods.BOAT_LICENSE.getId());
    GOOD_MAP.put(108_20026L, LodGoods.DRAGON_BLOCKER.getId());
    GOOD_MAP.put(108_20027L, LodGoods.MOON_GEM.getId());
    GOOD_MAP.put(108_20028L, LodGoods.MOON_DAGGER.getId());
    GOOD_MAP.put(108_20029L, LodGoods.MOON_MIRROR.getId());
    GOOD_MAP.put(108_20030L, new RegistryId("lloyd_mod", "chaos_divine_dragoon_spirit"));
    GOOD_MAP.put(108_20032L, APGoods.LAW_MAKING_LICENSE.getId());
    GOOD_MAP.put(108_20033L, APGoods.LAW_LAUNCHING_LICENSE.getId());
    GOOD_MAP.put(108_20036L, LodGoods.VANISHING_STONE.getId());
    GOOD_MAP.put(108_20037L, LodGoods.LAVITZS_PICTURE.getId());
    for(final Map.Entry<Long, RegistryId> entry : GOOD_MAP.entrySet()) {
      GOOD_MAP_REVERSE.put(entry.getValue(), entry.getKey());
    }
    assert GOOD_MAP.size() == GOOD_MAP_REVERSE.size();
  }

  private Goods() {
  }

  public static Map<Long, RegistryId> getStaticMap() {
    return Collections.unmodifiableMap(GOOD_MAP);
  }

  private static Map<RegistryId, Long> getStaticReverseMap() {
    return Collections.unmodifiableMap(GOOD_MAP_REVERSE);
  }

  public static Long getAPItemIdFromRegistryId(final RegistryId registryId) {
    return getStaticReverseMap().get(registryId);
  }
}
