package roboguy99.chemistry.item.element.render;

import java.io.IOException;

import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import roboguy99.chemistry.item.element.Element;

public class ModelLoader implements ICustomModelLoader
{
	private Element element;
	
	public ModelLoader(Element element)
	{
		this.element = element;
	}
	
	@Override
	public void onResourceManagerReload(IResourceManager resourceManager)
	{}

	@Override
	public boolean accepts(ResourceLocation modelLocation)
	{
		if(modelLocation == new ModelResourceLocation("chemistry:" + element.getName(), "inventory")) return true;
		return false;
	}

	@Override
	public IModel loadModel(ResourceLocation modelLocation) throws IOException
	{
		return new ModelElement(this.element);
	}
}
