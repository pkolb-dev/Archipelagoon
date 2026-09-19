package archipelagoon.ap.mapping.locations;

import legend.lodmod.LodAdditions;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Additions {
  private static final Map<RegistryId, Long> ADDITION_LOCATIONS = new LinkedHashMap<>();
  private static final Map<RegistryId, Long[]> ADDITION_LEVEL_LOCATIONS = new LinkedHashMap<>();

  static {
    final Long BASE_ID = 108_60000L;

    // set all non-starter additions for unlocks
    final ArrayList<RegistryId> additionUnlocks = new ArrayList<>();
    additionUnlocks.add(LodAdditions.VOLCANO.getId());
    additionUnlocks.add(LodAdditions.BURNING_RUSH.getId());
    additionUnlocks.add(LodAdditions.CRUSH_DANCE.getId());
    additionUnlocks.add(LodAdditions.MADNESS_HERO.getId());
    additionUnlocks.add(LodAdditions.MOON_STRIKE.getId());
    additionUnlocks.add(LodAdditions.BLAZING_DYNAMO.getId());

    additionUnlocks.add(LodAdditions.MORE_MORE.getId());
    additionUnlocks.add(LodAdditions.HARD_BLADE.getId());
    additionUnlocks.add(LodAdditions.DEMONS_DANCE.getId());

    additionUnlocks.add(LodAdditions.SPINNING_CANE.getId());
    additionUnlocks.add(LodAdditions.ROD_TYPHOON.getId());
    additionUnlocks.add(LodAdditions.GUST_OF_WIND_DANCE.getId());
    additionUnlocks.add(LodAdditions.FLOWER_STORM.getId());

    additionUnlocks.add(LodAdditions.ALBERT_SPINNING_CANE.getId());
    additionUnlocks.add(LodAdditions.ALBERT_ROD_TYPHOON.getId());
    additionUnlocks.add(LodAdditions.ALBERT_GUST_OF_WIND_DANCE.getId());
    additionUnlocks.add(LodAdditions.ALBERT_FLOWER_STORM.getId());

    additionUnlocks.add(LodAdditions.FERRY_OF_STYX.getId());
    additionUnlocks.add(LodAdditions.SUMMON_4_GODS.getId());
    additionUnlocks.add(LodAdditions.FIVE_RING_SHATTERING.getId());
    additionUnlocks.add(LodAdditions.HEX_HAMMER.getId());
    additionUnlocks.add(LodAdditions.OMNI_SWEEP.getId());

    additionUnlocks.add(LodAdditions.HAMMER_SPIN.getId());
    additionUnlocks.add(LodAdditions.COOL_BOOGIE.getId());
    additionUnlocks.add(LodAdditions.CATS_CRADLE.getId());
    additionUnlocks.add(LodAdditions.PERKY_STEP.getId());

    additionUnlocks.add(LodAdditions.INFERNO.getId());
    additionUnlocks.add(LodAdditions.BONE_CRUSH.getId());
    additionUnlocks.add(LodAdditions.VOLCANO.getId());
    additionUnlocks.add(LodAdditions.VOLCANO.getId());

    // iterate for IDs
    long currId = BASE_ID;
    for(final RegistryId id : additionUnlocks) {
      ADDITION_LOCATIONS.put(id, currId);
      currId++;
    }

    // create ALL additions (add first ones)
    final ArrayList<RegistryId> additionLevelUnlocks = new ArrayList<>();
    additionLevelUnlocks.add(LodAdditions.DOUBLE_SLASH.getId());
    additionLevelUnlocks.add(LodAdditions.WHIP_SMACK.getId());
    additionLevelUnlocks.add(LodAdditions.HARPOON.getId());
    additionLevelUnlocks.add(LodAdditions.ALBERT_HARPOON.getId());
    additionLevelUnlocks.add(LodAdditions.DOUBLE_PUNCH.getId());
    additionLevelUnlocks.add(LodAdditions.DOUBLE_SMACK.getId());
    additionLevelUnlocks.add(LodAdditions.PURSUIT.getId());
    additionLevelUnlocks.addAll(additionUnlocks);

    // set levels per addition
    for(final RegistryId id : additionLevelUnlocks) {
      final ArrayList<Long> locations = new ArrayList<>();
      for(int i = 0; i < 4; i++) {
        locations.add(currId);
        currId++;
      }

      ADDITION_LEVEL_LOCATIONS.put(id, locations.toArray(new Long[] {}));
    }
  }

  private Additions() {
  }

  public static Map<RegistryId, Long> getStaticMap() {
    return Collections.unmodifiableMap(ADDITION_LOCATIONS);
  }

  public static Long getAPLocationId(final RegistryId additionId) {
    return ADDITION_LOCATIONS.get(additionId);
  }

  public static Long getAPLocationId(final RegistryId additionId, final int level) {
    return ADDITION_LEVEL_LOCATIONS.get(additionId)[level - 2];
  }
}
