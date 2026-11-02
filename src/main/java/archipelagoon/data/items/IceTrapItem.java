package archipelagoon.data.items;

import legend.core.tags.IntTag;
import legend.core.tags.MapTag;
import legend.core.tags.RegistryIdTag;
import legend.core.tags.Tag;
import legend.game.characters.CharacterData2c;
import legend.game.characters.StatCollection;
import legend.game.characters.VitalsStat;
import legend.game.combat.bent.BattleEntity27c;
import legend.game.i18n.I18n;
import legend.game.inventory.Item;
import legend.game.inventory.ItemIcon;
import legend.game.inventory.ItemStack;
import legend.game.inventory.UseItemResponse;
import legend.game.scripting.ScriptState;
import legend.lodmod.items.BattleItem;
import org.legendofdragoon.modloader.registries.RegistryDelegate;

import java.util.Optional;
import java.util.function.Function;

import static legend.core.GameEngine.REGISTRIES;
import static legend.game.Scus94491BpeSegment_800b.gameState_800babc8;
import static legend.lodmod.LodMod.HP_STAT;

public class IceTrapItem extends BattleItem {
  public IceTrapItem() {
    super(ItemIcon.NONE, 0);
  }

  /**
   * Creates an ice trap that impersonates the item being passed in
   */
  public ItemStack impersonate(final Item item) {
    return this.impersonate(new ItemStack(item));
  }

  /**
   * Creates an ice trap that impersonates the item being passed in
   */
  public ItemStack impersonate(final ItemStack stack) {
    final MapTag itemTag = new MapTag();
    itemTag.set("itemId", new RegistryIdTag(stack.getRegistryId()));
    itemTag.set("durability", new IntTag(stack.getCurrentDurability()));

    final Tag extraData = stack.getExtraData();

    if(extraData != null) {
      itemTag.set("extraData", extraData);
    }

    final ItemStack impersonatedStack = new ItemStack(this, stack.getSize(), stack.getCurrentDurability());
    impersonatedStack.setExtraData(itemTag);

    return impersonatedStack;
  }

  private ItemStack getImpersonatedStack(final ItemStack stack) {
    final Tag data = stack.getExtraData();

    if(data == null || !data.asMap().has("itemId")) {
      return null;
    }

    final RegistryDelegate<Item> delegate = REGISTRIES.items.getEntry(data.asMap().get("itemId").asRegistryId().get());

    if(!delegate.isValid()) {
      return null;
    }

    final Item item = delegate.get();
    final ItemStack impersonatedStack = new ItemStack(item, stack.getSize(), stack.getCurrentDurability());
    impersonatedStack.setExtraData(data);

    return impersonatedStack;
  }

  private <T> Optional<T> getImpersonatedStackValue(final ItemStack stack, final Function<ItemStack, T> accessor) {
    final ItemStack impersonatedStack = this.getImpersonatedStack(stack);

    if(impersonatedStack == null) {
      return Optional.empty();
    }

    return Optional.of(accessor.apply(impersonatedStack));
  }

  @Override
  public ItemIcon getIcon(final ItemStack stack) {
    return this.getImpersonatedStackValue(stack, ItemStack::getIcon).orElseGet(() -> super.getIcon(stack));
  }

  @Override
  public String getNameTranslationKey(final ItemStack stack) {
    return this.getImpersonatedStackValue(stack, ItemStack::getNameTranslationKey).orElseGet(() -> super.getNameTranslationKey(stack));
  }

  @Override
  public String getDescriptionTranslationKey(final ItemStack stack) {
    return this.getImpersonatedStackValue(stack, ItemStack::getDescriptionTranslationKey).orElseGet(() -> super.getDescriptionTranslationKey(stack));
  }

  @Override
  public String getBattleDescriptionTranslationKey(final ItemStack stack) {
    return this.getImpersonatedStackValue(stack, ItemStack::getBattleDescriptionTranslationKey).orElseGet(() -> super.getBattleDescriptionTranslationKey(stack));
  }

  @Override
  public int getBuyPrice(final ItemStack stack) {
    return this.getImpersonatedStackValue(stack, ItemStack::getBuyPrice).orElseGet(() -> super.getBuyPrice(stack));
  }

  @Override
  public int getSellPrice(final ItemStack stack) {
    return this.getImpersonatedStackValue(stack, ItemStack::getSellPrice).orElseGet(() -> super.getSellPrice(stack));
  }

  @Override
  public int getMaxStackSize(final ItemStack stack) {
    return this.getImpersonatedStackValue(stack, ItemStack::getMaxSize).orElseGet(() -> super.getMaxStackSize(stack));
  }

  @Override
  public boolean hasDurability(final ItemStack stack) {
    // Reading the stack from our json data has to call this method. If we were to try to
    // read this from the impersonated stack it would cause a stack overflow.

    final Tag extraData = stack.getExtraData();

    if(extraData == null) {
      return super.hasDurability(stack);
    }

    final MapTag itemTag = extraData.asMap();
    if(!itemTag.has("durability")) {
      return super.hasDurability(stack);
    }

    return itemTag.get("durability").asBool().get();
  }

  @Override
  public int getMaxDurability(final ItemStack stack) {
    return this.getImpersonatedStackValue(stack, ItemStack::getMaxDurability).orElseGet(() -> super.getMaxDurability(stack));
  }

  // Breaks taking item from inventory
  //  @Override
  //  public boolean isSame(final ItemStack stack) {
  //    return this.getImpersonatedStackValue(stack, stack::isSameItem).orElseGet(() -> super.isSame(stack));
  //  }

  @Override
  public boolean canBeUsed(final ItemStack stack, final UsageLocation location) {
    return this.getImpersonatedStackValue(stack, impersonatedStack -> impersonatedStack.canBeUsed(location)).orElse(false);
  }

  @Override
  public boolean canBeUsedNow(final ItemStack stack, final UsageLocation location) {
    return this.getImpersonatedStackValue(stack, impersonatedStack -> impersonatedStack.canBeUsedNow(location)).orElseGet(() -> super.canBeUsedNow(stack, location));
  }

  @Override
  public boolean canTarget(final ItemStack stack, final TargetType type) {
    if(type == TargetType.INSTANT) {
      return true;
    }

    return this.getImpersonatedStackValue(stack, impersonatedStack -> impersonatedStack.canTarget(type)).orElse(false);
  }

  @Override
  public void useInMenu(final ItemStack stack, final UseItemResponse response, final int charId) {
    final CharacterData2c character = gameState_800babc8.charData_32c.get(charId);
    final StatCollection stats = character.stats;
    final VitalsStat stat = stats.getStat(HP_STAT.get());
    final int currentHp = stats.getStat(HP_STAT.get()).getCurrent();
    final int hpToTake = currentHp / 10;

    stat.setCurrent(Math.max(1, currentHp - hpToTake));

    //    loadCharacterStats(); // not sure what equivalent is here
    response.success(I18n.translate(this.getTranslationKey("use")));
  }

  @Override
  protected int getUseItemScriptEntrypoint() {
    return 34;
  }

  @Override
  protected void useItemScriptLoaded(final ScriptState<BattleEntity27c> user, final int targetBentIndex) {
    user.setStor(8, 0xd7fff5); // Colour
    user.setStor(28, user.index);
    user.setStor(30, user.index);
  }
}