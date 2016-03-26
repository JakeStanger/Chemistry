package roboguy99.chemistry.item.compound;

import java.util.LinkedHashMap;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roboguy99.chemistry.item.element.Element;

public class Compound extends Item
{
	private String formula;
	
	public Compound(LinkedHashMap<Element, Integer> structure)
	{	
		this.setUnlocalizedName("");
		this.setMaxStackSize(64);
		GameRegistry.registerItem(this, "");
	}
}
