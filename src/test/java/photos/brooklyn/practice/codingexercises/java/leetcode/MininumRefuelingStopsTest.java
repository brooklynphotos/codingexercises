package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static org.junit.Assert.*;

public class MininumRefuelingStopsTest {
    private final MininumRefuelingStopsDFS obj = new MininumRefuelingStopsDFS();
//    private final MininumRefuelingStopsGreedy obj = new MininumRefuelingStopsGreedy();
//    private final MininumRefuelingStops obj = new MininumRefuelingStops();
    private long start;
    @Rule public final TestName testName = new TestName();

    @Before
    public void setup(){
        start = System.currentTimeMillis();
    }

    @Test
    public void minRefuelStopsNoStop() {
        assertEquals(obj.minRefuelStops(1, 1, new int[][]{}), 0);
    }

    @Test
    public void minRefuelStopsImpossible1() {
        assertEquals(obj.minRefuelStops(100, 1, new int[][]{{10, 100}}), -1);
    }

    @Test
    public void minRefuelStopsImpossible2() {
        assertEquals(obj.minRefuelStops(100, 50, new int[][]{{25, 30}}), -1);
    }

    @Test
    public void minRefuelStops_2() {
        assertEquals(obj.minRefuelStops(100, 10, new int[][]{{10,60},{20,30},{30,30},{60,40}}), 2);
    }

    @Test
    public void minRefuelStops_1() {
        assertEquals(obj.minRefuelStops(100, 50, new int[][]{{50,50}}), 1);
    }

    @Test
    public void minRefuelStops_4() {
        final int[][] station = {{42,39},{132,236},{166,142},{434,7},{462,80},{518,103},{545,209},{656,104},{769,137},{811,67}};
        assertEquals(obj.minRefuelStops(1000, 299, station), 4);
        printDuration(station);
    }

    @Test
    public void minRefuelStops_4_1() {
        final int[][] station = {{13,21},{26,115},{100,47},{225,99},{299,141},{444,198},{608,190},{636,157},{647,255},{841,123}};
        assertEquals(obj.minRefuelStops(1000, 299, station), 4);
        printDuration(station);
    }

    @Test
    public void minRefuelStops_long() {
        final int[][] stations = {{32131797,142290934},{86397166,44642653},{99237057,56978680},{130019011,99649968},{154227249,90514223},{198652959,102942413},{272491487,108474929},{282220105,83721209},{302284128,43151624},{318501736,107636032},{359336452,73807027},{425903682,43078334},{447483572,53751173},{469840976,57311636},{472584505,57629539},{531147470,106487691},{611722638,111485731},{650472592,20105771},{692670691,141572192},{747847056,7972504},{800899205,106134661},{825649709,136473550},{880534339,72135820},{887048383,73776979},{967172408,58930710}};
        assertEquals(obj.minRefuelStops(1000000000, 145267354, stations), 8);
        printDuration(stations);
    }

    @Test
    public void minRefuelStops_long_2() {
        final int[][] stations ={{2,76},{25,160},{32,161},{36,161},{45,128},{55,198},{62,94},{64,128},{73,169},{76,154},{88,219},{91,88},{97,69},{103,121},{104,17},{109,64},{110,7},{112,44},{117,29},{121,218},{136,40},{154,136},{159,203},{179,61},{180,196},{191,48},{195,180},{196,17},{226,90},{236,219},{237,95},{239,19},{241,88},{275,133},{276,85},{292,38},{310,98},{316,229},{327,228},{337,156},{339,207},{348,45},{369,19},{374,142},{376,19},{382,164},{384,33},{392,159},{433,84},{436,135},{454,96},{455,197},{460,209},{491,212},{495,128},{513,119},{535,44},{543,189},{551,22},{571,19},{582,6},{584,53},{598,141},{603,93},{605,4},{606,245},{619,142},{625,168},{649,217},{663,32},{668,44},{685,159},{690,73},{692,197},{707,247},{711,14},{713,103},{729,142},{735,243},{764,249},{790,28},{797,56},{813,69},{833,100},{839,67},{842,51},{848,106},{859,44},{860,39},{889,156},{901,124},{903,160},{916,21},{921,114},{925,121},{930,170},{942,39},{950,110},{962,135},{966,249}};
        assertEquals(obj.minRefuelStops(1000, 36,stations), 5);
        printDuration(stations);
    }

