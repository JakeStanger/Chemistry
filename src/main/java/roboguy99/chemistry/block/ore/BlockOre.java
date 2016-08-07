package roboguy99.chemistry.block.ore;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.api.Elements.Element;
import roboguy99.chemistry.item.element.ItemElement;

public abstract class BlockOre extends Block
{
	private String name;
	
	public BlockOre(Element element)
	{	
		super(Material.ROCK);
		this.name = "ore_" + element.getElement().getName().replaceAll("element_", "").toLowerCase();
		
		this.setCreativeTab(Chemistry.tabOres);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setHardness(3F);
		this.setHarvestLevel("pickaxe", 2);
		GameRegistry.register(this);
		
		ItemBlock itemBlock = new ItemBlock(this);
		itemBlock.setRegistryName(name);
		GameRegistry.register(itemBlock);
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation("chemistry:" + name, "inventory"));
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
	
	//protected abstract void giveProcessRecipe();
}
