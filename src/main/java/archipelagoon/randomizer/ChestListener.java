package archipelagoon.randomizer;

import legend.game.scripting.ScriptLifecycleEvent;
import legend.game.types.LodString;
import legend.game.types.Textbox4c;
import legend.game.types.TextboxChar08;
import legend.game.types.TextboxText84;
import org.legendofdragoon.modloader.events.EventListener;

import java.util.Arrays;

import static legend.core.GameEngine.EVENTS;
import static legend.game.Text.calculateAppropriateTextboxBounds;
import static legend.game.Text.textboxText_800bdf38;
import static legend.game.Text.textboxes_800be358;
import static legend.game.scripting.ScriptLifecycleEvent.Lifecycle.ALLOCATED;
import static legend.game.scripting.ScriptLifecycleEvent.Lifecycle.POST_SCRIPT_VM_TICK;

public class ChestListener {

  private String message = "";
  private int nameLength;
  private int itemLength;
  private int scriptId = -1;

  public ChestListener() {
    EVENTS.register(this);
  }

  public void setMessage(final String message, final int itemLength, final int nameLength) {
    this.message = message;
    this.nameLength = nameLength;
    this.itemLength = itemLength;
  }

  @EventListener
  public void scriptLifecycleListener(final ScriptLifecycleEvent event) {
    if(event.getLifecycle() != ALLOCATED && event.getLifecycle() != POST_SCRIPT_VM_TICK) {
      return;
    }

    if(event.getLifecycle() == ALLOCATED && this.scriptId == -1) {
      this.scriptId = event.scriptIndex;
      return;
    }

    if(this.scriptId == -1) {
      return;
    }

    if(this.scriptId != event.scriptIndex) {
      return;
    }

    if(event.getLifecycle() == POST_SCRIPT_VM_TICK) {
      final TextboxText84 textboxText84 = Arrays.stream(textboxText_800bdf38)
        .filter(textBox -> {
          if(textBox.str_24 == null) {
            return false;
          }
          // TODO: this will need to be sync'd with SC stuff
          return textBox.str_24.get().contains("Acquired");
        })
        .findFirst()
        .orElse(null);

      for(int i = 0; i < textboxText_800bdf38.length; i++) {
        final TextboxText84 textboxText = textboxText_800bdf38[i];
        final Textbox4c textbox = textboxes_800be358[i];

        if(textboxText.str_24 == null) {
          continue;
        }

        this.scriptId = -1;
        textboxText.str_24 = new LodString(this.message);
        final int textLength = Math.max(this.itemLength, this.nameLength);
        textbox.chars_18 = textLength + 6;
        textbox.lines_1a = 3;
        textboxText.chars_1c = textbox.chars_18 - 1;
        textboxText.lines_1e = textbox.lines_1a - 1;
        textboxText.chars_58 = new TextboxChar08[textboxText.chars_1c * (textboxText.lines_1e + 1)];
        Arrays.setAll(textboxText.chars_58, _ -> new TextboxChar08());
        calculateAppropriateTextboxBounds(i, textbox.x_14, textbox.y_16);

        ChestManager.getInstance().cleanupChestListener();
        return;
      }
    }
  }
}
