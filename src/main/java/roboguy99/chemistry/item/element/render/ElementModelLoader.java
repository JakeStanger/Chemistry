package roboguy99.chemistry.item.element.render;

import java.io.IOException;

import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;

public class ElementModelLoader implements ICustomModelLoader
{		
	@Override
	public void onResourceManagerReload(IResourceManager resourceManager)
	{}

	@Override
	public boolean accepts(ResourceLocation modelLocation)
	{
		return modelLocation.getResourceDomain().equals("chemistry") && modelLocation.getResourcePath().startsWith("models/item/element_");
	}

	@Override
	public IModel loadModel(ResourceLocation modelLocation) throws IOException
	{
		return new ModelElement(modelLocation.getResourcePath().substring("models/item/element_".length()));
	}
}
