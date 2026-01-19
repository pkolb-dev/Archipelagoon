package archipelagoon.ap.mapping.locations;

import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Enemies {
  private static final Map<Long, String> ENEMY_LOCATIONS = new HashMap<>();
  private static final Map<String, Long> ENEMY_LOCATIONS_REVERSE = new HashMap<>();

  static {
    ENEMY_LOCATIONS.put(108_70001L, "knight_of_sandora_knight_of_sandora_commander");
    ENEMY_LOCATIONS.put(108_70002L, "fruegel_hellena_warden_hellena_warden_senior_warden_senior_warden");
    ENEMY_LOCATIONS.put(108_70003L, "urobolus");
    ENEMY_LOCATIONS.put(108_70004L, "sandora_elite_sandora_elite_sandora_elite");
    ENEMY_LOCATIONS.put(108_70005L, "kongol");
    ENEMY_LOCATIONS.put(108_70006L, "virage_head_virage_body_virage_arm_");
    ENEMY_LOCATIONS.put(108_70007L, "fire_bird_volcano_ball_volcano_ball_volcano_ball_volcano_ball");
    ENEMY_LOCATIONS.put(108_70008L, "feyrbrand_greham");
    ENEMY_LOCATIONS.put(108_70009L, "drake_the_bandit_wire_bursting_ball_bursting_ball_bursting_ball");
    ENEMY_LOCATIONS.put(108_70010L, "shirley_shana_albert");
    ENEMY_LOCATIONS.put(108_70011L, "gorgaga");
    ENEMY_LOCATIONS.put(108_70012L, "serfius");
    ENEMY_LOCATIONS.put(108_70013L, "danton");
    ENEMY_LOCATIONS.put(108_70014L, "atlow");
    ENEMY_LOCATIONS.put(108_70015L, "lloyd_dummy_lloyd");
    ENEMY_LOCATIONS.put(108_70016L, "fruegel_rodriguez_guftas");
    ENEMY_LOCATIONS.put(108_70017L, "kongol_1");
    ENEMY_LOCATIONS.put(108_70018L, "emperor_doel_dragoon_doel");
    ENEMY_LOCATIONS.put(108_70019L, "mappi_crafty_thief_crafty_thief");
    ENEMY_LOCATIONS.put(108_70020L, "virage_head_virage_body_virage_arm_virage_arm_");
    ENEMY_LOCATIONS.put(108_70021L, "mappi_gehrich");
    ENEMY_LOCATIONS.put(108_70022L, "lenus");
    ENEMY_LOCATIONS.put(108_70023L, "ghost_commander_ghost_knight_ghost_knight_ghost_knight_ghost_knight");
    ENEMY_LOCATIONS.put(108_70024L, "lenus_regole");
    ENEMY_LOCATIONS.put(108_70025L, "s_virage_head_s_virage_body_s_virage_arm_");
    ENEMY_LOCATIONS.put(108_70026L, "grand_jewel");
    ENEMY_LOCATIONS.put(108_70027L, "divine_dragon_divine_cannon_divine_ball");
    ENEMY_LOCATIONS.put(108_70028L, "windigo_snow_cannon_snow_cannon_heart");
    ENEMY_LOCATIONS.put(108_70029L, "lloyd");
    ENEMY_LOCATIONS.put(108_70030L, "polter_helm_polter_armor_polter_sword");
    ENEMY_LOCATIONS.put(108_70031L, "last_kraken_cleone_cleone");
    ENEMY_LOCATIONS.put(108_70032L, "magician_faust_mazo_mazo_mazo_mazo");
    ENEMY_LOCATIONS.put(108_70033L, "belzac");
    ENEMY_LOCATIONS.put(108_70034L, "damia");
    ENEMY_LOCATIONS.put(108_70035L, "kanzas");
    ENEMY_LOCATIONS.put(108_70036L, "syuveil");
    ENEMY_LOCATIONS.put(108_70037L, "vector_selebus_kubila");
    ENEMY_LOCATIONS.put(108_70038L, "ghostfb_dragon_spirit");
    ENEMY_LOCATIONS.put(108_70039L, "ghost_regole_dragon_spirit");
    ENEMY_LOCATIONS.put(108_70040L, "divine_dragoon_ghost_dragon_spirit");
    ENEMY_LOCATIONS.put(108_70041L, "zackwell_lavitzs_spirit");
    ENEMY_LOCATIONS.put(108_70042L, "caterpillar_pupa_imago");
    ENEMY_LOCATIONS.put(108_70043L, "michael_michael_core_");
    ENEMY_LOCATIONS.put(108_70044L, "s_virage_head_s_virage_arm_s_virage_body_");
    ENEMY_LOCATIONS.put(108_70045L, "zieg_feld_missing");
    ENEMY_LOCATIONS.put(108_70046L, "melbu_frahma_melbu_frahma_melbu_frahma_melbu_frahma_melbu_frahma");
    ENEMY_LOCATIONS.put(108_70047L, "jiango");
    ENEMY_LOCATIONS.put(108_70048L, "kamuy_kamuys_tree");

    for(final Map.Entry<Long, String> entry :ENEMY_LOCATIONS.entrySet()) {
      ENEMY_LOCATIONS_REVERSE.put(entry.getValue(), entry.getKey());
    }
    assert ENEMY_LOCATIONS.size() == ENEMY_LOCATIONS_REVERSE.size();
  }

  private Enemies() {
  }

  public static Map<Long, String> getStaticMap() {
    return Collections.unmodifiableMap(ENEMY_LOCATIONS);
  }

  public static Map<String, Long> getStaticReverseMap() {
    return Collections.unmodifiableMap(ENEMY_LOCATIONS_REVERSE);
  }

  public static Long getAPLocationIdFromRegistryId(final RegistryId registryId) {
    return getStaticReverseMap().get(registryId.entryId());
  }

  public static String getEntryIdFromAPLocationId (final Long locationId) {
    return getStaticMap().get(locationId);
  }
}
