package archipelagoon.ap.mapping.items;

import legend.lodmod.LodCharacterTemplates;
import legend.lodmod.LodSpells;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public final class Magic {
  private static final Map<Long, RegistryId> MAGIC_MAP = new HashMap<>();
  private static final Map<RegistryId, Long> PROGRESSIVE_MAGIC_MAP = new LinkedHashMap<>();

  static {
    MAGIC_MAP.put(108_31001L, LodSpells.FLAMESHOT.getId());
    MAGIC_MAP.put(108_31002L, LodSpells.EXPLOSION.getId());
    MAGIC_MAP.put(108_31003L, LodSpells.FINAL_BURST.getId());
    MAGIC_MAP.put(108_31004L, LodSpells.RED_EYED_DRAGON.getId());
    MAGIC_MAP.put(108_31005L, LodSpells.DIVINE_DG_BALL.getId());
    MAGIC_MAP.put(108_31006L, LodSpells.DIVINE_DG_CANNON.getId());

    MAGIC_MAP.put(108_31011L, LodSpells.WING_BLASTER.getId());
    MAGIC_MAP.put(108_31012L, LodSpells.BLOSSOM_STORM.getId());
    MAGIC_MAP.put(108_31013L, LodSpells.GASPLESS.getId());
    MAGIC_MAP.put(108_31014L, LodSpells.JADE_DRAGON.getId());

    MAGIC_MAP.put(108_31021L, LodSpells.ASTRAL_DRAIN.getId());
    MAGIC_MAP.put(108_31022L, LodSpells.DEATH_DIMENSION.getId());
    MAGIC_MAP.put(108_31023L, LodSpells.DEMONS_GATE.getId());
    MAGIC_MAP.put(108_31024L, LodSpells.DARK_DRAGON.getId());

    MAGIC_MAP.put(108_31031L, LodSpells.MOON_LIGHT.getId());
    MAGIC_MAP.put(108_31032L, LodSpells.STAR_CHILDREN.getId());
    MAGIC_MAP.put(108_31033L, LodSpells.GATES_OF_HEAVEN.getId());
    MAGIC_MAP.put(108_31034L, LodSpells.WHITE_SILVER_DRAGON.getId());

    MAGIC_MAP.put(108_31041L, LodSpells.ATOMIC_MIND.getId());
    MAGIC_MAP.put(108_31042L, LodSpells.THUNDER_KID.getId());
    MAGIC_MAP.put(108_31043L, LodSpells.THUNDER_GOD.getId());
    MAGIC_MAP.put(108_31044L, LodSpells.VIOLET_DRAGON.getId());

    MAGIC_MAP.put(108_31051L, LodSpells.ALBERT_WING_BLASTER.getId());
    MAGIC_MAP.put(108_31052L, LodSpells.ROSE_STORM.getId());
    MAGIC_MAP.put(108_31053L, LodSpells.ALBERT_GASPLESS.getId());
    MAGIC_MAP.put(108_31054L, LodSpells.JADE_DRAGON.getId());

    MAGIC_MAP.put(108_31061L, LodSpells.FREEZING_RING.getId());
    MAGIC_MAP.put(108_31062L, LodSpells.RAINBOW_BREATH.getId());
    MAGIC_MAP.put(108_31063L, LodSpells.DIAMOND_DUST.getId());
    MAGIC_MAP.put(108_31064L, LodSpells.BLUE_SEA_DRAGON.getId());

    MAGIC_MAP.put(108_31071L, LodSpells.GRAND_STREAM.getId());
    MAGIC_MAP.put(108_31072L, LodSpells.METEOR_STRIKE.getId());
    MAGIC_MAP.put(108_31073L, LodSpells.GOLDEN_DRAGON.getId());

    MAGIC_MAP.put(108_31081L, LodSpells.MIRANDA_MOON_LIGHT.getId());
    MAGIC_MAP.put(108_31082L, LodSpells.MIRANDA_STAR_CHILDREN.getId());
    MAGIC_MAP.put(108_31083L, LodSpells.MIRANDA_GATES_OF_HEAVEN.getId());
    MAGIC_MAP.put(108_31084L, LodSpells.WHITE_SILVER_DRAGON.getId());

    MAGIC_MAP.put(108_31091L, new RegistryId("lloyd_mod", "running_slash"));
    MAGIC_MAP.put(108_31092L, new RegistryId("lloyd_mod", "spectral_sword"));
    MAGIC_MAP.put(108_31093L, new RegistryId("lloyd_mod", "sword_rush"));
    MAGIC_MAP.put(108_31094L, new RegistryId("lloyd_mod", "aerial_crash"));
    MAGIC_MAP.put(108_31095L, new RegistryId("lloyd_mod", "ball_barrage"));
    MAGIC_MAP.put(108_31096L, new RegistryId("lloyd_mod", "sigil_of_explosion"));
    MAGIC_MAP.put(108_31097L, new RegistryId("lloyd_mod", "draconic_impale"));

    PROGRESSIVE_MAGIC_MAP.put(LodCharacterTemplates.DART.getId(), 108_31000L);
    PROGRESSIVE_MAGIC_MAP.put(LodCharacterTemplates.LAVITZ.getId(), 108_31010L);
    PROGRESSIVE_MAGIC_MAP.put(LodCharacterTemplates.SHANA.getId(), 108_31020L);
    PROGRESSIVE_MAGIC_MAP.put(LodCharacterTemplates.ROSE.getId(), 108_31030L);
    PROGRESSIVE_MAGIC_MAP.put(LodCharacterTemplates.HASCHEL.getId(), 108_31040L);
    PROGRESSIVE_MAGIC_MAP.put(LodCharacterTemplates.ALBERT.getId(), 108_31050L);
    PROGRESSIVE_MAGIC_MAP.put(LodCharacterTemplates.MERU.getId(), 108_31060L);
    PROGRESSIVE_MAGIC_MAP.put(LodCharacterTemplates.KONGOL.getId(), 108_31070L);
    PROGRESSIVE_MAGIC_MAP.put(LodCharacterTemplates.MIRANDA.getId(), 108_31080L);
    PROGRESSIVE_MAGIC_MAP.put(new RegistryId("lloyd_mod", "lloyd"), 108_31090L);
  }

  private Magic() {
  }

  public static Map<Long, RegistryId> getStaticMap() {
    return Collections.unmodifiableMap(MAGIC_MAP);
  }

  private static Map<RegistryId, Long> getProgressiveStaticMap() {
    return Collections.unmodifiableMap(PROGRESSIVE_MAGIC_MAP);
  }

  public static Long getAPItemIdFromCharacterIndex(final RegistryId charId) {
    return PROGRESSIVE_MAGIC_MAP.getOrDefault(charId, null);
  }

  public static RegistryId getCharacterIndexFromAPItemId(final Long apItemId) {
    if(!PROGRESSIVE_MAGIC_MAP.containsValue(apItemId)) {
      return null;
    }

    for(final Map.Entry<RegistryId, Long> entry : PROGRESSIVE_MAGIC_MAP.entrySet()) {
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


