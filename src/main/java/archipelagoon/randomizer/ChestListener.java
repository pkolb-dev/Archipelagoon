package archipelagoon.randomizer;

import legend.game.scripting.ScriptLifecycleEvent;
import legend.game.types.TextboxText84;
import org.legendofdragoon.modloader.events.EventListener;

import java.util.Arrays;

import static legend.core.GameEngine.EVENTS;
import static legend.game.Text.textboxText_800bdf38;
import static legend.game.scripting.ScriptLifecycleEvent.Lifecycle.ALLOCATED;
import static legend.game.scripting.ScriptLifecycleEvent.Lifecycle.POST_SCRIPT_VM_TICK;

public class ChestListener {

  private final String message;
  private int scriptId = -1;

  public ChestListener(final String message) {
    EVENTS.register(this);
    this.message = message;
  }

  @EventListener
  public void scriptLifecycleListener(final ScriptLifecycleEvent event) {
    if(event.getLifecycle() != ALLOCATED && event.getLifecycle() != POST_SCRIPT_VM_TICK) {
      return;
    }

    if(event.getLifecycle() == ALLOCATED) {
      this.scriptId = 0;
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

      this.scriptId = -1;
      if(textboxText84 == null) {
        return;
      }

      textboxText84.str_24.set(this.message);
      ChestManager.getInstance().cleanupChestListener();
    }
  }
}
