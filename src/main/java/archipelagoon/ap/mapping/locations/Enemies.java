package archipelagoon.ap.mapping.locations;

import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class Enemies {
  private static final Map<String, Long> ENEMY_LOCATIONS = new HashMap<>();
  private static final Map<Long, String> ENEMY_LOCATIONS_REVERSE = new HashMap<>();

  static {
    ENEMY_LOCATIONS.put("knight_of_sandora_knight_of_sandora_commander", 108_70001L);
    ENEMY_LOCATIONS.put("fruegel_hellena_warden_hellena_warden_senior_warden_senior_warden", 108_70002L);
    ENEMY_LOCATIONS.put("urobolus", 108_70003L);
    ENEMY_LOCATIONS.put("sandora_elite_sandora_elite_sandora_elite", 108_70004L);
    ENEMY_LOCATIONS.put("kongol", 108_70005L);
    ENEMY_LOCATIONS.put("virage_head_virage_body_virage_arm_", 108_70006L);
    ENEMY_LOCATIONS.put("fire_bird_volcano_ball_volcano_ball_volcano_ball_volcano_ball", 108_70007L);
    ENEMY_LOCATIONS.put("feyrbrand_greham", 108_70008L);
    ENEMY_LOCATIONS.put("drake_the_bandit_wire_bursting_ball_bursting_ball_bursting_ball", 108_70009L);
    ENEMY_LOCATIONS.put("shirley_shana_albert", 108_70010L);
    ENEMY_LOCATIONS.put("gorgaga", 108_70011L);
    ENEMY_LOCATIONS.put("serfius", 108_70012L);
    ENEMY_LOCATIONS.put("danton", 108_70013L);
    ENEMY_LOCATIONS.put("atlow", 108_70014L);
    ENEMY_LOCATIONS.put("lloyd_dummy_lloyd", 108_70015L);
    ENEMY_LOCATIONS.put("fruegel_rodriguez_guftas", 108_70016L);
    ENEMY_LOCATIONS.put("kongol_1", 108_70017L);
    ENEMY_LOCATIONS.put("emperor_doel_dragoon_doel", 108_70018L);
    ENEMY_LOCATIONS.put("mappi_crafty_thief_crafty_thief", 108_70019L);
    ENEMY_LOCATIONS.put("virage_head_virage_body_virage_arm_virage_arm_", 108_70020L);
    ENEMY_LOCATIONS.put("mappi_gehrich", 108_70021L);
    ENEMY_LOCATIONS.put("lenus", 108_70022L);
    ENEMY_LOCATIONS.put("ghost_commander_ghost_knight_ghost_knight_ghost_knight_ghost_knight", 108_70023L);
    ENEMY_LOCATIONS.put("lenus_regole", 108_70024L);
    ENEMY_LOCATIONS.put("s_virage_head_s_virage_body_s_virage_arm_", 108_70025L);
    ENEMY_LOCATIONS.put("grand_jewel", 108_70026L);
    ENEMY_LOCATIONS.put("divine_dragon_divine_cannon_divine_ball", 108_70027L);
    ENEMY_LOCATIONS.put("windigo_snow_cannon_snow_cannon_heart", 108_70028L);
    ENEMY_LOCATIONS.put("lloyd", 108_70029L);
    ENEMY_LOCATIONS.put("polter_helm_polter_armor_polter_sword", 108_70030L);
    ENEMY_LOCATIONS.put("last_kraken_cleone_cleone", 108_70031L);
    ENEMY_LOCATIONS.put("magician_faust_mazo_mazo_mazo_mazo", 108_70032L);
    ENEMY_LOCATIONS.put("belzac", 108_70033L);
    ENEMY_LOCATIONS.put("damia", 108_70034L);
    ENEMY_LOCATIONS.put("kanzas", 108_70035L);
    ENEMY_LOCATIONS.put("syuveil", 108_70036L);
    ENEMY_LOCATIONS.put("vector_selebus_kubila", 108_70037L);
    ENEMY_LOCATIONS.put("ghostfb_dragon_spirit", 108_70038L);
    ENEMY_LOCATIONS.put("ghost_regole_dragon_spirit", 108_70039L);
    ENEMY_LOCATIONS.put("divine_dragoon_ghost_dragon_spirit", 108_70040L);
    ENEMY_LOCATIONS.put("zackwell_lavitzs_spirit", 108_70041L);
    ENEMY_LOCATIONS.put("caterpillar_pupa_imago", 108_70042L);
    ENEMY_LOCATIONS.put("michael_michael_core_", 108_70043L);
    ENEMY_LOCATIONS.put("s_virage_head_s_virage_arm_s_virage_body_", 108_70044L);
    ENEMY_LOCATIONS.put("zieg_feld_missing", 108_70045L);
    ENEMY_LOCATIONS.put("melbu_frahma_melbu_frahma_melbu_frahma_melbu_frahma_melbu_frahma", 108_70046L);
    ENEMY_LOCATIONS.put("jiango", 108_70047L);
    ENEMY_LOCATIONS.put("kamuy_kamuys_tree", 108_70048L);

    for(final Map.Entry<String, Long> entry :ENEMY_LOCATIONS.entrySet()) {
      ENEMY_LOCATIONS_REVERSE.put(entry.getValue(), entry.getKey());
    }
    assert ENEMY_LOCATIONS.size() == ENEMY_LOCATIONS_REVERSE.size();
  }

  private Enemies() {
  }

  public static Map<String, Long> getStaticMap() {
    return Collections.unmodifiableMap(ENEMY_LOCATIONS);
  }

  public static Map<Long, String> getStaticReverseMap() {
    return Collections.unmodifiableMap(ENEMY_LOCATIONS_REVERSE);
  }

  public static Optional<Long> findAPLocationId(final RegistryId registryId) {
    if (registryId == null) {
      return Optional.empty();
    }
    return Optional.ofNullable(ENEMY_LOCATIONS.get(registryId.entryId()));
  }

  public static String getEntryIdFromAPLocationId (final Long locationId) {
    return getStaticReverseMap().get(locationId);
  }
}
