printjson(db.people.aggregate([{
    $group: {_id: null, unikalne_zawody: {$addToSet : "$job"}}
}]).toArray())