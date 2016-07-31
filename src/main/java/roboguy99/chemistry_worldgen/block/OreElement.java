package roboguy99.chemistry_worldgen.block;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry_worldgen.ChemistryWorldGen;

public class OreElement extends Block
{
	private String name;
	
	public OreElement(Element element)
	{	
		super(Blocks.STONE.getMaterial(Blocks.STONE.getDefaultState())); //TODO Find replacement for this
		this.name = element.getName().replaceAll("element_", "").toLowerCase();
		
		this.setCreativeTab(ChemistryWorldGen.tabOre);
		this.setUnlocalizedName("ore_" + name);
		GameRegistry.register(this);
	}
	
	public String getName()
	{
		return this.name;
	}
}
