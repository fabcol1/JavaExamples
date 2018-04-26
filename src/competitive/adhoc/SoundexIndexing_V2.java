package competitive.adhoc;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

///////////////// UVa n# 739 https://uva.onlinejudge.org/external/7/739.pdf

public class SoundexIndexing_V2 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String data = "ALEXANDER\r\n" + "ORDERS\r\n" + "    AUDIO    \r\n" + "ERROR\r\n" + "EASILY\r\n" + "TAKING\r\n"
				+ "PREVENTION\r\n" + "FINDER\r\n" + "REGULATION\r\n" + "FINDING\r\n" + "ORGANIZATION\r\n" + "BOUND\r\n"
				+ "STATIC\r\n" + "PHILIPS\r\n" + "HERE\r\n" + "CAMPING\r\n" + "GATEWAY\r\n" + "JEWELRY\r\n"
				+ "STRAIGHT\r\n" + "JEAN\r\n" + "MIND\r\n" + "ABSTRACT\r\n" + "TOUR\r\n" + "DOING\r\n" + "GROW\r\n"
				+ "CIRCUMSTANCES\r\n" + "BOOK\r\n" + "PHILADELPHIA\r\n" + "ROBERTS\r\n" + "CONSULTANT\r\n"
				+ "NOTHING\r\n" + "CORPORATION\r\n" + "JEWISH\r\n" + "ACCIDENT\r\n" + "ATOM\r\n" + "SCENE\r\n"
				+ "CREAM\r\n" + "COLUMBIA\r\n" + "OBJECT\r\n" + "SPECS\r\n" + "DSL\r\n" + "INITIATIVES\r\n"
				+ "CARTOONS\r\n" + "ADD\r\n" + "BROWN\r\n" + "STATED\r\n" + "RETURNED\r\n" + "OURSELVES\r\n"
				+ "ETHNIC\r\n" + "WEDDING\r\n" + "PARAMETERS\r\n" + "ENGINES\r\n" + "OPENING\r\n" + "CONTROLLED\r\n"
				+ "ACTUAL\r\n" + "ORIENTED\r\n" + "BANG\r\n" + "YEARS\r\n" + "INITIATIVE\r\n" + "CUTS\r\n"
				+ "ORGANIC\r\n" + "VEHICLE\r\n" + "SCIENCE\r\n" + "OKAY\r\n" + "KOREAN\r\n" + "PROCESSING\r\n"
				+ "ADDITIONAL\r\n" + "ACCESSIBILITY\r\n" + "MICHIGAN\r\n" + "ASPECT\r\n" + "OFF\r\n" + "PAPER\r\n"
				+ "FINLAND\r\n" + "RESTRICTED\r\n" + "SIGNAL\r\n" + "RECOGNITION\r\n" + "FILED\r\n" + "MESH\r\n"
				+ "SOFT\r\n" + "FACES\r\n" + "WATERS\r\n" + "TICKETS\r\n" + "GOING\r\n" + "HITS\r\n" + "AGAINST\r\n"
				+ "ENCOURAGED\r\n" + "JUDGE\r\n" + "LOOKED\r\n" + "OTHERWISE\r\n" + "PORTUGAL\r\n" + "SCHEDULES\r\n"
				+ "SPONSOR\r\n" + "PAN\r\n" + "TRUSTED\r\n" + "PREMIUM\r\n" + "IMAGE\r\n" + "DEAD\r\n"
				+ "NETHERLANDS\r\n" + "FUNDS\r\n" + "SCORE\r\n" + "LEGAL\r\n" + "VIDEO\r\n" + "III\r\n" + "FINAL\r\n"
				+ "HILLS\r\n" + "DATES\r\n" + "POUND\r\n" + "RUGBY\r\n" + "BAR\r\n" + "EXPERTISE\r\n" + "DETERMINE\r\n"
				+ "UPSKIRT\r\n" + "ARAB\r\n" + "DOUGLAS\r\n" + "WIDTH\r\n" + "PAKISTAN\r\n" + "PRIOR\r\n"
				+ "MERCHANTS\r\n" + "SOCIAL\r\n" + "LIVE\r\n" + "PRIMARY\r\n" + "STAND\r\n" + "MERCHANT\r\n"
				+ "ULTRA\r\n" + "SEATS\r\n" + "CRIME\r\n" + "STRUCTURAL\r\n" + "HUMAN\r\n" + "BEGIN\r\n" + "MONTHLY\r\n"
				+ "PRISON\r\n" + "COLUMN\r\n" + "DOCTOR\r\n" + "COURSE\r\n" + "OFFER\r\n" + "ASSOCIATED\r\n"
				+ "WASTE\r\n" + "WIN\r\n" + "CLOUDY\r\n" + "DEVICE\r\n" + "INCREASED\r\n" + "GREEK\r\n" + "ANNUAL\r\n"
				+ "SPLIT\r\n" + "LIBERTY\r\n" + "SUGGESTED\r\n" + "SLOWLY\r\n" + "BETWEEN\r\n" + "EXPAND\r\n"
				+ "SHIP\r\n" + "JET\r\n" + "PAY\r\n" + "STUFF\r\n" + "ASSEMBLY\r\n" + "PIN\r\n" + "JUSTICE\r\n"
				+ "POWERED\r\n" + "GUIDE\r\n" + "POSITIVE\r\n" + "REPORTED\r\n" + "DISCUSSED\r\n" + "CARS\r\n"
				+ "CLAY\r\n" + "FIGHT\r\n" + "STUDIED\r\n" + "COMMUNICATION\r\n" + "GOVERNOR\r\n" + "BOARDS\r\n"
				+ "LEG\r\n" + "COMMAND\r\n" + "CABLE\r\n" + "ACC\r\n" + "CVS\r\n" + "WOW\r\n" + "TESTS\r\n"
				+ "ATLANTA\r\n" + "FIVE\r\n" + "CAPABILITY\r\n" + "PROVINCE\r\n" + "SHIPPED\r\n" + "BUYER\r\n"
				+ "SAYS\r\n" + "TECHNIQUES\r\n" + "PROMOTION\r\n" + "MARKETPLACE\r\n" + "INTERVIEW\r\n" + "FEEDBACK\r\n"
				+ "SACRAMENTO\r\n" + "DAVID\r\n" + "ITSELF\r\n" + "FINANCIAL\r\n" + "TEENS\r\n" + "MOTHER\r\n"
				+ "PROMOTIONAL\r\n" + "TELLING\r\n" + "REPRESENTATION\r\n" + "ANY\r\n" + "WHEEL\r\n" + "KNOWS\r\n"
				+ "COMICS\r\n" + "BORN\r\n" + "FRIENDLY\r\n" + "RAIN\r\n" + "ENOUGH\r\n" + "PROCESSOR\r\n"
				+ "MILLER\r\n" + "LIB\r\n" + "MAD\r\n" + "BELIEVED\r\n" + "STRONGLY\r\n" + "AWARD\r\n" + "SEX\r\n"
				+ "EVERYTHING\r\n" + "APARTMENT\r\n" + "FOLKS\r\n" + "HAPPEN\r\n" + "HIGHWAY\r\n" + "TRANSMISSION\r\n"
				+ "DVD\r\n" + "AGES\r\n" + "FAQS\r\n" + "CAME\r\n" + "HUSBAND\r\n" + "TONIGHT\r\n" + "UNIQUE\r\n"
				+ "ANGELS\r\n" + "SUBMITTED\r\n" + "AUDIENCE\r\n" + "FRIENDS\r\n" + "SAVINGS\r\n" + "HTML\r\n"
				+ "SUPPLEMENT\r\n" + "HENCE\r\n" + "PLEASE\r\n" + "QUESTIONS\r\n" + "COMMENTARY\r\n" + "CAMPUS\r\n"
				+ "CAMCORDER\r\n" + "DISCOVERY\r\n" + "MACHINES\r\n" + "GENERAL\r\n" + "DISPLAY\r\n" + "FAIR\r\n"
				+ "STANDARD\r\n" + "COMFORTABLE\r\n" + "BUKKAKE\r\n" + "NEGATIVE\r\n" + "NOTEBOOK\r\n" + "OUR\r\n"
				+ "SCIENTISTS\r\n" + "DISCUSS\r\n" + "EVENT\r\n" + "FUNDING\r\n" + "HOURS\r\n" + "TENNIS\r\n"
				+ "COOKIES\r\n" + "DIRECTLY\r\n" + "ESTABLISHED\r\n" + "PICKS\r\n" + "DEMOCRACY\r\n" + "JESSICA\r\n"
				+ "FORGOT\r\n" + "INC\r\n" + "LAKE\r\n" + "INSTEAD\r\n" + "MACHINERY\r\n" + "ZERO\r\n" + "EQUIPPED\r\n"
				+ "INTERFACE\r\n" + "CANDIDATE\r\n" + "THICK\r\n" + "COMMITTED\r\n" + "COUNSELING\r\n" + "PUMP\r\n"
				+ "INDIA\r\n" + "CONTAINS\r\n" + "CREATES\r\n" + "EFFORTS\r\n" + "ROD\r\n" + "TURKEY\r\n" + "JONES\r\n"
				+ "SIMON\r\n" + "PENNSYLVANIA\r\n" + "CAUSED\r\n" + "WATCHING\r\n" + "VON\r\n" + "ORIGIN\r\n"
				+ "CANADIAN\r\n" + "POSITIONS\r\n" + "HARRIS\r\n" + "APPLICABLE\r\n" + "JAN\r\n" + "ANIMAL\r\n"
				+ "ROLL\r\n" + "RADIATION\r\n" + "SEMINAR\r\n" + "EVIL\r\n" + "APPROXIMATELY\r\n" + "COUNTY\r\n"
				+ "CENTER\r\n" + "ACTIVE\r\n" + "HRS\r\n" + "EVE\r\n" + "FOR\r\n" + "DOMESTIC\r\n" + "REVENUE\r\n"
				+ "BLANK\r\n" + "TURNED\r\n" + "PLAYER\r\n" + "RESPECTIVE\r\n" + "CONTINUING\r\n" + "SOME\r\n"
				+ "PERSON\r\n" + "ATTRIBUTES\r\n" + "FAR\r\n" + "ULTIMATE\r\n" + "ENTERPRISE\r\n" + "YEAH\r\n"
				+ "REVISION\r\n" + "ENJOYED\r\n" + "LAWRENCE\r\n" + "ANSWERS\r\n" + "EVOLUTION\r\n" + "CONCRETE\r\n"
				+ "COMMUNITIES\r\n" + "KNIGHT\r\n" + "LAMP\r\n" + "ARTHUR\r\n" + "IDENTITY\r\n" + "FACULTY\r\n"
				+ "EXAM\r\n" + "AREAS\r\n" + "CYPRUS\r\n" + "BRAZIL\r\n" + "IMPROVING\r\n" + "CHAPTER\r\n" + "DONE\r\n"
				+ "PLANS\r\n" + "GENERATED\r\n" + "ADVANTAGE\r\n" + "APPEARS\r\n" + "EARRINGS\r\n" + "TEN\r\n"
				+ "ELECTION\r\n" + "HOLIDAY\r\n" + "WIND\r\n" + "WEAPONS\r\n" + "BERLIN\r\n" + "AVENUE\r\n"
				+ "COUNTER\r\n" + "MILE\r\n" + "CHEST\r\n" + "GIVE\r\n" + "SECURITY\r\n" + "CONSERVATION\r\n"
				+ "OAK\r\n" + "FLOWER\r\n" + "BIKE\r\n" + "EXPLORER\r\n" + "ROMANTIC\r\n" + "MOMENT\r\n" + "COURTS\r\n"
				+ "RETIREMENT\r\n" + "FOODS\r\n" + "PARALLEL\r\n" + "IMPOSSIBLE\r\n" + "TERRY\r\n" + "RESPONSE\r\n"
				+ "DOT\r\n" + "BROADCAST\r\n" + "VOTES\r\n" + "BILLION\r\n" + "SPEAKING\r\n" + "BRINGS\r\n"
				+ "KENTUCKY\r\n" + "WIDELY\r\n" + "BATTERY\r\n" + "RICHMOND\r\n" + "COLUMBUS\r\n" + "PUBLIC\r\n"
				+ "MAXIMUM\r\n" + "PROPER\r\n" + "HEY\r\n" + "SPECIAL\r\n" + "MOTOROLA\r\n" + "PLATFORMS\r\n"
				+ "ELIZABETH\r\n" + "APRIL\r\n" + "CRASH\r\n" + "CONTRACTOR\r\n" + "NEIGHBORHOOD\r\n" + "SOLVE\r\n"
				+ "INDICATES\r\n" + "PUBLICATION\r\n" + "FUNERAL\r\n" + "HOUSTON\r\n" + "HONOR\r\n" + "SONGS\r\n"
				+ "SATISFACTION\r\n" + "GENDER\r\n" + "PERMIT\r\n" + "REPORT\r\n" + "IOWA\r\n" + "UNDERSTANDING\r\n"
				+ "INSTITUTIONAL\r\n" + "PEARL\r\n" + "PLANE\r\n" + "ORACLE\r\n" + "FTP\r\n" + "PAD\r\n"
				+ "MATERIAL\r\n" + "POSITION\r\n" + "CAN\r\n" + "WORST\r\n" + "CONFIGURATION\r\n" + "ALREADY\r\n"
				+ "TRANSLATION\r\n" + "PLASTIC\r\n" + "CAMBRIDGE\r\n" + "GIVEN\r\n" + "ILLUSTRATED\r\n" + "GUITAR\r\n"
				+ "LESBIAN\r\n" + "FAMILY\r\n" + "BEASTIALITY\r\n" + "LATEST\r\n" + "HERITAGE\r\n" + "SCORES\r\n"
				+ "ENTERING\r\n" + "MATTHEW\r\n" + "ACADEMIC\r\n" + "ALLEN\r\n" + "DISPLAYS\r\n" + "ALLOWING\r\n"
				+ "TWENTY\r\n" + "TESTING\r\n" + "MEETINGS\r\n" + "FORT\r\n" + "VITAMIN\r\n" + "ROBOT\r\n"
				+ "ORDERED\r\n" + "PENALTY\r\n" + "HORROR\r\n" + "ENVIRONMENTS\r\n" + "SHARING\r\n" + "WHICH\r\n"
				+ "REALLY\r\n" + "CONSERVATIVE\r\n" + "SUPPLIED\r\n" + "SHOWS\r\n" + "BOUNDARY\r\n" + "HAND\r\n"
				+ "ACCEPTANCE\r\n" + "TIGHT\r\n" + "CARTRIDGE\r\n" + "LIVING\r\n" + "STEP\r\n" + "MULTIPLE\r\n"
				+ "NATIONS\r\n" + "WINNER\r\n" + "KNOWN\r\n" + "RESULT\r\n" + "PUZZLE\r\n" + "FREQUENCY\r\n"
				+ "AROUND\r\n" + "REFERENCES\r\n" + "INDEED\r\n" + "SUCCESSFUL\r\n" + "STATISTICAL\r\n"
				+ "TELECOMMUNICATIONS\r\n" + "CHEMICALS\r\n" + "WAKE\r\n" + "RATES\r\n" + "CATALOGUE\r\n"
				+ "INSTANCE\r\n" + "ACHIEVE\r\n" + "PLUG\r\n" + "POPULAR\r\n" + "CHRISTOPHER\r\n" + "REPORTING\r\n"
				+ "FIELD\r\n" + "PUB\r\n" + "REQUESTS\r\n" + "DEGREE\r\n" + "RESERVES\r\n" + "APPROACHES\r\n"
				+ "EVENTUALLY\r\n" + "KITCHEN\r\n" + "BENEFIT\r\n" + "INTENDED\r\n" + "PETER\r\n" + "DIRECTORS\r\n"
				+ "NEAREST\r\n" + "UNDERSTAND\r\n" + "LENGTH\r\n" + "SPEAKERS\r\n" + "ORDERING\r\n" + "CZECH\r\n"
				+ "PLENTY\r\n" + "CLINICAL\r\n" + "GOLD\r\n" + "THIS\r\n" + "EVERYBODY\r\n" + "CHANCE\r\n"
				+ "ABILITY\r\n" + "POSTERS\r\n" + "INDIAN\r\n" + "CONTRACT\r\n" + "OBJECTS\r\n" + "ARCHIVES\r\n"
				+ "PHENTERMINE\r\n" + "HOUSEHOLD\r\n" + "PAGE\r\n" + "FETISH\r\n" + "IDEAS\r\n" + "SURE\r\n"
				+ "PROVIDED\r\n" + "ONLY\r\n" + "ODDS\r\n" + "HEIGHTS\r\n" + "WISHLIST\r\n" + "CONFERENCE\r\n"
				+ "ATHLETIC\r\n" + "HIDDEN\r\n" + "BITS\r\n" + "SCHEDULE\r\n" + "SHOOTING\r\n" + "TOKYO\r\n"
				+ "OFFERED\r\n" + "MASTER\r\n" + "CARTRIDGES\r\n" + "AWARENESS\r\n" + "PERMALINK\r\n" + "VIRUS\r\n"
				+ "VIEWS\r\n" + "EDUCATIONAL\r\n" + "PEAK\r\n" + "POWDER\r\n" + "WERE\r\n" + "FROM\r\n" + "HAIRY\r\n"
				+ "WED\r\n" + "DAMAGE\r\n" + "PAST\r\n" + "VERTICAL\r\n" + "MEXICO\r\n" + "CLASSICS\r\n"
				+ "SENSITIVE\r\n" + "COTTON\r\n" + "CYCLE\r\n" + "STAGES\r\n" + "IDEA\r\n" + "SLIP\r\n" + "FLORIDA\r\n"
				+ "RSS\r\n" + "TECHNICAL\r\n" + "CLIENT\r\n" + "STAMPS\r\n" + "MANUAL\r\n" + "TAIWAN\r\n"
				+ "IMPROVED\r\n" + "DAKOTA\r\n" + "NAVY\r\n" + "FREEDOM\r\n" + "RELATIVE\r\n" + "CULTURE\r\n"
				+ "ORDER\r\n" + "EXPERIENCED\r\n" + "MANY\r\n" + "DIRECTION\r\n" + "REPLY\r\n" + "ACCORDING\r\n"
				+ "BODY\r\n" + "MET\r\n" + "MORTGAGES\r\n" + "OPERA\r\n" + "IMPLICATIONS\r\n" + "VOLTAGE\r\n"
				+ "INFANT\r\n" + "SPRAY\r\n" + "ACCEPTABLE\r\n" + "BLUETOOTH\r\n" + "FEEL\r\n" + "FILMS\r\n"
				+ "BILLS\r\n" + "FAMILIES\r\n" + "RISK\r\n" + "BUGS\r\n" + "TONY\r\n" + "CURRENCY\r\n"
				+ "RECOMMENDATIONS\r\n" + "PURPOSES\r\n" + "HIGH\r\n" + "DIET\r\n" + "NICE\r\n" + "INCLUDES\r\n"
				+ "GRACE\r\n" + "THROAT\r\n" + "PROFIT\r\n" + "ELSE\r\n" + "REACH\r\n" + "VOID\r\n" + "SUCK\r\n"
				+ "STEEL\r\n" + "INTRODUCED\r\n" + "USERS\r\n" + "JENNIFER\r\n" + "ANTHONY\r\n" + "CHANNEL\r\n"
				+ "IDENTIFICATION\r\n" + "NOR\r\n" + "COFFEE\r\n" + "MOUTH\r\n" + "USED\r\n" + "QUALIFIED\r\n"
				+ "REASONABLE\r\n" + "EMPHASIS\r\n" + "FACING\r\n" + "CONSIDERED\r\n" + "LATTER\r\n" + "SHARED\r\n"
				+ "RIDING\r\n" + "BONDS\r\n" + "CALLED\r\n" + "NAVIGATE\r\n" + "VACATIONS\r\n" + "ANONYMOUS\r\n"
				+ "UNIVERSITY\r\n" + "GALLERIES\r\n" + "COVER\r\n" + "AMERICAN\r\n" + "PERCENTAGE\r\n" + "CONDUCTED\r\n"
				+ "UPS\r\n" + "REALIZE\r\n" + "LAND\r\n" + "LETTER\r\n" + "DIAMOND\r\n" + "BREAST\r\n" + "DEVEL\r\n"
				+ "REAR\r\n" + "WALLPAPERS\r\n" + "POTENTIAL\r\n" + "BRIEF\r\n" + "JON\r\n" + "REVISED\r\n"
				+ "SUGAR\r\n" + "LINCOLN\r\n" + "TOURISM\r\n" + "STANDING\r\n" + "FAVORITE\r\n" + "ROGER\r\n"
				+ "KISS\r\n" + "LIVECAM\r\n" + "ESTIMATE\r\n" + "REVEALED\r\n" + "BLOCK\r\n" + "TRANSACTIONS\r\n"
				+ "JUST\r\n" + "STATISTICS\r\n" + "RELEASED\r\n" + "INSTRUCTION\r\n" + "AMAZING\r\n" + "TAPE\r\n"
				+ "AGENCIES\r\n" + "SPANISH\r\n" + "NOW\r\n" + "SURGERY\r\n" + "CIRCLE\r\n" + "TOE\r\n" + "CON\r\n"
				+ "IDENTIFIED\r\n" + "EARNED\r\n" + "MOVES\r\n" + "NEBRASKA\r\n" + "LOCAL\r\n" + "YIELD\r\n"
				+ "FIBER\r\n" + "PLACE\r\n" + "RECORD\r\n" + "PURSUANT\r\n" + "REFLECT\r\n" + "JESUS\r\n" + "LIKELY\r\n"
				+ "MENTIONED\r\n" + "TRIAL\r\n" + "DONALD\r\n" + "WYOMING\r\n" + "PEOPLE\r\n" + "JIMMY\r\n"
				+ "FASHION\r\n" + "RATING\r\n" + "CUP\r\n" + "POUR\r\n" + "SOIL\r\n" + "REVOLUTION\r\n" + "SUPPOSED\r\n"
				+ "JAPAN\r\n" + "INCLUDED\r\n" + "MAINTENANCE\r\n" + "THOSE\r\n" + "SON\r\n" + "PACKAGE\r\n"
				+ "VERY\r\n" + "COMPUTING\r\n" + "RARE\r\n" + "UNITS\r\n" + "VOLUME\r\n" + "OWNER\r\n"
				+ "ENCYCLOPEDIA\r\n" + "PROTEINS\r\n" + "TOMORROW\r\n" + "ISO\r\n" + "CHIPS\r\n" + "CHAT\r\n"
				+ "REDUCED\r\n" + "EDITOR\r\n" + "DISCOUNTS\r\n" + "LESBIANS\r\n" + "CALLS\r\n" + "DISCUSSION\r\n"
				+ "MOORE\r\n" + "DAVIS\r\n" + "ICONS\r\n" + "FORMS\r\n" + "LAS\r\n" + "HUNGARY\r\n" + "SPY\r\n"
				+ "SHOULD\r\n" + "CERTIFIED\r\n" + "WORSE\r\n" + "HANDLE\r\n" + "NUCLEAR\r\n" + "TIP\r\n" + "ZUM\r\n"
				+ "NOVEL\r\n" + "BARRY\r\n" + "PATCH\r\n" + "BLVD\r\n" + "MAINTAINED\r\n" + "KENT\r\n" + "MIGHT\r\n"
				+ "LASER\r\n" + "INNER\r\n" + "TIM\r\n" + "EACH\r\n" + "READERS\r\n" + "CATS\r\n" + "EAGLE\r\n"
				+ "EXACTLY\r\n" + "SORRY\r\n" + "BIRDS\r\n" + "MONDAY\r\n" + "ANDY\r\n" + "WISCONSIN\r\n"
				+ "FORMULA\r\n" + "SENTENCE\r\n" + "MARKETING\r\n" + "EXCEL\r\n" + "CLARK\r\n" + "MODELS\r\n"
				+ "THEATRE\r\n" + "PIONEER\r\n" + "MYSELF\r\n" + "BLOGS\r\n" + "PACKET\r\n" + "RECIPE\r\n"
				+ "FORMER\r\n" + "HER\r\n" + "BRING\r\n" + "TRENDS\r\n" + "CUSTOMER\r\n" + "PASSWORD\r\n"
				+ "ARTICLE\r\n" + "RELATED\r\n" + "RATE\r\n" + "TOOLS\r\n" + "RELATIVELY\r\n" + "REGISTRY\r\n"
				+ "SOLID\r\n" + "COLLECT\r\n" + "CACHED\r\n" + "DRAWN\r\n" + "SPORT\r\n" + "ELECTRONICS\r\n"
				+ "PASSED\r\n" + "TIGER\r\n" + "PORTABLE\r\n" + "RATINGS\r\n" + "BASIC\r\n" + "PEACE\r\n" + "CELLS\r\n"
				+ "SELECTION\r\n" + "COMMERCIAL\r\n" + "PCS\r\n" + "CLICKING\r\n" + "NODE\r\n" + "TRAIN\r\n"
				+ "ENGLAND\r\n" + "MORAL\r\n" + "COMPUTERS\r\n" + "FUNNY\r\n" + "TOGETHER\r\n" + "INTERACTION\r\n"
				+ "PHOTO\r\n" + "EXTREMELY\r\n" + "MEXICAN\r\n" + "TILL\r\n" + "DOSE\r\n" + "CLEVELAND\r\n"
				+ "SUCCESS\r\n" + "ENEMY\r\n" + "MARCH\r\n" + "FATHER\r\n" + "HEALTHY\r\n" + "BOOTY\r\n" + "SHOOT\r\n"
				+ "TIPS\r\n" + "WORDS\r\n" + "REFUND\r\n" + "DISTRIBUTED\r\n" + "DRIVEN\r\n" + "PAUL\r\n" + "LOST\r\n"
				+ "FRAME\r\n" + "PAIR\r\n" + "FLOW\r\n" + "PACKARD\r\n" + "DESCRIPTION\r\n" + "EASTERN\r\n"
				+ "ACCESSORIES\r\n" + "LOVELY\r\n" + "CLOSE\r\n" + "VOYEUR\r\n" + "SIERRA\r\n" + "COURT\r\n"
				+ "BREAKFAST\r\n" + "HUMOR\r\n" + "UNITED\r\n" + "BECOME\r\n" + "TWICE\r\n" + "BROUGHT\r\n"
				+ "WILLIAM\r\n" + "DESTINATIONS\r\n" + "MEETING\r\n" + "SUBSCRIPTION\r\n" + "AMP\r\n" + "NORWAY\r\n"
				+ "ERRORS\r\n" + "AUTHORS\r\n" + "CAR\r\n" + "CLICK\r\n" + "SITE\r\n" + "ROAD\r\n" + "APPROPRIATE\r\n"
				+ "FEW\r\n" + "AWARE\r\n" + "MAKES\r\n" + "TEXT\r\n" + "LYRICS\r\n" + "MENTAL\r\n" + "TEND\r\n"
				+ "BILLY\r\n" + "DUST\r\n" + "EAT\r\n" + "INTERNAL\r\n" + "LARGER\r\n" + "SIEMENS\r\n"
				+ "DISABILITY\r\n" + "VALUABLE\r\n" + "EXAMPLE\r\n" + "TRANS\r\n" + "MOVE\r\n" + "METAL\r\n" + "HIT\r\n"
				+ "CHEMISTRY\r\n" + "CHARLIE\r\n" + "HAT\r\n" + "YOGA\r\n" + "PHASE\r\n" + "PRIVATE\r\n" + "FINISH\r\n"
				+ "CHAIN\r\n" + "AUTOMATIC\r\n" + "POOR\r\n" + "CHARACTERS\r\n" + "POLITICAL\r\n" + "ASSIGNMENT\r\n"
				+ "DELAWARE\r\n" + "MEMORIES\r\n" + "NOTEBOOKS\r\n" + "SONY\r\n" + "VISA\r\n" + "ADMINISTRATIVE\r\n"
				+ "RAW\r\n" + "SIDES\r\n" + "SCREEN\r\n" + "UNIT\r\n" + "TOLL\r\n" + "    BEN\r\n" + "HUMANS\r\n"
				+ "CATEGORIES\r\n" + "AFFILIATES\r\n" + "ACTOR\r\n" + "FORCES\r\n" + "RES\r\n" + "RAY\r\n"
				+ "LITERATURE\r\n" + "DENVER\r\n" + "ARKANSAS\r\n" + "FARM\r\n" + "DIED\r\n" + "BOND\r\n" + "BRIDGE\r\n"
				+ "BOLD\r\n" + "NURSE\r\n" + "SEXUAL\r\n" + "LISA\r\n" + "DEFENCE\r\n" + "BELL\r\n" + "LOWEST\r\n"
				+ "RELEASES\r\n" + "ABSOLUTELY\r\n" + "INSIGHT\r\n" + "VIA\r\n" + "INTELLIGENT\r\n" + "ABSOLUTE\r\n"
				+ "BASIS\r\n" + "ARGENTINA\r\n" + "WILDLIFE\r\n" + "DECREASE\r\n" + "JOINED\r\n" + "LOSS\r\n"
				+ "PRODUCTION\r\n" + "RULES\r\n" + "PROTECTION\r\n" + "POINT\r\n" + "MEANS\r\n" + "SALE\r\n"
				+ "AUTOMATICALLY\r\n" + "BOOKING\r\n" + "QTY\r\n" + "TEMPLATES\r\n" + "REQUESTED\r\n" + "DEL\r\n"
				+ "RESPONSES\r\n" + "CONTRIBUTED\r\n" + "FORECAST\r\n" + "DRUGS\r\n" + "FAST\r\n" + "WINNING\r\n"
				+ "CASUAL\r\n" + "EXCITING\r\n" + "LOADING\r\n" + "DRINKING\r\n" + "LARRY\r\n" + "HUNTING\r\n"
				+ "AUSTRALIAN\r\n" + "DIVISION\r\n" + "CONNECTED\r\n" + "SERVES\r\n" + "REQUIRE\r\n" + "JAVA\r\n"
				+ "CROSS\r\n" + "AGED\r\n" + "EMPLOYED\r\n" + "SHELL\r\n" + "TRANSACTION\r\n" + "PROVIDING\r\n"
				+ "TOURIST\r\n" + "MATERIALS\r\n" + "ACADEMY\r\n" + "HIV\r\n" + "SCAN\r\n" + "MUNICIPAL\r\n"
				+ "SECTORS\r\n" + "GLOBE\r\n" + "NOBODY\r\n" + "ROBERT\r\n" + "WRIGHT\r\n" + "PRETTY\r\n"
				+ "INDICATED\r\n" + "PLACES\r\n" + "EXTREME\r\n" + "NBA\r\n" + "FUNCTION\r\n" + "MANAGING\r\n"
				+ "RELEASE\r\n" + "SIGNIFICANTLY\r\n" + "BUSINESS\r\n" + "MINT\r\n" + "COLLECTION\r\n" + "DISTRICT\r\n"
				+ "REMEMBER\r\n" + "HOLE\r\n" + "PRECISION\r\n" + "CONSUMER\r\n" + "LINDA\r\n" + "PROVE\r\n"
				+ "RANGE\r\n" + "PRESSURE\r\n" + "LISTENING\r\n" + "AUSTRALIA\r\n" + "COVERS\r\n" + "VIAGRA\r\n"
				+ "NOTICES\r\n" + "POLICE\r\n" + "PST\r\n" + "SPIRIT\r\n" + "BELOW\r\n" + "DESIGNED\r\n" + "NFL\r\n"
				+ "IRAQI\r\n" + "SIZE\r\n" + "DOUBT\r\n" + "ESCAPE\r\n" + "CAPS\r\n" + "SEEK\r\n" + "ANYTHING\r\n"
				+ "SYMBOLS\r\n" + "ENSURE\r\n" + "BASKETBALL\r\n" + "GAMES\r\n" + "SELLING\r\n";

		InputStream testInput = new ByteArrayInputStream(data.getBytes("UTF-8"));
		InputStream old = System.in;

		System.setIn(testInput);

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		boolean first = true;

		while (sc.hasNextLine()) {
			if (first) {
				System.out.format("%-9s%-25s%-4s\n", "", "NAME", "SOUNDEX CODE");
				first = false;
			}
			final String inp_line_str = sc.nextLine().trim().replaceAll("\\s+", "");

			char[] inp_char = inp_line_str.toCharArray();

			if (inp_char == null)
				continue;

			sb.append(inp_char[0]);

			int lastChange = calculateExchange(inp_char[0]);

			for (int i = 1; i < inp_char.length; i++) {

				int newChange = calculateExchange(inp_char[i]);
				if (newChange != lastChange && newChange != -1) {
					sb.append(newChange);
				}
				lastChange = newChange;
			}

			sb.append("000\n");
			System.out.format("%-9s%-25s%-4s\n", "", inp_line_str, sb.substring(0, 4).toString().trim());
			sb.delete(0, sb.length());
		}

		System.out.format("%-19s%-13s\n", "", "END OF OUTPUT");
		sc.close();
		System.setIn(old);
	}

//	public static int calculateExchange(char c) {
//		if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'W' || c == 'Y' || c == 'H') {
//			return -1;
//		} else if (c == 'B' || c == 'P' || c == 'F' || c == 'V') {
//			return 1;
//		} else if (c == 'C' || c == 'S' || c == 'K' || c == 'G' || c == 'J' || c == 'Q' || c == 'X' || c == 'Z') {
//			return 2;
//		} else if (c == 'D' || c == 'T') {
//			return 3;
//		} else if (c == 'L') {
//			return 4;
//		} else if (c == 'M' || c == 'N') {
//			return 5;
//		} else if (c == 'R') {
//			return 6;
//		}
//		return -1;
//	}
	
	public static int calculateExchange(char c) {
		if("AEIOUWYH".indexOf(c)!=-1) {
			return -1;
		} else if("BPFV".indexOf(c)!=-1) {
			return 1;
		} else if("CSKGJQXZ".indexOf(c)!=-1) {
			return 2;
		} else if("DT".indexOf(c)!=-1) {
			return 3;
		} else if('L' == c) {
			return 4;
		} else if("MN".indexOf(c)!=-1) {
			return 5;
		} else if('R' == c) {
			return 6;
		}
		
		return -1;
	}

}
