printjson(
db.people.aggregate(
    [{$group: {
            _id: "$nationality",
            srednie_bmi : {$avg: {$divide : [{$toDouble: "$weight"},{$sqrt : {$toDouble:"$height"}}]}},
            min_bmi : {$min: {$divide : [{$toDouble: "$weight"},{$sqrt : {$toDouble:"$height"}}]}},
            max_bmi : {$max: {$divide : [{$toDouble: "$weight"},{$sqrt : {$toDouble:"$height"}}]}}
        }}]
    ).toArray())