Feature: As a sports user,
        I would like to read about all articles related to sports

  Scenario: Use the search option to find all articles related to ‘sports’.
            Output the first heading and the last heading returned on the page

    Given User is on scores-fixtures page
    When  User enter text "sports" in search textbox
    And   User click on search button
    Then  User should see the corresponding articles related to sports
    And   Output the first heading and the last heading returned on the page


