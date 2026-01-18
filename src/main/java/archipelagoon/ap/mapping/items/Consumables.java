package archipelagoon.ap.mapping.items;

import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Consumables {
  private static final Map<Long, String> CONSUMABLE_MAP = new HashMap<>();
  private static final Map<String, Long> CONSUMABLE_MAP_REVERSE = new HashMap<>();

  static {
    CONSUMABLE_MAP.put(108_00001L,  "angels_prayer");
    CONSUMABLE_MAP.put(108_00002L,  "healing_potion");
    CONSUMABLE_MAP.put(108_00003L,  "healing_fog");
    CONSUMABLE_MAP.put(108_00004L,  "healing_breeze");
    CONSUMABLE_MAP.put(108_00005L,  "healing_rain");
    CONSUMABLE_MAP.put(108_00006L,  "moon_serenade");
    CONSUMABLE_MAP.put(108_00007L,  "sun_rhapsody");
    CONSUMABLE_MAP.put(108_00008L,  "spirit_potion");
    CONSUMABLE_MAP.put(108_00009L,  "body_purifier");
    CONSUMABLE_MAP.put(108_00010L,  "depetrifier");
    CONSUMABLE_MAP.put(108_00011L,  "mind_purifier");
    CONSUMABLE_MAP.put(108_00012L,  "recovery_ball");

    CONSUMABLE_MAP.put(108_00013L,  "black_rain");
    CONSUMABLE_MAP.put(108_00014L,  "burn_out");
    CONSUMABLE_MAP.put(108_00015L,  "burning_wave");
    CONSUMABLE_MAP.put(108_00016L,  "dancing_ray");
    CONSUMABLE_MAP.put(108_00017L,  "dark_mist");
    CONSUMABLE_MAP.put(108_00018L,  "detonate_rock");
    CONSUMABLE_MAP.put(108_00019L,  "down_burst");
    CONSUMABLE_MAP.put(108_00020L,  "fatal_blizzard");
    CONSUMABLE_MAP.put(108_00021L,  "flash_hall");
    CONSUMABLE_MAP.put(108_00022L,  "frozen_jet");
    CONSUMABLE_MAP.put(108_00023L,  "gravity_grabber");
    CONSUMABLE_MAP.put(108_00024L,  "gushing_magma");
    CONSUMABLE_MAP.put(108_00025L,  "meteor_fall");
    CONSUMABLE_MAP.put(108_00026L,  "night_raid");
    CONSUMABLE_MAP.put(108_00027L,  "pellet");
    CONSUMABLE_MAP.put(108_00028L,  "psyche_bomb");
    CONSUMABLE_MAP.put(108_00029L,  "psyche_bomb_x");
    CONSUMABLE_MAP.put(108_00030L,  "rave_twister");
    CONSUMABLE_MAP.put(108_00031L,  "spark_net");
    CONSUMABLE_MAP.put(108_00032L,  "spear_frost");
    CONSUMABLE_MAP.put(108_00033L,  "spectral_flash");
    CONSUMABLE_MAP.put(108_00034L,  "spinning_gale");
    CONSUMABLE_MAP.put(108_00035L,  "thunderbolt");
    CONSUMABLE_MAP.put(108_00036L,  "trans_light");
    CONSUMABLE_MAP.put(108_00037L,  "attack_ball");

    CONSUMABLE_MAP.put(108_00038L,  "charm_potion");
    CONSUMABLE_MAP.put(108_00039L,  "magic_sig_stone");
    CONSUMABLE_MAP.put(108_00040L,  "midnight_terror");
    CONSUMABLE_MAP.put(108_00041L,  "pandemonium");
    CONSUMABLE_MAP.put(108_00042L,  "panic_bell");
    CONSUMABLE_MAP.put(108_00043L,  "poison_needle");
    CONSUMABLE_MAP.put(108_00044L,  "sachet");
    CONSUMABLE_MAP.put(108_00045L,  "smoke_ball");
    CONSUMABLE_MAP.put(108_00046L,  "stunning_hammer");
    CONSUMABLE_MAP.put(108_00047L,  "total_vanishing");


    for (final Map.Entry<Long, String> entry :CONSUMABLE_MAP.entrySet()) {
      CONSUMABLE_MAP_REVERSE.put(entry.getValue(), entry.getKey());
    }
    assert CONSUMABLE_MAP.size() == CONSUMABLE_MAP_REVERSE.size();
  }

  private Consumables () {
  }

  public static Map<Long, String> getStaticMap() {
    return Collections.unmodifiableMap(CONSUMABLE_MAP);
  }

  private static Map<String, Long> getStaticReverseMap() {
    return Collections.unmodifiableMap(CONSUMABLE_MAP_REVERSE);
  }

  public static Long getAPItemIdFromRegistryId(final RegistryId registryId) {
    return getStaticReverseMap().get(registryId.entryId());
  }

  public static String getEntryIdFromAPItemId (final Long itemId) {
    return getStaticMap().get(itemId);
  }
}
