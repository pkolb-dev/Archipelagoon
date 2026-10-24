package archipelagoon.randomizer;

import archipelagoon.ap.APContext;
import archipelagoon.ap.mapping.locations.GoodsLocations;
import archipelagoon.data.enums.StoryFlags;
import archipelagoon.data.enums.Submaps;
import legend.core.GameEngine;
import legend.game.modding.events.inventory.ScriptFlags1ChangedEvent;
import legend.game.modding.events.inventory.ScriptFlags2ChangedEvent;
import legend.game.modding.events.scripting.ReadGlobalFlagsEvent;
import legend.game.modding.events.submap.SubmapWarpEvent;
import legend.game.scripting.ScriptFlagArrayEnum;
import legend.lodmod.LodGoods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.List;

import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;

public final class StoryFlagManager {
  private static final Logger LOGGER = LogManager.getFormatterLogger(StoryFlagManager.class);
  private static int current_submap = -1;

  private StoryFlagManager() {
  }

  public static int getCurrentSubmap() {
    if(current_submap == -1) {
      LOGGER.warn("StoryFlagManager.getCurrentSubmap() returned a -1. Submap variable may not have been initialized yet.");
    }
    return current_submap;
  }

  public static void submapWarpListener(final SubmapWarpEvent event) {
    current_submap = event.submapCut;
  }

  public static void readScriptFlags(final ReadGlobalFlagsEvent event) {
    if(event.flagArray == ScriptFlagArrayEnum.FLAGS2) {
      switch(event.getFlagIndex()) {
        case StoryFlags.FOREST_MERCHANT_1, StoryFlags.FOREST_MERCHANT_2:
          if(current_submap == Submaps.FOREST_MERCHANT) {
            event.flagValue = false;
          }
          break;
        case StoryFlags.NEST_OF_DRAGON_PLANT:
          if(current_submap == Submaps.NEST_OF_DRAGON_PLANT) {
            event.flagValue = event.flagValue && hasGood(LodGoods.LIFE_WATER.getId());
          }
          break;
        case StoryFlags.NEST_OF_DRAGON_LIFE_WATER:
          if(current_submap == Submaps.NEST_OF_DRAGON_LIFE_WATER) {
            event.flagValue = event.flagValue && hasGood(LodGoods.WATER_BOTTLE.getId());
          }
          break;
        case StoryFlags.HELLENA_SHANA_DOOR:
          if(current_submap == Submaps.HELLENA_ELEVATOR) {
            event.flagValue = event.flagValue && hasGood(LodGoods.PRISON_KEY.getId());
          }
          break;
        case StoryFlags.FURNI_BOAT:
          if(current_submap == Submaps.FURNI_HOTEL) {
            event.flagValue = event.flagValue & hasGood(LodGoods.BOAT_LICENSE.getId());
          }
          break;
      }
    } else if(event.flagArray == ScriptFlagArrayEnum.FLAGS1) {
      switch(event.getFlagIndex()) {
        case StoryFlags.PRAIRIE_CLIFF_TREE:
          if(current_submap == Submaps.PRAIRIE_CLIFF_TREE) {
            event.flagValue = event.flagValue && hasGood(LodGoods.AXE_FROM_THE_SHACK.getId());
          }
          break;
      }
    }
  }

  private static boolean hasGood(final RegistryId goodId) {
    return gameState_800babc8.goods_19c.has(GameEngine.REGISTRIES.goods.getEntry(goodId));
  }

  public static void handleScriptFlagsChanged(final ScriptFlags1ChangedEvent event) {
    final APContext ctx = APContext.getContext();
    switch(event.index) {
      case StoryFlags.PRAIRIE_CLIFF_TREE:
        if(current_submap == Submaps.PRAIRIE_SHACK_INSIDE) {
          ctx.checkLocation(GoodsLocations.getAPLocationId(LodGoods.AXE_FROM_THE_SHACK.getId()));
        }
        break;
    }
  }

  public static void handleScriptFlagsChanged(final ScriptFlags2ChangedEvent event) {
    final APContext ctx = APContext.getContext();
    switch(event.index) {
      case StoryFlags.HELLENA_SHANA_DOOR:
        if(current_submap == Submaps.HELLENA_ELEVATOR) {
          ctx.checkLocation(GoodsLocations.getAPLocationId(LodGoods.PRISON_KEY.getId()));
        }
        break;
      case StoryFlags.GOOD_SPIRITS_PURCHASED:
        if(current_submap == Submaps.BALE_BAR) {
          break;
        }
      case StoryFlags.HOAX_POST_INVASION:
        if(current_submap == Submaps.HOAX_INVASION) {
          final List<Long> goodsList = List.of(
            GoodsLocations.getAPLocationId(LodGoods.RED_DRAGOON_SPIRIT.getId()),
            GoodsLocations.getAPLocationId(LodGoods.DARK_DRAGOON_SPIRIT.getId())
          );
          ctx.checkLocations(goodsList);
        }
        break;
      case StoryFlags.GOLD_D_SPIRIT_OBTAINED:
        if(current_submap == Submaps.LOHAN_MERCHANT) {
          ctx.checkLocation(GoodsLocations.getAPLocationId(LodGoods.GOLD_DRAGOON_SPIRIT.getId()));
        }
        break;
      case StoryFlags.NEST_OF_DRAGON_LIFE_WATER:
        if(current_submap == Submaps.LOHAN_MERCHANT) {
          ctx.checkLocation(GoodsLocations.getAPLocationId(LodGoods.WATER_BOTTLE.getId()));
        }
        break;
      case StoryFlags.NEST_OF_DRAGON_PLANT:
        if(current_submap == Submaps.NEST_OF_DRAGON_LIFE_WATER) {
          ctx.checkLocation(GoodsLocations.getAPLocationId(LodGoods.LIFE_WATER.getId()));
        }
        break;
      case StoryFlags.GREHAM_FEYRBRAND_DEFEATED:
        if(current_submap == Submaps.NEST_OF_DRAGON_GREHAM_ROOM) {
          ctx.checkLocation(GoodsLocations.getAPLocationId(LodGoods.JADE_DRAGOON_SPIRIT.getId()));
        }
        break;
    }
  }
}
