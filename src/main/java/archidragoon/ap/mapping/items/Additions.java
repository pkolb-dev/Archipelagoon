package archidragoon.ap.mapping.items;

import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Additions {
  private static final Map<Long, String> ADDITION_MAP = new HashMap<>();
  private static final Map<String, Long> ADDITION_MAP_REVERSE = new HashMap<>();

  static {
    ADDITION_MAP.put(108_30001L,  "dart_progressive_addition");
    ADDITION_MAP.put(108_30002L,  "double_slash");
    ADDITION_MAP.put(108_30003L,  "volcano");
    ADDITION_MAP.put(108_30004L,  "burning_rush");
    ADDITION_MAP.put(108_30005L,  "crush_dance");
    ADDITION_MAP.put(108_30006L,  "madness_hero");
    ADDITION_MAP.put(108_30007L,  "moon_strike");
    ADDITION_MAP.put(108_30008L,  "blazing_dynamo");

    ADDITION_MAP.put(108_30009L,  "lavitz_progressive_addition");
    ADDITION_MAP.put(108_30010L,  "harpoon");
    ADDITION_MAP.put(108_30011L,  "spinning_cane");
    ADDITION_MAP.put(108_30012L,  "rod_typhoon");
    ADDITION_MAP.put(108_30013L,  "gust_of_wind_dance");
    ADDITION_MAP.put(108_30014L,  "flower_storm");

    ADDITION_MAP.put(108_30015L,  "rose_progressive_addition");
    ADDITION_MAP.put(108_30016L,  "whip_smack");
    ADDITION_MAP.put(108_30017L,  "more_more");
    ADDITION_MAP.put(108_30018L,  "hard_blade");
    ADDITION_MAP.put(108_30019L,  "demons_dance");

    ADDITION_MAP.put(108_30020L,  "haschel_progressive_addition");
    ADDITION_MAP.put(108_30021L,  "double_punch");
    ADDITION_MAP.put(108_30022L,  "ferry_of_styx");
    ADDITION_MAP.put(108_30023L,  "summon_4_gods");
    ADDITION_MAP.put(108_30024L,  "five_ring_shattering");
    ADDITION_MAP.put(108_30025L,  "hex_hammer");
    ADDITION_MAP.put(108_30026L,  "omni_sweep");

    ADDITION_MAP.put(108_30027L,  "albert_progressive_addition");
    ADDITION_MAP.put(108_30028L,  "albert_harpoon");
    ADDITION_MAP.put(108_30029L,  "albert_spinning_cane");
    ADDITION_MAP.put(108_30030L,  "albert_rod_typhoon");
    ADDITION_MAP.put(108_30031L,  "albert_gust_of_wind_dance");
    ADDITION_MAP.put(108_30032L,  "albert_flower_storm");

    ADDITION_MAP.put(108_30033L,  "meru_progressive_addition");
    ADDITION_MAP.put(108_30034L,  "double_smack");
    ADDITION_MAP.put(108_30035L,  "hammer_spin");
    ADDITION_MAP.put(108_30036L,  "cool_boogie");
    ADDITION_MAP.put(108_30037L,  "cats_cradle");
    ADDITION_MAP.put(108_30038L,  "perky_step");

    ADDITION_MAP.put(108_30039L,  "kongol_progressive_addition");
    ADDITION_MAP.put(108_30040L,  "pursuit");
    ADDITION_MAP.put(108_30041L,  "inferno");
    ADDITION_MAP.put(108_30042L,  "bone_crush");


    for (final Map.Entry<Long, String> entry :ADDITION_MAP.entrySet()) {
      ADDITION_MAP_REVERSE.put(entry.getValue(), entry.getKey());
    }

    assert ADDITION_MAP.size() == ADDITION_MAP_REVERSE.size();
  }

  private Additions () {
  }

  public static Map<Long, String> getStaticMap() {
    return Collections.unmodifiableMap(ADDITION_MAP);
  }

  private static Map<String, Long> getStaticReverseMap() {
    return Collections.unmodifiableMap(ADDITION_MAP_REVERSE);
  }

  public static Long getAPItemIdFromRegistryId(final RegistryId registryId) {
    return getStaticReverseMap().get(registryId.entryId());
  }

  public static String getEntryIdFromAPItemId (final Long itemId) {
    return getStaticMap().get(itemId);
  }
}
