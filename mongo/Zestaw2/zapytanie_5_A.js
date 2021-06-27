printjson(
db.people.aggregate(
    [
        {$match :{nationality: "Poland", sex: "Female"}},
        { $unwind : "$credit" },
        {$group: {
                _id: "$credit.currency",
                suma: {$sum: {$toDouble: "$credit.balance"}},
                srednia: {$avg: {$toDouble: "$credit.balance"}}
            }},
    ]
    ).toArray())