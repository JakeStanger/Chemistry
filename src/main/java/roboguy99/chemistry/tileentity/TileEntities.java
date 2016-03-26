package roboguy99.chemistry.tileentity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntities 
{
	public TileEntities()
	{
		GameRegistry.registerTileEntity(TileCompoundMaker.class, "tileCompoundMaker");
	}
}
