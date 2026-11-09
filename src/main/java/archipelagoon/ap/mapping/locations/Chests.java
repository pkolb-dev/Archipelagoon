package archipelagoon.ap.mapping.locations;

import archipelagoon.data.enums.Submaps;
import archipelagoon.data.tables.ChestData;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Chests {
  private static final Map<Integer, Map<Integer, Long>> CHEST_LOCATIONS = new LinkedHashMap<>();

  static {
    //    final Long BASE_ID = 108_40000L;
    CHEST_LOCATIONS.put(Submaps.SELES_FENCE_AREA, ChestData.seles_chests);
    CHEST_LOCATIONS.put(Submaps.FOREST_MERCHANT, ChestData.forest_merchant_chests);
    CHEST_LOCATIONS.put(Submaps.FOREST_TREE_BRIDGE, ChestData.forest_tree_bridge_chests);
    CHEST_LOCATIONS.put(Submaps.FOREST_MAZE, ChestData.forest_maze_chests);
    CHEST_LOCATIONS.put(Submaps.HELLENA_PRISON_NORTHWEST_ENTRANCE, ChestData.hellena_01_nw_entrance_chests);
    CHEST_LOCATIONS.put(Submaps.HELLENA_BARRACKS_ELEVATOR, ChestData.hellena_barracks_chests);
    CHEST_LOCATIONS.put(Submaps.HELLENA_JUMP_PUZZLE, ChestData.hellena_jump_puzzle_chests);
    CHEST_LOCATIONS.put(Submaps.HELLENA_TINY_CELL, ChestData.hellena_tiny_cell_chests);
    CHEST_LOCATIONS.put(Submaps.HELLENA_SHANA_EAST_CELL, ChestData.hellena_shana_tower_east_chests);
    CHEST_LOCATIONS.put(Submaps.HELLENA_SHANA_WEST_CELL, ChestData.hellena_shana_tower_west_chests);
    CHEST_LOCATIONS.put(Submaps.PRAIRIE_SHACK_OUTSIDE, ChestData.prairie_shack_chests);
    CHEST_LOCATIONS.put(Submaps.PRAIRIE_COAST_BEFORE_TREE, ChestData.prairie_rock_arch_chests);
    CHEST_LOCATIONS.put(Submaps.PRAIRIE_OUTSIDE_OF_CAVE, ChestData.prairie_before_cave_chests);
    CHEST_LOCATIONS.put(Submaps.LIMESTONE_CAVE_ENTRY, ChestData.limestone_cave_entry_chests);
    CHEST_LOCATIONS.put(Submaps.LIMESTONE_CAVE_WATERSLIDE, ChestData.limestone_cave_waterslide_chests);
    CHEST_LOCATIONS.put(Submaps.LIMESTONE_CAVE_HOPPING_ROCKS_ROOM, ChestData.limestone_cave_hopping_rocks_chests);
    CHEST_LOCATIONS.put(Submaps.LIMESTONE_CAVE_FROG_ROOM, ChestData.limestone_cave_frog_chests);
    CHEST_LOCATIONS.put(Submaps.LIMESTONE_CAVE_ROCK_FIREFLIES_ROOM, ChestData.limestone_cave_rock_fireflies_chests);
    CHEST_LOCATIONS.put(Submaps.LIMESTONE_CAVE_STONE_BRIDGE_ROOM, ChestData.limestone_cave_stone_bridge_chests);
    CHEST_LOCATIONS.put(Submaps.LIMESTONE_CAVE_SAVE_ROOM, ChestData.limestone_cave_save_room_chests);
    CHEST_LOCATIONS.put(Submaps.LIMESTONE_CAVE_WINDING_TUNNEL, ChestData.limestone_cave_winding_tunnel_chests);

    CHEST_LOCATIONS.put(Submaps.BARRENS_FLETZ_EXIT, ChestData.barrens_fletz_exit_chests);
    CHEST_LOCATIONS.put(Submaps.BARRENS_DONAU_EXIT, ChestData.barrens_donau_exit_chests);
    CHEST_LOCATIONS.put(Submaps.VALLEY_OF_CORRUPTED_GRAVITY_FIREFLIES, ChestData.valley_area1_chests);
    CHEST_LOCATIONS.put(Submaps.VALLEY_OF_CORRUPTED_GRAVITY_FIRST_ROCKS, ChestData.valley_area2_chests);
    CHEST_LOCATIONS.put(Submaps.VALLEY_OF_CORRUPTED_GRAVITY_SAVE_ROOM, ChestData.valley_area4_chests);
    CHEST_LOCATIONS.put(Submaps.HOME_OF_GIGANTO_ENTRANCE, ChestData.gigantos_entrance_chests);
    CHEST_LOCATIONS.put(Submaps.HOME_OF_GIGANTO_SWITCH, ChestData.gigantos_switch_room_chests);
    CHEST_LOCATIONS.put(Submaps.HOME_OF_GIGANTO_SAVE_ROOM, ChestData.gigantos_save_room_chests);
    CHEST_LOCATIONS.put(Submaps.PHANTOM_SHIP_BOGY_ROOM, ChestData.phantom_ship_bogy_room_chests);
    CHEST_LOCATIONS.put(Submaps.PHANTOM_SHIP_HALLWAY, ChestData.phantom_ship_hallway_chests);
    CHEST_LOCATIONS.put(Submaps.PHANTOM_SHIP_PASSWORD_ROOM, ChestData.phantom_ship_password_chests);
    CHEST_LOCATIONS.put(Submaps.PHANTOM_SHIP_CAPTAIN_ROOM, ChestData.phantom_ship_captain_chests);
    CHEST_LOCATIONS.put(Submaps.PHANTOM_SHIP_PUZZLE, ChestData.phantom_ship_password_chests);
    CHEST_LOCATIONS.put(Submaps.PHANTOM_SHIP_LOCKED_ROOM, ChestData.phantom_ship_locked_room_chests);
    CHEST_LOCATIONS.put(Submaps.PHANTOM_SHIP_CRADLE, ChestData.phantom_ship_cradle_chests);
    CHEST_LOCATIONS.put(Submaps.LIDIERA_OUTSIDE, ChestData.lidiera_outside_chests);
    CHEST_LOCATIONS.put(Submaps.LIDIERA_CAVE, ChestData.lidiera_cave_chests);
    CHEST_LOCATIONS.put(Submaps.UNDERSEA_CAVE_BRIDGE, ChestData.undersea_cave_bridge_chests);
    CHEST_LOCATIONS.put(Submaps.UNDERSEA_CAVE_SECOND_ROOM, ChestData.undersea_cave_middle_chests);
    CHEST_LOCATIONS.put(Submaps.UNDERSEA_CAVE_WEST_ROOM, ChestData.undersea_cave_left_chests);
    CHEST_LOCATIONS.put(Submaps.UNDERSEA_CAVE_SAVE_ROOM, ChestData.undersea_cave_save_room_chests);
    CHEST_LOCATIONS.put(Submaps.FLETZ_TRAINING_ROOM, ChestData.fletz_training_chests);

    CHEST_LOCATIONS.put(Submaps.EVERGREEN_FOREST_RAT_TREE, ChestData.evergreen_forest_tree_chests);
    CHEST_LOCATIONS.put(Submaps.EVERGREEN_FOREST_WEST_PATH, ChestData.evergreen_forest_west_chests);
    CHEST_LOCATIONS.put(Submaps.EVERGREEN_FOREST_KAMUI_HILL, ChestData.evergreen_forest_kamuy_hill_chests);
    CHEST_LOCATIONS.put(Submaps.EVERGREEN_FOREST_MOUNTAIN_GUARD, ChestData.evergreen_forest_mountain_chests);
    CHEST_LOCATIONS.put(Submaps.CRYSTAL_PALACE_ENTRANCE, ChestData.crystal_palace_entrance_chests);
    CHEST_LOCATIONS.put(Submaps.CRYSTAL_PALACE_DINING, ChestData.crystal_palace_interior_chests);
    CHEST_LOCATIONS.put(Submaps.FORBIDDEN_LAND_STEAM_VENTS, ChestData.forbidden_land_steam_vent_chests);
    CHEST_LOCATIONS.put(Submaps.FORBIDDEN_LAND_TELEPORTERS_2, ChestData.forbidden_land_teleporter_chests);
    CHEST_LOCATIONS.put(Submaps.FORBIDDEN_LAND_PLATFORM_ROOM, ChestData.forbidden_land_platform_chests);
    CHEST_LOCATIONS.put(Submaps.MOUNTAIN_OF_MORTAL_DRAGON_BONE_PATH, ChestData.mountain_of_mortal_dragon_base_chests);
    CHEST_LOCATIONS.put(Submaps.MOUNTAIN_OF_MORTAL_DRAGON_LEDGE, ChestData.mountain_of_mortal_dragon_ledge_chests);
    CHEST_LOCATIONS.put(Submaps.MOUNTAIN_OF_MORTAL_DRAGON_FORK_PATH, ChestData.mountain_of_mortal_dragon_path_chests);
    CHEST_LOCATIONS.put(Submaps.MOUNTAIN_OF_MORTAL_DRAGON_SAVE_ROOM, ChestData.mountain_of_mortal_dragon_save_chests);
    CHEST_LOCATIONS.put(Submaps.MOUNTAIN_OF_MORTAL_DRAGON_PRE_BOSS, ChestData.mountain_of_mortal_dragon_pre_boss_chests);
    CHEST_LOCATIONS.put(Submaps.KASHUA_GLACIER_ENTRANCE, ChestData.kashua_glacier_entrance_chests);
    CHEST_LOCATIONS.put(Submaps.KASHUA_GLACIER_SIGN_ROOM, ChestData.kashua_glacier_sign_room_chests);
    CHEST_LOCATIONS.put(Submaps.KASHUA_GLACIER_MERCHANT, ChestData.kashua_glacier_merchant_chests);
    CHEST_LOCATIONS.put(Submaps.KASHUA_GLACIER_ICICLE_ROOM, ChestData.kashua_glacier_icicle_chests);
    CHEST_LOCATIONS.put(Submaps.KASHUA_GLACIER_BOSS_ROOM, ChestData.kashua_glacier_boss_chests);
    CHEST_LOCATIONS.put(Submaps.KASHUA_GLACIER_TOWER, ChestData.kashua_glacier_tower_chests);
    CHEST_LOCATIONS.put(Submaps.FLANVEL_TOWER_ENTRANCE, ChestData.flanvel_tower_entrance_chests);
    CHEST_LOCATIONS.put(Submaps.FLANVEL_TOWER_INTERIOR, ChestData.flanvel_tower_interior_chests);
    CHEST_LOCATIONS.put(Submaps.FLANVEL_TOWER_APPARITION, ChestData.flanvel_tower_apparition_chests);
    CHEST_LOCATIONS.put(Submaps.FLANVEL_TOWER_SAVE_ROOM_2, ChestData.flanvel_tower_save_2_chests);
    CHEST_LOCATIONS.put(Submaps.FLANVEL_TOWER_FAUST, ChestData.flanvel_tower_faust_chests);
    CHEST_LOCATIONS.put(Submaps.SNOWFIELD_ARCHES, ChestData.snowfield_arches_chests);
    CHEST_LOCATIONS.put(Submaps.SNOWFIELD_CLIFF_SLIDE, ChestData.snowfield_cliff_chests);
    CHEST_LOCATIONS.put(Submaps.FORT_MAGRAD_ENTRANCE, ChestData.fort_magrad_entrance_chests);
    CHEST_LOCATIONS.put(Submaps.FORT_MAGRAD_SAVE_ROOM, ChestData.fort_magrad_save_chests);
    CHEST_LOCATIONS.put(Submaps.FORT_MAGRAD_BOSS, ChestData.fort_magrad_boss_chests);
    CHEST_LOCATIONS.put(Submaps.VELLWEB_MERCHANTS, ChestData.vellweb_stair_bottom_chests);
    CHEST_LOCATIONS.put(Submaps.VELLWEB_STAIR_CHEST_PATHS, ChestData.vellweb_stairs_chests);
  }

  private Chests() {
  }

  public static Map<Integer, Map<Integer, Long>> getStaticMap() {
    return Collections.unmodifiableMap(CHEST_LOCATIONS);
  }

  public static Map<Long, String> getStaticStringMap() {
    final Map<Long, String> locationMap = new LinkedHashMap<>();
    for(final Map.Entry<Integer, Map<Integer, Long>> areaInfo : CHEST_LOCATIONS.entrySet()) {
      for(final Map.Entry<Integer, Long> chestInfo : areaInfo.getValue().entrySet()) {
        locationMap.put(chestInfo.getValue(), String.valueOf(chestInfo.getKey()));
      }
    }

    return Collections.unmodifiableMap(locationMap);
  }

  public static Long getAPLocationId(final int submap, final int objectIndex) {
    try {
      return getStaticMap().get(submap).getOrDefault(objectIndex, -1L);
    } catch(final Exception e) {
      return -1L;
    }
  }
}
