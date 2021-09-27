Feature: The register page requires that new user passwords must match

  Background:
    Given User navigates to Register Page

  Scenario Outline: User attempts to make a valid first time account with OpenCart but mistypes their
  confirm password
    When User enters in "<firstName>"
    And User enters in "<lastName>"
    And User enters in "<email>"
    And User enters in "<telephoneNumber>"
    And User enters in "<password>"
    And User repeats their "<confirmPassword>"
    And User selects "<newsletterOption>"
    And User endorses the privacy policy
    And User clicks the Continue button
    Then User is presented with an error

    Examples:
      | firstName | lastName | email            | telephoneNumber | password     | confirmPassword | newsletterOption |
      | bob       | hope     | abc123@gmail.com | 5555555555      | yankeeDoodle | happybirthday   | true             |