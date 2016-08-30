package roboguy99.chemistry.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.gui.container.ContainerBlockCompoundCreator;
import roboguy99.chemistry.network.packet.CompoundCreate;
import roboguy99.chemistry.tile.TileCompoundCreator;

public class GuiBlockCompoundCreator extends GuiContainer
{
	private GuiButton btnCreate;
	
	@Override
	public void initGui()
	{
		super.initGui();
		btnCreate = new GuiButton(0, this.guiLeft + 8 + 18 + 12, this.guiTop + 133, 100, 20, "Create Compound");
		this.buttonList.add(btnCreate);
	}
	
	private static final ResourceLocation texture = new ResourceLocation("chemistry", "textures/gui/compoundCreator.png");
	
	public GuiBlockCompoundCreator(Container container, TileCompoundCreator compoundCreator)
	{
		super(container);
		this.xSize = 176;
		this.ySize = 241;
		
		TileCompoundCreator compoundCreator1 = compoundCreator;
	}
	
	/**
	 * Draw screen and all components
	 */
	@Override
	public void drawScreen(int var1, int var2, float var3)
	{
		super.drawScreen(var1, var2, var3);
		float xSize_lo = var1;
		float ySize_lo = var2;
	}
	
	@Override
	protected void actionPerformed(GuiButton btn)
	{
		if(btn == this.btnCreate) Chemistry.INSTANCE.getNetworkWrapper().sendToServer(new CompoundCreate(((ContainerBlockCompoundCreator) Minecraft.getMinecraft().thePlayer.openContainer).getTilePos()));
	}
	
	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of the items)
	 */
	@Override
	protected void drawGuiContainerForegroundLayer(int var1, int var2)
	{}
	
	/**
	 * Draw the background layer for the GuiContainer (everything behind the items)
	 */
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
	{	
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}
}
