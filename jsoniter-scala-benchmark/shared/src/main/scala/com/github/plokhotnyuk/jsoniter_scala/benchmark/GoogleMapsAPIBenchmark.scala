package com.github.plokhotnyuk.jsoniter_scala.benchmark

import java.nio.charset.StandardCharsets.UTF_8

import com.github.plokhotnyuk.jsoniter_scala.benchmark.JsoniterScalaCodecs._
import com.github.plokhotnyuk.jsoniter_scala.core._

abstract class GoogleMapsAPIBenchmark extends CommonParams {
  //Distance Matrix API call for top-10 by population cities in US:
  //https://maps.googleapis.com/maps/api/distancematrix/json?origins=New+York|Los+Angeles|Chicago|Houston|Phoenix+AZ|Philadelphia|San+Antonio|San+Diego|Dallas|San+Jose&destinations=New+York|Los+Angeles|Chicago|Houston|Phoenix+AZ|Philadelphia|San+Antonio|San+Diego|Dallas|San+Jose
  var jsonString1: String =
    """{
      |  "destination_addresses" : [
      |    "New York, NY, USA",
      |    "Los Angeles, CA, USA",
      |    "Chicago, IL, USA",
      |    "Houston, TX, USA",
      |    "Phoenix, AZ, USA",
      |    "Philadelphia, PA, USA",
      |    "San Antonio, TX, USA",
      |    "San Diego, CA, USA",
      |    "Dallas, TX, USA",
      |    "San Jose, CA, USA"
      |  ],
      |  "origin_addresses" : [
      |    "New York, NY, USA",
      |    "Los Angeles, CA, USA",
      |    "Chicago, IL, USA",
      |    "Houston, TX, USA",
      |    "Phoenix, AZ, USA",
      |    "Philadelphia, PA, USA",
      |    "San Antonio, TX, USA",
      |    "San Diego, CA, USA",
      |    "Dallas, TX, USA",
      |    "San Jose, CA, USA"
      |  ],
      |  "rows" : [
      |    {
      |      "elements" : [
      |        {
      |          "distance" : {
      |            "text" : "1 m",
      |            "value" : 0
      |          },
      |          "duration" : {
      |            "text" : "1 min",
      |            "value" : 0
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "4,490 km",
      |            "value" : 4489862
      |          },
      |          "duration" : {
      |            "text" : "1 day 16 hours",
      |            "value" : 145589
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1,270 km",
      |            "value" : 1270445
      |          },
      |          "duration" : {
      |            "text" : "12 hours 10 mins",
      |            "value" : 43773
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,621 km",
      |            "value" : 2620658
      |          },
      |          "duration" : {
      |            "text" : "23 hours 55 mins",
      |            "value" : 86073
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "3,876 km",
      |            "value" : 3875676
      |          },
      |          "duration" : {
      |            "text" : "1 day 12 hours",
      |            "value" : 129040
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "158 km",
      |            "value" : 158242
      |          },
      |          "duration" : {
      |            "text" : "1 hour 55 mins",
      |            "value" : 6885
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,935 km",
      |            "value" : 2934803
      |          },
      |          "duration" : {
      |            "text" : "1 day 3 hours",
      |            "value" : 96322
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "4,443 km",
      |            "value" : 4443412
      |          },
      |          "duration" : {
      |            "text" : "1 day 17 hours",
      |            "value" : 147406
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,492 km",
      |            "value" : 2492302
      |          },
      |          "duration" : {
      |            "text" : "22 hours 53 mins",
      |            "value" : 82371
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "4,728 km",
      |            "value" : 4728294
      |          },
      |          "duration" : {
      |            "text" : "1 day 19 hours",
      |            "value" : 154228
      |          },
      |          "status" : "OK"
      |        }
      |      ]
      |    },
      |    {
      |      "elements" : [
      |        {
      |          "distance" : {
      |            "text" : "4,501 km",
      |            "value" : 4501326
      |          },
      |          "duration" : {
      |            "text" : "1 day 16 hours",
      |            "value" : 145282
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1 m",
      |            "value" : 0
      |          },
      |          "duration" : {
      |            "text" : "1 min",
      |            "value" : 0
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "3,244 km",
      |            "value" : 3243718
      |          },
      |          "duration" : {
      |            "text" : "1 day 5 hours",
      |            "value" : 103355
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,491 km",
      |            "value" : 2491140
      |          },
      |          "duration" : {
      |            "text" : "21 hours 48 mins",
      |            "value" : 78485
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "600 km",
      |            "value" : 600314
      |          },
      |          "duration" : {
      |            "text" : "5 hours 29 mins",
      |            "value" : 19738
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "4,368 km",
      |            "value" : 4368094
      |          },
      |          "duration" : {
      |            "text" : "1 day 15 hours",
      |            "value" : 141933
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,177 km",
      |            "value" : 2176782
      |          },
      |          "duration" : {
      |            "text" : "19 hours 3 mins",
      |            "value" : 68584
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "194 km",
      |            "value" : 193646
      |          },
      |          "duration" : {
      |            "text" : "1 hour 57 mins",
      |            "value" : 7042
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,312 km",
      |            "value" : 2311734
      |          },
      |          "duration" : {
      |            "text" : "20 hours 25 mins",
      |            "value" : 73503
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "547 km",
      |            "value" : 546932
      |          },
      |          "duration" : {
      |            "text" : "5 hours 11 mins",
      |            "value" : 18651
      |          },
      |          "status" : "OK"
      |        }
      |      ]
      |    },
      |    {
      |      "elements" : [
      |        {
      |          "distance" : {
      |            "text" : "1,282 km",
      |            "value" : 1281616
      |          },
      |          "duration" : {
      |            "text" : "12 hours 8 mins",
      |            "value" : 43678
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "3,243 km",
      |            "value" : 3242543
      |          },
      |          "duration" : {
      |            "text" : "1 day 5 hours",
      |            "value" : 103349
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1 m",
      |            "value" : 0
      |          },
      |          "duration" : {
      |            "text" : "1 min",
      |            "value" : 0
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1,742 km",
      |            "value" : 1741571
      |          },
      |          "duration" : {
      |            "text" : "16 hours 11 mins",
      |            "value" : 58255
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,821 km",
      |            "value" : 2821137
      |          },
      |          "duration" : {
      |            "text" : "1 day 2 hours",
      |            "value" : 92449
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1,220 km",
      |            "value" : 1219825
      |          },
      |          "duration" : {
      |            "text" : "11 hours 27 mins",
      |            "value" : 41212
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1,997 km",
      |            "value" : 1996514
      |          },
      |          "duration" : {
      |            "text" : "18 hours 4 mins",
      |            "value" : 65059
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "3,342 km",
      |            "value" : 3341754
      |          },
      |          "duration" : {
      |            "text" : "1 day 6 hours",
      |            "value" : 106407
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1,490 km",
      |            "value" : 1489726
      |          },
      |          "duration" : {
      |            "text" : "14 hours 2 mins",
      |            "value" : 50540
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "3,481 km",
      |            "value" : 3480975
      |          },
      |          "duration" : {
      |            "text" : "1 day 7 hours",
      |            "value" : 111989
      |          },
      |          "status" : "OK"
      |        }
      |      ]
      |    },
      |    {
      |      "elements" : [
      |        {
      |          "distance" : {
      |            "text" : "2,624 km",
      |            "value" : 2623641
      |          },
      |          "duration" : {
      |            "text" : "23 hours 58 mins",
      |            "value" : 86258
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,488 km",
      |            "value" : 2488117
      |          },
      |          "duration" : {
      |            "text" : "21 hours 49 mins",
      |            "value" : 78547
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1,742 km",
      |            "value" : 1741761
      |          },
      |          "duration" : {
      |            "text" : "16 hours 13 mins",
      |            "value" : 58360
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1 m",
      |            "value" : 0
      |          },
      |          "duration" : {
      |            "text" : "1 min",
      |            "value" : 0
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1,890 km",
      |            "value" : 1889580
      |          },
      |          "duration" : {
      |            "text" : "16 hours 28 mins",
      |            "value" : 59289
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,489 km",
      |            "value" : 2489250
      |          },
      |          "duration" : {
      |            "text" : "22 hours 42 mins",
      |            "value" : 81704
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "317 km",
      |            "value" : 317168
      |          },
      |          "duration" : {
      |            "text" : "2 hours 55 mins",
      |            "value" : 10481
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,363 km",
      |            "value" : 2362972
      |          },
      |          "duration" : {
      |            "text" : "20 hours 36 mins",
      |            "value" : 74158
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "385 km",
      |            "value" : 384812
      |          },
      |          "duration" : {
      |            "text" : "3 hours 26 mins",
      |            "value" : 12385
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "3,033 km",
      |            "value" : 3033431
      |          },
      |          "duration" : {
      |            "text" : "1 day 3 hours",
      |            "value" : 96387
      |          },
      |          "status" : "OK"
      |        }
      |      ]
      |    },
      |    {
      |      "elements" : [
      |        {
      |          "distance" : {
      |            "text" : "3,885 km",
      |            "value" : 3884549
      |          },
      |          "duration" : {
      |            "text" : "1 day 12 hours",
      |            "value" : 128892
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "599 km",
      |            "value" : 598636
      |          },
      |          "duration" : {
      |            "text" : "5 hours 32 mins",
      |            "value" : 19898
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,829 km",
      |            "value" : 2828868
      |          },
      |          "duration" : {
      |            "text" : "1 day 2 hours",
      |            "value" : 92370
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1,893 km",
      |            "value" : 1892718
      |          },
      |          "duration" : {
      |            "text" : "16 hours 31 mins",
      |            "value" : 59432
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1 m",
      |            "value" : 0
      |          },
      |          "duration" : {
      |            "text" : "1 min",
      |            "value" : 0
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "3,776 km",
      |            "value" : 3776390
      |          },
      |          "duration" : {
      |            "text" : "1 day 11 hours",
      |            "value" : 124555
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1,578 km",
      |            "value" : 1578360
      |          },
      |          "duration" : {
      |            "text" : "13 hours 46 mins",
      |            "value" : 49532
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "571 km",
      |            "value" : 570657
      |          },
      |          "duration" : {
      |            "text" : "5 hours 17 mins",
      |            "value" : 19041
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1,713 km",
      |            "value" : 1713312
      |          },
      |          "duration" : {
      |            "text" : "15 hours 8 mins",
      |            "value" : 54450
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1,144 km",
      |            "value" : 1143951
      |          },
      |          "duration" : {
      |            "text" : "10 hours 29 mins",
      |            "value" : 37738
      |          },
      |          "status" : "OK"
      |        }
      |      ]
      |    },
      |    {
      |      "elements" : [
      |        {
      |          "distance" : {
      |            "text" : "159 km",
      |            "value" : 158684
      |          },
      |          "duration" : {
      |            "text" : "1 hour 53 mins",
      |            "value" : 6753
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "4,363 km",
      |            "value" : 4362509
      |          },
      |          "duration" : {
      |            "text" : "1 day 16 hours",
      |            "value" : 142324
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1,221 km",
      |            "value" : 1220728
      |          },
      |          "duration" : {
      |            "text" : "11 hours 30 mins",
      |            "value" : 41424
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,488 km",
      |            "value" : 2487984
      |          },
      |          "duration" : {
      |            "text" : "22 hours 37 mins",
      |            "value" : 81429
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "3,769 km",
      |            "value" : 3769346
      |          },
      |          "duration" : {
      |            "text" : "1 day 11 hours",
      |            "value" : 124752
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1 m",
      |            "value" : 0
      |          },
      |          "duration" : {
      |            "text" : "1 min",
      |            "value" : 0
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,802 km",
      |            "value" : 2802129
      |          },
      |          "duration" : {
      |            "text" : "1 day 1 hour",
      |            "value" : 91677
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "4,337 km",
      |            "value" : 4337082
      |          },
      |          "duration" : {
      |            "text" : "1 day 16 hours",
      |            "value" : 143118
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,360 km",
      |            "value" : 2359628
      |          },
      |          "duration" : {
      |            "text" : "21 hours 35 mins",
      |            "value" : 77726
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "4,679 km",
      |            "value" : 4678576
      |          },
      |          "duration" : {
      |            "text" : "1 day 18 hours",
      |            "value" : 151879
      |          },
      |          "status" : "OK"
      |        }
      |      ]
      |    },
      |    {
      |      "elements" : [
      |        {
      |          "distance" : {
      |            "text" : "2,939 km",
      |            "value" : 2938513
      |          },
      |          "duration" : {
      |            "text" : "1 day 3 hours",
      |            "value" : 96477
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,178 km",
      |            "value" : 2178117
      |          },
      |          "duration" : {
      |            "text" : "19 hours 6 mins",
      |            "value" : 68773
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1,996 km",
      |            "value" : 1996414
      |          },
      |          "duration" : {
      |            "text" : "18 hours 3 mins",
      |            "value" : 64959
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "318 km",
      |            "value" : 317558
      |          },
      |          "duration" : {
      |            "text" : "2 hours 54 mins",
      |            "value" : 10436
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1,580 km",
      |            "value" : 1579581
      |          },
      |          "duration" : {
      |            "text" : "13 hours 45 mins",
      |            "value" : 49515
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,804 km",
      |            "value" : 2804123
      |          },
      |          "duration" : {
      |            "text" : "1 day 2 hours",
      |            "value" : 91923
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1 m",
      |            "value" : 0
      |          },
      |          "duration" : {
      |            "text" : "1 min",
      |            "value" : 0
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,053 km",
      |            "value" : 2052972
      |          },
      |          "duration" : {
      |            "text" : "17 hours 53 mins",
      |            "value" : 64384
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "440 km",
      |            "value" : 440485
      |          },
      |          "duration" : {
      |            "text" : "4 hours 7 mins",
      |            "value" : 14809
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,723 km",
      |            "value" : 2723432
      |          },
      |          "duration" : {
      |            "text" : "1 day 0 hours",
      |            "value" : 86613
      |          },
      |          "status" : "OK"
      |        }
      |      ]
      |    },
      |    {
      |      "elements" : [
      |        {
      |          "distance" : {
      |            "text" : "4,450 km",
      |            "value" : 4449804
      |          },
      |          "duration" : {
      |            "text" : "1 day 17 hours",
      |            "value" : 147307
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "193 km",
      |            "value" : 193391
      |          },
      |          "duration" : {
      |            "text" : "2 hours 1 min",
      |            "value" : 7257
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "3,343 km",
      |            "value" : 3342861
      |          },
      |          "duration" : {
      |            "text" : "1 day 6 hours",
      |            "value" : 106618
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,365 km",
      |            "value" : 2365196
      |          },
      |          "duration" : {
      |            "text" : "20 hours 39 mins",
      |            "value" : 74342
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "571 km",
      |            "value" : 571299
      |          },
      |          "duration" : {
      |            "text" : "5 hours 20 mins",
      |            "value" : 19183
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "4,342 km",
      |            "value" : 4341645
      |          },
      |          "duration" : {
      |            "text" : "1 day 16 hours",
      |            "value" : 142971
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,051 km",
      |            "value" : 2050838
      |          },
      |          "duration" : {
      |            "text" : "17 hours 54 mins",
      |            "value" : 64441
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1 m",
      |            "value" : 0
      |          },
      |          "duration" : {
      |            "text" : "1 min",
      |            "value" : 0
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,186 km",
      |            "value" : 2185790
      |          },
      |          "duration" : {
      |            "text" : "19 hours 16 mins",
      |            "value" : 69360
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "740 km",
      |            "value" : 740005
      |          },
      |          "duration" : {
      |            "text" : "7 hours 6 mins",
      |            "value" : 25541
      |          },
      |          "status" : "OK"
      |        }
      |      ]
      |    },
      |    {
      |      "elements" : [
      |        {
      |          "distance" : {
      |            "text" : "2,493 km",
      |            "value" : 2492688
      |          },
      |          "duration" : {
      |            "text" : "22 hours 52 mins",
      |            "value" : 82333
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,311 km",
      |            "value" : 2310974
      |          },
      |          "duration" : {
      |            "text" : "20 hours 27 mins",
      |            "value" : 73596
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1,557 km",
      |            "value" : 1556570
      |          },
      |          "duration" : {
      |            "text" : "14 hours 3 mins",
      |            "value" : 50581
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "385 km",
      |            "value" : 385037
      |          },
      |          "duration" : {
      |            "text" : "3 hours 28 mins",
      |            "value" : 12495
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1,712 km",
      |            "value" : 1712438
      |          },
      |          "duration" : {
      |            "text" : "15 hours 6 mins",
      |            "value" : 54339
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,358 km",
      |            "value" : 2358297
      |          },
      |          "duration" : {
      |            "text" : "21 hours 36 mins",
      |            "value" : 77780
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "441 km",
      |            "value" : 440702
      |          },
      |          "duration" : {
      |            "text" : "4 hours 7 mins",
      |            "value" : 14800
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,186 km",
      |            "value" : 2185829
      |          },
      |          "duration" : {
      |            "text" : "19 hours 13 mins",
      |            "value" : 69208
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1 m",
      |            "value" : 0
      |          },
      |          "duration" : {
      |            "text" : "1 min",
      |            "value" : 0
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,716 km",
      |            "value" : 2715614
      |          },
      |          "duration" : {
      |            "text" : "1 day 1 hour",
      |            "value" : 89296
      |          },
      |          "status" : "OK"
      |        }
      |      ]
      |    },
      |    {
      |      "elements" : [
      |        {
      |          "distance" : {
      |            "text" : "4,741 km",
      |            "value" : 4740819
      |          },
      |          "duration" : {
      |            "text" : "1 day 19 hours",
      |            "value" : 153881
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "549 km",
      |            "value" : 549030
      |          },
      |          "duration" : {
      |            "text" : "5 hours 11 mins",
      |            "value" : 18643
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "3,483 km",
      |            "value" : 3483210
      |          },
      |          "duration" : {
      |            "text" : "1 day 7 hours",
      |            "value" : 111954
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "3,037 km",
      |            "value" : 3036563
      |          },
      |          "duration" : {
      |            "text" : "1 day 3 hours",
      |            "value" : 96326
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1,146 km",
      |            "value" : 1145736
      |          },
      |          "duration" : {
      |            "text" : "10 hours 26 mins",
      |            "value" : 37580
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "4,679 km",
      |            "value" : 4679027
      |          },
      |          "duration" : {
      |            "text" : "1 day 18 hours",
      |            "value" : 151414
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,722 km",
      |            "value" : 2722204
      |          },
      |          "duration" : {
      |            "text" : "1 day 0 hours",
      |            "value" : 86426
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "740 km",
      |            "value" : 739719
      |          },
      |          "duration" : {
      |            "text" : "7 hours 2 mins",
      |            "value" : 25298
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "2,717 km",
      |            "value" : 2717009
      |          },
      |          "duration" : {
      |            "text" : "1 day 1 hour",
      |            "value" : 89209
      |          },
      |          "status" : "OK"
      |        },
      |        {
      |          "distance" : {
      |            "text" : "1 m",
      |            "value" : 0
      |          },
      |          "duration" : {
      |            "text" : "1 min",
      |            "value" : 0
      |          },
      |          "status" : "OK"
      |        }
      |      ]
      |    }
      |  ],
      |  "status" : "OK"
      |}""".stripMargin
    var jsonString2: String =
    """{
      |  "destination_addresses": [
      |    "New York, NY, USA",
      |    "Los Angeles, CA, USA",
      |    "Chicago, IL, USA",
      |    "Houston, TX, USA",
      |    "Phoenix, AZ, USA",
      |    "Philadelphia, PA, USA",
      |    "San Antonio, TX, USA",
      |    "San Diego, CA, USA",
      |    "Dallas, TX, USA",
      |    "San Jose, CA, USA"
      |  ],
      |  "origin_addresses": [
      |    "New York, NY, USA",
      |    "Los Angeles, CA, USA",
      |    "Chicago, IL, USA",
      |    "Houston, TX, USA",
      |    "Phoenix, AZ, USA",
      |    "Philadelphia, PA, USA",
      |    "San Antonio, TX, USA",
      |    "San Diego, CA, USA",
      |    "Dallas, TX, USA",
      |    "San Jose, CA, USA"
      |  ],
      |  "rows": [
      |    {
      |      "elements": [
      |        {
      |          "distance": {
      |            "text": "1 m",
      |            "value": 0
      |          },
      |          "duration": {
      |            "text": "1 min",
      |            "value": 0
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "4,490 km",
      |            "value": 4489862
      |          },
      |          "duration": {
      |            "text": "1 day 16 hours",
      |            "value": 145589
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1,270 km",
      |            "value": 1270445
      |          },
      |          "duration": {
      |            "text": "12 hours 10 mins",
      |            "value": 43773
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,621 km",
      |            "value": 2620658
      |          },
      |          "duration": {
      |            "text": "23 hours 55 mins",
      |            "value": 86073
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "3,876 km",
      |            "value": 3875676
      |          },
      |          "duration": {
      |            "text": "1 day 12 hours",
      |            "value": 129040
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "158 km",
      |            "value": 158242
      |          },
      |          "duration": {
      |            "text": "1 hour 55 mins",
      |            "value": 6885
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,935 km",
      |            "value": 2934803
      |          },
      |          "duration": {
      |            "text": "1 day 3 hours",
      |            "value": 96322
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "4,443 km",
      |            "value": 4443412
      |          },
      |          "duration": {
      |            "text": "1 day 17 hours",
      |            "value": 147406
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,492 km",
      |            "value": 2492302
      |          },
      |          "duration": {
      |            "text": "22 hours 53 mins",
      |            "value": 82371
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "4,728 km",
      |            "value": 4728294
      |          },
      |          "duration": {
      |            "text": "1 day 19 hours",
      |            "value": 154228
      |          },
      |          "status": "OK"
      |        }
      |      ]
      |    },
      |    {
      |      "elements": [
      |        {
      |          "distance": {
      |            "text": "4,501 km",
      |            "value": 4501326
      |          },
      |          "duration": {
      |            "text": "1 day 16 hours",
      |            "value": 145282
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1 m",
      |            "value": 0
      |          },
      |          "duration": {
      |            "text": "1 min",
      |            "value": 0
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "3,244 km",
      |            "value": 3243718
      |          },
      |          "duration": {
      |            "text": "1 day 5 hours",
      |            "value": 103355
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,491 km",
      |            "value": 2491140
      |          },
      |          "duration": {
      |            "text": "21 hours 48 mins",
      |            "value": 78485
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "600 km",
      |            "value": 600314
      |          },
      |          "duration": {
      |            "text": "5 hours 29 mins",
      |            "value": 19738
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "4,368 km",
      |            "value": 4368094
      |          },
      |          "duration": {
      |            "text": "1 day 15 hours",
      |            "value": 141933
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,177 km",
      |            "value": 2176782
      |          },
      |          "duration": {
      |            "text": "19 hours 3 mins",
      |            "value": 68584
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "194 km",
      |            "value": 193646
      |          },
      |          "duration": {
      |            "text": "1 hour 57 mins",
      |            "value": 7042
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,312 km",
      |            "value": 2311734
      |          },
      |          "duration": {
      |            "text": "20 hours 25 mins",
      |            "value": 73503
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "547 km",
      |            "value": 546932
      |          },
      |          "duration": {
      |            "text": "5 hours 11 mins",
      |            "value": 18651
      |          },
      |          "status": "OK"
      |        }
      |      ]
      |    },
      |    {
      |      "elements": [
      |        {
      |          "distance": {
      |            "text": "1,282 km",
      |            "value": 1281616
      |          },
      |          "duration": {
      |            "text": "12 hours 8 mins",
      |            "value": 43678
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "3,243 km",
      |            "value": 3242543
      |          },
      |          "duration": {
      |            "text": "1 day 5 hours",
      |            "value": 103349
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1 m",
      |            "value": 0
      |          },
      |          "duration": {
      |            "text": "1 min",
      |            "value": 0
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1,742 km",
      |            "value": 1741571
      |          },
      |          "duration": {
      |            "text": "16 hours 11 mins",
      |            "value": 58255
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,821 km",
      |            "value": 2821137
      |          },
      |          "duration": {
      |            "text": "1 day 2 hours",
      |            "value": 92449
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1,220 km",
      |            "value": 1219825
      |          },
      |          "duration": {
      |            "text": "11 hours 27 mins",
      |            "value": 41212
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1,997 km",
      |            "value": 1996514
      |          },
      |          "duration": {
      |            "text": "18 hours 4 mins",
      |            "value": 65059
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "3,342 km",
      |            "value": 3341754
      |          },
      |          "duration": {
      |            "text": "1 day 6 hours",
      |            "value": 106407
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1,490 km",
      |            "value": 1489726
      |          },
      |          "duration": {
      |            "text": "14 hours 2 mins",
      |            "value": 50540
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "3,481 km",
      |            "value": 3480975
      |          },
      |          "duration": {
      |            "text": "1 day 7 hours",
      |            "value": 111989
      |          },
      |          "status": "OK"
      |        }
      |      ]
      |    },
      |    {
      |      "elements": [
      |        {
      |          "distance": {
      |            "text": "2,624 km",
      |            "value": 2623641
      |          },
      |          "duration": {
      |            "text": "23 hours 58 mins",
      |            "value": 86258
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,488 km",
      |            "value": 2488117
      |          },
      |          "duration": {
      |            "text": "21 hours 49 mins",
      |            "value": 78547
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1,742 km",
      |            "value": 1741761
      |          },
      |          "duration": {
      |            "text": "16 hours 13 mins",
      |            "value": 58360
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1 m",
      |            "value": 0
      |          },
      |          "duration": {
      |            "text": "1 min",
      |            "value": 0
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1,890 km",
      |            "value": 1889580
      |          },
      |          "duration": {
      |            "text": "16 hours 28 mins",
      |            "value": 59289
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,489 km",
      |            "value": 2489250
      |          },
      |          "duration": {
      |            "text": "22 hours 42 mins",
      |            "value": 81704
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "317 km",
      |            "value": 317168
      |          },
      |          "duration": {
      |            "text": "2 hours 55 mins",
      |            "value": 10481
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,363 km",
      |            "value": 2362972
      |          },
      |          "duration": {
      |            "text": "20 hours 36 mins",
      |            "value": 74158
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "385 km",
      |            "value": 384812
      |          },
      |          "duration": {
      |            "text": "3 hours 26 mins",
      |            "value": 12385
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "3,033 km",
      |            "value": 3033431
      |          },
      |          "duration": {
      |            "text": "1 day 3 hours",
      |            "value": 96387
      |          },
      |          "status": "OK"
      |        }
      |      ]
      |    },
      |    {
      |      "elements": [
      |        {
      |          "distance": {
      |            "text": "3,885 km",
      |            "value": 3884549
      |          },
      |          "duration": {
      |            "text": "1 day 12 hours",
      |            "value": 128892
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "599 km",
      |            "value": 598636
      |          },
      |          "duration": {
      |            "text": "5 hours 32 mins",
      |            "value": 19898
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,829 km",
      |            "value": 2828868
      |          },
      |          "duration": {
      |            "text": "1 day 2 hours",
      |            "value": 92370
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1,893 km",
      |            "value": 1892718
      |          },
      |          "duration": {
      |            "text": "16 hours 31 mins",
      |            "value": 59432
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1 m",
      |            "value": 0
      |          },
      |          "duration": {
      |            "text": "1 min",
      |            "value": 0
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "3,776 km",
      |            "value": 3776390
      |          },
      |          "duration": {
      |            "text": "1 day 11 hours",
      |            "value": 124555
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1,578 km",
      |            "value": 1578360
      |          },
      |          "duration": {
      |            "text": "13 hours 46 mins",
      |            "value": 49532
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "571 km",
      |            "value": 570657
      |          },
      |          "duration": {
      |            "text": "5 hours 17 mins",
      |            "value": 19041
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1,713 km",
      |            "value": 1713312
      |          },
      |          "duration": {
      |            "text": "15 hours 8 mins",
      |            "value": 54450
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1,144 km",
      |            "value": 1143951
      |          },
      |          "duration": {
      |            "text": "10 hours 29 mins",
      |            "value": 37738
      |          },
      |          "status": "OK"
      |        }
      |      ]
      |    },
      |    {
      |      "elements": [
      |        {
      |          "distance": {
      |            "text": "159 km",
      |            "value": 158684
      |          },
      |          "duration": {
      |            "text": "1 hour 53 mins",
      |            "value": 6753
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "4,363 km",
      |            "value": 4362509
      |          },
      |          "duration": {
      |            "text": "1 day 16 hours",
      |            "value": 142324
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1,221 km",
      |            "value": 1220728
      |          },
      |          "duration": {
      |            "text": "11 hours 30 mins",
      |            "value": 41424
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,488 km",
      |            "value": 2487984
      |          },
      |          "duration": {
      |            "text": "22 hours 37 mins",
      |            "value": 81429
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "3,769 km",
      |            "value": 3769346
      |          },
      |          "duration": {
      |            "text": "1 day 11 hours",
      |            "value": 124752
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1 m",
      |            "value": 0
      |          },
      |          "duration": {
      |            "text": "1 min",
      |            "value": 0
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,802 km",
      |            "value": 2802129
      |          },
      |          "duration": {
      |            "text": "1 day 1 hour",
      |            "value": 91677
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "4,337 km",
      |            "value": 4337082
      |          },
      |          "duration": {
      |            "text": "1 day 16 hours",
      |            "value": 143118
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,360 km",
      |            "value": 2359628
      |          },
      |          "duration": {
      |            "text": "21 hours 35 mins",
      |            "value": 77726
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "4,679 km",
      |            "value": 4678576
      |          },
      |          "duration": {
      |            "text": "1 day 18 hours",
      |            "value": 151879
      |          },
      |          "status": "OK"
      |        }
      |      ]
      |    },
      |    {
      |      "elements": [
      |        {
      |          "distance": {
      |            "text": "2,939 km",
      |            "value": 2938513
      |          },
      |          "duration": {
      |            "text": "1 day 3 hours",
      |            "value": 96477
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,178 km",
      |            "value": 2178117
      |          },
      |          "duration": {
      |            "text": "19 hours 6 mins",
      |            "value": 68773
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1,996 km",
      |            "value": 1996414
      |          },
      |          "duration": {
      |            "text": "18 hours 3 mins",
      |            "value": 64959
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "318 km",
      |            "value": 317558
      |          },
      |          "duration": {
      |            "text": "2 hours 54 mins",
      |            "value": 10436
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1,580 km",
      |            "value": 1579581
      |          },
      |          "duration": {
      |            "text": "13 hours 45 mins",
      |            "value": 49515
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,804 km",
      |            "value": 2804123
      |          },
      |          "duration": {
      |            "text": "1 day 2 hours",
      |            "value": 91923
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1 m",
      |            "value": 0
      |          },
      |          "duration": {
      |            "text": "1 min",
      |            "value": 0
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,053 km",
      |            "value": 2052972
      |          },
      |          "duration": {
      |            "text": "17 hours 53 mins",
      |            "value": 64384
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "440 km",
      |            "value": 440485
      |          },
      |          "duration": {
      |            "text": "4 hours 7 mins",
      |            "value": 14809
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,723 km",
      |            "value": 2723432
      |          },
      |          "duration": {
      |            "text": "1 day 0 hours",
      |            "value": 86613
      |          },
      |          "status": "OK"
      |        }
      |      ]
      |    },
      |    {
      |      "elements": [
      |        {
      |          "distance": {
      |            "text": "4,450 km",
      |            "value": 4449804
      |          },
      |          "duration": {
      |            "text": "1 day 17 hours",
      |            "value": 147307
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "193 km",
      |            "value": 193391
      |          },
      |          "duration": {
      |            "text": "2 hours 1 min",
      |            "value": 7257
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "3,343 km",
      |            "value": 3342861
      |          },
      |          "duration": {
      |            "text": "1 day 6 hours",
      |            "value": 106618
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,365 km",
      |            "value": 2365196
      |          },
      |          "duration": {
      |            "text": "20 hours 39 mins",
      |            "value": 74342
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "571 km",
      |            "value": 571299
      |          },
      |          "duration": {
      |            "text": "5 hours 20 mins",
      |            "value": 19183
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "4,342 km",
      |            "value": 4341645
      |          },
      |          "duration": {
      |            "text": "1 day 16 hours",
      |            "value": 142971
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,051 km",
      |            "value": 2050838
      |          },
      |          "duration": {
      |            "text": "17 hours 54 mins",
      |            "value": 64441
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1 m",
      |            "value": 0
      |          },
      |          "duration": {
      |            "text": "1 min",
      |            "value": 0
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,186 km",
      |            "value": 2185790
      |          },
      |          "duration": {
      |            "text": "19 hours 16 mins",
      |            "value": 69360
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "740 km",
      |            "value": 740005
      |          },
      |          "duration": {
      |            "text": "7 hours 6 mins",
      |            "value": 25541
      |          },
      |          "status": "OK"
      |        }
      |      ]
      |    },
      |    {
      |      "elements": [
      |        {
      |          "distance": {
      |            "text": "2,493 km",
      |            "value": 2492688
      |          },
      |          "duration": {
      |            "text": "22 hours 52 mins",
      |            "value": 82333
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,311 km",
      |            "value": 2310974
      |          },
      |          "duration": {
      |            "text": "20 hours 27 mins",
      |            "value": 73596
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1,557 km",
      |            "value": 1556570
      |          },
      |          "duration": {
      |            "text": "14 hours 3 mins",
      |            "value": 50581
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "385 km",
      |            "value": 385037
      |          },
      |          "duration": {
      |            "text": "3 hours 28 mins",
      |            "value": 12495
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1,712 km",
      |            "value": 1712438
      |          },
      |          "duration": {
      |            "text": "15 hours 6 mins",
      |            "value": 54339
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,358 km",
      |            "value": 2358297
      |          },
      |          "duration": {
      |            "text": "21 hours 36 mins",
      |            "value": 77780
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "441 km",
      |            "value": 440702
      |          },
      |          "duration": {
      |            "text": "4 hours 7 mins",
      |            "value": 14800
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,186 km",
      |            "value": 2185829
      |          },
      |          "duration": {
      |            "text": "19 hours 13 mins",
      |            "value": 69208
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1 m",
      |            "value": 0
      |          },
      |          "duration": {
      |            "text": "1 min",
      |            "value": 0
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,716 km",
      |            "value": 2715614
      |          },
      |          "duration": {
      |            "text": "1 day 1 hour",
      |            "value": 89296
      |          },
      |          "status": "OK"
      |        }
      |      ]
      |    },
      |    {
      |      "elements": [
      |        {
      |          "distance": {
      |            "text": "4,741 km",
      |            "value": 4740819
      |          },
      |          "duration": {
      |            "text": "1 day 19 hours",
      |            "value": 153881
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "549 km",
      |            "value": 549030
      |          },
      |          "duration": {
      |            "text": "5 hours 11 mins",
      |            "value": 18643
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "3,483 km",
      |            "value": 3483210
      |          },
      |          "duration": {
      |            "text": "1 day 7 hours",
      |            "value": 111954
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "3,037 km",
      |            "value": 3036563
      |          },
      |          "duration": {
      |            "text": "1 day 3 hours",
      |            "value": 96326
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1,146 km",
      |            "value": 1145736
      |          },
      |          "duration": {
      |            "text": "10 hours 26 mins",
      |            "value": 37580
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "4,679 km",
      |            "value": 4679027
      |          },
      |          "duration": {
      |            "text": "1 day 18 hours",
      |            "value": 151414
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,722 km",
      |            "value": 2722204
      |          },
      |          "duration": {
      |            "text": "1 day 0 hours",
      |            "value": 86426
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "740 km",
      |            "value": 739719
      |          },
      |          "duration": {
      |            "text": "7 hours 2 mins",
      |            "value": 25298
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "2,717 km",
      |            "value": 2717009
      |          },
      |          "duration": {
      |            "text": "1 day 1 hour",
      |            "value": 89209
      |          },
      |          "status": "OK"
      |        },
      |        {
      |          "distance": {
      |            "text": "1 m",
      |            "value": 0
      |          },
      |          "duration": {
      |            "text": "1 min",
      |            "value": 0
      |          },
      |          "status": "OK"
      |        }
      |      ]
      |    }
      |  ],
      |  "status": "OK"
      |}""".stripMargin
  var compactJsonString: String = """{"destination_addresses":["New York, NY, USA","Los Angeles, CA, USA","Chicago, IL, USA","Houston, TX, USA","Phoenix, AZ, USA","Philadelphia, PA, USA","San Antonio, TX, USA","San Diego, CA, USA","Dallas, TX, USA","San Jose, CA, USA"],"origin_addresses":["New York, NY, USA","Los Angeles, CA, USA","Chicago, IL, USA","Houston, TX, USA","Phoenix, AZ, USA","Philadelphia, PA, USA","San Antonio, TX, USA","San Diego, CA, USA","Dallas, TX, USA","San Jose, CA, USA"],"rows":[{"elements":[{"distance":{"text":"1 m","value":0},"duration":{"text":"1 min","value":0},"status":"OK"},{"distance":{"text":"4,490 km","value":4489862},"duration":{"text":"1 day 16 hours","value":145589},"status":"OK"},{"distance":{"text":"1,270 km","value":1270445},"duration":{"text":"12 hours 10 mins","value":43773},"status":"OK"},{"distance":{"text":"2,621 km","value":2620658},"duration":{"text":"23 hours 55 mins","value":86073},"status":"OK"},{"distance":{"text":"3,876 km","value":3875676},"duration":{"text":"1 day 12 hours","value":129040},"status":"OK"},{"distance":{"text":"158 km","value":158242},"duration":{"text":"1 hour 55 mins","value":6885},"status":"OK"},{"distance":{"text":"2,935 km","value":2934803},"duration":{"text":"1 day 3 hours","value":96322},"status":"OK"},{"distance":{"text":"4,443 km","value":4443412},"duration":{"text":"1 day 17 hours","value":147406},"status":"OK"},{"distance":{"text":"2,492 km","value":2492302},"duration":{"text":"22 hours 53 mins","value":82371},"status":"OK"},{"distance":{"text":"4,728 km","value":4728294},"duration":{"text":"1 day 19 hours","value":154228},"status":"OK"}]},{"elements":[{"distance":{"text":"4,501 km","value":4501326},"duration":{"text":"1 day 16 hours","value":145282},"status":"OK"},{"distance":{"text":"1 m","value":0},"duration":{"text":"1 min","value":0},"status":"OK"},{"distance":{"text":"3,244 km","value":3243718},"duration":{"text":"1 day 5 hours","value":103355},"status":"OK"},{"distance":{"text":"2,491 km","value":2491140},"duration":{"text":"21 hours 48 mins","value":78485},"status":"OK"},{"distance":{"text":"600 km","value":600314},"duration":{"text":"5 hours 29 mins","value":19738},"status":"OK"},{"distance":{"text":"4,368 km","value":4368094},"duration":{"text":"1 day 15 hours","value":141933},"status":"OK"},{"distance":{"text":"2,177 km","value":2176782},"duration":{"text":"19 hours 3 mins","value":68584},"status":"OK"},{"distance":{"text":"194 km","value":193646},"duration":{"text":"1 hour 57 mins","value":7042},"status":"OK"},{"distance":{"text":"2,312 km","value":2311734},"duration":{"text":"20 hours 25 mins","value":73503},"status":"OK"},{"distance":{"text":"547 km","value":546932},"duration":{"text":"5 hours 11 mins","value":18651},"status":"OK"}]},{"elements":[{"distance":{"text":"1,282 km","value":1281616},"duration":{"text":"12 hours 8 mins","value":43678},"status":"OK"},{"distance":{"text":"3,243 km","value":3242543},"duration":{"text":"1 day 5 hours","value":103349},"status":"OK"},{"distance":{"text":"1 m","value":0},"duration":{"text":"1 min","value":0},"status":"OK"},{"distance":{"text":"1,742 km","value":1741571},"duration":{"text":"16 hours 11 mins","value":58255},"status":"OK"},{"distance":{"text":"2,821 km","value":2821137},"duration":{"text":"1 day 2 hours","value":92449},"status":"OK"},{"distance":{"text":"1,220 km","value":1219825},"duration":{"text":"11 hours 27 mins","value":41212},"status":"OK"},{"distance":{"text":"1,997 km","value":1996514},"duration":{"text":"18 hours 4 mins","value":65059},"status":"OK"},{"distance":{"text":"3,342 km","value":3341754},"duration":{"text":"1 day 6 hours","value":106407},"status":"OK"},{"distance":{"text":"1,490 km","value":1489726},"duration":{"text":"14 hours 2 mins","value":50540},"status":"OK"},{"distance":{"text":"3,481 km","value":3480975},"duration":{"text":"1 day 7 hours","value":111989},"status":"OK"}]},{"elements":[{"distance":{"text":"2,624 km","value":2623641},"duration":{"text":"23 hours 58 mins","value":86258},"status":"OK"},{"distance":{"text":"2,488 km","value":2488117},"duration":{"text":"21 hours 49 mins","value":78547},"status":"OK"},{"distance":{"text":"1,742 km","value":1741761},"duration":{"text":"16 hours 13 mins","value":58360},"status":"OK"},{"distance":{"text":"1 m","value":0},"duration":{"text":"1 min","value":0},"status":"OK"},{"distance":{"text":"1,890 km","value":1889580},"duration":{"text":"16 hours 28 mins","value":59289},"status":"OK"},{"distance":{"text":"2,489 km","value":2489250},"duration":{"text":"22 hours 42 mins","value":81704},"status":"OK"},{"distance":{"text":"317 km","value":317168},"duration":{"text":"2 hours 55 mins","value":10481},"status":"OK"},{"distance":{"text":"2,363 km","value":2362972},"duration":{"text":"20 hours 36 mins","value":74158},"status":"OK"},{"distance":{"text":"385 km","value":384812},"duration":{"text":"3 hours 26 mins","value":12385},"status":"OK"},{"distance":{"text":"3,033 km","value":3033431},"duration":{"text":"1 day 3 hours","value":96387},"status":"OK"}]},{"elements":[{"distance":{"text":"3,885 km","value":3884549},"duration":{"text":"1 day 12 hours","value":128892},"status":"OK"},{"distance":{"text":"599 km","value":598636},"duration":{"text":"5 hours 32 mins","value":19898},"status":"OK"},{"distance":{"text":"2,829 km","value":2828868},"duration":{"text":"1 day 2 hours","value":92370},"status":"OK"},{"distance":{"text":"1,893 km","value":1892718},"duration":{"text":"16 hours 31 mins","value":59432},"status":"OK"},{"distance":{"text":"1 m","value":0},"duration":{"text":"1 min","value":0},"status":"OK"},{"distance":{"text":"3,776 km","value":3776390},"duration":{"text":"1 day 11 hours","value":124555},"status":"OK"},{"distance":{"text":"1,578 km","value":1578360},"duration":{"text":"13 hours 46 mins","value":49532},"status":"OK"},{"distance":{"text":"571 km","value":570657},"duration":{"text":"5 hours 17 mins","value":19041},"status":"OK"},{"distance":{"text":"1,713 km","value":1713312},"duration":{"text":"15 hours 8 mins","value":54450},"status":"OK"},{"distance":{"text":"1,144 km","value":1143951},"duration":{"text":"10 hours 29 mins","value":37738},"status":"OK"}]},{"elements":[{"distance":{"text":"159 km","value":158684},"duration":{"text":"1 hour 53 mins","value":6753},"status":"OK"},{"distance":{"text":"4,363 km","value":4362509},"duration":{"text":"1 day 16 hours","value":142324},"status":"OK"},{"distance":{"text":"1,221 km","value":1220728},"duration":{"text":"11 hours 30 mins","value":41424},"status":"OK"},{"distance":{"text":"2,488 km","value":2487984},"duration":{"text":"22 hours 37 mins","value":81429},"status":"OK"},{"distance":{"text":"3,769 km","value":3769346},"duration":{"text":"1 day 11 hours","value":124752},"status":"OK"},{"distance":{"text":"1 m","value":0},"duration":{"text":"1 min","value":0},"status":"OK"},{"distance":{"text":"2,802 km","value":2802129},"duration":{"text":"1 day 1 hour","value":91677},"status":"OK"},{"distance":{"text":"4,337 km","value":4337082},"duration":{"text":"1 day 16 hours","value":143118},"status":"OK"},{"distance":{"text":"2,360 km","value":2359628},"duration":{"text":"21 hours 35 mins","value":77726},"status":"OK"},{"distance":{"text":"4,679 km","value":4678576},"duration":{"text":"1 day 18 hours","value":151879},"status":"OK"}]},{"elements":[{"distance":{"text":"2,939 km","value":2938513},"duration":{"text":"1 day 3 hours","value":96477},"status":"OK"},{"distance":{"text":"2,178 km","value":2178117},"duration":{"text":"19 hours 6 mins","value":68773},"status":"OK"},{"distance":{"text":"1,996 km","value":1996414},"duration":{"text":"18 hours 3 mins","value":64959},"status":"OK"},{"distance":{"text":"318 km","value":317558},"duration":{"text":"2 hours 54 mins","value":10436},"status":"OK"},{"distance":{"text":"1,580 km","value":1579581},"duration":{"text":"13 hours 45 mins","value":49515},"status":"OK"},{"distance":{"text":"2,804 km","value":2804123},"duration":{"text":"1 day 2 hours","value":91923},"status":"OK"},{"distance":{"text":"1 m","value":0},"duration":{"text":"1 min","value":0},"status":"OK"},{"distance":{"text":"2,053 km","value":2052972},"duration":{"text":"17 hours 53 mins","value":64384},"status":"OK"},{"distance":{"text":"440 km","value":440485},"duration":{"text":"4 hours 7 mins","value":14809},"status":"OK"},{"distance":{"text":"2,723 km","value":2723432},"duration":{"text":"1 day 0 hours","value":86613},"status":"OK"}]},{"elements":[{"distance":{"text":"4,450 km","value":4449804},"duration":{"text":"1 day 17 hours","value":147307},"status":"OK"},{"distance":{"text":"193 km","value":193391},"duration":{"text":"2 hours 1 min","value":7257},"status":"OK"},{"distance":{"text":"3,343 km","value":3342861},"duration":{"text":"1 day 6 hours","value":106618},"status":"OK"},{"distance":{"text":"2,365 km","value":2365196},"duration":{"text":"20 hours 39 mins","value":74342},"status":"OK"},{"distance":{"text":"571 km","value":571299},"duration":{"text":"5 hours 20 mins","value":19183},"status":"OK"},{"distance":{"text":"4,342 km","value":4341645},"duration":{"text":"1 day 16 hours","value":142971},"status":"OK"},{"distance":{"text":"2,051 km","value":2050838},"duration":{"text":"17 hours 54 mins","value":64441},"status":"OK"},{"distance":{"text":"1 m","value":0},"duration":{"text":"1 min","value":0},"status":"OK"},{"distance":{"text":"2,186 km","value":2185790},"duration":{"text":"19 hours 16 mins","value":69360},"status":"OK"},{"distance":{"text":"740 km","value":740005},"duration":{"text":"7 hours 6 mins","value":25541},"status":"OK"}]},{"elements":[{"distance":{"text":"2,493 km","value":2492688},"duration":{"text":"22 hours 52 mins","value":82333},"status":"OK"},{"distance":{"text":"2,311 km","value":2310974},"duration":{"text":"20 hours 27 mins","value":73596},"status":"OK"},{"distance":{"text":"1,557 km","value":1556570},"duration":{"text":"14 hours 3 mins","value":50581},"status":"OK"},{"distance":{"text":"385 km","value":385037},"duration":{"text":"3 hours 28 mins","value":12495},"status":"OK"},{"distance":{"text":"1,712 km","value":1712438},"duration":{"text":"15 hours 6 mins","value":54339},"status":"OK"},{"distance":{"text":"2,358 km","value":2358297},"duration":{"text":"21 hours 36 mins","value":77780},"status":"OK"},{"distance":{"text":"441 km","value":440702},"duration":{"text":"4 hours 7 mins","value":14800},"status":"OK"},{"distance":{"text":"2,186 km","value":2185829},"duration":{"text":"19 hours 13 mins","value":69208},"status":"OK"},{"distance":{"text":"1 m","value":0},"duration":{"text":"1 min","value":0},"status":"OK"},{"distance":{"text":"2,716 km","value":2715614},"duration":{"text":"1 day 1 hour","value":89296},"status":"OK"}]},{"elements":[{"distance":{"text":"4,741 km","value":4740819},"duration":{"text":"1 day 19 hours","value":153881},"status":"OK"},{"distance":{"text":"549 km","value":549030},"duration":{"text":"5 hours 11 mins","value":18643},"status":"OK"},{"distance":{"text":"3,483 km","value":3483210},"duration":{"text":"1 day 7 hours","value":111954},"status":"OK"},{"distance":{"text":"3,037 km","value":3036563},"duration":{"text":"1 day 3 hours","value":96326},"status":"OK"},{"distance":{"text":"1,146 km","value":1145736},"duration":{"text":"10 hours 26 mins","value":37580},"status":"OK"},{"distance":{"text":"4,679 km","value":4679027},"duration":{"text":"1 day 18 hours","value":151414},"status":"OK"},{"distance":{"text":"2,722 km","value":2722204},"duration":{"text":"1 day 0 hours","value":86426},"status":"OK"},{"distance":{"text":"740 km","value":739719},"duration":{"text":"7 hours 2 mins","value":25298},"status":"OK"},{"distance":{"text":"2,717 km","value":2717009},"duration":{"text":"1 day 1 hour","value":89209},"status":"OK"},{"distance":{"text":"1 m","value":0},"duration":{"text":"1 min","value":0},"status":"OK"}]}],"status":"OK"}"""
  var jsonBytes1: Array[Byte] = jsonString1.getBytes(UTF_8)
  var jsonBytes2: Array[Byte] = jsonString2.getBytes(UTF_8)
  var compactJsonBytes: Array[Byte] = compactJsonString.getBytes(UTF_8)
  var obj: GoogleMapsAPI.DistanceMatrix = readFromArray[GoogleMapsAPI.DistanceMatrix](jsonBytes1)
  var preallocatedBuf: Array[Byte] = new Array(jsonBytes1.length + 100/*to avoid possible out of bounds error*/)
}