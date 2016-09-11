package roboguy99.chemistry.fluid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * @author Jake stanger
 *         TODO Write JavaDoc
 */
public class FluidBasic extends Fluid
{
	private static final int DEFAULT_DENSITY = 1000;
	private static final int DEFAULT_VISCOSITY = 1000;
	
	private String name;
	
	public FluidBasic(String name)
	{
		this(name, DEFAULT_DENSITY, DEFAULT_VISCOSITY);
	}
	
	public FluidBasic(String name, int density, int viscosity)
	{
		super(name, new ResourceLocation("chemistry:blocks/fluid_" + name + "_still"), new ResourceLocation("chemistry:blocks/fluid_" + name + "_flow"));
		
		this.name = name;
		
		this.setDensity(density);
		this.setViscosity(viscosity);
		this.setUnlocalizedName(name);
		FluidRegistry.registerFluid(this);
		FluidRegistry.addBucketForFluid(this);
	}
	
	public String getSimpleName()
	{
		return this.name;
	}
}
