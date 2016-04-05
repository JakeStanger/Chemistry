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
		HYDROGEN(elements.get(0)),
		HELIUM(elements.get(1)),
		LITHIUM(elements.get(2)),
		BERYLLIUM(elements.get(3)),
		BORON(elements.get(4)),
		CARBON(elements.get(5)),
		NITROGEN(elements.get(6)),
		OXYGEN(elements.get(7)),
		FLUORINE(elements.get(8)),
		NEON(elements.get(9)),
		SODIUM(elements.get(10)),
		MAGNESIUM(elements.get(11)),
		ALUMINIUM(elements.get(12)),
		SILICON(elements.get(13)),
		PHOSPHORUS(elements.get(14)),
		SULFUR(elements.get(15)),
		CHLORINE(elements.get(16)),
		ARGON(elements.get(17)),
		POTASSIUM(elements.get(18)),
		CALCIUM(elements.get(19)),
		SCANDIUM(elements.get(20)),
		TITANIUM(elements.get(21)),
		VANADIUM(elements.get(22)),
		CHROMIUM(elements.get(23)),
		MANGANESE(elements.get(24)),
		IRON(elements.get(25)),
		COBALT(elements.get(26)),
		NICKEL(elements.get(27)),
		COPPER(elements.get(28)),
		ZINC(elements.get(29)),
		GALLIUM(elements.get(30)),
		GERMANIUM(elements.get(31)),
		ARSENIC(elements.get(32)),
		SELENIUM(elements.get(33)),
		BROMINE(elements.get(34)),
		KRYPTON(elements.get(35)),
		RUBIDIUM(elements.get(36)),
		STRONTIUM(elements.get(37)),
		YTTRIUM(elements.get(38)),
		ZIRCONIUM(elements.get(39)),
		NIOBIUM(elements.get(40)),
		MOLYBDENUM(elements.get(41)),
		TECHNETIUM(elements.get(42)),
		RUTHENIUM(elements.get(43)),
		RHODIUM(elements.get(44)),
		PALLADIUM(elements.get(45)),
		SILVER(elements.get(46)),
		CADMIUM(elements.get(47)),
		INDIUM(elements.get(48)),
		TIN(elements.get(49)),
		ANTIMONY(elements.get(50)),
		TELLURIUM(elements.get(51)),
		IODINE(elements.get(52)),
		XENON(elements.get(53)),
		CESIUM(elements.get(54)),
		BARIUM(elements.get(55)),
		LANTHANUM(elements.get(56)),
		CERIUM(elements.get(57)),
		PRASEODYMIUM(elements.get(58)),
		NEODYMIUM(elements.get(59)),
		PROMETHIUM(elements.get(60)),
		SAMARIUM(elements.get(61)),
		EUROPIUM(elements.get(62)),
		GADOLINIUM(elements.get(63)),
		TERBIUM(elements.get(64)),
		DYSPROSIUM(elements.get(65)),
		HOLMIUM(elements.get(66)),
		ERBIUM(elements.get(67)),
		THULIUM(elements.get(68)),
		YTTERBIUM(elements.get(69)),
		LUTETIUM(elements.get(70)),
		HAFNIUM(elements.get(71)),
		TANTALUM(elements.get(72)),
		TUNGSTEN(elements.get(73)),
		RHENIUM(elements.get(74)),
		OSMIUM(elements.get(75)),
		IRIDIUM(elements.get(76)),
		PLATINUM(elements.get(77)),
		GOLD(elements.get(78)),
		MERCURY(elements.get(79)),
		THALLIUM(elements.get(80)),
		LEAD(elements.get(81)),
		BISMUTH(elements.get(82)),
		POLONIUM(elements.get(83)),
		ASTATINE(elements.get(84)),
		RADON(elements.get(85)),
		FRANCIUM(elements.get(86)),
		RADIUM(elements.get(87)),
		ACTINIUM(elements.get(88)),
		THORIUM(elements.get(89)),
		PROTACTINIUM(elements.get(90)),
		URANIUM(elements.get(91)),
		NEPTUNIUM(elements.get(92)),
		PLUTONIUM(elements.get(93)),
		AMERICIUM(elements.get(94)),
		CURIUM(elements.get(95)),
		BERKELIUM(elements.get(96)),
		CALIFORNIUM(elements.get(97)),
		EINSTEINIUM(elements.get(98)),
		FERMIUM(elements.get(99)),
		MENDELEVIUM(elements.get(100)),
		NOBELIUM(elements.get(101)),
		LAWRENCIUM(elements.get(102)),
		RUTHERFORDIUM(elements.get(103)),
		DUBNIUM(elements.get(104)),
		SEABORGIUM(elements.get(105)),
		BOHRIUM(elements.get(106)),
		HASSIUM(elements.get(107)),
		MEITNERIUM(elements.get(108)),
		DARMSTADTIUM(elements.get(109)),
		ROENTGENIUM(elements.get(110)),
		COPERNICIUM(elements.get(111)),
		UNUNTRIUM(elements.get(112)),
		FLEROVIUM(elements.get(113)),
		UNUNPENTIUM(elements.get(114)),
		LIVERMORIUM(elements.get(115)),
		UNUNSEPTIUM(elements.get(116)),
		UNUNOCTIUM(elements.get(117)),
		MOLECULE_MARKER(elements.get(118));
		
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
