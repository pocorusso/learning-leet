class BinarySearch {
    fun run() {
        println(search(intArrayOf(-1, 0, 5), 5))
        println(search(intArrayOf(-1, 0, 3, 5, 9, 12), 0))
        println(search(intArrayOf(2, 5), 5))
        println(search(intArrayOf(-1), 9))
        println(search(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
        println(search(intArrayOf(-1, 0, 3, 5, 9, 12), -1))
        println(search(intArrayOf(-1, 0, 3, 5, 9, 12), 12))
        println(search(intArrayOf(-1, 0, 3, 5, 9, 12), 2))

        println(search(intArrayOf(-997,-996,-992,-990,-988,-985,-983,-980,-979,-977,-975,-974,-973,-972,-971,-967,-965,-964,-959,-956,-954,-951,-950,-949,-947,-946,-945,-943,-942,-938,-936,-935,-933,-932,-930,-929,-927,-925,-924,-923,-921,-919,-917,-916,-913,-912,-911,-910,-909,-908,-903,-900,-899,-898,-891,-890,-886,-884,-883,-880,-874,-872,-871,-870,-869,-868,-867,-866,-865,-860,-859,-858,-854,-852,-851,-848,-845,-844,-843,-842,-840,-839,-837,-836,-835,-833,-832,-831,-829,-828,-826,-822,-820,-819,-818,-817,-816,-815,-814,-812,-811,-808,-807,-806,-805,-803,-801,-798,-796,-795,-793,-792,-791,-790,-789,-788,-787,-785,-782,-779,-778,-773,-771,-769,-768,-767,-765,-764,-763,-759,-756,-755,-754,-753,-751,-750,-747,-746,-744,-743,-741,-740,-730,-729,-728,-727,-726,-725,-724,-723,-722,-717,-715,-714,-711,-710,-709,-708,-700,-697,-688,-687,-685,-683,-681,-678,-677,-676,-673,-670,-669,-668,-666,-661,-659,-658,-655,-654,-652,-647,-643,-641,-635,-633,-632,-630,-629,-627,-626,-620,-616,-612,-611,-610,-608,-604,-602,-601,-597,-596,-592,-585,-584,-583,-578,-577,-574,-567,-565,-557,-554,-553,-550,-549,-548,-547,-545,-543,-542,-541,-540,-538,-535,-532,-531,-530,-528,-526,-524,-522,-521,-520,-519,-518,-517,-516,-508,-507,-506,-504,-502,-499,-497,-496,-495,-492,-485,-484,-483,-482,-478,-477,-474,-473,-472,-471,-465,-464,-462,-461,-457,-453,-452,-450,-448,-447,-446,-445,-444,-442,-441,-440,-439,-438,-437,-436,-435,-434,-432,-430,-429,-427,-425,-424,-421,-419,-417,-412,-411,-409,-405,-404,-403,-398,-397,-395,-390,-388,-387,-385,-384,-383,-378,-377,-376,-374,-370,-365,-364,-362,-361,-356,-352,-351,-350,-346,-343,-342,-340,-339,-338,-336,-334,-332,-329,-327,-326,-325,-324,-322,-320,-318,-316,-315,-314,-310,-309,-305,-304,-303,-301,-300,-298,-297,-291,-290,-288,-286,-284,-282,-278,-277,-276,-271,-269,-267,-266,-265,-264,-263,-259,-258,-256,-255,-253,-252,-251,-250,-249,-245,-244,-240,-239,-236,-234,-232,-227,-226,-222,-219,-217,-216,-213,-212,-211,-210,-209,-208,-207,-205,-203,-202,-197,-196,-194,-193,-192,-190,-189,-188,-187,-186,-185,-183,-182,-181,-180,-179,-178,-176,-175,-174,-172,-170,-168,-167,-166,-163,-162,-161,-157,-156,-155,-148,-147,-145,-144,-143,-139,-137,-135,-133,-131,-128,-121,-120,-119,-117,-114,-112,-111,-109,-107,-106,-104,-102,-97,-95,-94,-93,-91,-88,-87,-85,-82,-80,-79,-78,-77,-76,-75,-74,-73,-66,-63,-59,-58,-57,-53,-52,-51,-50,-49,-47,-46,-45,-42,-40,-38,-36,-35,-34,-33,-32,-28,-27,-26,-25,-24,-21,-14,-9,-3,-1,0,2,3,7,9,11,13,17,19,20,21,22,23,26,28,31,33,36,37,38,39,41,42,47,48,51,53,54,56,57,58,60,63,65,67,72,73,74,76,78,80,82,85,86,91,92,93,94,99,101,102,103,104,105,107,112,114,115,119,120,122,123,125,126,127,128,130,133,137,139,140,141,142,145,146,148,151,156,157,158,161,163,164,167,172,174,176,177,179,189,191,199,201,202,203,206,210,211,213,214,217,218,220,221,222,223,226,236,237,240,241,244,245,250,251,252,253,254,255,257,258,261,262,265,266,271,272,273,275,276,278,279,281,284,289,291,294,295,296,298,299,300,302,303,306,307,308,309,310,311,313,314,315,316,319,320,328,333,334,339,341,343,344,345,347,349,352,353,356,360,361,362,364,366,367,369,371,373,376,377,378,379,381,383,386,387,388,390,392,393,394,396,397,398,399,400,401,403,406,413,415,416,419,421,426,428,432,435,436,438,439,440,441,444,445,448,450,455,456,457,459,460,463,466,467,471,473,474,475,476,477,478,479,480,484,485,486,487,489,490,492,497,498,500,501,502,504,505,507,508,509,510,511,513,514,515,516,520,521,528,535,538,542,545,546,547,548,553,556,557,558,559,561,562,563,565,566,567,570,572,573,575,576,577,578,579,580,581,583,585,586,591,592,594,595,598,599,601,607,608,610,613,614,617,621,625,628,631,632,633,635,637,639,640,644,648,650,652,656,660,661,662,664,665,666,667,669,670,671,672,676,677,680,681,682,683,684,686,688,689,690,691,692,693,694,695,696,698,700,701,706,707,709,712,713,718,719,724,725,727,728,731,733,734,740,741,742,744,746,749,750,751,753,754,755,756,758,761,763,764,766,771,772,773,774,776,777,778,779,780,781,785,786,787,792,793,796,798,800,801,802,804,808,810,812,813,814,815,817,821,823,825,826,828,829,830,833,834,843,844,845,850,854,856,857,859,860,862,863,864,865,866,867,868,869,872,873,874,876,877,880,881,883,884,886,887,888,889,891,892,893,894,896,897,898,901,905,906,907,908,910,911,912,913,914,917,920,921,923,924,925,926,927,929,931,932,936,939,940,943,944,947,952,954,956,959,960,963,965,969,970,972,973,974,975,981,985,986,987,988,989,991,995,996,997,998),656))
    }

    fun search(nums: IntArray, target: Int): Int {
//        if (target == nums[0]) return 0
//        if( nums.size > 1 && target == nums[1]) return 1

        var max = nums.size - 1
        var min = 0

        while (min <= max) {
            val mid = ((max - min) / 2) + min
            when {
                target == nums[mid] -> return mid
                target > nums[mid] -> min = mid + 1
                target < nums[mid] -> max = mid - 1
            }
        }
        return -1
    }

}