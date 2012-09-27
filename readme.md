Json-lib skip maybe decition
=============

Change Json-lib process skip JSONUtils#mayBeJSON.
Set javaVm option -Djsonlib.skipMaybe=false if need original result.

Original
-------
* {obj:'null'}=>{"obj":"\"null\""}
* {'function(){}':123}=>{function(){}:123}
* {obj:{obj:'[1,3]'}}=>{"obj":{"obj":[1,3]}}
* {obj:{obj:'{a:2}'}}=>{"obj":{"obj":{"a":2}}}
* {obj:{obj:'null'}}=>{"obj":{"obj":"\"null\""}}
* {obj:{obj:'function(){}'}}=>{"obj":{"obj":"\"function(){}\""}}
* {obj:{'[1,3]':123}}=>error:JSON keys must be strings.
* {obj:{'{a:2}':123}}=>error:JSON keys must be strings.
* {obj:{'null':123}}=>error:JSON keys must be strings.
* {obj:{'function(){}':123}}=>error:JSON keys must be strings.

SkipMaybe
-------
* {obj:'null'}=>{"obj":"null"}
* {'function(){}':123}=>{"function(){}":123}
* {obj:{obj:'[1,3]'}}=>{"obj":{"obj":"[1,3]"}}
* {obj:{obj:'{a:2}'}}=>{"obj":{"obj":"{a:2}"}}
* {obj:{obj:'null'}}=>{"obj":{"obj":"null"}}
* {obj:{obj:'function(){}'}}=>{"obj":{"obj":"function(){}"}}
* {obj:{'[1,3]':123}}=>{"obj":{"[1,3]":123}}
* {obj:{'{a:2}':123}}=>{"obj":{"{a:2}":123}}
* {obj:{'null':123}}=>{"obj":{"null":123}}
* {obj:{'function(){}':123}}=>{"function(){}":{"[1,3]":123}}

