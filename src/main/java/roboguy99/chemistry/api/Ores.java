package roboguy99.chemistry.api;

import java.util.ArrayList;
import java.util.List;

import roboguy99.chemistry.block.ore.BlockOre;
import roboguy99.chemistry.block.ore.OreAluminium;
import roboguy99.chemistry.block.ore.OreCopper;
import roboguy99.chemistry.block.ore.OreLead;
import roboguy99.chemistry.block.ore.OrePlatinum;
import roboguy99.chemistry.block.ore.OreSilver;
import roboguy99.chemistry.block.ore.OreSulphur;
import roboguy99.chemistry.block.ore.OreTin;
import roboguy99.chemistry.block.ore.OreTitanium;
import roboguy99.chemistry.block.ore.OreTungsten;
import roboguy99.chemistry.block.ore.OreUranium;
import roboguy99.chemistry.item.element.ItemElement;

/**
 * TODO Probably re-write this
 * @author Roboguy99
 *
 */
public class Ores 
{
	private static List<BlockOre> ores = new ArrayList<BlockOre>();
	
	public Ores()
	{
		ores.add(new OreAluminium());
		ores.add(new OreCopper());
		ores.add(new OreLead());
		ores.add(new OrePlatinum());
		ores.add(new OreSilver());
		ores.add(new OreSulphur());
		ores.add(new OreTin());
		ores.add(new OreTitanium());
		ores.add(new OreTungsten());
		ores.add(new OreUranium());
	}
	
	private static BlockOre getOre(int index)
	{
		return ores.get(index);
	}
	
	public static void addOre(BlockOre ore)
	{
		ores.add(ore);
	}
	
	/**
	 * Gets the array of elements
	 * @return The array of elements
	 */
	public static List<BlockOre> getOres()
	{
		return Ores.ores;
	}
	
	public enum Ore
	{
		ALUMINIUM(Ores.getOre(0)),
		COPPER(Ores.getOre(1)),
		LEAD(Ores.getOre(2)),
		PLATINUM(Ores.getOre(3)),
		SILVER(Ores.getOre(4)),
		SULPHUR(Ores.getOre(5)),
		TIN(Ores.getOre(6)),
		TITANIUM(Ores.getOre(7)),
		TUNGSTEN(Ores.getOre(8)),
		URANIUM(Ores.getOre(9));
		
		private final BlockOre ore;
		
		private Ore(BlockOre ore)
		{
			this.ore = ore;
		}
		
		public BlockOre getOre()
		{
			return ore;
		}
	}
}
