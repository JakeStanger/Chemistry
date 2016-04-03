package roboguy99.chemistry.tile;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntities 
{
	public TileEntities()
	{
		GameRegistry.registerTileEntity(TileCompoundCreator.class, "tileCompoundCreator");
	}
}
