printjson(
db.people.find(
	{
	$expr: {$gte:[{$toDouble: "$weight"}, 68]}, 
	$expr: {$lt:[{$toDouble: "$weight"}, 71.5]}
	}
).toArray())