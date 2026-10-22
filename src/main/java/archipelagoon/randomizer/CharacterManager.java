package archipelagoon.randomizer;

import legend.game.characters.CharacterData2c;
import legend.game.characters.LevelUpSource;
import legend.game.characters.StatCollection;
import legend.game.characters.UnaryStat;
import legend.game.inventory.Equipment;
import legend.game.types.EquipmentSlot;
import legend.game.types.GameState52c;
import legend.lodmod.LodCharacterTemplates;
import legend.lodmod.LodEquipment;
import legend.lodmod.LodMod;
import org.legendofdragoon.modloader.registries.RegistryId;

import java.util.ArrayList;

import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;
import static legend.lodmod.LodMod.ATTACK_AVOID_STAT;
import static legend.lodmod.LodMod.ATTACK_HIT_STAT;
import static legend.lodmod.LodMod.GUARD_HEAL_STAT;
import static legend.lodmod.LodMod.HP_STAT;
import static legend.lodmod.LodMod.MAGIC_AVOID_STAT;
import static legend.lodmod.LodMod.MAGIC_HIT_STAT;
import static legend.lodmod.LodMod.MP_STAT;

public final class CharacterManager {
  private static final CharacterManager INSTANCE = new CharacterManager();

  private CharacterManager() {
  }

  public static CharacterManager getInstance() {
    return INSTANCE;
  }

  public void lockCharacters(final GameState52c state) {
    state.charData_32c.forEach(cd -> {
      // remove from In party & can be in party
      cd.partyFlags_04 &= ~CharacterData2c.IN_PARTY;
      cd.partyFlags_04 &= ~CharacterData2c.CAN_BE_IN_PARTY;
      cd.partyFlags_04 &= ~CharacterData2c.TEMPORARILY_REMOVED_FROM_PARTY;
    });

    // clear active party
    state.charIds_88.clear();
  }

  public void addToPool(final RegistryId charId, final GameState52c gameState) {
    final GameState52c state = this.resolveState(gameState);

    final CharacterData2c character = state.charData_32c.stream()
      .filter(cd -> cd.template.getRegistryId().equals(charId))
      .findFirst()
      .orElse(null);

    if(character == null) {
      return;
    }

    character.partyFlags_04 |= 0x3;
    character.level_12 = 0;
    character.dlevel_13 = 0;
    final UnaryStat aHitStat = character.stats.getStat(ATTACK_HIT_STAT.get());
    final UnaryStat mHitStat = character.stats.getStat(MAGIC_HIT_STAT.get());
    final UnaryStat aAvoStat = character.stats.getStat(ATTACK_AVOID_STAT.get());
    final UnaryStat mAvoStat = character.stats.getStat(ATTACK_AVOID_STAT.get());
    final UnaryStat guardHealStat = character.stats.getStat(GUARD_HEAL_STAT.get());
    character.stats.set(new StatCollection(HP_STAT.get(), MP_STAT.get(), LodMod.SP_STAT.get(), LodMod.SPEED_STAT.get(), LodMod.ATTACK_STAT.get(), LodMod.MAGIC_ATTACK_STAT.get(), LodMod.DEFENSE_STAT.get(), LodMod.MAGIC_DEFENSE_STAT.get(), ATTACK_HIT_STAT.get(), LodMod.MAGIC_HIT_STAT.get(), LodMod.ATTACK_AVOID_STAT.get(), LodMod.MAGIC_AVOID_STAT.get(), LodMod.DRAGOON_ATTACK_STAT.get(), LodMod.DRAGOON_MAGIC_ATTACK_STAT.get(), LodMod.DRAGOON_DEFENSE_STAT.get(), LodMod.DRAGOON_MAGIC_DEFENSE_STAT.get(), GUARD_HEAL_STAT.get()));
    character.stats.getStat(ATTACK_HIT_STAT.get()).set(aHitStat);
    character.stats.getStat(MAGIC_HIT_STAT.get()).set(mHitStat);
    character.stats.getStat(ATTACK_AVOID_STAT.get()).set(aAvoStat);
    character.stats.getStat(MAGIC_AVOID_STAT.get()).set(mAvoStat);
    character.stats.getStat(GUARD_HEAL_STAT.get()).set(guardHealStat);
    character.xp_00 = 0;
    character.applyLevelUp(null, LevelUpSource.INITIALIZATION);
    character.applyDragoonLevelUp(null);

    character.stats.getStat(HP_STAT.get()).restore();
    character.stats.getStat(MP_STAT.get()).restore();

    if(state.charIds_88.size() < 3) {
      state.charIds_88.add(state.charData_32c.indexOf(character));
    }
  }

