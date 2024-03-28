# Notes App

A Simple CRUD Rest API for Notes

## Installation

Clone the repo and open from IntelliJ(or any preferred IDE) then run this on terminal

```bash
mvn clean install
```

## Usage

Run from IDE then endpoints can be accessed on port 8080. You can use postman or run curl on terminal

1. POST /notes: Create a new note.
```bash
curl --location 'localhost:8080/notes' \
--header 'Content-Type: application/json' \
--data '{ 
	"title": "Note 1",
    "body": "Sample note"

}'
```

2. GET /notes: Retrieve all notes.
```bash
curl --location 'localhost:8080/notes' \
--header 'Accept-Encoding: application/json'
```

3. GET /notes/:id: Retrieve a specific note by ID.
```bash
curl --location 'localhost:8080/notes/1'
```


4. PUT /notes/:id: Update a specific note.
```bash
curl --location --request PUT 'localhost:8080/notes/1' \
--header 'Content-Type: application/json' \
--data '{ 
	"title": "Note 1",
    "body": "Sample note edit"

}'
```
 

5. DELETE /notes/:id: Delete a specific note.
```bash
curl --location --request DELETE 'localhost:8080/notes/1' \
--data ''
```

## Appendix

1. Unit tests are created for better error catching
2. Data validations and error handling are also applied
3. H2 is used as in memory db


## Author

[John Paul Ebreo](www.linkedin.com/in/john-paul-ebreo-59837311b)