    @Test
    public void minRefuelStops_long_3() {
        final int[][] stations = {{5590343,172199995},{9597925,66959980},{17458877,25410843},{19316850,171475405},{26734512,165021255},{27818085,173857453},{32799645,120085267},{36595033,14698294},{43748247,148152449},{47055296,16557052},{62883650,32815835},{89987371,135718126},{101735352,142551315},{116605238,76573199},{122305661,141851496},{124627898,75812909},{129939726,101400194},{130782901,1229002},{139284467,98956784},{152275623,67585912},{221981391,109569180},{225518008,131873374},{241091549,147281246},{243368018,109154669},{244945616,125644479},{256331324,181550873},{267096222,121425286},{271708669,96907241},{273286224,183629825},{279057376,128533710},{279250783,97255151},{286272139,79593},{289292272,24004116},{304193781,14000757},{322555901,104089751},{337941633,130219125},{339613715,82056278},{359029274,48173733},{376778553,62303813},{380744805,143979248},{388651507,51624325},{424233832,92077586},{427498760,181216682},{433329344,92849754},{446037055,90926817},{448406642,164092000},{472019828,138336382},{481310088,171132953},{488754242,191903001},{492150652,12474268},{499399493,24231976},{502884368,124644534},{517420684,70368679},{530662198,135330392},{544845174,38932093},{545744872,161378587},{557359624,60485042},{565591334,40519269},{591822314,73067602},{593497302,32637244},{599458701,133279255},{601087436,120984599},{609586775,136893327},{612060407,113418115},{622494251,60932192},{656830970,78597867},{658728270,135101135},{678794253,32470338},{690468550,56228115},{693303020,26115826},{724003103,64015308},{735662404,83665467},{737685789,48798388},{757747925,27613507},{762124016,160915769},{763315975,176170695},{777724356,43588855},{798364978,29647913},{799826931,16955999},{802171402,44218112},{805220468,151736602},{806185064,3651245},{810948951,50567125},{816952574,14035934},{826725378,2991927},{846539629,185201851},{883733128,121632399},{886444032,87734701},{889034803,50478289},{895631192,143903951},{902629824,133494421},{908038570,83258331},{913511561,158282511},{941354375,172455018},{945194154,50242772},{960006712,92607298},{967932785,41803136},{983630047,74577298},{989716164,58797029},{996410123,111248584}};
        assertEquals(obj.minRefuelStops(1000000000,38810519, stations),6);
        printDuration(stations);
    }

