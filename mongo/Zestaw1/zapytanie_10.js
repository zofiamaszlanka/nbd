printjson(
db.people.updateMany(
    {"job" : "Editor"},
    {$unset: {"email" : {$ne:0}}}
    )
)