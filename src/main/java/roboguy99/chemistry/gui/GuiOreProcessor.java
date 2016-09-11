package roboguy99.chemistry.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import roboguy99.chemistry.gui.container.ContainerOreProcessor;
import roboguy99.chemistry.tile.TileOreProcessor;

/**
 * Created by jake on 30/08/16.
 */
public class GuiOreProcessor extends GuiContainer
{
	private static final ResourceLocation texture = new ResourceLocation("chemistry", "textures/gui/oreProcessor.png");
	
	private TileOreProcessor oreProcessor;
	
	public GuiOreProcessor(ContainerOreProcessor container, TileOreProcessor oreProcessor)
	{
		super(container);
		this.oreProcessor = oreProcessor;
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
		
		int progress = this.oreProcessor.getProgressScaled(GuiDrawHelper.ARROW_WIDTH+4);
		guiDrawHelper.drawArrow(k + 29, l + 28, progress, this);
		
		int energy = this.oreProcessor.getEnergyScaled(GuiDrawHelper.ENERGY_WIDTH);
		guiDrawHelper.drawEnergyBar(k + 7, l + 64, energy, this);
	}
}
