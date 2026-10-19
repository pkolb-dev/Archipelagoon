package archipelagoon.randomizer;

import archipelagoon.ap.APContext;
import archipelagoon.ap.mapping.items.Additions;
import archipelagoon.data.enums.AdditionRandomizerType;
import archipelagoon.data.tables.ProgressiveAdditions;
import legend.core.GameEngine;
import legend.game.additions.UnlockState;
import legend.game.characters.CharacterAdditionInfo;
import legend.game.characters.CharacterData2c;
import legend.game.types.GameState52c;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;

public final class AdditionManager {
  private static final AdditionManager INSTANCE = new AdditionManager();

  private AdditionManager() {
  }

  public static AdditionManager getInstance() {
    return INSTANCE;
  }

  public void lockAdditions(final GameState52c gameState) {
    final GameState52c state = this.resolveState(gameState);

    state.charData_32c.forEach(cd -> {
      cd.getAllAdditions().forEach(addition -> {
        final int timestamp = 0;
        cd.getAdditionInfo(addition).setUnlockState(UnlockState.LOCKED, timestamp);
      });
    });
  }

  public void setAdditions(final GameState52c gameState) {
    final APContext ctx = APContext.getContext();

    switch(AdditionRandomizerType.values()[ctx.getSlotData().additionRandomizer]) {
      case AdditionRandomizerType.SHUFFLED:
        this.setShuffled(gameState);
        break;
      case AdditionRandomizerType.PROGRESSIVE:
        this.setProgressive(gameState);
        break;
    }
  }

  private void setShuffled(final GameState52c gameState) {
    final Map<Long, RegistryId> additionList = Additions.getStaticMap();
    final GameState52c state = this.resolveState(gameState);
    final APContext ctx = APContext.getContext();

    for(final Long id : ctx.getReceivedItemIDs()) {

      final RegistryId registryId = additionList.getOrDefault(id, null);
      if(registryId == null) {
        continue;
      }

      this.unlockAddition(registryId, state);
    }
  }

  private void setProgressive(final GameState52c gameState) {
    final GameState52c state = this.resolveState(gameState);

    final APContext ctx = APContext.getContext();
    final List<Long> receivedItems = ctx.getReceivedItemIDs();

    state.charData_32c.forEach(cd -> {
      final Long progressiveId = Additions.getAPItemIdFromCharacterIndex(cd.template.getRegistryId());
      final int totalReceived = Collections.frequency(receivedItems, progressiveId);
      final Map<Integer, RegistryId> additions = ProgressiveAdditions.getAdditionsForChar(cd.template.getRegistryId());

      for(int i = 1; i <= totalReceived; i++) {
        if(!additions.containsKey(i)) {
          break;
        }

        final RegistryId registryId = additions.get(i);

        final CharacterAdditionInfo additionInfo = cd.getAdditionInfo(registryId);
        if(additionInfo.getUnlockState() != UnlockState.UNLOCKED) {
          additionInfo.setUnlockState(UnlockState.UNLOCKED, state.timestamp_a0);
        }
      }
    });
  }

  public void unlockAddition(final RegistryId registryId, final GameState52c gameState) {
    if(!GameEngine.REGISTRIES.additions.hasEntry(registryId)) {
      return;
    }

    final GameState52c state = this.resolveState(gameState);

    state.charData_32c.forEach(cd -> {
      final CharacterAdditionInfo info = cd.getAdditionInfo(registryId);
      if(info == null) {
        return;
      }

      final CharacterAdditionInfo additionInfo = cd.getAdditionInfo(registryId);
      if(additionInfo.getUnlockState() != UnlockState.UNLOCKED) {
        additionInfo.setUnlockState(UnlockState.UNLOCKED, state.timestamp_a0);

        if(cd.getAdditionInfo(cd.selectedAddition_19).getUnlockState() != UnlockState.UNLOCKED) {
          cd.selectedAddition_19 = registryId;
        }
      }
    });
  }

  public void selectAddition(final GameState52c gameState) {
    final GameState52c state = this.resolveState(gameState);
    state.charData_32c.forEach(cd -> {
      final CharacterAdditionInfo addition = cd.getAdditionInfo(cd.selectedAddition_19);
      if(addition == null) {
        return;
      }

      if(addition.getUnlockState() == UnlockState.UNLOCKED) {
        return;
      }

      for(final RegistryId entry : cd.getAllAdditions()) {
        if(cd.getAdditionInfo(entry).getUnlockState() == UnlockState.UNLOCKED) {
          cd.selectedAddition_19 = entry;
          break;
        }
      }
    });
  }

  public void checkUnlock(final CharacterData2c charData) {
    final APContext apContext = APContext.getContext();

    for(final RegistryId id : charData.getAllAdditions()) {

      final CharacterAdditionInfo info = charData.getAdditionInfo(id);

      final var addition = GameEngine.REGISTRIES.additions.getEntry(id).get();
      if(addition == null) {
        continue;
      }

      if(info.checkUnlockCriteria(charData)) {
        final Long apId = archipelagoon.ap.mapping.locations.Additions.getAPLocationId(id);
        if(apId != null) {
          apContext.checkLocation(apId);
        }
      }
    }
  }

  private GameState52c resolveState(final GameState52c state) {
    return state != null ? state : gameState_800babc8;
  }

  public RegistryId getProgressiveAdditionRegistryId(final long itemId) {
    final APContext ctx = APContext.getContext();
    final List<Long> receivedItems = ctx.getReceivedItemIDs();

    final RegistryId charId = Additions.getCharacterIndexFromAPItemId(itemId);
    if(charId == null) {
      return null;
    }

    final int totalReceived = Collections.frequency(receivedItems, itemId);
    final Map<Integer, RegistryId> additions = ProgressiveAdditions.getAdditionsForChar(charId);

    if(!additions.containsKey(totalReceived)) {
      return null;
    }

    return additions.get(totalReceived);
  }

  public void checkAdditionLevelLocation(final RegistryId additionId, final int level) {
    final APContext apContext = APContext.getContext();

    final var addition = GameEngine.REGISTRIES.additions.getEntry(additionId).get();
    if(addition == null) {
      return;
    }

    final Long apId = archipelagoon.ap.mapping.locations.Additions.getAPLocationId(additionId, level);
    if(apId != null) {
      apContext.checkLocation(apId);
    }
  }
}