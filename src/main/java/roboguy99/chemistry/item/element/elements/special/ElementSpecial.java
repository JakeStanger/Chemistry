package roboguy99.chemistry.item.element.elements.special;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import roboguy99.chemistry.item.element.ItemElement;

/**
 * An element used for mod utility purposes.
 * If you require an element that is not part of your periodic table, 
 * but you need for some internal mechanism, extend this.
 * For example, see the MoleculeMarker element.
 * @author Roboguy99
 *
 */
public abstract class ElementSpecial extends ItemElement
{
	/*@Override
	protected void addToCreativeTab()
	{}*/
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced)
	{}
}