    @Test
    public void minRefuelStops_long_4() {
        final int[][] stations = {{1,193},{14,82},{16,128},{18,121},{22,155},{26,46},{34,181},{35,135},{36,193},{40,129},{41,191},{43,190},{44,3},{45,153},{49,192},{50,145},{51,44},{53,126},{58,185},{59,102},{60,103},{62,13},{64,183},{67,27},{68,155},{70,27},{71,149},{72,130},{73,32},{74,114},{77,6},{79,195},{80,113},{82,128},{84,101},{85,169},{88,140},{92,87},{93,165},{94,71},{97,124},{100,12},{103,131},{104,40},{107,149},{108,131},{109,40},{110,33},{114,172},{116,164},{117,162},{119,154},{120,80},{121,112},{123,109},{126,23},{127,85},{128,76},{129,64},{134,132},{136,21},{137,164},{138,174},{139,153},{141,108},{142,118},{143,174},{144,39},{145,176},{147,178},{149,52},{151,13},{153,103},{154,27},{157,81},{158,120},{159,53},{162,46},{163,120},{165,32},{167,35},{169,26},{170,134},{176,32},{179,13},{181,19},{182,5},{185,197},{186,18},{189,81},{190,91},{191,42},{193,153},{194,4},{196,62},{199,18},{202,108},{203,108},{204,62},{209,159},{211,131},{213,36},{215,3},{216,62},{217,155},{219,81},{220,153},{221,186},{222,30},{224,192},{226,115},{227,171},{228,153},{229,177},{232,127},{234,110},{235,78},{237,155},{239,154},{240,151},{242,14},{244,188},{247,88},{248,3},{249,21},{254,111},{256,17},{258,122},{260,143},{263,95},{264,153},{265,21},{266,98},{268,184},{270,120},{271,22},{273,158},{277,144},{279,166},{285,21},{287,154},{290,16},{293,143},{296,85},{297,177},{299,124},{306,37},{307,162},{308,5},{309,2},{310,26},{313,136},{315,8},{317,72},{320,192},{321,151},{326,65},{328,82},{332,53},{333,56},{335,7},{336,145},{337,108},{339,37},{341,132},{344,86},{345,112},{348,127},{349,32},{353,153},{354,80},{356,198},{358,109},{360,15},{362,63},{363,143},{364,196},{365,9},{366,166},{368,136},{372,37},{375,184},{376,76},{380,72},{381,166},{382,95},{383,81},{384,93},{386,180},{387,172},{397,46},{399,125},{400,152},{402,80},{405,82},{406,169},{408,92},{410,188},{411,167},{413,193},{416,116},{423,61},{424,19},{425,198},{426,15},{428,185},{432,89},{434,121},{435,99},{440,73},{441,195},{442,81},{444,150},{446,132},{448,17},{449,132},{450,81},{451,144},{453,142},{455,172},{456,184},{457,144},{459,89},{461,85},{462,79},{465,172},{468,152},{470,121},{472,170},{473,138},{474,14},{475,33},{477,177},{478,168},{481,11},{485,150},{489,10},{490,88},{492,127},{494,30},{496,149},{497,66},{500,163},{502,91},{505,2},{506,65},{507,162},{508,61},{510,47},{511,96},{512,5},{513,124},{514,184},{515,148},{517,98},{518,19},{520,48},{521,114},{522,188},{523,10},{527,146},{530,13},{532,162},{534,162},{535,33},{536,150},{537,49},{539,86},{541,24},{544,155},{545,109},{546,184},{548,107},{551,58},{555,170},{557,187},{560,60},{562,107},{563,76},{564,16},{565,95},{566,10},{568,123},{570,157},{571,171},{572,79},{573,88},{574,48},{575,135},{577,58},{579,26},{582,142},{587,134},{597,153},{598,153},{599,164},{600,70},{606,189},{607,106},{609,127},{610,40},{611,40},{612,61},{613,144},{616,116},{617,65},{619,20},{620,145},{623,63},{624,130},{630,156},{631,132},{633,172},{634,112},{635,175},{639,3},{642,112},{643,34},{645,99},{646,141},{647,124},{648,191},{653,9},{654,145},{655,36},{658,144},{664,5},{667,116},{671,17},{673,83},{674,51},{676,63},{677,52},{683,151},{685,73},{686,1},{687,101},{688,31},{690,153},{691,71},{692,196},{693,98},{694,55},{695,134},{696,71},{697,138},{698,24},{700,166},{702,21},{705,107},{707,15},{712,12},{714,174},{715,174},{720,20},{728,12},{729,167},{730,157},{733,56},{734,101},{735,136},{738,110},{740,161},{741,167},{746,57},{748,97},{752,44},{753,172},{755,174},{756,153},{757,104},{763,139},{765,67},{769,108},{772,161},{773,185},{774,121},{775,183},{777,141},{780,78},{782,76},{784,119},{785,71},{786,26},{788,15},{789,69},{790,154},{793,184},{796,76},{797,101},{798,73},{799,52},{802,38},{805,171},{806,108},{807,73},{809,200},{811,23},{812,87},{813,137},{814,16},{815,80},{816,47},{817,39},{818,56},{819,154},{820,146},{821,117},{822,146},{823,108},{824,96},{826,121},{827,51},{828,171},{831,20},{832,3},{833,107},{835,182},{836,145},{837,62},{838,180},{842,137},{845,128},{846,44},{850,121},{855,121},{856,191},{857,105},{863,115},{864,128},{866,183},{867,33},{868,160},{870,103},{871,64},{872,136},{876,182},{878,16},{880,168},{884,31},{887,142},{890,160},{894,104},{895,43},{896,167},{897,65},{898,123},{902,135},{903,132},{904,63},{905,168},{906,3},{908,139},{909,84},{913,33},{914,88},{915,142},{917,182},{918,159},{919,185},{920,3},{922,115},{925,155},{926,40},{927,175},{928,87},{934,168},{935,27},{937,125},{939,4},{941,72},{942,156},{944,148},{945,18},{950,82},{952,175},{955,85},{957,194},{963,28},{966,143},{969,31},{970,97},{971,73},{972,37},{973,14},{974,83},{978,104},{979,140},{981,144},{983,89},{985,126},{988,61},{989,36},{991,191},{993,200},{994,176},{995,14},{997,77},{998,79},{999,40}};
        assertEquals(obj.minRefuelStops(1000,1, stations),6);
        printDuration(stations);
    }

