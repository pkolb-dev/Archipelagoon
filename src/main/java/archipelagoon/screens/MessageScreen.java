package archipelagoon.screens;

import legend.core.lang.RawText;
import legend.core.platform.input.InputAction;
import legend.game.i18n.I18n;
import legend.game.inventory.screens.InputPropagation;
import legend.game.inventory.screens.MenuScreen;
import legend.game.types.MessageBox20;
import legend.game.types.MessageBoxResult;
import legend.game.types.MessageBoxType;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import static legend.game.Graphics.displayWidth_1f8003e0;
import static legend.game.SItem.messageBox;
import static legend.game.SItem.setMessageBoxOptions;
import static legend.game.SItem.setMessageBoxText;

public class MessageScreen extends MenuScreen {
  private final Consumer<MessageBoxResult> onResult;
  private final MessageBox20 messageBox = new MessageBox20();
  private int framesRemaining;

  public MessageScreen(final String messageKey, final Consumer<MessageBoxResult> onResult) {
    this.framesRemaining = 120;
    setMessageBoxText(this.messageBox, I18n.translate(messageKey), MessageBoxType.ALERT);
    final RawText yes = new RawText("");
    final RawText no = new RawText("null");
    setMessageBoxOptions(this.messageBox, yes, no);

    this.messageBox.x_1c = displayWidth_1f8003e0 - 190;
    this.messageBox.y_1e = 5;
    this.onResult = onResult;
  }

  private void unloadMessage() {
    this.messageBox.state_0c = 4;
    this.getStack().popScreen();
    this.onResult.accept(null);
  }

  @Override
  protected void render() {
    messageBox(this.messageBox);

    if(this.messageBox.state_0c == 0) {
      this.unloadMessage();
    }

    if(this.framesRemaining-- < 0) {
      this.deferAction(this::unloadMessage);
    }
  }

  @Override
  protected InputPropagation inputActionPressed(@NotNull final InputAction action, final boolean repeat) {
    return InputPropagation.HANDLED;
  }
}
