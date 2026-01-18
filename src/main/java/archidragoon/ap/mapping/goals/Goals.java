package archidragoon.ap.mapping.goals;

import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Goals {
  private static final Map<Integer, String> GOAL_MAP = new HashMap<>();

  static {
    GOAL_MAP.put(2,  "fruegel_rodriguez_guftas");
    GOAL_MAP.put(3,  "emperor_doel_dragoon_doel");
    GOAL_MAP.put(4,  "lenus_regole");
    GOAL_MAP.put(5,  "magician_faust");
    GOAL_MAP.put(6,  "melbu_frahma_melbu_frahma_melbu_frahma_melbu_frahma_melbu_frahma");
  }

  private Goals () {
  }

  public static Map<Integer, String> getStaticMap() {
    return Collections.unmodifiableMap(GOAL_MAP);
  }
}
