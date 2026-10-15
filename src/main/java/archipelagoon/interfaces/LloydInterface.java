package archipelagoon.interfaces;

import legend.game.characters.RegisterCharacterTemplatesEvent;

public interface LloydInterface {
  void registerEvents();

  void registerTemplate(RegisterCharacterTemplatesEvent event);
}

