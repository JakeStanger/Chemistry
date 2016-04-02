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
		/*ModelLoaderRegistry.registerLoader(new ModelLoader());
		
		ModelResourceLocation heldModel = new ModelResourceLocation("chemistry:elementHeld", "inventory");
		ModelResourceLocation baseModel = new ModelResourceLocation(new ResourceLocation("chemistry", "element_base_carbon"), "inventory");
		for(Element element : Elements.getElements())
		{
			ModelResourceLocation elementModel = new ModelResourceLocation("chemistry:" +  element.getName(), "inventory");
			
			net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(element, 0, elementModel);
			ModelBakery.registerItemVariants(element, baseModel, heldModel);
		}*/
		
		//Element carbon = Elements.getElement(6);
		
		/*ModelResourceLocation elementModel = new ModelResourceLocation("chemistry:element_" +  carbon.getName(), "inventory");
		for(int i = 0; i < 10; i++) Chemistry.logger.info(baseModel);
		ModelBakery.registerItemVariants(carbon, baseModel, heldModel);
		net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(carbon, 0, elementModel);*/
	}
}
