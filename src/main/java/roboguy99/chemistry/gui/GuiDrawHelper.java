package roboguy99.chemistry.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import org.lwjgl.opengl.GL11;
import roboguy99.chemistry.wrapper.FluidTooltipWrapper;

/**
 * @author Jake stanger
 * Helper methods for drawing GUI components
 */
public class GuiDrawHelper
{
	private static final ResourceLocation texture = new ResourceLocation("chemistry", "textures/gui/components.png");
	
	static final int ENERGY_BACK_START_X = 0, ENERGY_BACK_START_Y = 0;
	static final int ENERGY_FRONT_START_X = 0, ENERGY_FRONT_START_Y = 7;
	static final int ENERGY_WIDTH = 162, ENERGY_HEIGHT = 7;
	
	static final int ARROW_BACK_START_X = 0, ARROW_BACK_START_Y = 14;
	static final int ARROW_FRONT_START_X = 21, ARROW_FRONT_START_Y = 14;
	static final int ARROW_WIDTH = 21, ARROW_HEIGHT = 15;
	
	static final int FLUID_START_X = 0, FLUID_START_Y = 29;
	static final int FLUID_WIDTH = 21, FLUID_HEIGHT = 44;
	
	static final int FLUID_GAUGE_START_X = 21, FLUID_GAUGE_START_Y = 30;
	static final int FLUID_GAUGE_WIDTH = 3, FLUID_GAUGE_HEIGHT = 40;
	
	static GuiDrawHelper getInstance()
	{
		return instance;
	}
	
	private static GuiDrawHelper instance;
	
	public GuiDrawHelper()
	{
		GuiDrawHelper.instance = this;
	}
	
	void drawEnergyBar(int x, int y, int energyScaled, GuiContainer gui)
	{
		bindTexture();
		gui.drawTexturedModalRect(x, y, ENERGY_BACK_START_X, ENERGY_BACK_START_Y, ENERGY_WIDTH, ENERGY_HEIGHT);
		gui.drawTexturedModalRect(x, y, ENERGY_FRONT_START_X, ENERGY_FRONT_START_Y, energyScaled, ENERGY_HEIGHT);
	}
	
	void drawArrow(int x, int y, int progressScaled, GuiContainer gui)
	{
		bindTexture();
		gui.drawTexturedModalRect(x, y, ARROW_BACK_START_X, ARROW_BACK_START_Y, ARROW_WIDTH, ARROW_HEIGHT);
		gui.drawTexturedModalRect(x, y, ARROW_FRONT_START_X, ARROW_FRONT_START_Y, progressScaled, ARROW_HEIGHT+1);
	}
	
	void drawFluidTank(int x, int y, Fluid fluid, int fluidAmount, int fluidCapacity, GuiRefinery gui) //TODO make base fluid tile
	{
		float fluidAmountScaled = ((float) fluidAmount / fluidCapacity) * (FLUID_HEIGHT-2);
		
		//Draw tank
		bindTexture();
		gui.drawTexturedModalRect(x, y, FLUID_START_X, FLUID_START_Y, FLUID_WIDTH, FLUID_HEIGHT);
		
		drawRepeatedFluidSprite(fluid, x+1, y+1+(FLUID_HEIGHT-2-fluidAmountScaled), FLUID_WIDTH-2, FLUID_HEIGHT-2-(FLUID_HEIGHT-2-fluidAmountScaled)); //Draw fluid
		
		//Draw gauge
		bindTexture();
		gui.drawTexturedModalRect(x+1, y+2, FLUID_GAUGE_START_X, FLUID_GAUGE_START_Y, FLUID_GAUGE_WIDTH, FLUID_GAUGE_HEIGHT);
		
		//Tooltip
		gui.tooltips.put(fluid, new FluidTooltipWrapper(x, y, FLUID_WIDTH, FLUID_HEIGHT, fluidAmount, fluidCapacity));
	}
	
	boolean isPointInRegion(int rectX, int rectY, int rectWidth, int rectHeight, int pointX, int pointY) //TODO make base GUI
	{
		boolean isHorizontallyInLine = pointX > rectX && pointX < (rectX + rectWidth);
		boolean isVerticallyInLine = pointY > rectY && pointY < (rectY + rectHeight);
		return isHorizontallyInLine && isVerticallyInLine;
	}
	
	private static void bindTexture()
	{
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
	}
	
	/*------------------
	 * All the below code was taken from Immersive Engineering.
	 * @author BluSunrize
	 * https://github.com/BluSunrize/ImmersiveEngineering/blob/1.10/src/main/java/blusunrize/immersiveengineering/client/ClientUtils.java
	 ------------------*/
	
	private static void bindTexture(String path)
	{
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(path));
	}
	
	
	private static void drawRepeatedFluidSprite(Fluid fluid, float x, float y, float w, float h)
	{
		bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE.toString());
		TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(fluid.getStill().toString());
		if(sprite != null)
		{
			int iW = sprite.getIconWidth();
			int iH = sprite.getIconHeight();
			if(iW > 0 && iH > 0)
				drawRepeatedSprite(x, y, w, h, iW, iH, sprite.getMinU(), sprite.getMaxU(), sprite.getMinV(), sprite.getMaxV());
		}
	}
	
	private static void drawRepeatedSprite(float x, float y, float w, float h, int iconWidth, int iconHeight, float uMin, float uMax, float vMin, float vMax)
	{
		int iterMaxW = (int) (w / iconWidth);
		int iterMaxH = (int) (h / iconHeight);
		float leftoverW = w % iconWidth;
		float leftoverH = h % iconHeight;
		float leftoverWf = leftoverW / (float) iconWidth;
		float leftoverHf = leftoverH / (float) iconHeight;
		float iconUDif = uMax - uMin;
		float iconVDif = vMax - vMin;
		for(int ww = 0; ww < iterMaxW; ww++)
		{
			for(int hh = 0; hh < iterMaxH; hh++)
				drawTexturedRect(x + ww * iconWidth, y + hh * iconHeight, iconWidth, iconHeight, uMin, uMax, vMin, vMax);
			drawTexturedRect(x + ww * iconWidth, y + iterMaxH * iconHeight, iconWidth, leftoverH, uMin, uMax, vMin, (vMin + iconVDif * leftoverHf));
		}
		if(leftoverW > 0)
		{
			for(int hh = 0; hh < iterMaxH; hh++)
				drawTexturedRect(x + iterMaxW * iconWidth, y + hh * iconHeight, leftoverW, iconHeight, uMin, (uMin + iconUDif * leftoverWf), vMin, vMax);
			drawTexturedRect(x + iterMaxW * iconWidth, y + iterMaxH * iconHeight, leftoverW, leftoverH, uMin, (uMin + iconUDif * leftoverWf), vMin, (vMin + iconVDif * leftoverHf));
		}
	}
	
	private static void drawTexturedRect(float x, float y, float w, float h, double... uv)
	{
		Tessellator tessellator = Tessellator.getInstance();
		VertexBuffer worldrenderer = tessellator.getBuffer();
		worldrenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
		worldrenderer.pos(x, y + h, 0).tex(uv[0], uv[3]).endVertex();
		worldrenderer.pos(x + w, y + h, 0).tex(uv[1], uv[3]).endVertex();
		worldrenderer.pos(x + w, y, 0).tex(uv[1], uv[2]).endVertex();
		worldrenderer.pos(x, y, 0).tex(uv[0], uv[2]).endVertex();
		tessellator.draw();
	}
}
