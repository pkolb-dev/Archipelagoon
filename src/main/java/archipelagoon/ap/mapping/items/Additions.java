package archipelagoon.ap.mapping.items;

import legend.lodmod.LodAdditions;
import legend.lodmod.LodCharacterTemplates;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public final class Additions {
  private static final Map<Long, RegistryId> ADDITION_MAP = new HashMap<>();
  private static final Map<RegistryId, Long> ADDITION_MAP_REVERSE = new HashMap<>();
  private static final Map<RegistryId, Long> PROGRESSIVE_ADDITION_MAP = new LinkedHashMap<>();

  static {
    ADDITION_MAP.put(108_30002L, LodAdditions.DOUBLE_SLASH.getId());
    ADDITION_MAP.put(108_30003L, LodAdditions.VOLCANO.getId());
    ADDITION_MAP.put(108_30004L, LodAdditions.BURNING_RUSH.getId());
    ADDITION_MAP.put(108_30005L, LodAdditions.CRUSH_DANCE.getId());
    ADDITION_MAP.put(108_30006L, LodAdditions.MADNESS_HERO.getId());
    ADDITION_MAP.put(108_30007L, LodAdditions.MOON_STRIKE.getId());
    ADDITION_MAP.put(108_30008L, LodAdditions.BLAZING_DYNAMO.getId());

    ADDITION_MAP.put(108_30010L, LodAdditions.HARPOON.getId());
    ADDITION_MAP.put(108_30011L, LodAdditions.SPINNING_CANE.getId());
    ADDITION_MAP.put(108_30012L, LodAdditions.ROD_TYPHOON.getId());
    ADDITION_MAP.put(108_30013L, LodAdditions.GUST_OF_WIND_DANCE.getId());
    ADDITION_MAP.put(108_30014L, LodAdditions.FLOWER_STORM.getId());

    ADDITION_MAP.put(108_30016L, LodAdditions.WHIP_SMACK.getId());
    ADDITION_MAP.put(108_30017L, LodAdditions.MORE_MORE.getId());
    ADDITION_MAP.put(108_30018L, LodAdditions.HARD_BLADE.getId());
    ADDITION_MAP.put(108_30019L, LodAdditions.DEMONS_DANCE.getId());

    ADDITION_MAP.put(108_30021L, LodAdditions.DOUBLE_PUNCH.getId());
    ADDITION_MAP.put(108_30022L, LodAdditions.FERRY_OF_STYX.getId());
    ADDITION_MAP.put(108_30023L, LodAdditions.SUMMON_4_GODS.getId());
    ADDITION_MAP.put(108_30024L, LodAdditions.FIVE_RING_SHATTERING.getId());
    ADDITION_MAP.put(108_30025L, LodAdditions.HEX_HAMMER.getId());
    ADDITION_MAP.put(108_30026L, LodAdditions.OMNI_SWEEP.getId());

    ADDITION_MAP.put(108_30028L, LodAdditions.ALBERT_HARPOON.getId());
    ADDITION_MAP.put(108_30029L, LodAdditions.ALBERT_SPINNING_CANE.getId());
    ADDITION_MAP.put(108_30030L, LodAdditions.ALBERT_ROD_TYPHOON.getId());
    ADDITION_MAP.put(108_30031L, LodAdditions.ALBERT_GUST_OF_WIND_DANCE.getId());
    ADDITION_MAP.put(108_30032L, LodAdditions.ALBERT_FLOWER_STORM.getId());

    ADDITION_MAP.put(108_30034L, LodAdditions.DOUBLE_SMACK.getId());
    ADDITION_MAP.put(108_30035L, LodAdditions.HAMMER_SPIN.getId());
    ADDITION_MAP.put(108_30036L, LodAdditions.COOL_BOOGIE.getId());
    ADDITION_MAP.put(108_30037L, LodAdditions.CATS_CRADLE.getId());
    ADDITION_MAP.put(108_30038L, LodAdditions.PERKY_STEP.getId());

    ADDITION_MAP.put(108_30040L, LodAdditions.PURSUIT.getId());
    ADDITION_MAP.put(108_30041L, LodAdditions.INFERNO.getId());
    ADDITION_MAP.put(108_30042L, LodAdditions.BONE_CRUSH.getId());

    for(final Map.Entry<Long, RegistryId> entry : ADDITION_MAP.entrySet()) {
      ADDITION_MAP_REVERSE.put(entry.getValue(), entry.getKey());
    }

    assert ADDITION_MAP.size() == ADDITION_MAP_REVERSE.size();

    PROGRESSIVE_ADDITION_MAP.put(LodCharacterTemplates.DART.getId(), 108_30001L);
    PROGRESSIVE_ADDITION_MAP.put(LodCharacterTemplates.LAVITZ.getId(), 108_30009L);
    //    PROGRESSIVE_ADDITION_MAP.put(LodCharacterTemplates.SHANA.getId(), -1L);
    PROGRESSIVE_ADDITION_MAP.put(LodCharacterTemplates.ROSE.getId(), 108_30015L);
    PROGRESSIVE_ADDITION_MAP.put(LodCharacterTemplates.HASCHEL.getId(), 108_30020L);
    PROGRESSIVE_ADDITION_MAP.put(LodCharacterTemplates.ALBERT.getId(), 108_30027L);
    PROGRESSIVE_ADDITION_MAP.put(LodCharacterTemplates.MERU.getId(), 108_30033L);
    PROGRESSIVE_ADDITION_MAP.put(LodCharacterTemplates.KONGOL.getId(), 108_30039L);
    //    PROGRESSIVE_ADDITION_MAP.put(LodCharacterTemplates.MIRANDA.getId(), -1L);
  }

  private Additions() {
  }

  public static Map<Long, RegistryId> getStaticMap() {
    return Collections.unmodifiableMap(ADDITION_MAP);
  }

  public static Long getAPItemIdFromCharacterIndex(final RegistryId charId) {
    if(PROGRESSIVE_ADDITION_MAP.containsKey(charId)) {
      return PROGRESSIVE_ADDITION_MAP.get(charId);
    }
    return null;
  }

  public static RegistryId getCharacterIndexFromAPItemId(final Long apItemId) {
    if(!PROGRESSIVE_ADDITION_MAP.containsValue(apItemId)) {
      return null;
    }

    for(final Map.Entry<RegistryId, Long> entry : PROGRESSIVE_ADDITION_MAP.entrySet()) {
      if(Objects.equals(entry.getValue(), apItemId)) {
        return entry.getKey();
      }
    }

    return null;
  }

  public static RegistryId getRegistryIdFromAPItemId(final Long itemId) {
    return getStaticMap().get(itemId);
  }
}
