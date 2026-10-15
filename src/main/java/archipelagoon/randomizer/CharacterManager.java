package archipelagoon.randomizer;

import legend.game.characters.CharacterData2c;
import legend.game.types.GameState52c;
import org.legendofdragoon.modloader.registries.RegistryId;

import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;

public final class CharacterManager {
  private static final CharacterManager INSTANCE = new CharacterManager();

  private CharacterManager() {
  }

  public static CharacterManager getInstance() {
    return INSTANCE;
  }

  public void lockCharacters(final GameState52c state) {
    state.charData_32c.forEach(cd -> {
      // remove from In party & can be in party
      cd.partyFlags_04 &= ~CharacterData2c.IN_PARTY;
      cd.partyFlags_04 &= ~CharacterData2c.CAN_BE_IN_PARTY;
      cd.partyFlags_04 &= ~CharacterData2c.TEMPORARILY_REMOVED_FROM_PARTY;
    });

    // clear active party
    state.charIds_88.clear();
  }

  public void addToPool(final RegistryId charId, final GameState52c gameState) {
    final GameState52c state = this.resolveState(gameState);

    final CharacterData2c character = state.charData_32c.stream()
      .filter(cd -> cd.template.getRegistryId().equals(charId))
      .findFirst()
      .orElse(null);

    if(character == null) {
      return;
    }

    character.partyFlags_04 |= 0x3;
    character.level_12 = 1;
    character.xp_00 = 0;

    if(state.charIds_88.size() < 3) {
      state.charIds_88.add(state.charData_32c.indexOf(character));
    }
  }

  private GameState52c resolveState(final GameState52c state) {
    return state != null ? state : gameState_800babc8;
  }
}
