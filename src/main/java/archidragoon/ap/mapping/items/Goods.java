package archidragoon.ap.mapping.items;

import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Goods {
  private static final Map<Long, String> GOOD_MAP = new HashMap<>();
  private static final Map<String, Long> GOOD_MAP_REVERSE = new HashMap<>();

  static {
    GOOD_MAP.put(108_20001L,  "red_dragoon_spirit");
    GOOD_MAP.put(108_20002L,  "blue_dragoon_spirit");
    GOOD_MAP.put(108_20003L,  "jade_dragoon_spirit");
    GOOD_MAP.put(108_20004L,  "gold_dragoon_spirit");
    GOOD_MAP.put(108_20005L,  "violet_dragoon_spirit");
    GOOD_MAP.put(108_20006L,  "silver_dragoon_spirit");
    GOOD_MAP.put(108_20007L,  "dark_dragoon_spirit");
    GOOD_MAP.put(108_20008L,  "divine_dragoon_spirit");

    GOOD_MAP.put(108_20009L,  "war_bulletin");
    GOOD_MAP.put(108_20010L,  "fathers_stone");
    GOOD_MAP.put(108_20011L,  "prison_key");
    GOOD_MAP.put(108_20012L,  "axe_from_shack");
    GOOD_MAP.put(108_20013L,  "good_spirits");
    GOOD_MAP.put(108_20014L,  "shiny_bag");
    GOOD_MAP.put(108_20015L,  "water_bottle");
    GOOD_MAP.put(108_20016L,  "life_water");
    GOOD_MAP.put(108_20017L,  "magic_oil");
    GOOD_MAP.put(108_20018L,  "yellow_stone");
    GOOD_MAP.put(108_20019L,  "blue_stone");
    GOOD_MAP.put(108_20020L,  "red_stone");
    GOOD_MAP.put(108_20021L,  "letter_from_lynn");
    GOOD_MAP.put(108_20022L,  "pass_for_valley");
    GOOD_MAP.put(108_20023L,  "kates_bouquet");
    GOOD_MAP.put(108_20024L,  "key_to_ship");
    GOOD_MAP.put(108_20025L,  "boat_license");
    GOOD_MAP.put(108_20026L,  "dragon_blocker");
    GOOD_MAP.put(108_20027L,  "moon_gem");
    GOOD_MAP.put(108_20028L,  "moon_dagger");
    GOOD_MAP.put(108_20029L,  "moon_mirror");
    GOOD_MAP.put(108_20030L,  "omega_bomb");
    GOOD_MAP.put(108_20031L,  "omega_master");
    GOOD_MAP.put(108_20032L,  "law_maker");
    GOOD_MAP.put(108_20033L,  "law_output");
    GOOD_MAP.put(108_20034L,  "gold_dragoon_spirit_2");
    GOOD_MAP.put(108_20035L,  "magic_shiny_bag");
    GOOD_MAP.put(108_20036L,  "vanishing_stone");
    GOOD_MAP.put(108_20037L,  "lavitzs_picture");

    for (final Map.Entry<Long, String> entry :GOOD_MAP.entrySet()) {
      GOOD_MAP_REVERSE.put(entry.getValue(), entry.getKey());
    }
    assert GOOD_MAP.size() == GOOD_MAP_REVERSE.size();
  }

  private Goods () {
  }

  public static Map<Long, String> getStaticMap() {
    return Collections.unmodifiableMap(GOOD_MAP);
  }

  private static Map<String, Long> getStaticReverseMap() {
    return Collections.unmodifiableMap(GOOD_MAP_REVERSE);
  }

  public static Long getAPItemIdFromRegistryId(final RegistryId registryId) {
    return getStaticReverseMap().get(registryId.entryId());
  }

  public static String getEntryIdFromAPItemId (final Long itemId) {
    return getStaticMap().get(itemId);
  }
}
