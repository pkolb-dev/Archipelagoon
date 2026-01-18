package archipelagoon.ap.mapping.items;

import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Equipment {
  private static final Map<Long, String> EQUIPMENT_MAP = new HashMap<>();
  private static final Map<String, Long> EQUIPMENT_MAP_REVERSE = new HashMap<>();

  static {
    EQUIPMENT_MAP.put(108_10001L,  "active_ring");
    EQUIPMENT_MAP.put(108_10002L,  "amulet");
    EQUIPMENT_MAP.put(108_10003L,  "angel_robe");
    EQUIPMENT_MAP.put(108_10004L,  "angel_scarf");
    EQUIPMENT_MAP.put(108_10005L,  "armet");
    EQUIPMENT_MAP.put(108_10006L,  "armor_of_legend");
    EQUIPMENT_MAP.put(108_10007L,  "armor_of_yore");
    EQUIPMENT_MAP.put(108_10008L,  "arrow_of_force");
    EQUIPMENT_MAP.put(108_10009L,  "attack_badge");
    EQUIPMENT_MAP.put(108_10010L,  "axe");

    EQUIPMENT_MAP.put(108_10011L,  "bandana");
    EQUIPMENT_MAP.put(108_10012L,  "bandits_ring");
    EQUIPMENT_MAP.put(108_10013L,  "bandits_shoes");
    EQUIPMENT_MAP.put(108_10014L,  "basher");
    EQUIPMENT_MAP.put(108_10015L,  "bastard_sword");
    EQUIPMENT_MAP.put(108_10016L,  "battle_axe");
    EQUIPMENT_MAP.put(108_10017L,  "beast_fang");
    EQUIPMENT_MAP.put(108_10018L,  "bemusing_arrow");
    EQUIPMENT_MAP.put(108_10019L,  "blue_dg_armor");
    EQUIPMENT_MAP.put(108_10020L,  "blue_sea_stone");
    EQUIPMENT_MAP.put(108_10021L,  "bracelet");
    EQUIPMENT_MAP.put(108_10022L,  "brass_knuckle");
    EQUIPMENT_MAP.put(108_10023L,  "bravery_amulet");
    EQUIPMENT_MAP.put(108_10024L,  "breast_plate");
    EQUIPMENT_MAP.put(108_10025L,  "broad_sword");

    EQUIPMENT_MAP.put(108_10026L,  "cape");
    EQUIPMENT_MAP.put(108_10027L,  "chain_mail");
    EQUIPMENT_MAP.put(108_10028L,  "claymore");
    EQUIPMENT_MAP.put(108_10029L,  "clothes");
    EQUIPMENT_MAP.put(108_10030L,  "combat_shoes");

    EQUIPMENT_MAP.put(108_10031L,  "dancers_ring");
    EQUIPMENT_MAP.put(108_10032L,  "dancers_shoes");
    EQUIPMENT_MAP.put(108_10033L,  "dancing_dagger");
    EQUIPMENT_MAP.put(108_10034L,  "dark_dg_armor");
    EQUIPMENT_MAP.put(108_10035L,  "darkness_stone");
    EQUIPMENT_MAP.put(108_10036L,  "demon_stiletto");
    EQUIPMENT_MAP.put(108_10037L,  "destone_amulet");
    EQUIPMENT_MAP.put(108_10038L,  "destroyer_mace");
    EQUIPMENT_MAP.put(108_10039L,  "detonate_arrow");
    EQUIPMENT_MAP.put(108_10040L,  "diamond_claw");
    EQUIPMENT_MAP.put(108_10041L,  "disciple_vest");
    EQUIPMENT_MAP.put(108_10042L,  "dragon_buster");
    EQUIPMENT_MAP.put(108_10043L,  "dragon_helm");
    EQUIPMENT_MAP.put(108_10044L,  "dragon_shield");

    EQUIPMENT_MAP.put(108_10045L,  "elude_cloak");
    EQUIPMENT_MAP.put(108_10046L,  "emerald_earring");
    EQUIPMENT_MAP.put(108_10047L,  "energy_girdle");

    EQUIPMENT_MAP.put(108_10048L,  "fairy_sword");
    EQUIPMENT_MAP.put(108_10049L,  "fake_power_wrist");
    EQUIPMENT_MAP.put(108_10050L,  "fake_shield");
    EQUIPMENT_MAP.put(108_10051L,  "falchion");
    EQUIPMENT_MAP.put(108_10052L,  "felt_hat");
    EQUIPMENT_MAP.put(108_10053L,  "flamberge");

    EQUIPMENT_MAP.put(108_10054L,  "giganto_armor");
    EQUIPMENT_MAP.put(108_10055L,  "giganto_helm");
    EQUIPMENT_MAP.put(108_10056L,  "giganto_ring");
    EQUIPMENT_MAP.put(108_10057L,  "gladius");
    EQUIPMENT_MAP.put(108_10058L,  "glaive");
    EQUIPMENT_MAP.put(108_10059L,  "gold_dg_armor");
    EQUIPMENT_MAP.put(108_10060L,  "golden_stone");
    EQUIPMENT_MAP.put(108_10061L,  "great_axe");
    EQUIPMENT_MAP.put(108_10062L,  "guard_badge");

    EQUIPMENT_MAP.put(108_10063L,  "halberd");
    EQUIPMENT_MAP.put(108_10064L,  "heat_blade");
    EQUIPMENT_MAP.put(108_10065L,  "heavy_mace");
    EQUIPMENT_MAP.put(108_10066L,  "holy_ankh");

    EQUIPMENT_MAP.put(108_10067L,  "indoras_axe");
    EQUIPMENT_MAP.put(108_10068L,  "iron_kneepiece");
    EQUIPMENT_MAP.put(108_10069L,  "iron_knuckle");

    EQUIPMENT_MAP.put(108_10070L,  "jade_dg_armor");
    EQUIPMENT_MAP.put(108_10071L,  "jade_stone");
    EQUIPMENT_MAP.put(108_10072L,  "jeweled_crown");

    EQUIPMENT_MAP.put(108_10073L,  "knight_helm");
    EQUIPMENT_MAP.put(108_10074L,  "knight_shield");

    EQUIPMENT_MAP.put(108_10075L,  "lance");
    EQUIPMENT_MAP.put(108_10076L,  "leather_armor");
    EQUIPMENT_MAP.put(108_10077L,  "leather_boots");
    EQUIPMENT_MAP.put(108_10078L,  "leather_jacket");
    EQUIPMENT_MAP.put(108_10079L,  "leather_shoes");
    EQUIPMENT_MAP.put(108_10080L,  "legend_casque");
    EQUIPMENT_MAP.put(108_10081L,  "lion_fur");
    EQUIPMENT_MAP.put(108_10082L,  "long_bow");

    EQUIPMENT_MAP.put(108_10083L,  "mace");
    EQUIPMENT_MAP.put(108_10084L,  "mage_ring");
    EQUIPMENT_MAP.put(108_10085L,  "magic_ego_bell");
    EQUIPMENT_MAP.put(108_10086L,  "magical_greaves");
    EQUIPMENT_MAP.put(108_10087L,  "magical_hat");
    EQUIPMENT_MAP.put(108_10088L,  "magical_ring");
    EQUIPMENT_MAP.put(108_10089L,  "masters_vest");
    EQUIPMENT_MAP.put(108_10090L,  "mind_crush");
    EQUIPMENT_MAP.put(108_10091L,  "morning_star");

    EQUIPMENT_MAP.put(108_10092L,  "panic_guard");
    EQUIPMENT_MAP.put(108_10093L,  "partisan");
    EQUIPMENT_MAP.put(108_10094L,  "phantom_shield");
    EQUIPMENT_MAP.put(108_10095L,  "phoenix_plume");
    EQUIPMENT_MAP.put(108_10096L,  "physical_ring");
    EQUIPMENT_MAP.put(108_10097L,  "plate_mail");
    EQUIPMENT_MAP.put(108_10098L,  "platinum_collar");
    EQUIPMENT_MAP.put(108_10099L,  "poison_guard");
    EQUIPMENT_MAP.put(108_10100L,  "power_wrist");
    EQUIPMENT_MAP.put(108_10101L,  "pretty_hammer");
    EQUIPMENT_MAP.put(108_10102L,  "protector");

    EQUIPMENT_MAP.put(108_10103L,  "rainbow_dress");
    EQUIPMENT_MAP.put(108_10104L,  "rainbow_earring");
    EQUIPMENT_MAP.put(108_10105L,  "rapier");
    EQUIPMENT_MAP.put(108_10106L,  "red_dg_armor");
    EQUIPMENT_MAP.put(108_10107L,  "red_eye_stone");
    EQUIPMENT_MAP.put(108_10108L,  "robe");
    EQUIPMENT_MAP.put(108_10109L,  "roses_hair_band");
    EQUIPMENT_MAP.put(108_10110L,  "ruby_ring");
    
    EQUIPMENT_MAP.put(108_10111L,  "sages_cloak");
    EQUIPMENT_MAP.put(108_10112L,  "saint_armor");
    EQUIPMENT_MAP.put(108_10113L,  "sallet");
    EQUIPMENT_MAP.put(108_10114L,  "sapphire_pin");
    EQUIPMENT_MAP.put(108_10115L,  "satori_vest");
    EQUIPMENT_MAP.put(108_10116L,  "scale_armor");
    EQUIPMENT_MAP.put(108_10117L,  "shadow_cutter");
    EQUIPMENT_MAP.put(108_10118L,  "short_bow");
    EQUIPMENT_MAP.put(108_10120L,  "silver_dg_armor");
    EQUIPMENT_MAP.put(108_10121L,  "silver_stone");
    EQUIPMENT_MAP.put(108_10122L,  "silver_vest");
    EQUIPMENT_MAP.put(108_10123L,  "soft_boots");
    EQUIPMENT_MAP.put(108_10124L,  "soul_eater");
    EQUIPMENT_MAP.put(108_10125L,  "soul_headband");
    EQUIPMENT_MAP.put(108_10126L,  "sparkle_arrow");
    EQUIPMENT_MAP.put(108_10127L,  "sparkle_dress");
    EQUIPMENT_MAP.put(108_10128L,  "spear");
    EQUIPMENT_MAP.put(108_10129L,  "spear_of_terror");
    EQUIPMENT_MAP.put(108_10130L,  "spirit_cloak");
    EQUIPMENT_MAP.put(108_10131L,  "spirit_ring");
    EQUIPMENT_MAP.put(108_10132L,  "spiritual_ring");
    EQUIPMENT_MAP.put(108_10133L,  "stardust_boots");
    EQUIPMENT_MAP.put(108_10134L,  "stun_guard");
    
    EQUIPMENT_MAP.put(108_10135L,  "talisman");
    EQUIPMENT_MAP.put(108_10136L,  "therapy_ring");
    EQUIPMENT_MAP.put(108_10137L,  "thunder_fist");
    EQUIPMENT_MAP.put(108_10138L,  "tiara");
    EQUIPMENT_MAP.put(108_10139L,  "tomahawk");
    EQUIPMENT_MAP.put(108_10140L,  "twister_glaive");
    
    EQUIPMENT_MAP.put(108_10141L,  "ultimate_wargod");
    
    EQUIPMENT_MAP.put(108_10142L,  "violet_dg_armor");
    EQUIPMENT_MAP.put(108_10143L,  "violet_stone");
    EQUIPMENT_MAP.put(108_10144L,  "virulent_arrow");
    
    EQUIPMENT_MAP.put(108_10145L,  "war_hammer");
    EQUIPMENT_MAP.put(108_10146L,  "wargod_calling");
    EQUIPMENT_MAP.put(108_10147L,  "wargods_amulet");
    EQUIPMENT_MAP.put(108_10148L,  "wargods_sash");
     



    for (final Map.Entry<Long, String> entry :EQUIPMENT_MAP.entrySet()) {
      EQUIPMENT_MAP_REVERSE.put(entry.getValue(), entry.getKey());
    }
    assert EQUIPMENT_MAP.size() == EQUIPMENT_MAP_REVERSE.size();
  }

  private Equipment () {
  }

  public static Map<Long, String> getStaticMap() {
    return Collections.unmodifiableMap(EQUIPMENT_MAP);
  }

  private static Map<String, Long> getStaticReverseMap() {
    return Collections.unmodifiableMap(EQUIPMENT_MAP_REVERSE);
  }

  public static Long getAPItemIdFromRegistryId(final RegistryId registryId) {
    return getStaticReverseMap().get(registryId.entryId());
  }

  public static String getEntryIdFromAPItemId (final Long itemId) {
    return getStaticMap().get(itemId);
  }
}
