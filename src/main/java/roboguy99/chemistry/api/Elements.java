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
	public static Element getElement(int atomicNumber)
	{
		return elements.get(atomicNumber-1);
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
		HYDROGEN(elements.get(1)),
		HELIUM(elements.get(2)),
		LITHIUM(elements.get(3)),
		BERYLLIUM(elements.get(4)),
		BORON(elements.get(5)),
		CARBON(elements.get(6)),
		NITROGEN(elements.get(7)),
		OXYGEN(elements.get(8)),
		FLUORINE(elements.get(9)),
		NEON(elements.get(10)),
		SODIUM(elements.get(11)),
		MAGNESIUM(elements.get(12)),
		ALUMINIUM(elements.get(13)),
		SILICON(elements.get(14)),
		PHOSPHORUS(elements.get(15)),
		SULFUR(elements.get(16)),
		CHLORINE(elements.get(17)),
		ARGON(elements.get(18)),
		POTASSIUM(elements.get(19)),
		CALCIUM(elements.get(20)),
		SCANDIUM(elements.get(21)),
		TITANIUM(elements.get(22)),
		VANADIUM(elements.get(23)),
		CHROMIUM(elements.get(24)),
		MANGANESE(elements.get(25)),
		IRON(elements.get(26)),
		COBALT(elements.get(27)),
		NICKEL(elements.get(28)),
		COPPER(elements.get(29)),
		ZINC(elements.get(30)),
		GALLIUM(elements.get(31)),
		GERMANIUM(elements.get(32)),
		ARSENIC(elements.get(33)),
		SELENIUM(elements.get(34)),
		BROMINE(elements.get(35)),
		KRYPTON(elements.get(36)),
		RUBIDIUM(elements.get(37)),
		STRONTIUM(elements.get(38)),
		YTTRIUM(elements.get(39)),
		ZIRCONIUM(elements.get(40)),
		NIOBIUM(elements.get(41)),
		MOLYBDENUM(elements.get(42)),
		TECHNETIUM(elements.get(43)),
		RUTHENIUM(elements.get(44)),
		RHODIUM(elements.get(45)),
		PALLADIUM(elements.get(46)),
		SILVER(elements.get(47)),
		CADMIUM(elements.get(48)),
		INDIUM(elements.get(49)),
		TIN(elements.get(50)),
		ANTIMONY(elements.get(51)),
		TELLURIUM(elements.get(52)),
		IODINE(elements.get(53)),
		XENON(elements.get(54)),
		CESIUM(elements.get(55)),
		BARIUM(elements.get(56)),
		LANTHANUM(elements.get(57)),
		CERIUM(elements.get(58)),
		PRASEODYMIUM(elements.get(59)),
		NEODYMIUM(elements.get(60)),
		PROMETHIUM(elements.get(61)),
		SAMARIUM(elements.get(62)),
		EUROPIUM(elements.get(63)),
		GADOLINIUM(elements.get(64)),
		TERBIUM(elements.get(65)),
		DYSPROSIUM(elements.get(66)),
		HOLMIUM(elements.get(67)),
		ERBIUM(elements.get(68)),
		THULIUM(elements.get(69)),
		YTTERBIUM(elements.get(70)),
		LUTETIUM(elements.get(71)),
		HAFNIUM(elements.get(72)),
		TANTALUM(elements.get(73)),
		TUNGSTEN(elements.get(74)),
		RHENIUM(elements.get(75)),
		OSMIUM(elements.get(76)),
		IRIDIUM(elements.get(77)),
		PLATINUM(elements.get(78)),
		GOLD(elements.get(79)),
		MERCURY(elements.get(80)),
		THALLIUM(elements.get(81)),
		LEAD(elements.get(82)),
		BISMUTH(elements.get(83)),
		POLONIUM(elements.get(84)),
		ASTATINE(elements.get(85)),
		RADON(elements.get(86)),
		FRANCIUM(elements.get(87)),
		RADIUM(elements.get(88)),
		ACTINIUM(elements.get(89)),
		THORIUM(elements.get(90)),
		PROTACTINIUM(elements.get(91)),
		URANIUM(elements.get(92)),
		NEPTUNIUM(elements.get(93)),
		PLUTONIUM(elements.get(94)),
		AMERICIUM(elements.get(95)),
		CURIUM(elements.get(96)),
		BERKELIUM(elements.get(97)),
		CALIFORNIUM(elements.get(98)),
		EINSTEINIUM(elements.get(99)),
		FERMIUM(elements.get(100)),
		MENDELEVIUM(elements.get(101)),
		NOBELIUM(elements.get(102)),
		LAWRENCIUM(elements.get(103)),
		RUTHERFORDIUM(elements.get(104)),
		DUBNIUM(elements.get(105)),
		SEABORGIUM(elements.get(106)),
		BOHRIUM(elements.get(107)),
		HASSIUM(elements.get(108)),
		MEITNERIUM(elements.get(109)),
		DARMSTADTIUM(elements.get(110)),
		ROENTGENIUM(elements.get(111)),
		COPERNICIUM(elements.get(112)),
		UNUNTRIUM(elements.get(113)),
		FLEROVIUM(elements.get(114)),
		UNUNPENTIUM(elements.get(115)),
		LIVERMORIUM(elements.get(116)),
		UNUNSEPTIUM(elements.get(117)),
		UNUNOCTIUM(elements.get(118)),
		MOLECULE_MARKER(elements.get(119));
		
		public static EnumElement[] ELEMENTS = new EnumElement[] {HYDROGEN,HELIUM,LITHIUM,BERYLLIUM,BORON,CARBON,NITROGEN,OXYGEN,FLUORINE,NEON,SODIUM,MAGNESIUM,ALUMINIUM,SILICON,PHOSPHORUS,SULFUR,CHLORINE,ARGON,POTASSIUM,CALCIUM,SCANDIUM,TITANIUM,VANADIUM,CHROMIUM,MANGANESE,IRON,COBALT,NICKEL,COPPER,ZINC,GALLIUM,GERMANIUM,ARSENIC,SELENIUM,BROMINE,KRYPTON,RUBIDIUM,STRONTIUM,YTTRIUM,ZIRCONIUM,NIOBIUM,MOLYBDENUM,TECHNETIUM,RUTHENIUM,RHODIUM,PALLADIUM,SILVER,CADMIUM,INDIUM,TIN,ANTIMONY,TELLURIUM,IODINE,XENON,CESIUM,BARIUM,LANTHANUM,CERIUM,PRASEODYMIUM,NEODYMIUM,PROMETHIUM,SAMARIUM,EUROPIUM,GADOLINIUM,TERBIUM,DYSPROSIUM,HOLMIUM,ERBIUM,THULIUM,YTTERBIUM,LUTETIUM,HAFNIUM,TANTALUM,TUNGSTEN,RHENIUM,OSMIUM,IRIDIUM,PLATINUM,GOLD,MERCURY,THALLIUM,LEAD,BISMUTH,POLONIUM,ASTATINE,RADON,FRANCIUM,RADIUM,ACTINIUM,THORIUM,PROTACTINIUM,URANIUM,NEPTUNIUM,PLUTONIUM,AMERICIUM,CURIUM,BERKELIUM,CALIFORNIUM,EINSTEINIUM,FERMIUM,MENDELEVIUM,NOBELIUM,LAWRENCIUM,RUTHERFORDIUM,DUBNIUM,SEABORGIUM,BOHRIUM,HASSIUM,MEITNERIUM,DARMSTADTIUM,ROENTGENIUM,COPERNICIUM,UNUNTRIUM,FLEROVIUM,UNUNPENTIUM,LIVERMORIUM,UNUNSEPTIUM,UNUNOCTIUM,MOLECULE_MARKER};
		
		private final Element element;
		
		private EnumElement(Element ele)
		{
			element = ele;
		}
		
		public Element getElement()
		{
			return element;
		}
	}
}
