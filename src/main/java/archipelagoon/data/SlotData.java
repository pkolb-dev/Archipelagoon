package archipelagoon.data;

import com.google.gson.annotations.SerializedName;
import legend.lodmod.LodShops;
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

  @SerializedName("bale_equipment_shop_slots")
  public int baleEquipmentShopSlots = 10;

  @SerializedName("serdio_item_shop_slots")
  public int serdioItemShopSlots = 7;

  @SerializedName("lohan_equipment_shop_slots")
  public int lohanEquipmentShopSlots = 12;

  @SerializedName("lohan_item_shop_slots")
  public int lohanItemShopSlots = 8;

  @SerializedName("kazas_equipment_shop_slots")
  public int kazasEquipmentShopSlots = 4;

  @SerializedName("kazas_fort_item_shop_slots")
  public int kazasFortItemShopSlots = 5;

  @SerializedName("fletz_equipment_shop_slots")
  public int fletzEquipmentShopSlots = 10;

  @SerializedName("fletz_item_shop_slots")
  public int fletzItemShopSlots = 9;

  @SerializedName("donau_equipment_shop_slots")
  public int donauEquipmentShopSlots = 2;

  @SerializedName("donau_item_shop_slots")
  public int donauItemShopSlots = 6;

  @SerializedName("queen_fury_equipment_shop_slots")
  public int queenFuryEquipmentShopSlots = 5;

  @SerializedName("queen_fury_item_shop_slots")
  public int queenFuryItemShopSlots = 8;

  @SerializedName("fueno_equipment_shop_slots")
  public int fuenoEquipmentShopSlots = 6;

  @SerializedName("fueno_item_shop_slots")
  public int fuenoItemShopSlots = 8;

  @SerializedName("furni_equipment_shop_slots")
  public int furniEquipmentShopSlots = 6;

  @SerializedName("furni_item_shop_slots")
  public int furniItemShopSlots = 5;

  @SerializedName("deningrad_equipment_shop_slots")
  public int deningradEquipmentShopSlots = 13;

  @SerializedName("deningrad_item_shop_slots")
  public int deningradItemShopSlots = 10;

  @SerializedName("wingly_forest_equipment_shop_slots")
  public int winglyForestEquipmentShopSlots = 4;

  @SerializedName("wingly_forest_item_shop_slots")
  public int winglyForestItemShopSlots = 8;

  @SerializedName("vellweb_equipment_shop_slots")
  public int vellwebEquipmentShopSlots = 5;

  @SerializedName("vellweb_item_shop_slots")
  public int vellwebItemShopSlots = 7;

  @SerializedName("ulara_equipment_shop_slots")
  public int ularaEquipmentShopSlots = 9;

  @SerializedName("ulara_item_shop_slots")
  public int ularaItemShopSlots = 12;

  @SerializedName("rouge_equipment_shop_slots")
  public int rougeEquipmentShopSlots = 3;

  @SerializedName("rouge_item_shop_slots")
  public int rougeItemShopSlots = 7;

  @SerializedName("moon_equipment_shop_slots")
  public int moonEquipmentShopSlots = 17;

  @SerializedName("moon_item_shop_slots")
  public int moonItemShopSlots = 9;

  @SerializedName("hellena_01_item_shop_slots")
  public int hellena01ItemShopSlots = 3;

  @SerializedName("kashua_equipment_shop_slots")
  public int kashuaEquipmentShopSlots = 7;

  @SerializedName("kashua_item_shop_slots")
  public int kashuaItemShopSlots = 6;

  @SerializedName("fletz_accessory_shop_slots")
  public int fletzAccessoryShopSlots = 4;

  @SerializedName("forest_item_shop_slots")
  public int forestItemShopSlots = 4;

  @SerializedName("kazas_fort_equipment_shop_slots")
  public int kazasFortEquipmentShopSlots = 2;

  @SerializedName("volcano_item_shop_slots")
  public int volcanoItemShopSlots = 7;

  @SerializedName("zenebatos_equipment_shop_slots")
  public int zenebatosEquipmentShopSlots = 9;

  @SerializedName("zenebatos_item_shop_slots")
  public int zenebatosItemShopSlots = 8;

  @SerializedName("hellena_02_item_shop_slots")
  public int hellena02ItemShopSlots = 6;

  @SerializedName("black_castle_item_shop_slots")
  public int blackCastleItemShopSlots = 7;

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
    if(registryId.equals(LodShops.BALE_EQUIPMENT_SHOP.getId())) {
      return this.baleEquipmentShopSlots;
    } else if(registryId.equals(LodShops.SERDIO_ITEM_SHOP.getId())) {
      return this.serdioItemShopSlots;
    } else if(registryId.equals(LodShops.LOHAN_EQUIPMENT_SHOP.getId())) {
      return this.lohanEquipmentShopSlots;
    } else if(registryId.equals(LodShops.LOHAN_ITEM_SHOP.getId())) {
      return this.lohanItemShopSlots;
    } else if(registryId.equals(LodShops.KAZAS_EQUIPMENT_SHOP.getId())) {
      return this.kazasEquipmentShopSlots;
    } else if(registryId.equals(LodShops.KAZAS_FORT_ITEM_SHOP.getId())) {
      return this.kazasFortItemShopSlots;
    } else if(registryId.equals(LodShops.FLETZ_EQUIPMENT_SHOP.getId())) {
      return this.fletzEquipmentShopSlots;
    } else if(registryId.equals(LodShops.FLETZ_ITEM_SHOP.getId())) {
      return this.fletzItemShopSlots;
    } else if(registryId.equals(LodShops.DONAU_EQUIPMENT_SHOP.getId())) {
      return this.donauEquipmentShopSlots;
    } else if(registryId.equals(LodShops.DONAU_ITEM_SHOP.getId())) {
      return this.donauItemShopSlots;
    } else if(registryId.equals(LodShops.QUEEN_FURY_EQUIPMENT_SHOP.getId())) {
      return this.queenFuryEquipmentShopSlots;
    } else if(registryId.equals(LodShops.QUEEN_FURY_ITEM_SHOP.getId())) {
      return this.queenFuryItemShopSlots;
    } else if(registryId.equals(LodShops.FUENO_EQUIPMENT_SHOP.getId())) {
      return this.fuenoEquipmentShopSlots;
    } else if(registryId.equals(LodShops.FUENO_ITEM_SHOP.getId())) {
      return this.fuenoItemShopSlots;
    } else if(registryId.equals(LodShops.FURNI_EQUIPMENT_SHOP.getId())) {
      return this.furniEquipmentShopSlots;
    } else if(registryId.equals(LodShops.FURNI_ITEM_SHOP.getId())) {
      return this.furniItemShopSlots;
    } else if(registryId.equals(LodShops.DENINGRAD_EQUIPMENT_SHOP.getId())) {
      return this.deningradEquipmentShopSlots;
    } else if(registryId.equals(LodShops.DENINGRAD_ITEM_SHOP.getId())) {
      return this.deningradItemShopSlots;
    } else if(registryId.equals(LodShops.WINGLY_FOREST_EQUIPMENT_SHOP.getId())) {
      return this.winglyForestEquipmentShopSlots;
    } else if(registryId.equals(LodShops.WINGLY_FOREST_ITEM_SHOP.getId())) {
      return this.winglyForestItemShopSlots;
    } else if(registryId.equals(LodShops.VELLWEB_EQUIPMENT_SHOP.getId())) {
      return this.vellwebEquipmentShopSlots;
    } else if(registryId.equals(LodShops.VELLWEB_ITEM_SHOP.getId())) {
      return this.vellwebItemShopSlots;
    } else if(registryId.equals(LodShops.ULARA_EQUIPMENT_SHOP.getId())) {
      return this.ularaEquipmentShopSlots;
    } else if(registryId.equals(LodShops.ULARA_ITEM_SHOP.getId())) {
      return this.ularaItemShopSlots;
    } else if(registryId.equals(LodShops.ROUGE_EQUIPMENT_SHOP.getId())) {
      return this.rougeEquipmentShopSlots;
    } else if(registryId.equals(LodShops.ROUGE_ITEM_SHOP.getId())) {
      return this.rougeItemShopSlots;
    } else if(registryId.equals(LodShops.MOON_EQUIPMENT_SHOP.getId())) {
      return this.moonEquipmentShopSlots;
    } else if(registryId.equals(LodShops.MOON_ITEM_SHOP.getId())) {
      return this.moonItemShopSlots;
    } else if(registryId.equals(LodShops.HELLENA_01_ITEM_SHOP.getId())) {
      return this.hellena01ItemShopSlots;
    } else if(registryId.equals(LodShops.KASHUA_EQUIPMENT_SHOP.getId())) {
      return this.kashuaEquipmentShopSlots;
    } else if(registryId.equals(LodShops.KASHUA_ITEM_SHOP.getId())) {
      return this.kashuaItemShopSlots;
    } else if(registryId.equals(LodShops.FLETZ_ACCESSORY_SHOP.getId())) {
      return this.fletzAccessoryShopSlots;
    } else if(registryId.equals(LodShops.FOREST_ITEM_SHOP.getId())) {
      return this.forestItemShopSlots;
    } else if(registryId.equals(LodShops.KAZAS_FORT_EQUIPMENT_SHOP.getId())) {
      return this.kazasFortEquipmentShopSlots;
    } else if(registryId.equals(LodShops.VOLCANO_ITEM_SHOP.getId())) {
      return this.volcanoItemShopSlots;
    } else if(registryId.equals(LodShops.ZENEBATOS_EQUIPMENT_SHOP.getId())) {
      return this.zenebatosEquipmentShopSlots;
    } else if(registryId.equals(LodShops.ZENEBATOS_ITEM_SHOP.getId())) {
      return this.zenebatosItemShopSlots;
    } else if(registryId.equals(LodShops.HELLENA_02_ITEM_SHOP.getId())) {
      return this.hellena02ItemShopSlots;
    } else if(registryId.equals(LodShops.BLACK_CASTLE_ITEM_SHOP.getId())) {
      return this.blackCastleItemShopSlots;
    } else {
      return 0;
    }
  }
}