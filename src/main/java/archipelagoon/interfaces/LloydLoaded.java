package archipelagoon.interfaces;

import legend.game.characters.RegisterCharacterTemplatesEvent;
import lod.lloydmod.events.LloydAllowNewGameAddEvent;
import lod.lloydmod.events.LloydJoinedPartyEvent;
import org.legendofdragoon.modloader.events.EventListener;
import org.legendofdragoon.modloader.events.Priority;

import static legend.core.GameEngine.EVENTS;

public class LloydLoaded implements LloydInterface {

  public LloydLoaded() {
    super();
  }

  @Override
  public void registerEvents() {
    EVENTS.register(this);
  }

  @Override
  public void registerTemplate(final RegisterCharacterTemplatesEvent event) {

  }

  @EventListener(priority = Priority.LOW)
  public void lloydJoinedParty(final LloydJoinedPartyEvent event) {
    try {

      event.override = true;
    } catch(final Exception ignored) {
    }
  }

  @EventListener(priority = Priority.LOW)
  public void lloydJoinedParty(final LloydAllowNewGameAddEvent event) {
    try {
      event.allowNewGameAdd = false;
    } catch(final Exception ignored) {
    }
  }
}