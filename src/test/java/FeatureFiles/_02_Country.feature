Feature:  Country Functionality


  @SmokeTest    @SundayTest       # Buraya ıstedıgın kadar yanyana yazabılırsın
  Scenario: Create a Country


    Given Navigate to Campus
    When Enter username and password and click login button
    Then  User should login successfully
    And Navigate to country page
    When Create a country
    Then Success message should be displayed