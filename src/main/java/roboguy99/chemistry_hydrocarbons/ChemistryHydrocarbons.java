/*package roboguy99.chemistry_hydrocarbons;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.api.Elements;
import roboguy99.chemistry.api.Elements.EnumElement;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry_worldgen.ChemistryWorldGen;
import roboguy99.chemistry_worldgen.OreGenerator;
import roboguy99.chemistry_worldgen.block.OreElement;

@Mod(modid = ChemistryHydrocarbons.modID, version = ChemistryHydrocarbons.modVersion, name = ChemistryHydrocarbons.name)
public class ChemistryHydrocarbons
{
	// Mod data. Fallback if mc-mod.info fails to load.
	public static final String modID = "chemistry-hydrocarbons";
	public static final String modVersion = "0.0.0";
	public static final String name = "Chemistry Hydrocarbons";
	
	public static ChemistryHydrocarbons instance;
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		
	}
	
	public static CreativeTabs tabHydrocarbons = new CreativeTabs("tabHydrocarbons") 
	{
	    @Override
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() 
	    {
	        return EnumElement.COPPER.getElement(); //TODO Change to oil or something
	    }
	};
}
*/