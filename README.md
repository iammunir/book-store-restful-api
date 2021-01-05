# API Spec


## Create/Add a Book

Request : 
- Method : POST
- Endpoint : `/api/v1/book`
- Header : 
    - Content-Type : application/json
    - Accept : application/json
- Body : 
```json
{
  "id" : "string, unique",
  "title" : "string",
  "author" : "string",
  "price" : "long",
  "stock" : "integer"
}
```
- Response : 
```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "string, unique",
    "title" : "string",
    "author" : "string",
    "price" : "long",
    "stock" : "integer",
    "createdAt" : "date",
    "updatedAt" : "date"
  }
}
```


## Get a Book

Request :
- Method : GET
- Endpoint : `/api/v1/book/{book_id}`
- Header :
    - Accept : application/json
- Response :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "string, unique",
    "title" : "string",
    "author" : "string",
    "price" : "long",
    "stock" : "integer",
    "createdAt" : "date",
    "updatedAt" : "date"
  }
}
```


## Update a Book

Request :
- Method : PUT
- Endpoint : `/api/v1/book/{book_id}`
- Header :
    - Content-Type : application/json
    - Accept : application/json
- Body :
```json
{
  "title" : "string",
  "author" : "string",
  "price" : "long",
  "stock" : "integer"
}
```
- Response :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "string, unique",
    "title" : "string",
    "author" : "string",
    "price" : "long",
    "stock" : "integer",
    "createdAt" : "date",
    "updatedAt" : "date"
  }
}
```


## List Books

Request :
- Method : GET
- Endpoint : `/api/v1/book`
- Header :
    - Accept : application/json
- Query Param : 
    - size : number,
    - page : number
- Response :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : [
    {
      "id" : "string, unique",
      "title" : "string",
      "author" : "string",
      "price" : "long",
      "stock" : "integer",
      "createdAt" : "date",
      "updatedAt" : "date"
    },
    {
      "id" : "string, unique",
      "title" : "string",
      "author" : "string",
      "price" : "long",
      "stock" : "integer",
      "createdAt" : "date",
      "updatedAt" : "date"
    }
  ]
}
```


## Delete a Book

Request :
- Method : DELETE
- Endpoint : `/api/v1/book/{book_id}`
- Header :
    - Accept : application/json

- Response :
```json
{
  "code" : "number",
  "status" : "string"
}
```
