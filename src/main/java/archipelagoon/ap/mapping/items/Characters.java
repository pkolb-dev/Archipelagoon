package archipelagoon.ap.mapping.items;

import legend.lodmod.LodCharacterTemplates;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Characters {
  private static final Map<Long, RegistryId> CHARACTER_MAP = new HashMap<>();

  static {
    CHARACTER_MAP.put(108_32001L, LodCharacterTemplates.DART.getId());
    CHARACTER_MAP.put(108_32002L, LodCharacterTemplates.LAVITZ.getId());
    CHARACTER_MAP.put(108_32003L, LodCharacterTemplates.SHANA.getId());
    CHARACTER_MAP.put(108_32004L, LodCharacterTemplates.ROSE.getId());
    CHARACTER_MAP.put(108_32005L, LodCharacterTemplates.HASCHEL.getId());
    CHARACTER_MAP.put(108_32006L, LodCharacterTemplates.ALBERT.getId());
    CHARACTER_MAP.put(108_32007L, LodCharacterTemplates.MERU.getId());
    CHARACTER_MAP.put(108_32008L, LodCharacterTemplates.KONGOL.getId());
    CHARACTER_MAP.put(108_32009L, LodCharacterTemplates.MIRANDA.getId());
    CHARACTER_MAP.put(108_32010L, new RegistryId("lloyd_mod", "lloyd"));
  }

  public static Map<Long, RegistryId> getStaticMap() {
    return Collections.unmodifiableMap(CHARACTER_MAP);
  }
}
