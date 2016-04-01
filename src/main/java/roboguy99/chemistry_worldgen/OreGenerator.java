package roboguy99.chemistry_worldgen;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import roboguy99.chemistry_worldgen.block.OreElement;

public class OreGenerator implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		if(world.provider.getDimensionId() == 0)
		{
			for(OreElement ore : ChemistryWorldGen.instance.getOres())
			{
				for(int k = 0; k < 10; k++)
				{
		        	int x = (chunkX*16) + random.nextInt(16);
		        	int y = random.nextInt(64);
		        	int z = (chunkZ*16) + random.nextInt(16);
		        	
		        	(new WorldGenMinable(ore.getDefaultState(), 10)).generate(world, random, new BlockPos(x, y, z));
		        }
			}
		}
	}
}
