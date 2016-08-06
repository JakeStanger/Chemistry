package roboguy99.chemistry_worldgen;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import roboguy99.chemistry_worldgen.block.OreElement;
import roboguy99.chemistry_worldgen.ChemistryWorldGen;

public class OreGenerator implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		if(world.provider.getDimension() == 0)
		{
			for(OreElement ore : ChemistryWorldGen.instance.getOres())
			{
				for(int k = 0; k < 5; k++)
				{
		        	int x = (chunkX*16) + random.nextInt(16);
		        	int y = random.nextInt(64);
		        	int z = (chunkZ*16) + random.nextInt(16);
		        	
		        	(new WorldGenMinable(ore.getDefaultState(), 5)).generate(world, random, new BlockPos(x, y, z)); //TODO Make dependent on element
		        }
			}
		}
	}
}
