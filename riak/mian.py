import requests

URL = 'http://localhost:8098/buckets/s22555/keys/'

print("\ncreate: ")
shoes = {'brand': 'Spraindi', 'size': 37, 'price': 99}
print(requests.post(URL + "sprandi", data=shoes))
print("\nget: ")
print(requests.get(URL + "sprandi"))
print(requests.get(URL + "sprandi").text)

print("\nupdate: ")
shoes_updated = {'brand': 'Spraindi', 'size': 37, 'price': 88}
print(requests.put(URL + "sprandi", data=shoes_updated))
print("\nget: ")
print(requests.get(URL + "sprandi"))
print(requests.get(URL + "sprandi").text)

print("\ndelete: ")
print(requests.delete(URL + "sprandi"))
print("\nget: ")
print(requests.get(URL + "sprandi"))
print(requests.get(URL + "sprandi").text)