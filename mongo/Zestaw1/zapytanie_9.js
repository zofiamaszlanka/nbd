printjson(
db.people.update(
    {"first_name" : "Antonio"},
    {$push: {"hobby" : "pingpong"}}
    )


)