package roboguy99.chemistry.item.element.render;

import java.util.List;

import javax.vecmath.Matrix4f;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.IFlexibleBakedModel;
import net.minecraftforge.client.model.IPerspectiveAwareModel;
import net.minecraftforge.client.model.TRSRTransformation;
import roboguy99.chemistry.item.element.Element;

public class BakedModelElement implements IFlexibleBakedModel, IPerspectiveAwareModel
{
	private Element element;
	
	public BakedModelElement(Element element)
	{
		this.element = element;
	}
	
	@Override
	public Pair<? extends IFlexibleBakedModel, Matrix4f> handlePerspective(TransformType cameraTransformType)
	{
		IBakedModel model;
		if(cameraTransformType == TransformType.FIRST_PERSON || cameraTransformType == TransformType.THIRD_PERSON)
		{
			model = Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getModelManager().getModel(new ModelResourceLocation("chemistry:elementHeld", "inventory"));
		}
		else model = Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getModelManager().getModel(new ModelResourceLocation("chemistry:" + this.element.getName(), "inventory"));
		
		if(!(model instanceof IFlexibleBakedModel)) model = new IFlexibleBakedModel.Wrapper(model, DefaultVertexFormats.ITEM);
		
		return (Pair<? extends IFlexibleBakedModel, Matrix4f>) Pair.of(model, TRSRTransformation.identity().getMatrix());
	}
	
	@Override
	public List<BakedQuad> getFaceQuads(EnumFacing p_177551_1_)
	{
		return null;
	}

	@Override
	public List<BakedQuad> getGeneralQuads()
	{
		return null;
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
		return null;
	}

	@Override
	public VertexFormat getFormat()
	{
		return null;
	}	
}
