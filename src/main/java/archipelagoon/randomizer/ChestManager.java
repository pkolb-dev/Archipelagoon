package archipelagoon.randomizer;

import archipelagoon.ap.mapping.locations.Chests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static legend.core.GameEngine.SCRIPTS;
import static legend.game.Scus94491BpeSegment_8005.submapCut_80052c30;

public class ChestManager {
  private static final ChestManager INSTANCE = new ChestManager();
  private static final Logger LOGGER = LogManager.getFormatterLogger(ChestManager.class);
  private static int lastObjectIndex = -1;
  private final Pattern pattern = Pattern.compile("\\d+");

  private ChestManager() {
  }

  public static ChestManager getInstance() {
    return INSTANCE;
  }

  public Long getChestId() {
    final String indexName = SCRIPTS.getState(lastObjectIndex).name;

    final Matcher matcher = this.pattern.matcher(indexName);

    if(!matcher.find()) {
      return -1L;
    }

    final String msg = String.format("Chest accessed in %s", submapCut_80052c30);
    LOGGER.info(msg); // TODO: remove when chests fully impl
    return Chests.getAPLocationId(submapCut_80052c30, Integer.parseInt(matcher.group()));
  }

  public void updateObjectIndex(final int scriptIndex) {
    lastObjectIndex = scriptIndex;
  }
}
