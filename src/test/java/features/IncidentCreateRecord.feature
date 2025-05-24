Feature: Creating new record in the Service Now Incident table

  Background: 
    Given Set the base uri "https://dev265761.service-now.com" of the service now application
    And Set the base path "/api/now/table" of the service now api
    And Set the path parameter key name as "tableName" and value as "incident"
    And Set basic authentication with username "admin" and password "d@9IvhOh5DR*"
    And Add the header with key name as "Content-Type" and value as "application/json"

  Scenario: Create the new record in the incident table
    When send the request body as form of string value "{\"short_description\": \"RESTAPIMAY2025\",\"description\": \"Create a new record using POST method\"}"
    And hit the post method to create new record
    Then validate the record is created succesfully

  Scenario Outline: Create mulipule new records in the incident table
    When send the request body as a POJO object
      | <shortDescription> | <description> |
    And hit the post method to create new record the body is POJO object
    Then validate the record is created succesfully

    Examples: 
      | shortDescription | description                             |
      | RESTAPIMAY2025 1 | Create a new record using POST method 1 |
      | RESTAPIMAY2025 2 | Create a new record using POST method 2 |
      | RESTAPIMAY2025 3 | Create a new record using POST method 3 |
      | RESTAPIMAY2025 4 | Create a new record using POST method 4 |
