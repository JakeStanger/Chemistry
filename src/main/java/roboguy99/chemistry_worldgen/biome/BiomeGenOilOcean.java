/** Copyright (c) 2011-2015, SpaceToad and the BuildCraft Team http://www.mod-buildcraft.com
 * <p/>
 * BuildCraft is distributed under the terms of the Minecraft Mod Public License 1.0, or MMPL. Please check the contents
 * of the license located in http://www.mod-buildcraft.com/MMPL-1.0.txt */

package roboguy99.chemistry_worldgen.biome;

import net.minecraft.world.biome.BiomeGenOcean;
import net.minecraftforge.common.BiomeDictionary;

/**
 * @author SpaceToad and the BuildCraft Team
 */
public class BiomeGenOilOcean extends BiomeGenOcean
{
	public BiomeGenOilOcean(int id)
	{
		super(id);
		this.setBiomeName("oceanOil");
		this.setColor(112);
        this.setHeight(this.height_Oceans);
	}
	
	 public static BiomeGenOilOcean makeBiome(int id)
	 {
	        BiomeGenOilOcean biome = new BiomeGenOilOcean(id);
	        BiomeDictionary.registerBiomeType(biome, BiomeDictionary.Type.WATER);
	        //OilPopulate.INSTANCE.excessiveBiomes.add(biome.biomeID);
	        //OilPopulate.INSTANCE.surfaceDepositBiomes.add(biome.biomeID);
	        return biome;
	   }
}
