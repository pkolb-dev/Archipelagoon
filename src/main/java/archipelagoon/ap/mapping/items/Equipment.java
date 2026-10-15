package archipelagoon.ap.mapping.items;

import legend.lodmod.LodEquipment;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Equipment {
  private static final Map<Long, RegistryId> EQUIPMENT_MAP = new HashMap<>();

  static {
    EQUIPMENT_MAP.put(108_10001L, LodEquipment.ACTIVE_RING.getId());
    EQUIPMENT_MAP.put(108_10002L, LodEquipment.AMULET.getId());
    EQUIPMENT_MAP.put(108_10003L, LodEquipment.ANGEL_ROBE.getId());
    EQUIPMENT_MAP.put(108_10004L, LodEquipment.ANGEL_SCARF.getId());
    EQUIPMENT_MAP.put(108_10005L, LodEquipment.ARMET.getId());
    EQUIPMENT_MAP.put(108_10006L, LodEquipment.ARMOR_OF_LEGEND.getId());
    EQUIPMENT_MAP.put(108_10007L, LodEquipment.ARMOR_OF_YORE.getId());
    EQUIPMENT_MAP.put(108_10008L, LodEquipment.ARROW_OF_FORCE.getId());
    EQUIPMENT_MAP.put(108_10009L, LodEquipment.ATTACK_BADGE.getId());
    EQUIPMENT_MAP.put(108_10010L, LodEquipment.AXE.getId());

    EQUIPMENT_MAP.put(108_10011L, LodEquipment.BANDANA.getId());
    EQUIPMENT_MAP.put(108_10012L, LodEquipment.BANDITS_RING.getId());
    EQUIPMENT_MAP.put(108_10013L, LodEquipment.BANDITS_SHOES.getId());
    EQUIPMENT_MAP.put(108_10014L, LodEquipment.BASHER.getId());
    EQUIPMENT_MAP.put(108_10015L, LodEquipment.BASTARD_SWORD.getId());
    EQUIPMENT_MAP.put(108_10016L, LodEquipment.BATTLE_AXE.getId());
    EQUIPMENT_MAP.put(108_10017L, LodEquipment.BEAST_FANG.getId());
    EQUIPMENT_MAP.put(108_10018L, LodEquipment.BEMUSING_ARROW.getId());
    EQUIPMENT_MAP.put(108_10019L, LodEquipment.BLUE_DG_ARMOR.getId());
    EQUIPMENT_MAP.put(108_10020L, LodEquipment.BLUE_SEA_STONE.getId());
    EQUIPMENT_MAP.put(108_10021L, LodEquipment.BRACELET.getId());
    EQUIPMENT_MAP.put(108_10022L, LodEquipment.BRASS_KNUCKLE.getId());
    EQUIPMENT_MAP.put(108_10023L, LodEquipment.BRAVERY_AMULET.getId());
    EQUIPMENT_MAP.put(108_10024L, LodEquipment.BREAST_PLATE.getId());
    EQUIPMENT_MAP.put(108_10025L, LodEquipment.BROAD_SWORD.getId());

    EQUIPMENT_MAP.put(108_10026L, LodEquipment.CAPE.getId());
    EQUIPMENT_MAP.put(108_10027L, LodEquipment.CHAIN_MAIL.getId());
    EQUIPMENT_MAP.put(108_10028L, LodEquipment.CLAYMORE.getId());
    EQUIPMENT_MAP.put(108_10029L, LodEquipment.CLOTHES.getId());
    EQUIPMENT_MAP.put(108_10030L, LodEquipment.COMBAT_SHOES.getId());

    EQUIPMENT_MAP.put(108_10031L, LodEquipment.DANCERS_RING.getId());
    EQUIPMENT_MAP.put(108_10032L, LodEquipment.DANCERS_SHOES.getId());
    EQUIPMENT_MAP.put(108_10033L, LodEquipment.DANCING_DAGGER.getId());
    EQUIPMENT_MAP.put(108_10034L, LodEquipment.DARK_DG_ARMOR.getId());
    EQUIPMENT_MAP.put(108_10035L, LodEquipment.DARKNESS_STONE.getId());
    EQUIPMENT_MAP.put(108_10036L, LodEquipment.DEMON_STILETTO.getId());
    EQUIPMENT_MAP.put(108_10037L, LodEquipment.DESTONE_AMULET.getId());
    EQUIPMENT_MAP.put(108_10038L, LodEquipment.DESTROYER_MACE.getId());
    EQUIPMENT_MAP.put(108_10039L, LodEquipment.DETONATE_ARROW.getId());
    EQUIPMENT_MAP.put(108_10040L, LodEquipment.DIAMOND_CLAW.getId());
    EQUIPMENT_MAP.put(108_10041L, LodEquipment.DISCIPLE_VEST.getId());
    EQUIPMENT_MAP.put(108_10042L, LodEquipment.DRAGON_BUSTER.getId());
    EQUIPMENT_MAP.put(108_10043L, LodEquipment.DRAGON_HELM.getId());
    EQUIPMENT_MAP.put(108_10044L, LodEquipment.DRAGON_SHIELD.getId());

    EQUIPMENT_MAP.put(108_10045L, LodEquipment.ELUDE_CLOAK.getId());
    EQUIPMENT_MAP.put(108_10046L, LodEquipment.EMERALD_EARRING.getId());
    EQUIPMENT_MAP.put(108_10047L, LodEquipment.ENERGY_GIRDLE.getId());

    EQUIPMENT_MAP.put(108_10048L, LodEquipment.FAIRY_SWORD.getId());
    EQUIPMENT_MAP.put(108_10049L, LodEquipment.FAKE_POWER_WRIST.getId());
    EQUIPMENT_MAP.put(108_10050L, LodEquipment.FAKE_SHIELD.getId());
    EQUIPMENT_MAP.put(108_10051L, LodEquipment.FALCHION.getId());
    EQUIPMENT_MAP.put(108_10052L, LodEquipment.FELT_HAT.getId());
    EQUIPMENT_MAP.put(108_10053L, LodEquipment.FLAMBERGE.getId());

    EQUIPMENT_MAP.put(108_10054L, LodEquipment.GIGANTO_ARMOR.getId());
    EQUIPMENT_MAP.put(108_10055L, LodEquipment.GIGANTO_HELM.getId());
    EQUIPMENT_MAP.put(108_10056L, LodEquipment.GIGANTO_RING.getId());
    EQUIPMENT_MAP.put(108_10057L, LodEquipment.GLADIUS.getId());
    EQUIPMENT_MAP.put(108_10058L, LodEquipment.GLAIVE.getId());
    EQUIPMENT_MAP.put(108_10059L, LodEquipment.GOLD_DG_ARMOR.getId());
    EQUIPMENT_MAP.put(108_10060L, LodEquipment.GOLDEN_STONE.getId());
    EQUIPMENT_MAP.put(108_10061L, LodEquipment.GREAT_AXE.getId());
    EQUIPMENT_MAP.put(108_10062L, LodEquipment.GUARD_BADGE.getId());

    EQUIPMENT_MAP.put(108_10063L, LodEquipment.HALBERD.getId());
    EQUIPMENT_MAP.put(108_10064L, LodEquipment.HEAT_BLADE.getId());
    EQUIPMENT_MAP.put(108_10065L, LodEquipment.HEAVY_MACE.getId());
    EQUIPMENT_MAP.put(108_10066L, LodEquipment.HOLY_ANKH.getId());

    EQUIPMENT_MAP.put(108_10067L, LodEquipment.INDORAS_AXE.getId());
    EQUIPMENT_MAP.put(108_10068L, LodEquipment.IRON_KNEEPIECE.getId());
    EQUIPMENT_MAP.put(108_10069L, LodEquipment.IRON_KNUCKLE.getId());

    EQUIPMENT_MAP.put(108_10070L, LodEquipment.JADE_DG_ARMOR.getId());
    EQUIPMENT_MAP.put(108_10071L, LodEquipment.JADE_STONE.getId());
    EQUIPMENT_MAP.put(108_10072L, LodEquipment.JEWELED_CROWN.getId());

    EQUIPMENT_MAP.put(108_10073L, LodEquipment.KNIGHT_HELM.getId());
    EQUIPMENT_MAP.put(108_10074L, LodEquipment.KNIGHT_SHIELD.getId());

    EQUIPMENT_MAP.put(108_10075L, LodEquipment.LANCE.getId());
    EQUIPMENT_MAP.put(108_10076L, LodEquipment.LEATHER_ARMOR.getId());
    EQUIPMENT_MAP.put(108_10077L, LodEquipment.LEATHER_BOOTS.getId());
    EQUIPMENT_MAP.put(108_10078L, LodEquipment.LEATHER_JACKET.getId());
    EQUIPMENT_MAP.put(108_10079L, LodEquipment.LEATHER_SHOES.getId());
    EQUIPMENT_MAP.put(108_10080L, LodEquipment.LEGEND_CASQUE.getId());
    EQUIPMENT_MAP.put(108_10081L, LodEquipment.LION_FUR.getId());
    EQUIPMENT_MAP.put(108_10082L, LodEquipment.LONG_BOW.getId());

    EQUIPMENT_MAP.put(108_10083L, LodEquipment.MACE.getId());
    EQUIPMENT_MAP.put(108_10084L, LodEquipment.MAGE_RING.getId());
    EQUIPMENT_MAP.put(108_10085L, LodEquipment.MAGIC_EGO_BELL.getId());
    EQUIPMENT_MAP.put(108_10086L, LodEquipment.MAGICAL_GREAVES.getId());
    EQUIPMENT_MAP.put(108_10087L, LodEquipment.MAGICAL_HAT.getId());
    EQUIPMENT_MAP.put(108_10088L, LodEquipment.MAGICAL_RING.getId());
    EQUIPMENT_MAP.put(108_10089L, LodEquipment.MASTERS_VEST.getId());
    EQUIPMENT_MAP.put(108_10090L, LodEquipment.MIND_CRUSH.getId());
    EQUIPMENT_MAP.put(108_10091L, LodEquipment.MORNING_STAR.getId());

    EQUIPMENT_MAP.put(108_10092L, LodEquipment.PANIC_GUARD.getId());
    EQUIPMENT_MAP.put(108_10093L, LodEquipment.PARTISAN.getId());
    EQUIPMENT_MAP.put(108_10094L, LodEquipment.PHANTOM_SHIELD.getId());
    EQUIPMENT_MAP.put(108_10095L, LodEquipment.PHOENIX_PLUME.getId());
    EQUIPMENT_MAP.put(108_10096L, LodEquipment.PHYSICAL_RING.getId());
    EQUIPMENT_MAP.put(108_10097L, LodEquipment.PLATE_MAIL.getId());
    EQUIPMENT_MAP.put(108_10098L, LodEquipment.PLATINUM_COLLAR.getId());
    EQUIPMENT_MAP.put(108_10099L, LodEquipment.POISON_GUARD.getId());
    EQUIPMENT_MAP.put(108_10100L, LodEquipment.POWER_WRIST.getId());
    EQUIPMENT_MAP.put(108_10101L, LodEquipment.PRETTY_HAMMER.getId());
    EQUIPMENT_MAP.put(108_10102L, LodEquipment.PROTECTOR.getId());

    EQUIPMENT_MAP.put(108_10103L, LodEquipment.RAINBOW_DRESS.getId());
    EQUIPMENT_MAP.put(108_10104L, LodEquipment.RAINBOW_EARRING.getId());
    EQUIPMENT_MAP.put(108_10105L, LodEquipment.RAPIER.getId());
    EQUIPMENT_MAP.put(108_10106L, LodEquipment.RED_DG_ARMOR.getId());
    EQUIPMENT_MAP.put(108_10107L, LodEquipment.RED_EYE_STONE.getId());
    EQUIPMENT_MAP.put(108_10108L, LodEquipment.ROBE.getId());
    EQUIPMENT_MAP.put(108_10109L, LodEquipment.ROSES_HAIR_BAND.getId());
    EQUIPMENT_MAP.put(108_10110L, LodEquipment.RUBY_RING.getId());

    EQUIPMENT_MAP.put(108_10111L, LodEquipment.SAGES_CLOAK.getId());
    EQUIPMENT_MAP.put(108_10112L, LodEquipment.SAINT_ARMOR.getId());
    EQUIPMENT_MAP.put(108_10113L, LodEquipment.SALLET.getId());
    EQUIPMENT_MAP.put(108_10114L, LodEquipment.SAPPHIRE_PIN.getId());
    EQUIPMENT_MAP.put(108_10115L, LodEquipment.SATORI_VEST.getId());
    EQUIPMENT_MAP.put(108_10116L, LodEquipment.SCALE_ARMOR.getId());
    EQUIPMENT_MAP.put(108_10117L, LodEquipment.SHADOW_CUTTER.getId());
    EQUIPMENT_MAP.put(108_10118L, LodEquipment.SHORT_BOW.getId());
    EQUIPMENT_MAP.put(108_10119L, LodEquipment.SILVER_DG_ARMOR.getId());
    EQUIPMENT_MAP.put(108_10120L, LodEquipment.SILVER_STONE.getId());
    EQUIPMENT_MAP.put(108_10121L, LodEquipment.SILVER_VEST.getId());
    EQUIPMENT_MAP.put(108_10122L, LodEquipment.SOFT_BOOTS.getId());
    EQUIPMENT_MAP.put(108_10123L, LodEquipment.SOUL_EATER.getId());
    EQUIPMENT_MAP.put(108_10124L, LodEquipment.SOUL_HEADBAND.getId());
    EQUIPMENT_MAP.put(108_10125L, LodEquipment.SPARKLE_ARROW.getId());
    EQUIPMENT_MAP.put(108_10126L, LodEquipment.SPARKLE_DRESS.getId());
    EQUIPMENT_MAP.put(108_10127L, LodEquipment.SPEAR.getId());
    EQUIPMENT_MAP.put(108_10128L, LodEquipment.SPEAR_OF_TERROR.getId());
    EQUIPMENT_MAP.put(108_10129L, LodEquipment.SPIRIT_CLOAK.getId());
    EQUIPMENT_MAP.put(108_10130L, LodEquipment.SPIRIT_RING.getId());
    EQUIPMENT_MAP.put(108_10131L, LodEquipment.SPIRITUAL_RING.getId());
    EQUIPMENT_MAP.put(108_10132L, LodEquipment.STARDUST_BOOTS.getId());
    EQUIPMENT_MAP.put(108_10133L, LodEquipment.STUN_GUARD.getId());

    EQUIPMENT_MAP.put(108_10134L, LodEquipment.TALISMAN.getId());
    EQUIPMENT_MAP.put(108_10135L, LodEquipment.THERAPY_RING.getId());
    EQUIPMENT_MAP.put(108_10136L, LodEquipment.THUNDER_FIST.getId());
    EQUIPMENT_MAP.put(108_10137L, LodEquipment.TIARA.getId());
    EQUIPMENT_MAP.put(108_10138L, LodEquipment.TOMAHAWK.getId());
    EQUIPMENT_MAP.put(108_10139L, LodEquipment.TWISTER_GLAIVE.getId());

    EQUIPMENT_MAP.put(108_10140L, LodEquipment.ULTIMATE_WARGOD.getId());

    EQUIPMENT_MAP.put(108_10141L, LodEquipment.VIOLET_DG_ARMOR.getId());
    EQUIPMENT_MAP.put(108_10142L, LodEquipment.VIOLET_STONE.getId());
    EQUIPMENT_MAP.put(108_10143L, LodEquipment.VIRULENT_ARROW.getId());

    EQUIPMENT_MAP.put(108_10144L, LodEquipment.WAR_HAMMER.getId());
    EQUIPMENT_MAP.put(108_10145L, LodEquipment.WARGOD_CALLING.getId());
    EQUIPMENT_MAP.put(108_10146L, LodEquipment.WARGODS_AMULET.getId());
    EQUIPMENT_MAP.put(108_10147L, LodEquipment.WARGODS_SASH.getId());
    EQUIPMENT_MAP.put(108_10148L, LodEquipment.WARRIOR_DRESS.getId());
  }

  private Equipment() {
  }

  public static Map<Long, RegistryId> getStaticMap() {
    return Collections.unmodifiableMap(EQUIPMENT_MAP);
  }
}
