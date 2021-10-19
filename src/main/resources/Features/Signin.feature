Feature: As a QA, I would like to verify all negative scenarios for login

  Background:
    Given I am on scores-fixtures page

  Scenario Outline: Submit Login form with correct username and incorrect password
    And I navigate to login page
    When I attempt to login with correct "<username>" and incorrect "<password>"
    Then my login attempt should fail with wrong password "<error>"
    Examples:
      | username            | password     | error                                                              |
      | test1237@gmail.com  | summer777 |  Uh oh, that password doesn’t match that account. Please try again. |


  Scenario Outline: Submit Login form with incorrect username and correct password
    And I navigate to login page
    When I attempt to login with incorrect "<username>" and correct "<password>"
    Then my login attempt should fail with wrong username "<error>"
    Examples:
      | username            | password     | error                                                      |
      | test1234@gmail.com  | summer77     |  Uh oh, that password doesn’t match that account. Please try again.  |


#  Scenario Outline: Submit Login form with incorrect username and incorrect password
#    And I navigate to login page
#    When I attempt to login with incorrect "<username>" and incorrect "<password>"
#    Then my login attempt should fail with wrong username and password "<error>"
#    Examples:
#      | username            | password     | error                                                              |
#      | test1234@gmail.com  | summer77 |  Uh oh, that username doesn’t match that account. Please try again. |

