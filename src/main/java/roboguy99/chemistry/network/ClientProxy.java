package roboguy99.chemistry.network;

import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Elements;
import roboguy99.chemistry.item.element.render.ModelLoader;

public class ClientProxy extends CommonProxy
{	
	@Override
	public void registerProxies()
	{
		ModelLoaderRegistry.registerLoader(new ModelLoader());
		
		ModelResourceLocation heldModel = new ModelResourceLocation("chemistry:elementHeld", "inventory");
		for(Element element : Elements.getElements())
		{
			ModelResourceLocation baseModel = new ModelResourceLocation("chemistry:" + element.getName(), "inventory");
			ModelResourceLocation elementModel = new ModelResourceLocation(("chemistry:" + element.getName()).replaceAll("_", "-"), "inventory");
			
			net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(element, 0, baseModel);
			ModelBakery.registerItemVariants(element, elementModel, heldModel);
		}
	}
}
