package roboguy99.chemistry.api;

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

import roboguy99.chemistry.item.compound.Compound;
import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.elements.*;
import roboguy99.chemistry.item.element.elements.special.MoleculeMarker;

public class Elements 
{
	private static Element[] elements = new Element[118];
	private static Element moleculeMarker;
	
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
		
		this.moleculeMarker = new MoleculeMarker();
    }
	
	/**
	 * Gets the element instance linking to the specified atomic number.
	 * @param atomicNumber
	 * @return The element with the specified atomic number
	 */
	public static Element getElement(int atomicNumber)
	{
		return elements[atomicNumber-1];
	}
	
	/**
	 * Gets the element instance linking to the specified enum value.
	 * See EnumElement.
	 * @param enumElement
	 * @return The element for the given enum
	 */
	public static Element getElement(EnumElement enumElement)
	{
		return getElement(enumElement.atomicNumber);
	}
	
	/**
	 * Gets the array of elements
	 * @return The array of elements
	 */
	public static Element[] getElements()
	{
		return Elements.elements;
	}
	
	/**
	 * Gets the molecule marker element
	 * @return the registered instance of MoleculeMarker
	 */
	public static Element getMoleculeMarker()
	{
		return Elements.moleculeMarker;
	}
	
	public enum EnumElement
	{
		HYDROGEN(1),
		HELIUM(2),
		LITHIUM(3),
		BERYLLIUM(4),
		BORON(5),
		CARBON(6),
		NITROGEN(7),
		OXYGEN(8),
		FLUORINE(9),
		NEON(10),
		SODIUM(11),
		MAGNESIUM(12),
		ALUMINIUM(13),
		SILICON(14),
		PHOSPHORUS(15),
		SULFUR(16),
		CHLORINE(17),
		ARGON(18),
		POTASSIUM(19),
		CALCIUM(20),
		SCANDIUM(21),
		TITANIUM(22),
		VANADIUM(23),
		CHROMIUM(24),
		MANGANESE(25),
		IRON(26),
		COBALT(27),
		NICKEL(28),
		COPPER(29),
		ZINC(30),
		GALLIUM(31),
		GERMANIUM(32),
		ARSENIC(33),
		SELENIUM(34),
		BROMINE(35),
		KRYPTON(36),
		RUBIDIUM(37),
		STRONTIUM(38),
		YTTRIUM(39),
		ZIRCONIUM(40),
		NIOBIUM(41),
		MOLYBDENUM(42),
		TECHNETIUM(43),
		RUTHENIUM(44),
		RHODIUM(45),
		PALLADIUM(46),
		SILVER(47),
		CADMIUM(48),
		INDIUM(49),
		TIN(50),
		ANTIMONY(51),
		TELLURIUM(52),
		IODINE(53),
		XENON(54),
		CESIUM(55),
		BARIUM(56),
		LANTHANUM(57),
		CERIUM(58),
		PRASEODYMIUM(59),
		NEODYMIUM(60),
		PROMETHIUM(61),
		SAMARIUM(62),
		EUROPIUM(63),
		GADOLINIUM(64),
		TERBIUM(65),
		DYSPROSIUM(66),
		HOLMIUM(67),
		ERBIUM(68),
		THULIUM(69),
		YTTERBIUM(70),
		LUTETIUM(71),
		HAFNIUM(72),
		TANTALUM(73),
		TUNGSTEN(74),
		RHENIUM(75),
		OSMIUM(76),
		IRIDIUM(77),
		PLATINUM(78),
		GOLD(79),
		MERCURY(80),
		THALLIUM(81),
		LEAD(82),
		BISMUTH(83),
		POLONIUM(84),
		ASTATINE(85),
		RADON(86),
		FRANCIUM(87),
		RADIUM(88),
		ACTINIUM(89),
		THORIUM(90),
		PROTACTINIUM(91),
		URANIUM(92),
		NEPTUNIUM(93),
		PLUTONIUM(94),
		AMERICIUM(95),
		CURIUM(96),
		BERKELIUM(97),
		CALIFORNIUM(98),
		EINSTEINIUM(99),
		FERMIUM(100),
		MENDELEVIUM(101),
		NOBELIUM(102),
		LAWRENCIUM(103),
		RUTHERFORDIUM(104),
		DUBNIUM(105),
		SEABORGIUM(106),
		BOHRIUM(107),
		HASSIUM(108),
		MEITNERIUM(109),
		DARMSTADTIUM(110),
		ROENTGENIUM(111),
		COPERNICIUM(112),
		UNUNTRIUM(113),
		FLEROVIUM(114),
		UNUNPENTIUM(115),
		LIVERMORIUM(116),
		UNUNSEPTIUM(117),
		UNUNOCTIUM(118),
		MOLECULE_MARKER(119);
		
		public static EnumElement[] ELEMENTS = new EnumElement[] {HYDROGEN,HELIUM,LITHIUM,BERYLLIUM,BORON,CARBON,NITROGEN,OXYGEN,FLUORINE,NEON,SODIUM,MAGNESIUM,ALUMINIUM,SILICON,PHOSPHORUS,SULFUR,CHLORINE,ARGON,POTASSIUM,CALCIUM,SCANDIUM,TITANIUM,VANADIUM,CHROMIUM,MANGANESE,IRON,COBALT,NICKEL,COPPER,ZINC,GALLIUM,GERMANIUM,ARSENIC,SELENIUM,BROMINE,KRYPTON,RUBIDIUM,STRONTIUM,YTTRIUM,ZIRCONIUM,NIOBIUM,MOLYBDENUM,TECHNETIUM,RUTHENIUM,RHODIUM,PALLADIUM,SILVER,CADMIUM,INDIUM,TIN,ANTIMONY,TELLURIUM,IODINE,XENON,CESIUM,BARIUM,LANTHANUM,CERIUM,PRASEODYMIUM,NEODYMIUM,PROMETHIUM,SAMARIUM,EUROPIUM,GADOLINIUM,TERBIUM,DYSPROSIUM,HOLMIUM,ERBIUM,THULIUM,YTTERBIUM,LUTETIUM,HAFNIUM,TANTALUM,TUNGSTEN,RHENIUM,OSMIUM,IRIDIUM,PLATINUM,GOLD,MERCURY,THALLIUM,LEAD,BISMUTH,POLONIUM,ASTATINE,RADON,FRANCIUM,RADIUM,ACTINIUM,THORIUM,PROTACTINIUM,URANIUM,NEPTUNIUM,PLUTONIUM,AMERICIUM,CURIUM,BERKELIUM,CALIFORNIUM,EINSTEINIUM,FERMIUM,MENDELEVIUM,NOBELIUM,LAWRENCIUM,RUTHERFORDIUM,DUBNIUM,SEABORGIUM,BOHRIUM,HASSIUM,MEITNERIUM,DARMSTADTIUM,ROENTGENIUM,COPERNICIUM,UNUNTRIUM,FLEROVIUM,UNUNPENTIUM,LIVERMORIUM,UNUNSEPTIUM,UNUNOCTIUM,MOLECULE_MARKER};
		
		public final int atomicNumber;
		
		private EnumElement(int num)
		{
			atomicNumber = num;
		}
	}
}
