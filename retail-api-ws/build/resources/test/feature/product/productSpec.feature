Feature: A Product Search and Update.
  To allow a user to find a product and update the price
 
  Scenario: Search product by Id
    Given a external API to retrieve the product name by Id '13860428'
      And a external API provides the product name to be retrieved for the product Id 
      And to read pricing information from a NoSQL data source and combines it with the product Id 
    When the user searches for product name 'The Big Lebowski (Blu-ray)' with entered Id '13860428'
    Then product Id '13860428' should have been found
      And a product name 'The Big Lebowski (Blu-ray)' should be shown
      And a product price '13.49' should be shown 
      And a product currency 'USD' should be shown

  Scenario Outline: Modify a product's price
    Given a product id = <id>, price = <price> and currency = <currency>
    When the product's price is updated
    Then the result should be <result>
    Examples:
      | id       	   	   | price      | currency   | result |
      | 13860428   		   | 13.49      | USD        | true   |
      | 13860429   		   | 40.67      | EUR        | true   |
      | 13860430   		   | 60.67      | USD        | true   |
      | 15117729   		   | 525.67     | USD        | true   |
      | 99999999   		   | 9999.99    | USD        | false  |
      
  