package roboguy99.chemistry_worldgen.block;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry_worldgen.ChemistryWorldGen;

public class OreElement extends Block
{
	public OreElement(Element element)
	{
		super(Blocks.stone.getMaterial());
		this.setCreativeTab(ChemistryWorldGen.tabOre);
		this.setUnlocalizedName("ore_" + element.getName());
		GameRegistry.registerBlock(this, "ore" + element.getName());
	}
}
