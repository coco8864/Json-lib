Json-lib skip maybe decition
=============

We change Json-lib process skip JSONUtils#mayBeJSON.Reversibility is improved.  
Set java vm option -Djsonlib.skipMaybe=false when you need original behavior.  
[json-lib-2.4.1-skipmaybe-jdk13.jar](https://raw.github.com/coco8864/Json-lib/master/json-lib-2.4.1-skipmaybe-jdk13.jar)  
[json-lib-2.4.1-skipmaybe-jdk15.jar](https://raw.github.com/coco8864/Json-lib/master/json-lib-2.4.1-skipmaybe-jdk15.jar)  

Original
-------
1. {obj:'null'}=>{"obj":"\"null\""}
1. {'function(){}':123}=>{function(){}:123}
1. {obj:{obj:'[1,3]'}}=>{"obj":{"obj":[1,3]}}
1. {obj:{obj:'{a:2}'}}=>{"obj":{"obj":{"a":2}}}
1. {obj:{obj:'null'}}=>{"obj":{"obj":"\"null\""}}
1. {obj:{obj:'function(){}'}}=>{"obj":{"obj":"\"function(){}\""}}
1. {obj:{'[1,3]':123}}=>error:JSON keys must be strings.
1. {obj:{'{a:2}':123}}=>error:JSON keys must be strings.
1. {obj:{'null':123}}=>error:JSON keys must be strings.
1. {obj:{'function(){}':123}}=>error:JSON keys must be strings.

SkipMaybe
-------
1. {obj:'null'}=>{"obj":"null"}
1. {'function(){}':123}=>{"function(){}":123}
1. {obj:{obj:'[1,3]'}}=>{"obj":{"obj":"[1,3]"}}
1. {obj:{obj:'{a:2}'}}=>{"obj":{"obj":"{a:2}"}}
1. {obj:{obj:'null'}}=>{"obj":{"obj":"null"}}
1. {obj:{obj:'function(){}'}}=>{"obj":{"obj":"function(){}"}}
1. {obj:{'[1,3]':123}}=>{"obj":{"[1,3]":123}}
1. {obj:{'{a:2}':123}}=>{"obj":{"{a:2}":123}}
1. {obj:{'null':123}}=>{"obj":{"null":123}}
1. {obj:{'function(){}':123}}=>{"obj":{"function(){}":123}}