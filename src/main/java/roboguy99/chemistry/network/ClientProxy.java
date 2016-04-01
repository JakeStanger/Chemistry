package roboguy99.chemistry.network;

import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Elements;
import roboguy99.chemistry.item.element.render.ModelLoader;

public class ClientProxy extends CommonProxy
{	
	@Override
	public void registerProxies()
	{
		ModelLoaderRegistry.registerLoader(new ModelLoader());
		
		//ModelResourceLocation heldModel = new ModelResourceLocation("chemistry:elementHeld", "inventory");
		for(Element element : Elements.getElements())
		{
			ModelResourceLocation elementModel = new ModelResourceLocation("chemistry:" +  element.getName(), "inventory");
			
			//ModelBakery.registerItemVariants(element, elementModel, heldModel);
			
			net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(element, 0, elementModel);
		}
	}
}
