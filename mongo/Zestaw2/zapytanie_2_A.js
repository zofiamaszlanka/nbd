printjson(
db.people.aggregate(
    [
        { $unwind : "$credit" },
        {$group: {
            _id: "$credit.currency",
            ilosc_srodkow: {$sum: {$toDouble: "$credit.balance"}},
        }}]
    ).toArray()

)