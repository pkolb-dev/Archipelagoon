package archipelagoon.ap.mapping.locations;

import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Additions {
  private static final Map<Long, String> ADDITION_LOCATIONS = new HashMap<>();
  private static final Map<String, Long> ADDITION_LOCATIONS_REVERSE = new HashMap<>();

  static {
//    ADDITION_LOCATIONS.put(10860000L, "double_slash");
    ADDITION_LOCATIONS.put(10860001L, "volcano");
    ADDITION_LOCATIONS.put(10860002L, "burning_rush");
    ADDITION_LOCATIONS.put(10860003L, "crush_dance");
    ADDITION_LOCATIONS.put(10860004L, "madness_hero");
    ADDITION_LOCATIONS.put(10860005L, "moon_strike");
    ADDITION_LOCATIONS.put(10860006L, "blazing_dynamo");

//    ADDITION_LOCATIONS.put(108_60016L,  "whip_smack");
    ADDITION_LOCATIONS.put(108_60011L,  "more_more");
    ADDITION_LOCATIONS.put(108_60012L,  "hard_blade");
    ADDITION_LOCATIONS.put(108_60013L,  "demons_dance");

    //    ADDITION_LOCATIONS.put(108_60010L,  "harpoon");
    ADDITION_LOCATIONS.put(108_60021L,  "spinning_cane");
    ADDITION_LOCATIONS.put(108_60022L,  "rod_typhoon");
    ADDITION_LOCATIONS.put(108_60023L,  "gust_of_wind_dance");
    ADDITION_LOCATIONS.put(108_60024L,  "flower_storm");

    //    ADDITION_LOCATIONS.put(108_60028L,  "albert_harpoon");
    ADDITION_LOCATIONS.put(108_60031L,  "albert_spinning_cane");
    ADDITION_LOCATIONS.put(108_60032L,  "albert_rod_typhoon");
    ADDITION_LOCATIONS.put(108_60033L,  "albert_gust_of_wind_dance");
    ADDITION_LOCATIONS.put(108_60034L,  "albert_flower_storm");

    //    ADDITION_LOCATIONS.put(108_60021L,  "double_punch");
    ADDITION_LOCATIONS.put(108_60041L,  "ferry_of_styx");
    ADDITION_LOCATIONS.put(108_60042L,  "summon_4_gods");
    ADDITION_LOCATIONS.put(108_60043L,  "five_ring_shattering");
    ADDITION_LOCATIONS.put(108_60044L,  "hex_hammer");
    ADDITION_LOCATIONS.put(108_60045L,  "omni_sweep");

//    ADDITION_LOCATIONS.put(108_60034L,  "double_smack");
    ADDITION_LOCATIONS.put(108_60051L,  "hammer_spin");
    ADDITION_LOCATIONS.put(108_60052L,  "cool_boogie");
    ADDITION_LOCATIONS.put(108_60053L,  "cats_cradle");
    ADDITION_LOCATIONS.put(108_60054L,  "perky_step");

//    ADDITION_LOCATIONS.put(108_60040L,  "pursuit");
    ADDITION_LOCATIONS.put(108_60061L,  "inferno");
    ADDITION_LOCATIONS.put(108_60062L,  "bone_crush");

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
