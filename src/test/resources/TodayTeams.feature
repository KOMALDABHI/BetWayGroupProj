Feature: As a business user,
         I would like to make a record of all teams which are playing today

  @today
  Scenario: Output all team names with a match today.
            If there are no matches today, output a message to convey this.

    Given User is on scores-fixtures page
    Then  User gets all team names with a match today

