package roboguy99.chemistry.item.element.render;

import java.io.IOException;

import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Elements;

public class ModelLoader implements ICustomModelLoader
{
	private Element element = Elements.getElement(1);
	
	@Override
	public void onResourceManagerReload(IResourceManager resourceManager)
	{}

	@Override
	public boolean accepts(ResourceLocation modelLocation)
	{
		//Well I don't think this works. Also creating a new instance for EVERY MODEL in the game seems like a really bad idea...
		if(modelLocation.equals(new ModelResourceLocation("chemistry:" + element.getName(), "inventory"))) return true;
		return false;
	}

	@Override
	public IModel loadModel(ResourceLocation modelLocation) throws IOException
	{
		return new ModelElement(this.element);
	}
}
