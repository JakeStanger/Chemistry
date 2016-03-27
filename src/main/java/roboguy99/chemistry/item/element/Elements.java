package roboguy99.chemistry.item.element;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

import javax.imageio.ImageIO;

import roboguy99.chemistry.item.compound.Compound;
import roboguy99.chemistry.item.element.elements.Carbon;
import roboguy99.chemistry.item.element.elements.Helium;
import roboguy99.chemistry.item.element.elements.Hydrogen;
import roboguy99.chemistry.item.element.elements.Oxygen;
import roboguy99.chemistry.item.element.elements.Uranium;

public class Elements 
{	
	public static Hydrogen hydrogen;
	public static Helium helium;
	public static Oxygen oxygen;
	public static Carbon carbon;
	public static Uranium uranium;
	
	public static Compound ethanol;
	
	public Elements()
	{
		hydrogen = new Hydrogen();
		helium = new Helium();
		oxygen = new Oxygen();
		carbon = new Carbon();
		uranium = new Uranium();
		
		LinkedHashMap waterCompound = new LinkedHashMap(); //TODO Move all of these to their own class
		waterCompound.put(Elements.hydrogen, 2);
		waterCompound.put(Elements.oxygen, 1);
		Compound water = new Compound(waterCompound);
		
		LinkedHashMap glucoseCompound = new LinkedHashMap();
		glucoseCompound.put(Elements.carbon, 6);
		glucoseCompound.put(Elements.hydrogen, 12);
		glucoseCompound.put(Elements.oxygen, 6);
		Compound glucose = new Compound(glucoseCompound);
		
		LinkedHashMap ethanolCompoundMain = new LinkedHashMap();
		ethanolCompoundMain.put(Elements.carbon, 2);
		ethanolCompoundMain.put(Elements.hydrogen, 5);
		Compound ethanolMain = new Compound(ethanolCompoundMain);
		
		LinkedHashMap ethanolCompoundFunctional = new LinkedHashMap();
		ethanolCompoundFunctional.put(Elements.oxygen, 1);
		ethanolCompoundFunctional.put(Elements.hydrogen, 1);
		Compound ethanolFunctional = new Compound(ethanolCompoundFunctional);
		
		Compound[] compoundArray = {ethanolMain, ethanolFunctional};
		ethanol = new Compound(compoundArray);
		
		/*String text = "H"; TODO Automate this for every element

        /*
           Because font metrics is based on a graphics context, we need to create
           a small, temporary image so we can ascertain the width and height
           of the final image
         
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
        try {
            ImageIO.write(img, "png", new File("H.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
    }
}
