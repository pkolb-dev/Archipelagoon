package archipelagoon.randomizer;

import legend.game.modding.events.RenderEvent;
import legend.game.types.LodString;
import legend.game.types.Textbox4c;
import legend.game.types.TextboxChar08;
import legend.game.types.TextboxText84;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.legendofdragoon.modloader.events.EventListener;

import java.util.Arrays;

import static legend.game.Text.calculateAppropriateTextboxBounds;
import static legend.game.Text.textboxText_800bdf38;
import static legend.game.Text.textboxes_800be358;

public class ChestListener {

  private static final Logger LOGGER = LogManager.getFormatterLogger(ChestListener.class);
  private String message = "";
  private int nameLength;
  private int itemLength;
  private boolean isListening = false;

  public ChestListener(final String message, final int itemLength, final int nameLength) {
    this.setMessage(message, itemLength, nameLength);
    this.isListening = true;
  }

  public void setMessage(final String message, final int itemLength, final int nameLength) {
    this.message = message;
    this.nameLength = nameLength;
    this.itemLength = itemLength;
  }

  @EventListener
  public void renderListener(final RenderEvent event) {
    if(!this.isListening) {
      // this will repeatedly fire b/c listener isn't cleaned up properly
      //      LOGGER.warn("Stale reference to this listener");
      return;
    }

    for(int i = 0; i < textboxText_800bdf38.length; i++) {
      final TextboxText84 textboxText = textboxText_800bdf38[i];
      final Textbox4c textbox = textboxes_800be358[i];

      if(textboxText.str_24 == null || !textboxText.str_24.get().contains("Acquired")) {
        continue;
      }

      textboxText.str_24 = new LodString(this.message);
      final int textLength = Math.max(this.itemLength, this.nameLength);
      textbox.chars_18 = textLength + 6;
      textbox.lines_1a = 3;
      textboxText.chars_1c = textbox.chars_18 - 1;
      textboxText.lines_1e = textbox.lines_1a - 1;
      textboxText.chars_58 = new TextboxChar08[textboxText.chars_1c * (textboxText.lines_1e + 1)];
      Arrays.setAll(textboxText.chars_58, _ -> new TextboxChar08());
      calculateAppropriateTextboxBounds(i, textbox.x_14, textbox.y_16);

      this.isListening = false;
      ChestManager.getInstance().cleanupChestListener();

      return;
    }
  }
}
