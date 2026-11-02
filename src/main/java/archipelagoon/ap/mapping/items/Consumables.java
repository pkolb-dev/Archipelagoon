package archipelagoon.ap.mapping.items;

import legend.lodmod.LodItems;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Consumables {
  private static final Map<Long, RegistryId> CONSUMABLE_MAP = new HashMap<>();

  static {
    CONSUMABLE_MAP.put(108_00001L, LodItems.ANGELS_PRAYER.getId());
    CONSUMABLE_MAP.put(108_00002L, LodItems.HEALING_POTION.getId());
    CONSUMABLE_MAP.put(108_00003L, LodItems.HEALING_FOG.getId());
    CONSUMABLE_MAP.put(108_00004L, LodItems.HEALING_BREEZE.getId());
    CONSUMABLE_MAP.put(108_00005L, LodItems.HEALING_RAIN.getId());
    CONSUMABLE_MAP.put(108_00006L, LodItems.MOON_SERENADE.getId());
    CONSUMABLE_MAP.put(108_00007L, LodItems.SUN_RHAPSODY.getId());
    CONSUMABLE_MAP.put(108_00008L, LodItems.SPIRIT_POTION.getId());
    CONSUMABLE_MAP.put(108_00009L, LodItems.BODY_PURIFIER.getId());
    CONSUMABLE_MAP.put(108_00010L, LodItems.DEPETRIFIER.getId());
    CONSUMABLE_MAP.put(108_00011L, LodItems.MIND_PURIFIER.getId());
    CONSUMABLE_MAP.put(108_00012L, LodItems.RECOVERY_BALL.getId());

    CONSUMABLE_MAP.put(108_00013L, LodItems.BLACK_RAIN.getId());
    CONSUMABLE_MAP.put(108_00014L, LodItems.BURN_OUT.getId());
    CONSUMABLE_MAP.put(108_00015L, LodItems.BURNING_WAVE.getId());
    CONSUMABLE_MAP.put(108_00016L, LodItems.DANCING_RAY.getId());
    CONSUMABLE_MAP.put(108_00017L, LodItems.DARK_MIST.getId());
    CONSUMABLE_MAP.put(108_00018L, LodItems.DETONATE_ROCK.getId());
    CONSUMABLE_MAP.put(108_00019L, LodItems.DOWN_BURST.getId());
    CONSUMABLE_MAP.put(108_00020L, LodItems.FATAL_BLIZZARD.getId());
    CONSUMABLE_MAP.put(108_00021L, LodItems.FLASH_HALL.getId());
    CONSUMABLE_MAP.put(108_00022L, LodItems.FROZEN_JET.getId());
    CONSUMABLE_MAP.put(108_00023L, LodItems.GRAVITY_GRABBER.getId());
    CONSUMABLE_MAP.put(108_00024L, LodItems.GUSHING_MAGMA.getId());
    CONSUMABLE_MAP.put(108_00025L, LodItems.METEOR_FALL.getId());
    CONSUMABLE_MAP.put(108_00026L, LodItems.NIGHT_RAID.getId());
    CONSUMABLE_MAP.put(108_00027L, LodItems.PELLET.getId());
    CONSUMABLE_MAP.put(108_00028L, LodItems.PSYCHE_BOMB.getId());
    CONSUMABLE_MAP.put(108_00029L, LodItems.PSYCHE_BOMB_X.getId());
    CONSUMABLE_MAP.put(108_00030L, LodItems.RAVE_TWISTER.getId());
    CONSUMABLE_MAP.put(108_00031L, LodItems.SPARK_NET.getId());
    CONSUMABLE_MAP.put(108_00032L, LodItems.SPEAR_FROST.getId());
    CONSUMABLE_MAP.put(108_00033L, LodItems.SPECTRAL_FLASH.getId());
    CONSUMABLE_MAP.put(108_00034L, LodItems.SPINNING_GALE.getId());
    CONSUMABLE_MAP.put(108_00035L, LodItems.THUNDERBOLT.getId());
    CONSUMABLE_MAP.put(108_00036L, LodItems.TRANS_LIGHT.getId());
    CONSUMABLE_MAP.put(108_00037L, LodItems.ATTACK_BALL.getId());

    CONSUMABLE_MAP.put(108_00038L, LodItems.CHARM_POTION.getId());
    CONSUMABLE_MAP.put(108_00039L, LodItems.MAGIC_SIG_STONE.getId());
    CONSUMABLE_MAP.put(108_00040L, LodItems.MIDNIGHT_TERROR.getId());
    CONSUMABLE_MAP.put(108_00041L, LodItems.PANDEMONIUM.getId());
    CONSUMABLE_MAP.put(108_00042L, LodItems.PANIC_BELL.getId());
    CONSUMABLE_MAP.put(108_00043L, LodItems.POISON_NEEDLE.getId());
    CONSUMABLE_MAP.put(108_00044L, LodItems.SACHET.getId());
    CONSUMABLE_MAP.put(108_00045L, LodItems.SMOKE_BALL.getId());
    CONSUMABLE_MAP.put(108_00046L, LodItems.STUNNING_HAMMER.getId());
    CONSUMABLE_MAP.put(108_00047L, LodItems.TOTAL_VANISHING.getId());
  }

  private Consumables() {
  }

  public static Map<Long, RegistryId> getStaticMap() {
    return Collections.unmodifiableMap(CONSUMABLE_MAP);
  }
}
