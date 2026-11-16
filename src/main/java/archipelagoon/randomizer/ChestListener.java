package archipelagoon.randomizer;

import legend.game.scripting.ScriptLifecycleEvent;
import org.legendofdragoon.modloader.events.EventListener;

import static java.lang.IO.print;
import static legend.game.scripting.ScriptLifecycleEvent.Lifecycle.ALLOCATED;
import static legend.game.scripting.ScriptLifecycleEvent.Lifecycle.POST_SCRIPT_VM_TICK;

public class ChestListener {

  private int scriptId = -1;

  @EventListener
  public void scriptLifecycleListener(final ScriptLifecycleEvent event) {
    if(this.scriptId != -1) {
      return;
    }

    if((this.scriptId == event.scriptIndex) && event.getLifecycle() == POST_SCRIPT_VM_TICK) {
      print("Yes");
    }

    if(event.getLifecycle() == ALLOCATED) {
      this.scriptId = event.scriptIndex;
    }
  }
}
