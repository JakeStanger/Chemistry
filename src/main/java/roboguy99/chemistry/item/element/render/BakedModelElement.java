package roboguy99.chemistry.item.element.render;

import java.util.ArrayList;
import java.util.List;

import javax.vecmath.Matrix4f;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.block.model.ItemOverride;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.block.model.ModelManager;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.IPerspectiveAwareModel;
import net.minecraftforge.common.model.TRSRTransformation;

class BakedModelElement implements IBakedModel, IPerspectiveAwareModel
{
	private String elementName;
	
	public BakedModelElement(String elementName)
	{
		this.elementName = elementName;
	}
	
	@Override
	public Pair<? extends IBakedModel, Matrix4f> handlePerspective(TransformType cameraTransformType)
	{
		ModelManager manager = Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getModelManager();
		
		IBakedModel model;
		if(cameraTransformType != TransformType.GUI && cameraTransformType != TransformType.GROUND) 
			 model = manager.getModel(new ModelResourceLocation("chemistry:elementHeld", "inventory")); //Get held model
		else model = manager.getModel(new ModelResourceLocation("chemistry:element-" + this.elementName, "inventory")); //Get inventory model
		
		return Pair.of(model, TRSRTransformation.identity().getMatrix());
	}

	@Override
	public boolean isAmbientOcclusion()
	{
		return false;
	}

	@Override
	public boolean isGui3d()
	{
		return false;
	}

	@Override
	public boolean isBuiltInRenderer()
	{
		return false;
	}

	@Override
	public TextureAtlasSprite getParticleTexture()
	{
		return null;
	}

	@Override
	public ItemCameraTransforms getItemCameraTransforms()
	{
		return ItemCameraTransforms.DEFAULT; //The requirement for this is a bug
	}

	@Override
	public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) 
	{
		return new ArrayList<BakedQuad>();
	}

	@Override
	public ItemOverrideList getOverrides() 
	{
		return new ItemOverrideList(new ArrayList<ItemOverride>());
	}	
}