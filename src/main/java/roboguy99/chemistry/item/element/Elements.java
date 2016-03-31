package roboguy99.chemistry.item.element;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import roboguy99.chemistry.api.EnumElement;
import roboguy99.chemistry.item.compound.Compound;
import roboguy99.chemistry.item.element.elements.*;
import roboguy99.chemistry.item.element.elements.special.MoleculeMarker;

public class Elements 
{
	public static Element[] elements = new Element[119];
	
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
		elements[8] = new Flourine();
		elements[9] = new Neon();
		elements[10] = new Sodium();
		elements[11] = new Magnesium();
		elements[12] = new Aluminium();
		elements[13] = new Silicon();
		elements[14] = new Phosphorus();
		elements[15] = new Sulphur();
		elements[16] = new Chlorine();
		elements[17] = new Argon();
		elements[18] = new Potassium();
		elements[19] = new Calcium();
		elements[20] = new Scandium();
		elements[21] = new Titanium();
		elements[22] = new Vanadium();
		elements[23] = new Chromium();
		elements[24] = new Manganese();
		elements[25] = new Iron();
		elements[26] = new Cobalt();
		elements[27] = new Nickel();
		elements[28] = new Copper();
		elements[29] = new Zinc();
		elements[30] = new Gallium();
		elements[31] = new Germanium();
		elements[32] = new Arsenic();
		elements[33] = new Selenium();
		elements[34] = new Bromine();
		elements[35] = new Krypton();
		elements[36] = new Rubidium();
		elements[37] = new Strontium();
		elements[38] = new Yttrium();
		elements[39] = new Zirconium();
		elements[40] = new Niobium();
		elements[41] = new Molybdenum();
		elements[42] = new Technetium();
		elements[43] = new Ruthenium();
		elements[44] = new Rhodium();
		elements[45] = new Palladium();
		elements[46] = new Silver();
		elements[47] = new Cadmium();
		elements[48] = new Indium();
		elements[49] = new Tin();
		elements[50] = new Antimony();
		elements[51] = new Tellurium();
		elements[52] = new Iodine();
		elements[53] = new Xenon();
		elements[54] = new Caesium();
		elements[55] = new Barium();
		elements[56] = new Lanthanum();
		elements[57] = new Cerium();
		elements[58] = new Praseodymium();
		elements[59] = new Neodymium();
		elements[60] = new Promethium();
		elements[61] = new Samarium();
		elements[62] = new Europium();
		elements[63] = new Gadolinium();
		elements[64] = new Terbium();
		elements[65] = new Dysprosium();
		elements[66] = new Holmium();
		elements[67] = new Erbium();
		elements[68] = new Thulium();
		elements[69] = new Ytterbium();
		elements[70] = new Lutetium();
		elements[71] = new Hafnium();
		elements[72] = new Tantalum();
		elements[73] = new Tungsten();
		elements[74] = new Rhenium();
		elements[75] = new Osmium();
		elements[76] = new Iridium();
		elements[77] = new Platinum();
		elements[78] = new Gold();
		elements[79] = new Mercury();
		elements[80] = new Thallium();
		elements[81] = new Lead();
		elements[82] = new Bismuth();
		elements[83] = new Polonium();
		elements[84] = new Astatine();
		elements[85] = new Radon();
		elements[86] = new Francium();
		elements[87] = new Radium();
		elements[88] = new Actinium();
		elements[89] = new Thorium();
		elements[90] = new Protactinium();
		elements[91] = new Uranium();
		elements[92] = new Neptunium();
		elements[93] = new Plutonium();
		elements[94] = new Americium();
		elements[95] = new Curium();
		elements[96] = new Berkelium();
		elements[97] = new Californium();
		elements[98] = new Einsteinium();
		elements[99] = new Fermium();
		elements[100] = new Mendelevium();
		elements[101] = new Nobelium();
		elements[102] = new Lawrencium();
		elements[103] = new Rutherfordium();
		elements[104] = new Dubnium();
		elements[105] = new Seaborgium();
		elements[106] = new Bohrium();
		elements[107] = new Hassium();
		elements[108] = new Meitnerium();
		elements[109] = new Darmstadtium();
		elements[110] = new Roentgenium();
		elements[111] = new Copernicium();
		elements[112] = new Ununtrium();
		elements[113] = new Flerovium();
		elements[114] = new Ununpentium();
		elements[115] = new Livermorium();
		elements[116] = new Ununseptium();
		elements[117] = new Ununoctium();
		elements[118] = new MoleculeMarker();
		
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
				Group group = element.getGroup();
			
		        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		        Graphics2D g2d = img.createGraphics();
		        
		        Font font;
		        if(text.length() == 1) font = new Font("Helvetica", Font.PLAIN, 60);
		        else if(text.length() == 2) font = new Font("Helvetica", Font.PLAIN, 45);
		        else font = new Font("Helvetica", Font.PLAIN, 32);
		        
		        Color colour;
		        switch(group)
		        {
		        	case ALKALI_METALS:
		        		colour = Color.WHITE;
		        		break;
		        	case ALKALINE_EARTH_METALS:
		        		colour = Color.PINK;
		        		break;
		        	case TRANSITION_METALS:
		        		colour = Color.CYAN.darker();
		        		break;
		        	case OTHER_METALS:
		        		colour = Color.ORANGE;
		        		break;
		        	case NON_METALS:
		        		colour = Color.GREEN;
		        		break;
		        	case NOBLE_GASES:
		        		colour = Color.YELLOW;
		        		break;
		        	default:
		        		colour = Color.WHITE;
		        }
		        
		        g2d.setFont(font);
		        FontMetrics fm = g2d.getFontMetrics();
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

		        g2d.setColor(colour);
		        g2d.draw3DRect(0, 0, img.getWidth(), img.getHeight(), false);
		        g2d.fill3DRect(0, 0, 64, 64, false);
		        
		        g2d.setFont(font);
		        fm = g2d.getFontMetrics();
		        g2d.setColor(colour.brighter().darker().brighter()); //This gives a colour slightly different to a single brighter
		        
		        g2d.drawString(text, 32- fm.stringWidth(text)/2, 32+ fm.getDescent() + 5);
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
