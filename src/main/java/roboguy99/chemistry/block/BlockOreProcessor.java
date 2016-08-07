package roboguy99.chemistry.block;

import java.util.HashMap;

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
import roboguy99.chemistry.item.element.ItemElement;
import roboguy99.chemistry.tile.TileCompoundCreator;
import roboguy99.chemistry.tile.TileOreProcessor;

public class BlockOreProcessor extends BlockTile
{
	public BlockOreProcessor() 
	{
		super(Material.IRON, "blockOreProcessor", Chemistry.tabMachines, TileOreProcessor.class);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) 
	{
		if(!world.isRemote) 
		{
			HashMap<ItemElement, Integer> elements = assignRandomElements(heldItem.getItem());
			
			for(ItemElement element : elements.keySet())
			{
				player.addChatMessage(new TextComponentString(element.getName() + " - " + elements.get(element)));
			}
		}
		return true;
	}
	
	private HashMap<ItemElement, Integer> assignRandomElements(Item item)
	{
		HashMap<ItemElement, Integer> elements = new HashMap<ItemElement, Integer>();
		
		if(item == Item.getItemFromBlock(Blocks.STONE))
		{
			elements.put(Element.ANTIMONY.getElement(), 45);
			elements.put(Element.CARBON.getElement(), 12);
			elements.put(Element.URANIUM.getElement(), 1);
		}
		
		return elements;
	}
}
