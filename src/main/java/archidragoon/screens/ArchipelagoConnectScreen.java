package archidragoon.screens;

import archidragoon.ArchiDragoon;
import archidragoon.ap.APContext;
import legend.core.platform.input.InputAction;
import legend.game.Audio;
import legend.game.Menus;
import legend.game.i18n.I18n;
import legend.game.inventory.WhichMenu;
import legend.game.inventory.screens.InputPropagation;
import legend.game.inventory.screens.VerticalLayoutScreen;
import legend.game.inventory.screens.controls.Background;
import legend.game.inventory.screens.controls.Button;
import legend.game.inventory.screens.controls.Label;
import legend.game.inventory.screens.controls.Textbox;
import legend.game.modding.coremod.CoreMod;
import legend.game.saves.ConfigCollection;
import org.jetbrains.annotations.NotNull;

import java.net.URISyntaxException;

import static archidragoon.ArchiDragoon.ADDRESS_CONFIG;
import static archidragoon.ArchiDragoon.PASSWORD_CONFIG;
import static archidragoon.ArchiDragoon.SLOT_NAME_CONFIG;
import static legend.game.Audio.playMenuSound;
import static legend.game.FullScreenEffects.startFadeEffect;
import static legend.game.Menus.deallocateRenderables;

public class ArchipelagoConnectScreen  extends VerticalLayoutScreen {
    private final Textbox address;
    private final Textbox password;
    private final Textbox slotName;
    private Label statusLabel;

    private final APContext apContext;
    private final Runnable unload;

    private final ConfigCollection config;
    private final boolean unloading = false;

    public ArchipelagoConnectScreen(final ConfigCollection config, final Runnable unload) {
      deallocateRenderables(0xff);
      startFadeEffect(2, 10);

      this.config = config;
      this.unload = unload;

      this.addControl(new Background());

      this.apContext = APContext.getContext();

      this.address = new Textbox();
      this.address.setText(this.config.getConfig(ADDRESS_CONFIG.get()));
      this.address.setMaxLength(30);
      this.address.setZ(35);

      this.addRow(I18n.translate(ArchiDragoon.MOD_ID + ".config.address.label"), this.address);

      this.slotName = new Textbox();
      this.slotName.setText(this.config.getConfig(SLOT_NAME_CONFIG.get()));
      this.slotName.setMaxLength(15);
      this.slotName.setZ(35);

      this.addRow(I18n.translate(ArchiDragoon.MOD_ID + ".config.slot_name.label"), this.slotName);

      this.password = new Textbox();
      this.password.setText(this.config.getConfig(PASSWORD_CONFIG.get()));
      this.password.setMaxLength(15);
      this.password.setZ(35);

      this.addRow(I18n.translate(ArchiDragoon.MOD_ID + ".config.password.label"), this.password);

      this.statusLabel = new Label(I18n.translate(ArchiDragoon.MOD_ID + ".config." + (this.apContext.isConnected() ? "connected" : "not_connected")));
      this.addRow("", this.statusLabel);

      final Button connect = new Button(I18n.translate(ArchiDragoon.MOD_ID + ".config.connect"));
      this.addRow("", connect);
      connect.onPressed(() -> {
        this.statusLabel.setText(I18n.translate(ArchiDragoon.MOD_ID + ".config.connecting"));
        try {
          this.apContext.connect(this.address.getText(), this.slotName.getText(), this.password.getText());
          this.statusLabel = new Label(I18n.translate(ArchiDragoon.MOD_ID + ".config." + (this.apContext.isConnected() ? "connected" : "not_connected")));
        } catch(final URISyntaxException e) {
          this.statusLabel = new Label(I18n.translate(ArchiDragoon.MOD_ID + ".config." + "not_connected"));
        }
      });
    }

    @Override
    protected void render() {
      if(!this.unloading) {
        return;
      }

      Audio.playMenuSound(2);
      Menus.whichMenu_800bdc38 = WhichMenu.UNLOAD;
      this.unload.run();
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
}
