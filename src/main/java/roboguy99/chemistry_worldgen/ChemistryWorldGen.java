package roboguy99.chemistry_worldgen;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Elements;
import roboguy99.chemistry_worldgen.block.OreElement;

@Mod(modid = ChemistryWorldGen.modID, version = ChemistryWorldGen.modVersion, name = ChemistryWorldGen.name)
public class ChemistryWorldGen
{
	// Mod data. Fallback if mc-mod.info fails to load.
	public static final String modID = "chemistry-worldgen";
	public static final String modVersion = "0.0.0";
	public static final String name = "Chemistry World Generation";
	
	private List<OreElement> ores = new ArrayList<OreElement>();
	
	public static ChemistryWorldGen instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		this.instance = this;
		
		//new Config(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//for(Element element : Elements.getElements()) this.ores.add(new OreElement(element)); //TODO add these to list
		//GameRegistry.registerWorldGenerator(new OreGenerator(), 100);
	}
	
	/*public static CreativeTabs tabOre = new CreativeTabs("tabOre") 
	{
	    @Override
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() 
	    {
	        return Item.getItemFromBlock(ChemistryWorldGen.instance.ores.get(29)); //TODO Change to ore
	    }
	};*/
	
	public List<OreElement> getOres()
	{
		return this.ores;
	}
}
