package archipelagoon.screens;

import archipelagoon.Archipelagoon;
import archipelagoon.ap.APContext;
import legend.core.lang.I18nText;
import legend.core.lang.RawText;
import legend.core.lang.TextComponent;
import legend.core.platform.input.InputAction;
import legend.game.inventory.screens.InputPropagation;
import legend.game.inventory.screens.VerticalLayoutScreen;
import legend.game.inventory.screens.controls.Background;
import legend.game.inventory.screens.controls.Button;
import legend.game.inventory.screens.controls.Label;
import legend.game.inventory.screens.controls.Panel;
import legend.game.inventory.screens.controls.Textbox;
import legend.game.modding.coremod.CoreEngineStateTypes;
import legend.game.modding.coremod.CoreMod;
import legend.game.saves.ConfigCollection;
import org.jetbrains.annotations.NotNull;

import java.net.URISyntaxException;

import static archipelagoon.Archipelagoon.ADDRESS_CONFIG;
import static archipelagoon.Archipelagoon.PASSWORD_CONFIG;
import static archipelagoon.Archipelagoon.SLOT_NAME_CONFIG;
import static legend.game.EngineStates.currentEngineState_8004dd04;
import static legend.game.FullScreenEffects.startFadeEffect;
import static legend.game.Menus.deallocateRenderables;
import static legend.game.Scus94491BpeSegment_800b.battleLoaded_800bc94c;
import static legend.game.sound.Audio.playMenuSound;

public class ArchipelagoConnectScreen extends VerticalLayoutScreen {
  private final Textbox address;
  private final Textbox password;
  private final Textbox slotName;
  private final Label statusLabel;
  private final Runnable unload;
  private final ConfigCollection config;

  private final TextComponent connectedText =
    new I18nText(Archipelagoon.MOD_ID + ".config.connected");
  private final TextComponent notConnectedText =
    new I18nText(Archipelagoon.MOD_ID + ".config.not_connected");
  private final TextComponent connectingText =
    new I18nText(Archipelagoon.MOD_ID + ".config.connecting");
  private boolean connecting;
  private Boolean lastConnectedState;

  public ArchipelagoConnectScreen(final ConfigCollection config, final Runnable unload) {
    deallocateRenderables(0xff);
    startFadeEffect(2, 10);

    this.config = config;
    this.unload = unload;
    this.connecting = false;

    if(battleLoaded_800bc94c) {
      final Panel panel = Panel.panel();
      panel.setPos(12, 20);
      panel.setSize(296, 140);
      panel.setZ(36);
      this.addControl(panel);
    } else {
      this.addControl(new Background());
    }

    this.address = new Textbox();
    this.address.setText(this.config.getConfig(ADDRESS_CONFIG.get()));
    this.address.setMaxLength(30);
    this.address.setZ(35);

    this.addRow(new I18nText(Archipelagoon.MOD_ID + ".config.address.label"), this.address);

    this.slotName = new Textbox();
    this.slotName.setText(this.config.getConfig(SLOT_NAME_CONFIG.get()));
    this.slotName.setMaxLength(30);
    this.slotName.setZ(35);

    this.addRow(new I18nText(Archipelagoon.MOD_ID + ".config.slot_name.label"), this.slotName);

    this.password = new Textbox();
    this.password.setText(this.config.getConfig(PASSWORD_CONFIG.get()));
    this.password.setMaxLength(30);
    this.password.setZ(35);

    this.addRow(new I18nText(Archipelagoon.MOD_ID + ".config.password.label"), this.password);

    final APContext ctx = APContext.getContext();
    this.lastConnectedState = ctx.isConnected();
    this.statusLabel = new Label(new I18nText(Archipelagoon.MOD_ID + ".config." + (ctx.isConnected() ? "connected" : "not_connected")));
    this.addRow(new RawText(""), this.statusLabel);

    if(currentEngineState_8004dd04.is(CoreEngineStateTypes.TITLE.getId())) {
      return;
    }

    final Button connect = new Button(new I18nText(Archipelagoon.MOD_ID + ".config.connect"));
    this.addRow(new RawText(""), connect);
    connect.onPressed(() -> {
      this.connecting = true;
      this.statusLabel.setText(this.connectingText);
      try {
        ctx.connect(this.address.getText(), this.slotName.getText(), this.password.getText());
      } catch(final URISyntaxException e) {
        this.connecting = false;
        this.statusLabel.setText(this.notConnectedText);
      }
    });
  }

  @Override
  protected float getSizeScale() {
    if(battleLoaded_800bc94c) {
      return this.getWidth() / 320.0f;
    } else {
      return super.getWidth() / 368.0f;
    }
  }

  @Override
  protected void render() {
    super.render();
    final boolean connected = APContext.getContext().isConnected();
    if(connected) {
      this.connecting = false;
    }

    if(!this.connecting) {
      if(this.lastConnectedState == null || this.lastConnectedState != connected) {
        this.lastConnectedState = connected;
        this.statusLabel.setText(connected ? this.connectedText : this.notConnectedText);
      }
    }
  }

  @Override
  protected InputPropagation inputActionPressed(@NotNull final InputAction action, final boolean repeat) {
    if(super.inputActionPressed(action, repeat) == InputPropagation.HANDLED) {
      return InputPropagation.HANDLED;
    }

    if(action == CoreMod.INPUT_ACTION_MENU_BACK.get()) {
      this.config.setConfig(ADDRESS_CONFIG.get(), this.address.getText());
      this.config.setConfig(SLOT_NAME_CONFIG.get(), this.slotName.getText());
      this.config.setConfig(PASSWORD_CONFIG.get(), this.password.getText());
      playMenuSound(3);
      this.unload.run();
      return InputPropagation.HANDLED;
    }

    return InputPropagation.PROPAGATE;
  }

  @Override
  public int getWidth() {
    if(battleLoaded_800bc94c) {
      return 320;
    } else {
      return super.getWidth();
    }
  }
}
