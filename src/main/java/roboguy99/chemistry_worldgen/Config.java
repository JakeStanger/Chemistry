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
	
	public Config()
	{	
		this.config = Chemistry.getConfig(ChemistryWorldGen.modID);
		
		this.config.load();
			for(Element element : Elements.getElements()) this.config.get("worldgen", element.getName(), true);
			this.config.setCategoryComment("worldgen", "Individually enable/disable the worldgen for every single ore");
		this.config.save();
	}
}
