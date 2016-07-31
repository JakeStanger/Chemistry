package roboguy99.chemistry_worldgen;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.api.Elements;
import roboguy99.chemistry.api.Elements.EnumElement;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry_worldgen.block.OreElement;

@Mod(modid = ChemistryWorldGen.modID, version = ChemistryWorldGen.modVersion, name = ChemistryWorldGen.name)
public class ChemistryWorldGen
{
	// Mod data. Fallback if mc-mod.info fails to load.
	public static final String modID = "chemistry_worldgen";
	public static final String modVersion = "0.0.0";
	public static final String name = "Chemistry World Generation";
	
	private List<OreElement> ores = new ArrayList<OreElement>();
	
	public static ChemistryWorldGen instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		this.instance = this;
		
		new Config();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{	
		for(Element element : Elements.getElements()) this.ores.add(new OreElement(element));
		GameRegistry.registerWorldGenerator(new OreGenerator(), 100);
		
		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		
		for(OreElement ore : this.ores)
		{
			mesher.register(Item.getItemFromBlock(ore), 0, new ModelResourceLocation("chemistry_worldgen:ore_" + ore.getName(), "inventory"));
			Chemistry.logger.info(ore.getName());
		}
	}
	
	public static CreativeTabs tabOre = new CreativeTabs("tabOre") 
	{
	    @Override
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() 
	    {
	        return Item.getItemFromBlock(ChemistryWorldGen.instance.ores.get(EnumElement.COPPER.getElement().getAtomicNumber()));
	    }
	};
	
	public List<OreElement> getOres()
	{
		return this.ores;
	}
}
