package am2.api.spell.component.interfaces;

import am2.api.spell.ItemSpellBase;
import am2.api.spell.enums.Affinity;
import am2.api.spell.enums.SpellCastResult;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public interface ISpellShape extends ISpellPart{
	/**
	 * Creates the target area/entity list and applies the effects to ground/mobs
	 *
	 * @param item     The spell being cast
	 * @param stack    The itemstack representing the spell
	 * @param caster   The caster of the spell
	 * @param target   The specified target of the spell.  If this is not NULL, this is a forced target, and should be included with any other targets of the shape.  Otherwise the default spell shape logic should apply.
	 * @param world    The world the spell is being cast in
	 * @param x        The x-coordinate of the spell's effect
	 * @param y        The y-coordinate of the spell's effect
	 * @param z        The z-coordinate of the spell's effect
	 * @param side     The side the spell is applied on
	 * @param giveXP   This is passed along to be given back to the SpellHelper where needed.
	 * @param useCount The number of ticks the spell item has been in use for
	 * @return The result of the spell cast.
	 */
	 SpellCastResult beginStackStage(ItemSpellBase item, ItemStack stack, EntityLivingBase caster, EntityLivingBase target, World world, double x, double y, double z, EnumFacing side, boolean giveXP, int useCount);

	/**
	 * Is this shape a valid shape for a channeled/maintained spell?
	 */
	 boolean isChanneled();

	/**
	 * Allows different shapes to vary the mana cost of a spell
	 *
	 * @param spellStack the itemstack representing the spell (useful if you want to vary based on added modifiers as well, for example)
	 * @return
	 */
	 float manaCostMultiplier(ItemStack spellStack);

	/**
	 * Is the spell a terminus shape?  Return true if this component does not continue the spell chain when proccing.
	 */
	 boolean isTerminusShape();

	/**
	 * Is the shape a principal shape?  Return true if this spell requires another shape to proc (like runes and zones)
	 */
	 boolean isPrincipumShape();

	/**
	 * Play the sound for the specified affinity
	 */
	 String getSoundForAffinity(Affinity affinity, ItemStack stack, World world);
}
