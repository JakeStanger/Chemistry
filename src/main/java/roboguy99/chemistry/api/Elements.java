package roboguy99.chemistry.api;

import java.util.ArrayList;
import java.util.List;

import roboguy99.chemistry.item.element.Element;
import roboguy99.chemistry.item.element.elements.*;
import roboguy99.chemistry.item.element.elements.special.MoleculeMarker;

public class Elements 
{
	private static List<Element> elements = new ArrayList<Element>();
	
	public Elements()
	{
		elements.add(new Hydrogen());
		elements.add(new Helium());
		elements.add(new Lithium());
		elements.add(new Berylium());
		elements.add(new Boron());
		elements.add(new Carbon());
		elements.add(new Nitrogen());
		elements.add(new Oxygen());
		elements.add(new Flourine());
		elements.add(new Neon());
		elements.add(new Sodium());
		elements.add(new Magnesium());
		elements.add(new Aluminium());
		elements.add(new Silicon());
		elements.add(new Phosphorus());
		elements.add(new Sulphur());
		elements.add(new Chlorine());
		elements.add(new Argon());
		elements.add(new Potassium());
		elements.add(new Calcium());
		elements.add(new Scandium());
		elements.add(new Titanium());
		elements.add(new Vanadium());
		elements.add(new Chromium());
		elements.add(new Manganese());
		elements.add(new Iron());
		elements.add(new Cobalt());
		elements.add(new Nickel());
		elements.add(new Copper());
		elements.add(new Zinc());
		elements.add(new Gallium());
		elements.add(new Germanium());
		elements.add(new Arsenic());
		elements.add(new Selenium());
		elements.add(new Bromine());
		elements.add(new Krypton());
		elements.add(new Rubidium());
		elements.add(new Strontium());
		elements.add(new Yttrium());
		elements.add(new Zirconium());
		elements.add(new Niobium());
		elements.add(new Molybdenum());
		elements.add(new Technetium());
		elements.add(new Ruthenium());
		elements.add(new Rhodium());
		elements.add(new Palladium());
		elements.add(new Silver());
		elements.add(new Cadmium());
		elements.add(new Indium());
		elements.add(new Tin());
		elements.add(new Antimony());
		elements.add(new Tellurium());
		elements.add(new Iodine());
		elements.add(new Xenon());
		elements.add(new Caesium());
		elements.add(new Barium());
		elements.add(new Lanthanum());
		elements.add(new Cerium());
		elements.add(new Praseodymium());
		elements.add(new Neodymium());
		elements.add(new Promethium());
		elements.add(new Samarium());
		elements.add(new Europium());
		elements.add(new Gadolinium());
		elements.add(new Terbium());
		elements.add(new Dysprosium());
		elements.add(new Holmium());
		elements.add(new Erbium());
		elements.add(new Thulium());
		elements.add(new Ytterbium());
		elements.add(new Lutetium());
		elements.add(new Hafnium());
		elements.add(new Tantalum());
		elements.add(new Tungsten());
		elements.add(new Rhenium());
		elements.add(new Osmium());
		elements.add(new Iridium());
		elements.add(new Platinum());
		elements.add(new Gold());
		elements.add(new Mercury());
		elements.add(new Thallium());
		elements.add(new Lead());
		elements.add(new Bismuth());
		elements.add(new Polonium());
		elements.add(new Astatine());
		elements.add(new Radon());
		elements.add(new Francium());
		elements.add(new Radium());
		elements.add(new Actinium());
		elements.add(new Thorium());
		elements.add(new Protactinium());
		elements.add(new Uranium());
		elements.add(new Neptunium());
		elements.add(new Plutonium());
		elements.add(new Americium());
		elements.add(new Curium());
		elements.add(new Berkelium());
		elements.add(new Californium());
		elements.add(new Einsteinium());
		elements.add(new Fermium());
		elements.add(new Mendelevium());
		elements.add(new Nobelium());
		elements.add(new Lawrencium());
		elements.add(new Rutherfordium());
		elements.add(new Dubnium());
		elements.add(new Seaborgium());
		elements.add(new Bohrium());
		elements.add(new Hassium());
		elements.add(new Meitnerium());
		elements.add(new Darmstadtium());
		elements.add(new Roentgenium());
		elements.add(new Copernicium());
		elements.add(new Ununtrium());
		elements.add(new Flerovium());
		elements.add(new Ununpentium());
		elements.add(new Livermorium());
		elements.add(new Ununseptium());
		elements.add(new Ununoctium());
		elements.add(new MoleculeMarker());
    }
	
	/**
	 * Gets the element instance linking to the specified atomic number.
	 * @param atomicNumber
	 * @return The element with the specified atomic number
	 */
	public static Element getElement(int atomicNumber) //TODO Remove support of getting by atomic number
	{
		return elements.get(atomicNumber-1);
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
	
	public static void addElement(Element element)
	{
		elements.add(element);
	}
	
	/**
	 * Gets the array of elements
	 * @return The array of elements
	 */
	public static List<Element> getElements()
	{
		return Elements.elements;
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
