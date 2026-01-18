package archipelagoon.ap.events;

import archipelagoon.ap.APContext;
import archipelagoon.ap.mapping.LocationState;
import io.github.archipelagomw.events.ArchipelagoEventListener;
import io.github.archipelagomw.events.LocationInfoEvent;
import io.github.archipelagomw.parts.NetworkItem;
import legend.core.GameEngine;

import java.util.ArrayList;
import java.util.List;

import static archipelagoon.Archipelagoon.LOCATION_STATE_REGISTRY;

public class LocationInfoListener {
  @ArchipelagoEventListener
  public void onLocationInfoEvent(final LocationInfoEvent event) {
    final APContext context = APContext.getContext();
    final List<LocationState> locationList = new ArrayList<>();

    for (final NetworkItem item : event.locations) {
      final LocationState locationState = new LocationState(item, false);
      locationList.add(locationState);
    }

    GameEngine.CONFIG.setConfig(LOCATION_STATE_REGISTRY.get(), locationList);
  }
}
