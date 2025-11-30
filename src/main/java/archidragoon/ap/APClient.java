package archidragoon.ap;


import archidragoon.ap.events.ConnectionResult;
import io.github.archipelagomw.Client;
import legend.game.inventory.screens.MessageBoxScreen;

import java.net.URISyntaxException;

import static legend.game.SItem.menuStack;

public class APClient extends Client {
  private boolean errorDisplayed;

  public APClient(){
    super();
    final String gameName = "The Legend of Dragoon";
    this.setGame(gameName);
    this.registerDefaultListeners();
  }

  @Override
  public void onError(final Exception ex) {

    final String message = "An error has occurred:\n" + ex.getLocalizedMessage();
    if (this.errorDisplayed) {
      return;
    }
    this.errorDisplayed = true;
    menuStack.pushScreen(new MessageBoxScreen(message,0, result -> {
      this.errorDisplayed = false;
    }));
  }

  @Override
  public void onClose(final String Reason, final int attemptingReconnect) {
   // TODO pk
  }

  public void connectToServer(final String host, final String slotName, final String password) throws URISyntaxException {
    this.setName(slotName);
    this.setPassword(password);
    this.connect(host);
  }

  private void registerDefaultListeners() {
    this.getEventManager().registerListener(new ConnectionResult());
  }
}