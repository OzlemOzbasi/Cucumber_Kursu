Feature: Country Multi Scenario


  Background:    //  Farklı senaryolarda aynı olan kısımlar ıcın olanları bo bolume yazdık
    Given Navigate to Campus
    When Enter username and password and click login button
    Then  User should login successfully
    And Navigate to country page


  Scenario: Create a Country
    When Create a country
    Then Success message should be displayed


  Scenario: Create a Country parameter data
    When Create a country name as "DenizYeni1"  code as  "deniz1"
    Then Success message should be displayed