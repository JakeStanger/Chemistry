package roboguy99.chemistry.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import org.lwjgl.opengl.GL11;
import roboguy99.chemistry.api.Colour;
import roboguy99.chemistry.fluid.FilteredFluidTank;
import roboguy99.chemistry.tile.TileRefinery;
import roboguy99.chemistry.wrapper.FluidTooltipWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Jake stanger
 * GUI for the refinery TileEntity
 */
public class GuiRefinery extends GuiContainer
{
	private TileRefinery refinery;
	
	private static final ResourceLocation texture = new ResourceLocation("chemistry", "textures/gui/refinery.png");
	
	HashMap<Fluid, FluidTooltipWrapper> tooltips = new HashMap<>();
	
	public int getGuiLeft()
	{
		return this.guiLeft;
	}
	
	public int getGuiTop()
	{
		return this.guiTop;
	}
	
	public GuiRefinery(Container inventorySlotsIn, TileRefinery refinery)
	{
		super(inventorySlotsIn);
		this.refinery = refinery.getHost();
		this.xSize = 212;
		this.ySize = 188;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		//Draw base gui
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		
		GuiDrawHelper guiDrawHelper = GuiDrawHelper.getInstance();
		
		//Draw energy bar
		int energy = this.refinery.getEnergyScaled(GuiDrawHelper.ENERGY_WIDTH);
		guiDrawHelper.drawEnergyBar(k + 24, l + 95, energy, this);
		
		//Draw tanks
		int spacing = GuiDrawHelper.FLUID_WIDTH + 6;
		int heightDiff = 7;
		
		//int inputAmount = this.refinery.getInputTankScaled(GuiDrawHelper.FLUID_HEIGHT-2);
		int inputAmount = this.refinery.getOilTank().getFluidAmount();
		guiDrawHelper.drawFluidTank(k + 11, l + 47, refinery.getOilTank().getFilter(), refinery.getOilTank().getFluidAmount(), refinery.getOilTank().getCapacity(), this);
		
		
		for(int i = 0; i < this.refinery.getOutputTanks().length; i++)
		{
			FilteredFluidTank tank = this.refinery.getOutputTanks()[i];
			int fuelAmount = tank.getFluidAmount();
			int fuelCapacity = tank.getCapacity();
			Fluid fluid = tank.getFilter();
			
			guiDrawHelper.drawFluidTank(k + 12 + spacing*(i+1), l + 47 - heightDiff*(i+1), fluid, fuelAmount, fuelCapacity, this);
		}
		
		//Draw tooltips
		for(Fluid fluid : this.tooltips.keySet())
		{
			FluidTooltipWrapper wrapper = this.tooltips.get(fluid);
			if (guiDrawHelper.isPointInRegion(wrapper.getX(), wrapper.getY(), wrapper.getWidth(), wrapper.getHeight(), mouseX, mouseY))
			{
				List<String> text = new ArrayList<>();
				text.add(I18n.format("fluid." + fluid.getName()));
				text.add(Colour.BRIGHT_GREEN + (wrapper.getFluidAmount() + "/" + wrapper.getFluidCapacity()));
				this.drawHoveringText(text, mouseX, mouseY);
			}
		}
	}
	
	/**
	 * Draws a List of strings as a tooltip. Every entry is drawn on a separate line.
	 */
	@SuppressWarnings("NullableProblems")
	public void drawHoveringText(List<String> textLines, int x, int y)
	{
		drawHoveringText(textLines, x, y, fontRendererObj);
	}
}