  private GameState52c resolveState(final GameState52c state) {
    return state != null ? state : gameState_800babc8;
  }

  public void setStartingEquipment(final GameState52c state) {
    for(final CharacterData2c character : state.charData_32c) {
      final RegistryId charId = character.template.getRegistryId();
      if(charId.equals(LodCharacterTemplates.DART.getId())) {
        this.equipStartingGear(character, LodEquipment.BROAD_SWORD.get());
      } else if(charId.equals(LodCharacterTemplates.LAVITZ.getId())) {
        this.equipStartingGear(character, LodEquipment.SPEAR.get());
      } else if(charId.equals(LodCharacterTemplates.SHANA.getId())) {
        this.equipStartingGear(character, LodEquipment.SHORT_BOW.get());
      } else if(charId.equals(LodCharacterTemplates.ROSE.getId())) {
        this.equipStartingGear(character, LodEquipment.RAPIER.get());
      } else if(charId.equals(LodCharacterTemplates.HASCHEL.getId())) {
        this.equipStartingGear(character, LodEquipment.IRON_KNUCKLE.get());
      } else if(charId.equals(LodCharacterTemplates.ALBERT.getId())) {
        this.equipStartingGear(character, LodEquipment.SPEAR.get());
      } else if(charId.equals(LodCharacterTemplates.MERU.getId())) {
        this.equipStartingGear(character, LodEquipment.MACE.get());
      } else if(charId.equals(LodCharacterTemplates.KONGOL.getId())) {
        this.equipStartingGear(character, LodEquipment.AXE.get());
      } else if(charId.equals(LodCharacterTemplates.MIRANDA.getId())) {
        this.equipStartingGear(character, LodEquipment.SHORT_BOW.get());
      } else if(charId.equals(new RegistryId("lloyd_mod", "lloyd"))) {
        this.equipStartingGear(character, LodEquipment.BROAD_SWORD.get());
      }
    }
  }

  private void equipStartingGear(final CharacterData2c character, final Equipment weapon) {
    final ArrayList<RegistryId> maleChars = new ArrayList<>();
    maleChars.add(LodCharacterTemplates.DART.getId());
    maleChars.add(LodCharacterTemplates.LAVITZ.getId());
    maleChars.add(LodCharacterTemplates.HASCHEL.getId());
    maleChars.add(LodCharacterTemplates.ALBERT.getId());
    maleChars.add(LodCharacterTemplates.KONGOL.getId());
    maleChars.add(new RegistryId("lloyd_mod", "lloyd"));

    final ArrayList<RegistryId> femChars = new ArrayList<>();
    femChars.add(LodCharacterTemplates.SHANA.getId());
    femChars.add(LodCharacterTemplates.ROSE.getId());
    femChars.add(LodCharacterTemplates.MERU.getId());
    femChars.add(LodCharacterTemplates.MIRANDA.getId());

    character.equip(EquipmentSlot.WEAPON, weapon);
    if(maleChars.contains(character.template.getRegistryId())) {
      character.equip(EquipmentSlot.HELMET, LodEquipment.BANDANA.get());
      character.equip(EquipmentSlot.ARMOUR, LodEquipment.LEATHER_ARMOR.get());
      character.equip(EquipmentSlot.BOOTS, LodEquipment.LEATHER_SHOES.get());
      character.equip(EquipmentSlot.ACCESSORY, LodEquipment.BRACELET.get());
    } else if(femChars.contains(character.template.getRegistryId())) {
      character.equip(EquipmentSlot.HELMET, LodEquipment.BANDANA.get());
      character.equip(EquipmentSlot.ARMOUR, LodEquipment.LEATHER_ARMOR.get());
      character.equip(EquipmentSlot.BOOTS, LodEquipment.LEATHER_BOOTS.get());
      character.equip(EquipmentSlot.ACCESSORY, LodEquipment.BRACELET.get());
    }
  }
}
