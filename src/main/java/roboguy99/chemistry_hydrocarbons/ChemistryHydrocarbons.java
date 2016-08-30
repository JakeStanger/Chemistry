package roboguy99.chemistry_hydrocarbons;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import roboguy99.chemistry.api.Elements.Element;

@Mod(modid = ChemistryHydrocarbons.modID, version = ChemistryHydrocarbons.modVersion, name = ChemistryHydrocarbons.name)
public class ChemistryHydrocarbons
{
	// Mod data. Fallback if mc-mod.info fails to load.
	static final String modID = "chemistry-hydrocarbons";
	static final String modVersion = "0.0.0";
	static final String name = "Chemistry Hydrocarbons";
	
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
	        return Element.COPPER.getElement(); //TODO Change to oil or something
	    }
	};
}