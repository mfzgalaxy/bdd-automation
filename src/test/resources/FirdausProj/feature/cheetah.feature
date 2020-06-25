@firdaus
Feature: Automation Test for Cheetah Interview

  Scenario Outline: Drag and drop testing
    Given I'm on "<Url>" page
    When I drag little blue circle and drop into large circle
    Then I will be able to see You did great! Results
    @cheetah
    Examples:
      | Url |
      | https://demos.telerik.com/kendo-ui/dragdrop/index |