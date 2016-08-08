package roboguy99.chemistry;

import net.minecraftforge.common.config.Configuration;

public class Config
{
	public static Config INSTANCE;
	
	private final Configuration config;
	
	public Config()
	{
		this.INSTANCE = this;
		
		this.config = Chemistry.getConfig(Chemistry.modID);
		this.config.load();
			//Config
		this.config.save();
	}
}