    @Test
    public void minRefuelStops_long_5() {
        final int[][] stations = {{1,248},{2,145},{3,176},{7,161},{8,114},{10,13},{11,199},{13,104},{14,41},{15,29},{21,138},{23,214},{24,66},{27,66},{29,223},{31,210},{33,108},{34,227},{36,117},{37,120},{40,128},{41,80},{42,89},{44,86},{45,209},{48,61},{50,132},{52,101},{54,118},{55,158},{56,202},{57,1},{58,164},{59,244},{60,60},{61,90},{62,172},{63,77},{64,93},{65,3},{66,229},{71,89},{73,42},{75,35},{76,41},{77,207},{78,49},{82,158},{88,39},{89,135},{90,33},{92,184},{96,212},{99,225},{100,48},{103,222},{104,229},{106,172},{107,26},{108,158},{109,67},{110,112},{112,234},{116,229},{119,224},{122,69},{123,126},{124,115},{127,247},{130,128},{131,4},{133,168},{136,34},{139,45},{141,44},{142,193},{144,118},{149,94},{151,37},{154,60},{155,221},{157,245},{158,17},{164,154},{165,120},{169,165},{171,135},{173,38},{175,64},{176,100},{177,37},{182,215},{184,101},{189,41},{190,104},{191,246},{192,24},{193,49},{195,76},{200,129},{202,171},{203,227},{204,36},{205,52},{206,72},{207,110},{208,124},{209,222},{212,226},{213,233},{215,74},{217,242},{218,38},{220,103},{221,214},{223,219},{225,42},{226,43},{227,189},{229,245},{231,192},{232,182},{233,61},{236,180},{244,99},{245,160},{247,34},{248,33},{250,44},{255,55},{257,93},{258,72},{259,144},{260,38},{261,163},{262,56},{263,164},{265,82},{267,247},{268,27},{269,10},{270,191},{273,120},{274,85},{275,249},{276,237},{277,19},{278,108},{280,2},{282,137},{287,207},{290,173},{291,109},{294,32},{296,248},{302,70},{304,128},{305,14},{306,168},{307,100},{308,243},{315,68},{316,78},{318,27},{319,95},{321,107},{323,193},{327,69},{329,172},{331,235},{333,196},{335,118},{341,76},{342,171},{346,87},{349,25},{356,5},{357,32},{360,4},{361,30},{363,240},{364,182},{368,83},{371,20},{372,97},{373,51},{374,82},{375,235},{377,46},{379,206},{381,8},{382,108},{383,98},{384,227},{385,233},{390,164},{391,250},{394,225},{397,145},{403,227},{404,12},{405,14},{410,55},{414,43},{415,47},{417,100},{418,239},{420,12},{421,146},{422,48},{425,169},{426,12},{428,157},{430,159},{432,50},{433,124},{434,178},{435,169},{436,106},{438,207},{439,232},{440,182},{441,132},{442,226},{444,141},{445,124},{449,181},{451,107},{453,98},{454,5},{455,230},{457,58},{458,154},{460,240},{461,114},{462,94},{464,200},{466,223},{470,49},{472,120},{474,153},{476,229},{479,211},{482,180},{486,18},{488,102},{491,154},{492,56},{495,69},{496,172},{500,36},{501,234},{503,234},{509,134},{513,13},{514,208},{515,10},{516,67},{517,100},{518,46},{519,79},{520,154},{525,59},{529,132},{531,5},{532,97},{533,110},{534,198},{535,222},{538,23},{541,246},{542,56},{544,171},{545,103},{548,142},{549,10},{551,55},{556,67},{557,4},{559,66},{560,46},{561,232},{568,194},{570,18},{571,7},{572,125},{574,143},{575,81},{577,232},{578,158},{579,188},{581,19},{582,92},{586,107},{588,127},{589,127},{591,238},{592,83},{593,140},{594,87},{595,13},{596,101},{597,65},{602,23},{606,17},{607,231},{610,105},{611,147},{613,84},{618,183},{619,118},{620,29},{621,90},{622,213},{623,138},{624,16},{625,19},{626,177},{627,238},{628,217},{631,208},{632,55},{633,14},{634,132},{639,181},{644,104},{648,23},{649,48},{651,64},{653,175},{654,44},{655,77},{659,38},{660,56},{661,186},{662,163},{664,79},{666,228},{667,43},{668,29},{671,242},{674,196},{675,174},{677,44},{678,22},{679,143},{680,198},{681,219},{682,167},{683,132},{687,177},{688,135},{694,59},{696,50},{697,68},{706,68},{707,187},{708,240},{709,203},{710,58},{711,100},{712,232},{714,60},{716,104},{718,146},{721,176},{724,10},{726,66},{727,100},{728,235},{730,196},{731,213},{732,29},{734,226},{735,250},{736,150},{737,110},{739,39},{740,98},{742,18},{745,80},{748,209},{751,91},{753,186},{755,19},{756,94},{759,212},{762,239},{763,243},{765,225},{766,59},{768,234},{770,183},{771,170},{772,189},{774,176},{776,145},{778,53},{780,34},{781,78},{782,41},{783,228},{784,187},{785,24},{787,221},{792,242},{793,84},{796,30},{798,58},{800,150},{803,224},{805,92},{806,169},{807,133},{808,66},{809,103},{810,207},{812,23},{813,250},{814,110},{815,14},{816,147},{818,42},{819,17},{821,100},{822,234},{825,104},{827,201},{831,125},{832,46},{833,162},{834,52},{838,82},{839,177},{840,93},{843,194},{851,218},{852,132},{853,157},{854,71},{855,111},{857,232},{860,142},{861,145},{862,13},{863,123},{864,223},{865,31},{868,224},{871,222},{873,117},{875,142},{876,214},{877,55},{879,52},{880,227},{881,98},{886,15},{889,119},{891,188},{893,41},{896,79},{901,217},{904,94},{907,136},{908,149},{910,214},{911,135},{913,48},{916,28},{917,31},{922,20},{924,10},{927,131},{929,128},{931,221},{936,210},{939,108},{942,192},{948,247},{951,82},{952,133},{955,230},{957,147},{959,221},{961,160},{963,28},{965,230},{966,231},{967,48},{973,108},{976,76},{979,150},{980,36},{983,182},{994,74},{995,229},{996,14},{998,40},{999,99}};
        assertEquals(obj.minRefuelStops(1000,1, stations),5);
        printDuration(stations);
    }

    private void printDuration(final int[][] stations) {
        System.out.printf("%s: [%d] %d%n",testName.getMethodName(),stations.length,System.currentTimeMillis()-start);
    }
}