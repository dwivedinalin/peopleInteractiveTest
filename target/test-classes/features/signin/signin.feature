Feature: Signin flow of CardUp user

  @Sign_in_marathi_shaadi.com
  Scenario Outline: Signin for a new user
    Given When an existing user opens the marathi shaadi.com
    When  User enters email
    And User enters password
    And User clicks on next button
    Then Verify community name and mother tongue is same "<Row_Index>"

    Examples:
      | Row_Index |
      | 1         |


