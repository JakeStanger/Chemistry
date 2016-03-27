package roboguy99.chemistry.item.element;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import roboguy99.chemistry.api.EnumElement;
import roboguy99.chemistry.item.compound.Compound;
import roboguy99.chemistry.item.element.elements.Berylium;
import roboguy99.chemistry.item.element.elements.Boron;
import roboguy99.chemistry.item.element.elements.Carbon;
import roboguy99.chemistry.item.element.elements.Helium;
import roboguy99.chemistry.item.element.elements.Hydrogen;
import roboguy99.chemistry.item.element.elements.Lithium;
import roboguy99.chemistry.item.element.elements.Nitrogen;
import roboguy99.chemistry.item.element.elements.Oxygen;
import roboguy99.chemistry.item.element.elements.Uranium;

public class Elements 
{
	public static Element[] elements = new Element[118];
	
	public static Compound ethanol;
	
	public Elements()
	{
		elements[0] = new Hydrogen();
		elements[1] = new Helium();
		elements[2] = new Lithium();
		elements[3] = new Berylium();
		elements[4] = new Boron();
		elements[5] = new Carbon();
		elements[6] = new Nitrogen();
		elements[7] = new Oxygen();
		elements[91] = new Uranium();
		
		this.generateTexturesForElements();
    }
	
	/**
	 * Get the element instance linking to the specified atomic number
	 * @param atomicNumber
	 * @return The element with the specified atomic number
	 */
	public static Element getElement(int atomicNumber)
	{
		return elements[atomicNumber-1];
	}
	
	/**
	 * Get the element instance linking to the specified enum value
	 * @param enumElement
	 * @return The element for the given enum
	 */
	public static Element getElement(EnumElement enumElement)
	{
		return getElement(enumElement.atomicNumber);
	}
	
	private void generateTexturesForElements() //TODO Remove this once all elements are created
	{
		for(Element element : this.elements)
		{
			if(element != null && !new File("generatedtextures" + element.getName() + "png").isFile()) 
			{
				String text = element.getSymbol();
			
		        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		        Graphics2D g2d = img.createGraphics();
		        Font font = new Font("Arial", Font.PLAIN, 48);
		        g2d.setFont(font);
		        FontMetrics fm = g2d.getFontMetrics();
		        //int width = fm.stringWidth(text);
		        //int height = fm.getHeight();
		        g2d.dispose();
		
		        img = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);
		        g2d = img.createGraphics();
		        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
		        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
		        g2d.setFont(font);
		        fm = g2d.getFontMetrics();
		        g2d.setColor(Color.BLACK);
		        g2d.drawString(text, 0, fm.getAscent());
		        g2d.dispose();
		        try 
		        {
		            ImageIO.write(img, "png", new File("generatedtextures/" + element.getName() + ".png"));
		        } 
		        catch (IOException ex) 
		        {
		            ex.printStackTrace();
		        }
			}
		}
	}
}
