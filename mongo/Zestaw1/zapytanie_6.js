printjson(
db.people.insertOne(
    {
        "sex":"Female",
        "first_name":"Zofia",
        "last_name":"Maszlanka",
        "job":"Data Scientist",
        "email":"s22555@pjwstk.edu.pl",
        "location":
            {
            "city":"Warsaw",
            "address":{"streetname":"Koszykowa","streetnumber":"86"}
            },
        "description":"Lorem ipsum",
        "height":"164.01",
        "weight":"53.21",
        "birth_date":"1997-09-03T20:17:03Z",
        "nationality":"Poland",
        "credit":[{
            "type":"switch",
            "number":"6759828939100098699",
            "currency":"EUR",
            "balance":"80124.2"}]
    }
))