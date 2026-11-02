package archipelagoon.randomizer;

import archipelagoon.ap.APClient;
import legend.game.Scus94491BpeSegment_8006;
import legend.game.characters.StatCollection;
import legend.game.characters.VitalsStat;
import legend.game.combat.bent.BattleEntity27c;
import legend.game.combat.types.battlestate.StatusConditions20;
import legend.game.scripting.ScriptState;
import legend.game.scripting.ScriptTempParam;

import static legend.game.Scus94491BpeSegment_8006.battleState_8006e398;
import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;
import static legend.lodmod.LodMod.HP_STAT;

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
      this.handleCombatDeathlink();
    } else {
      this.handleOverworldDeathlink();
    }
  }

  private void handleOverworldDeathlink() {
    gameState_800babc8.charData_32c.forEach(cd -> {
      final StatCollection stats = cd.stats;
      final VitalsStat stat = stats.getStat(HP_STAT.get());

      stat.setCurrent(0);
    });
  }

  private void handleCombatDeathlink() {
    for(final ScriptState<? extends BattleEntity27c> state : battleState_8006e398.playerBents_e40) {
      // execute player bent deaths
      final StatusConditions20 conditions = Scus94491BpeSegment_8006.battleState_8006e398.statusConditions_00[state.innerStruct_00.allBentSlot_274];
      conditions.pandemoniumTurnsDiedAsDragoon_1d = 0x400 >>> 8 & 0xff;

      // call various handlers
      state.context.params_20[0] = new ScriptTempParam(state.index);
      state.context.params_20[1] = new ScriptTempParam(4);
      state.context.params_20[2] = new ScriptTempParam(0);

      state.scriptForkAndReenter();
    }
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
