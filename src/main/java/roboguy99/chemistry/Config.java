package roboguy99.chemistry;

import net.minecraftforge.common.config.Configuration;

class Config
{
	private static Config INSTANCE;
	
	public Config()
	{
		Config.INSTANCE = this;
		
		Configuration config = config = Chemistry.getConfig(Chemistry.modID);
		config.load();
			//Config
		config.save();
	}
}
