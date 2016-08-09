package roboguy99.chemistry.block;

import java.util.HashMap;
import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.api.Elements.Element;
import roboguy99.chemistry.block.ore.BlockOre;
import roboguy99.chemistry.item.block.ItemBlockOre;
import roboguy99.chemistry.item.element.ItemElement;
import roboguy99.chemistry.tile.TileCompoundCreator;
import roboguy99.chemistry.tile.TileOreProcessor;
import roboguy99.chemistry.wrapper.MinMax;

public class BlockOreProcessor extends BlockTile
{
	public BlockOreProcessor() 
	{
		super(Material.IRON, "blockOreProcessor", Chemistry.tabMachines, TileOreProcessor.class);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) 
	{
		if(!world.isRemote && heldItem != null) 
		{
			HashMap<ItemElement, Integer> elements = assignRandomElements(heldItem.getItem()); //Get random elements based on ore
			
			//TODO Replace with GUI
			for(ItemElement element : elements.keySet())
			{
				player.addChatMessage(new TextComponentString(element.getName() + " - " + elements.get(element))); 
			}
		}
		return true;
	}
	
	/**
	 * Assigns random elements based on the item given, assuming the item is an ore.
	 * The quantity of elements is based on the ore's resource map.
	 * @param item The item to assign elements to.
	 * @return A map of assigned elements and quantities
	 */
	private HashMap<ItemElement, Integer> assignRandomElements(Item item)
	{
		HashMap<ItemElement, Integer> elements = new HashMap<ItemElement, Integer>();
		
		if(item instanceof ItemBlockOre) //Check item is ore
		{
			Random random = new Random();
			BlockOre ore = ((ItemBlockOre) item).getOre();
			
			for(ItemElement element : ore.getResourceMap().keySet())
			{
				MinMax minMax = ore.getResourceMap().get(element);
				int quantity = random.nextInt(minMax.getMax()+1 - minMax.getMin()) + minMax.getMin(); //Get random quantity within bounds HEY TOBY I BROKE IT AGAIN
				elements.put(element, quantity);
			}
		}
		
		return elements;
	}
}
