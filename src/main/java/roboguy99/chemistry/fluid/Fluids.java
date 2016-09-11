package roboguy99.chemistry.fluid;

import com.google.common.collect.HashBiMap;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import roboguy99.chemistry.block.BlockFluid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jake stanger
 *         TODO Write JavaDoc
 */
public class Fluids
{
	private static HashBiMap<FluidBasic, BlockFluid> map = HashBiMap.create();
	private static List<FluidBasic> fluidList = new ArrayList<>();
	
	public Fluids(FMLPreInitializationEvent event)
	{
		FluidBasic fluidOil = new FluidBasic("oil", 1200, 2000);
		FluidBasic fluidFuel = new FluidBasic("fuel");
		
		map.put(fluidOil, new BlockFluid("blockOil", fluidOil));
		map.put(fluidFuel, new BlockFluid("blockFuel", fluidFuel));
		
		for(FluidBasic fluid : map.keySet())
		{
			fluidList.add(fluid);
			
			if(event.getSide() == Side.CLIENT)
			{
				BlockFluid blockFluid = map.get(fluid);
				
				ModelResourceLocation model = new ModelResourceLocation("chemistry:fluid_" + fluid.getSimpleName(), "fluid");
				
				Item itemFluid = Item.getItemFromBlock(blockFluid);
				
				ModelBakery.registerItemVariants(itemFluid);
				
				ModelLoader.setCustomMeshDefinition(itemFluid, stack -> model);
				ModelLoader.setCustomStateMapper(blockFluid, new StateMapperBase()
				{
					@SuppressWarnings("NullableProblems")
					@Override
					protected ModelResourceLocation getModelResourceLocation(IBlockState state)
					{
						return model;
					}
				});
			}
		}
	}
	
	public static FluidBasic getFluidFromName(String name)
	{
		for(FluidBasic fluid : Fluids.fluidList)
		{
			if(fluid.getSimpleName().equals(name)) return fluid;
		}
		
		return null;
	}
}
