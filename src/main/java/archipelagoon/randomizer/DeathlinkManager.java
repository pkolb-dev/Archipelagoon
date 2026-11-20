package archipelagoon.randomizer;

import archipelagoon.ap.APClient;
import legend.game.Scus94491BpeSegment_8006;
import legend.game.modding.coremod.CorePostBattleActions;
import legend.game.saves.RetailSavedGame;
import legend.game.saves.SavedGame;
import legend.lodmod.LodEngineStateTypes;

import static legend.game.EngineStates.currentEngineState_8004dd04;
import static legend.game.EngineStates.engineStateOnceLoaded_8004dd24;
import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;
import static legend.game.Scus94491BpeSegment_800b.postBattleAction_800bc974;
import static legend.game.Scus94491BpeSegment_800b.submapId_800bd808;

public class DeathlinkManager {
  private static final DeathlinkManager INSTANCE = new DeathlinkManager();
  private boolean shouldHoldTrigger = false;

  private DeathlinkManager() {
  }

  public static DeathlinkManager getInstance() {
    return INSTANCE;
  }

  public void receiveDeathlink() {
    // check if in combat or not
    if(Scus94491BpeSegment_8006.battleState_8006e398 != null) {
      this.shouldHoldTrigger = true;
      postBattleAction_800bc974 = CorePostBattleActions.GAME_OVER.get().inst();
    } else if(submapId_800bd808 == -1) {
      // what happens if you deathlink during FMV? - a nice little surprise ;)
      engineStateOnceLoaded_8004dd24 = LodEngineStateTypes.GAME_OVER.get();
    } else {
      this.handleOverworldDeathlink();
    }
  }

  private void handleOverworldDeathlink() {
    final SavedGame save = new RetailSavedGame(gameState_800babc8.campaign, gameState_800babc8.campaign.latestSave.version, gameState_800babc8.campaign.latestSave.fileName, gameState_800babc8.campaign.latestSave.saveName, gameState_800babc8.campaign.latestSave.campaignType, gameState_800babc8.campaign.latestSave.config);
    save.engineState = LodEngineStateTypes.GAME_OVER.getId();
    currentEngineState_8004dd04.loadSaveFromMenu(save);
  }

  public void sendDeathlink(final APClient client) {
    if(!this.shouldHoldTrigger) {
      client.sendDeathlink(client.getMyName(), this.getCause());
    } else {
      this.shouldHoldTrigger = false;
    }
  }

  private String getCause() {
    return "Party KO";
  }
}
