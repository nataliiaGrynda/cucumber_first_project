$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/carvana.feature");
formatter.feature({
  "name": "Carvana Page Validation",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Validate CAR FINDER menu item",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@na"
    }
  ]
});
formatter.step({
  "name": "user is on \"https://www.carvana.com/\"",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "user clicks on \"CAR FINDER” menu item",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});