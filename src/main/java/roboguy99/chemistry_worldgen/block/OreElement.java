package roboguy99.chemistry_worldgen.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry_worldgen.ChemistryWorldGen;

public class OreElement extends Block
{
	private String name;
	
	public OreElement(Element element)
	{	
		super(Material.ROCK); //TODO Find replacement for this
		this.name = "ore_" + element.getName().replaceAll("element_", "").toLowerCase();
		
		this.setCreativeTab(ChemistryWorldGen.tabOre);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setHardness(3F);
		this.setHarvestLevel("pickaxe", 2);
		GameRegistry.register(this);
		
		ItemBlock itemBlock = new ItemBlock(this);
		itemBlock.setRegistryName(name);
		GameRegistry.register(itemBlock);
	}
	
	/**
	 * Gets the name of the ore. 
	 * Useful if you only want the end part of the unlocalised name
	 * @return
	 */
	public String getName()
	{
		return this.name;
	}
}