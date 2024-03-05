Feature: Login Error

  Scenario: Login not allowed
    Given go on zigwheels site
    When clcik on login
    And click on google sign-in
    Then enter wrong mail-id and error appear
