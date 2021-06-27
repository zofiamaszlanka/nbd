printjson(db.people.aggregate(
    [{$group: {
            _id: "$sex",
            srednia_waga: {$avg: {$toDouble: "$weight"}},
            sredni_wzrost: {$avg: {$toDouble:"$height"}}
        }}]
    ).toArray()
)