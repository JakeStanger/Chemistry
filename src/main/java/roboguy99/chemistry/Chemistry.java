package roboguy99.chemistry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import roboguy99.chemistry.block.BlockCompoundAnalyser;
import roboguy99.chemistry.item.element.Elements;
import roboguy99.chemistry.network.CommonProxy;
import roboguy99.chemistry.tileentity.TileEntities;

/**
 * Main class. Handles mod initialisation.
 * 
 * @author Roboguy99
 * 
 */
@Mod(modid = Chemistry.modID, version = Chemistry.modVersion, name = Chemistry.name)
public class Chemistry {
	// Mod data. Fallback if mc-mod.info fails to load.
	public static final String modID = "chemistry";
	public static final String modVersion = "0.0.0";
	public static final String name = "Chemistry";

	public static final Logger logger = LogManager.getLogger("Chemistry");

	@SidedProxy(clientSide = "roboguy99.chemistry.network.ClientProxy", serverSide = "roboguy99.chemistry.network.CommonProxy")
	public static CommonProxy proxy;

	public static Chemistry instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) // Pre-initialisation loading
	{
		logger.info("Pre-initialising");
		this.instance = this;

		proxy.registerProxies();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) // Initialisation loading
	{
		logger.info("Initialising");
		new Elements();
	new BlockCompoundAnalyser();
		new TileEntities();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
	
	public static CreativeTabs tabElements = new CreativeTabs("tabElements") {
	    @Override
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() {
	        return Elements.hydrogen;
	    }
	};
}	