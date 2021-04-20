@firdaus
Feature: Automation Test for Axiata Digital Interview

  Scenario Outline: Purchase Mobile Plan <MobilePlan>
    Given I'm on "<Url>" page
    When I click on Mobile Link
    And I click on Mobile Rate Plan
    And I scroll down to Best Value Plan
    And I select "<MobilePlan>"
    Then I add to cart
    And I remove from cart
    And I proceed checkout
    @adl
    Examples:
      | Url | MobilePlan |
      | https://www.dialog.lk | 600 |
#      | https://www.dialog.lk | 1500 |