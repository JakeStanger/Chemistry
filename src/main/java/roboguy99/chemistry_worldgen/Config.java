package roboguy99.chemistry_worldgen;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Elements;

public class Config
{
	private Configuration config;
	
	public Config(FMLPreInitializationEvent event)
	{	
		this.config = new Configuration(new File(Chemistry.CONFIG_DIR, ChemistryWorldGen.modID +".cfg"));
		
		this.config.load();
			this.config.get("general", "ReplaceVanillaOres", true);
			for(Element element : Elements.getElements()) this.config.get("worldgen", element.getName(), true);
		this.config.save();
	}
}
