package roboguy99.chemistry.block.ore;

import java.util.HashMap;
import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.api.Colour;
import roboguy99.chemistry.api.Group;
import roboguy99.chemistry.item.block.ItemBlockOre;
import roboguy99.chemistry.item.element.ItemElement;
import roboguy99.chemistry.wrapper.MinMax;

public class BlockOre extends Block //TODO Display tooltip based on process results
{
	private String name;
	private HashMap<ItemElement, MinMax> resourceMap;
	
	public BlockOre(String name, ModelResourceLocation model, HashMap<ItemElement, MinMax> resourceMap)
	{	
		super(Material.ROCK);
		//this.name = "ore_" + element.getElement().getName().replaceAll("element_", "").toLowerCase();
		this.name = "ore_" + name;
		this.resourceMap = resourceMap;
		
		this.setCreativeTab(Chemistry.tabOres);
		this.setUnlocalizedName(this.name);
		this.setRegistryName(this.name);
		this.setHardness(3F);
		this.setHarvestLevel("pickaxe", 2);
		GameRegistry.register(this);
		
		ItemBlock itemBlock = new ItemBlockOre(this);
		itemBlock.setRegistryName(this.name);
		GameRegistry.register(itemBlock);
		
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, model);
		ModelLoader.setCustomModelResourceLocation(itemBlock, 0, model);
		//ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		//mesher.register(Item.getItemFromBlock(this), 0, model);
		//mesher.register(itemBlock, 0, model);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced)
	{
		if(!Keyboard.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode()))
		{
			tooltip.add(Colour.DARK_GREEN + "Sneak for more info");
		}
		else
		{
			for(ItemElement element: resourceMap.keySet())
			{
				String elementName = I18n.format(element.getUnlocalizedName() + ".name");
				MinMax minMax = this.resourceMap.get(element); //Process quantity bounds
				tooltip.add(Group.getGroupColour(element.getGroup()) + elementName + ": " + minMax.getMin() + "-" + minMax.getMax());
			}
		}
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
	
	/**
	 * Gets the list of all elements and their process values
	 * @return
	 */
	public HashMap<ItemElement, MinMax> getResourceMap()
	{
		return this.resourceMap;
	}
}
