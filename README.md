# HotelAPI
This project consists of creating an API REST that allows you to create a guest with several reservations. 

## Technologies
- JAVA
- SpringWeb
- SpringData – JPA
- Lombok
- H2 Database
- JUnit
- Mockito
- Maven

## Use in postman
### Guest
Create and update methods need a request body.

#### GET 
```
/api/v1/guests
```
#### GET guest by id
```
/api/v1/guests/find/{id}
```
#### Create
```
/api/v1/guests
```
```ruby
{
    "name": "Jorge",
    "lastName": "Perez",
    "birthdate": "1984-01-15",
    "nationality": "Mexican",
    "phone": "562-124-3567",
    "reservations": [
        {
            "checkInDate": "2025-08-16",
            "checkOutDate": "2025-08-20",
            "cost": 3500.00,
            "paymentMethod": "Credit card"
        },
        {
            "checkInDate": "2025-10-08",
            "checkOutDate": "2025-10-09",
            "cost": 300.00,
            "paymentMethod": "Credit card"
        }
    ]
}
```
#### Update
```
/api/v1/guests/update/{id}
```
```ruby
{
    "guestId": 1,
    "name": "Isabel",
    "lastName": "Perez",
    "birthdate": "1984-01-15",
    "nationality": "Mexican",
    "phone": "562-124-3567",
    "reservations": [
        {
            "checkInDate": "2025-08-16",
            "checkOutDate": "2025-08-20",
            "cost": 3500.00,
            "paymentMethod": "Cash"
        },
        {
            "checkInDate": "2025-10-08",
            "checkOutDate": "2025-10-09",
            "cost": 300.00,
            "paymentMethod": "Cash"
        }
    ]
}
```
#### Delete
```
/api/v1/guests/delete/{id}
```
