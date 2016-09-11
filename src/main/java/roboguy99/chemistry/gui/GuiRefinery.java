package roboguy99.chemistry.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import roboguy99.chemistry.tile.TileRefinery;

/**
 * @author Jake stanger
 *         TODO Write JavaDoc
 */
public class GuiRefinery extends GuiContainer
{
	private TileRefinery refinery;
	
	private static final ResourceLocation texture = new ResourceLocation("chemistry", "textures/gui/blank.png");
	
	public GuiRefinery(Container inventorySlotsIn, TileRefinery refinery)
	{
		super(inventorySlotsIn);
		this.refinery = refinery;
		this.xSize = 176;
		this.ySize = 156;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		
		GuiDrawHelper guiDrawHelper = GuiDrawHelper.getInstance();
		
		int inputAmount = this.refinery.getInputTankScaled(GuiDrawHelper.FLUID_HEIGHT-2);
		guiDrawHelper.drawFluidTank(k + 7, l + 7, refinery.getInputTank().getFilter(), inputAmount, this);
		
		int outputAmount = this.refinery.getOutputTankScaled(GuiDrawHelper.FLUID_HEIGHT-2);
		guiDrawHelper.drawFluidTank(k + 50, l + 7, refinery.getOutputTank().getFilter(), outputAmount, this);
		
		int energy = this.refinery.getEnergyScaled(162);
		guiDrawHelper.drawEnergyBar(k + 7, l + 64, energy, this);
	}
}
