package archipelagoon.data;

import legend.game.inventory.ItemIcon;
import legend.game.types.UiType;

public class APIcon extends ItemIcon {
  public static final APIcon PRIORITY = new APIcon(0);
  public static final APIcon OTHER = new APIcon(1);

  public APIcon(final int icon) {
    super(icon);
  }

  @Override
  protected UiType getUiType() {
    return APIconUiType._ICONS;
  }
}
