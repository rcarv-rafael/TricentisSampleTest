Feature: Vehicle Insurance request form

  Scenario: Success send request form.
    Given user is on main Request Insurance form page
    When to fill out Vehicle data
    * to fill out Insurant data
    * to fill out Product data
    And choose Price option
    And send Quote
    Then see success message.