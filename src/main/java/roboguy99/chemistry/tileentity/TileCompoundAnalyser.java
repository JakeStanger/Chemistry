package roboguy99.chemistry.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import roboguy99.chemistry.Chemistry;
import roboguy99.chemistry.item.element.Elements;

public class TileCompoundAnalyser extends TileEntity implements ITickable
{
    @Override
    public void update()
    {
    	if (!this.worldObj.isRemote)
    	{
    		System.out.println(Elements.ethanol.getStructure());
    	}
    }
}