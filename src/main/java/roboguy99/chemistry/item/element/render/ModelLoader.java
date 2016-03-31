package roboguy99.chemistry.item.element.render;

import java.io.IOException;

import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.api.EnumElement;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Elements;

public class ModelLoader implements ICustomModelLoader
{	
	private String elementName;
	
	@Override
	public void onResourceManagerReload(IResourceManager resourceManager)
	{}

	@Override
	public boolean accepts(ResourceLocation modelLocation)
	{
		if(modelLocation.getResourceDomain().equals("chemistry"))
		{
			String resourcePath = modelLocation.getResourcePath();
			resourcePath = resourcePath.substring(12, resourcePath.length());
			this.elementName = resourcePath;
			return true;
		}
		return false;
	}

	@Override
	public IModel loadModel(ResourceLocation modelLocation) throws IOException
	{
		return new ModelElement(this.elementName);
	}
}
