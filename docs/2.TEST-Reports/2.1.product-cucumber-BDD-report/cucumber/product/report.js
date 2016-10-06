$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("product/productSpec.feature");
formatter.feature({
  "line": 1,
  "name": "A Product Search and Update.",
  "description": "To allow a user to find a product and update the price",
  "id": "a-product-search-and-update.",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Search product by Id",
  "description": "",
  "id": "a-product-search-and-update.;search-product-by-id",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "a external API to retrieve the product name by Id \u002713860428\u0027",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "a external API provides the product name to be retrieved for the product Id",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "to read pricing information from a NoSQL data source and combines it with the product Id",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "the user searches for product name \u0027The Big Lebowski (Blu-ray)\u0027 with entered Id \u002713860428\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "product Id \u002713860428\u0027 should have been found",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "a product name \u0027The Big Lebowski (Blu-ray)\u0027 should be shown",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "a product price \u002713.49\u0027 should be shown",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "a product currency \u0027USD\u0027 should be shown",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenarioOutline({
  "line": 14,
  "name": "Modify a product\u0027s price",
  "description": "",
  "id": "a-product-search-and-update.;modify-a-product\u0027s-price",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 15,
  "name": "a product id \u003d \u003cid\u003e, price \u003d \u003cprice\u003e and currency \u003d \u003ccurrency\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "the product\u0027s price is updated",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "the result should be \u003cresult\u003e",
  "keyword": "Then "
});
formatter.examples({
  "line": 18,
  "name": "",
  "description": "",
  "id": "a-product-search-and-update.;modify-a-product\u0027s-price;",
  "rows": [
    {
      "cells": [
        "id",
        "price",
        "currency",
        "result"
      ],
      "line": 19,
      "id": "a-product-search-and-update.;modify-a-product\u0027s-price;;1"
    },
    {
      "cells": [
        "13860428",
        "13.49",
        "USD",
        "true"
      ],
      "line": 20,
      "id": "a-product-search-and-update.;modify-a-product\u0027s-price;;2"
    },
    {
      "cells": [
        "13860429",
        "40.67",
        "EUR",
        "true"
      ],
      "line": 21,
      "id": "a-product-search-and-update.;modify-a-product\u0027s-price;;3"
    },
    {
      "cells": [
        "13860430",
        "60.67",
        "USD",
        "true"
      ],
      "line": 22,
      "id": "a-product-search-and-update.;modify-a-product\u0027s-price;;4"
    },
    {
      "cells": [
        "15117729",
        "525.67",
        "USD",
        "true"
      ],
      "line": 23,
      "id": "a-product-search-and-update.;modify-a-product\u0027s-price;;5"
    },
    {
      "cells": [
        "99999999",
        "9999.99",
        "USD",
        "false"
      ],
      "line": 24,
      "id": "a-product-search-and-update.;modify-a-product\u0027s-price;;6"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 20,
  "name": "Modify a product\u0027s price",
  "description": "",
  "id": "a-product-search-and-update.;modify-a-product\u0027s-price;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 15,
  "name": "a product id \u003d 13860428, price \u003d 13.49 and currency \u003d USD",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "the product\u0027s price is updated",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "the result should be true",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "ProductSteps.updateProductPrice()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProductSteps.the_result_should_be_true()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 21,
  "name": "Modify a product\u0027s price",
  "description": "",
  "id": "a-product-search-and-update.;modify-a-product\u0027s-price;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 15,
  "name": "a product id \u003d 13860429, price \u003d 40.67 and currency \u003d EUR",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "the product\u0027s price is updated",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "the result should be true",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "ProductSteps.updateProductPrice()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProductSteps.the_result_should_be_true()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 22,
  "name": "Modify a product\u0027s price",
  "description": "",
  "id": "a-product-search-and-update.;modify-a-product\u0027s-price;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 15,
  "name": "a product id \u003d 13860430, price \u003d 60.67 and currency \u003d USD",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "the product\u0027s price is updated",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "the result should be true",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "ProductSteps.updateProductPrice()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProductSteps.the_result_should_be_true()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 23,
  "name": "Modify a product\u0027s price",
  "description": "",
  "id": "a-product-search-and-update.;modify-a-product\u0027s-price;;5",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 15,
  "name": "a product id \u003d 15117729, price \u003d 525.67 and currency \u003d USD",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "the product\u0027s price is updated",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "the result should be true",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "ProductSteps.updateProductPrice()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProductSteps.the_result_should_be_true()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 24,
  "name": "Modify a product\u0027s price",
  "description": "",
  "id": "a-product-search-and-update.;modify-a-product\u0027s-price;;6",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 15,
  "name": "a product id \u003d 99999999, price \u003d 9999.99 and currency \u003d USD",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "the product\u0027s price is updated",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "the result should be false",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "ProductSteps.updateProductPrice()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProductSteps.the_result_should_be_false()"
});
formatter.result({
  "status": "skipped"
});
});