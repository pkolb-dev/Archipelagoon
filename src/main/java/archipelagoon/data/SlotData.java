package archipelagoon.data;

import archipelagoon.ap.mapping.locations.Shops;
import com.google.gson.annotations.SerializedName;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class SlotData {
  public static final Set<String> EXPECTED_MOD_VERSIONS = new HashSet<>(List.of("2.1.0"));

  @SerializedName("addition_randomizer")
  public int additionRandomizer = 0;

  @SerializedName("magic_randomizer")
  public int magicRandomizer = 0;

  @SerializedName("lod_completion_condition")
  public int completionCondition = 1;

  @SerializedName("world_version")
  public List<Integer> worldVersion = new ArrayList<>();

  @SerializedName("death_link")
  public int deathLink = 0;

  @SerializedName("enable_shop_sanity")
  public int enableShopsanity = 0;

  @SerializedName("allow_repeat_consumables")
  public int allowRepeatConsumables = 0;

  @SerializedName("default_shop_slots")
  public int defaultShopSlots = 10;

  @SerializedName("missable_shop_slots")
  public int missableShopSlots = 10;

  @SerializedName("maximum_shop_price")
  public int maximumShopPrice = 500;

  @SerializedName("minimum_shop_price")
  public int minimumShopPrice = 10;

  public long slotSeed = 0L;

  private SlotData() {
  }

  public String getVersion() {
    return String.format("%s.%s.%s", this.worldVersion.get(0), this.worldVersion.get(1), this.worldVersion.get(2));
  }

  public int getShopSlots(final RegistryId registryId) {
    if(Shops.isPermanentShop(registryId)) {
      return this.defaultShopSlots;
    } else {
      return this.missableShopSlots;
    }
  }
}