printjson(
db.people.find(
    {$expr: {$gte:[{$year: {$toDate: "$birth_date"}}, 2001]}},
    {"_id":0, "first_name":1, "last_name":1, "location.city": 1}
    )
.toArray())