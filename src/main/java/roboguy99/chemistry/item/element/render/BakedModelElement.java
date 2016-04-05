package roboguy99.chemistry.item.element.render;

import java.util.List;

import javax.vecmath.Matrix3f;
import javax.vecmath.Matrix4f;
import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.IFlexibleBakedModel;
import net.minecraftforge.client.model.IPerspectiveAwareModel;
import net.minecraftforge.client.model.TRSRTransformation;
import net.minecraftforge.client.model.pipeline.IVertexConsumer;
import net.minecraftforge.client.model.pipeline.UnpackedBakedQuad;
import net.minecraftforge.client.model.pipeline.VertexTransformer;

public class BakedModelElement implements IFlexibleBakedModel, IPerspectiveAwareModel
{
	private String elementName;
	
	public BakedModelElement(String elementName)
	{
		this.elementName = elementName;
	}
	
	@Override
	public Pair<? extends IFlexibleBakedModel, Matrix4f> handlePerspective(TransformType cameraTransformType)
	{
		IBakedModel model;
		if(cameraTransformType != TransformType.GUI && cameraTransformType != TransformType.GROUND)
		{
			model = Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getModelManager().getModel(new ModelResourceLocation("chemistry:elementHeld", "inventory"));
		}
		else
		{
			model = Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getModelManager().getModel(new ModelResourceLocation("chemistry:element-" + this.elementName, "inventory"));
			
			if(cameraTransformType == TransformType.GROUND)
			{
				Builder generalQuads = new ImmutableList.Builder();
				Builder faceQuads = new ImmutableList.Builder();
				
				generalQuads.add(model.getGeneralQuads());
				faceQuads.add(model.getFaceQuads(EnumFacing.EAST));
				faceQuads.add(model.getFaceQuads(EnumFacing.NORTH));
				faceQuads.add(model.getFaceQuads(EnumFacing.SOUTH));
				faceQuads.add(model.getFaceQuads(EnumFacing.UP));
				faceQuads.add(model.getFaceQuads(EnumFacing.WEST));
				
				model = this.rotate(transform, invtranspose, model); //Now what?
			}
		}
		
		if(!(model instanceof IFlexibleBakedModel)) model = new IFlexibleBakedModel.Wrapper(model, DefaultVertexFormats.ITEM);
		
		return (Pair<? extends IFlexibleBakedModel, Matrix4f>) Pair.of(model, TRSRTransformation.identity().getMatrix());
	}
	
	private BakedQuad rotate(final Matrix4f transform, final Matrix3f invtranspose, BakedQuad quad)
    {
        UnpackedBakedQuad.Builder builder = new UnpackedBakedQuad.Builder(DefaultVertexFormats.ITEM);
        IVertexConsumer cons = new VertexTransformer(builder)
        {
            @Override public void put(int element, float... data)
            {
                VertexFormatElement el = DefaultVertexFormats.ITEM.getElement(element);
                switch(el.getUsage())
                {
                case POSITION:
                    float[] newData = new float[4];
                    Vector4f vec = new Vector4f(data);
                    transform.transform(vec);
                    vec.get(newData);
                    parent.put(element, newData);
                    break;
                case NORMAL:
                    float[] newData2 = new float[4];
                    Vector3f vec2 = new Vector3f(data);
                    invtranspose.transform(vec2);
                    vec2.get(newData2);
                    newData2[3] = 0;
                    parent.put(element, newData2);
                    break;
                default:
                    parent.put(element, data);
                    break;
                }
            }
        };
        quad.pipe(cons);
        return builder.build();
    }
	
	@Override
	public List<BakedQuad> getFaceQuads(EnumFacing face)
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
