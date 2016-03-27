package roboguy99.chemistry.tileentity;

import java.util.LinkedHashMap;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.api.EnumElement;
import roboguy99.chemistry.item.compound.CompoundHandler;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.Elements;

public class TileCompoundAnalyser extends TileEntity implements ITickable
{
    @Override
    public void update()
    {
    	if (!this.worldObj.isRemote)
    	{
    		CompoundHandler compoundHandler = new CompoundHandler();
    		
    		LinkedHashMap<Element, Integer> glucose = new LinkedHashMap<Element, Integer>();
    		glucose.put(Elements.getElement(EnumElement.CARBON), 6);
    		glucose.put(Elements.getElement(EnumElement.HYDROGEN), 12);
    		glucose.put(Elements.getElement(EnumElement.OXYGEN), 6);
    			
    		compoundHandler.createCompound(glucose);
    	}
    }
}