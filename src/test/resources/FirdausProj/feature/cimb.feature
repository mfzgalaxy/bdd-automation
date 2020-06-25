@firdaus
Feature: Automation Test on CIMB website

  Scenario Outline: Verify on Specific Deal - <Deal>
    Given I'm on "<Url>" page
    When I select CIMB Deals
    And I would like to explore more for "<Deal>" under Travel & Fun
    Then I will be able to see its details and other similar deals
    @Deal-Validate
    Examples:
      | Url | Deal  |
      | https://www.cimb.com.my/en/personal/home.html | Airpaz |

  Scenario Outline: Verify Property Loan Repayment Calculator
    Given I'm on "<Url>" page
    And I navigate to Tools page from menu
    When I access to Property Loan Repayment Calculator from menu
    And I have enter Property Loan Amount = "<Property Loan Amount>"
    And I have enter Property Loan Tenure = "<Property Loan Tenure>"
    And I have enter Year 1 Interest = "<Year 1 Interest>"
    And I have enter Year 2 Interest = "<Year 2 Interest>"
    And I have enter Year 3 Interest = "<Year 3 Interest>"
    And I have enter Year 4 Interest = "<Year 4 Interest>"
    And I have enter Year 5 Interest = "<Year 5 Interest>"
    And I click on Submit
    Then I will be able to see the Effective Interest Rate, Total Interest Payable and Total Amount Payable
    And I will be able to see the loan repayment table with total loan tenure that I’ve entered
    And different interest rates for different year based on my input

    @Tool-Validate
    Examples:
      | Url                                                | Property Loan Amount  | Property Loan Tenure  |    Year 1 Interest  |    Year 2 Interest  |    Year 3 Interest  |    Year 4 Interest  |    Year 5 Interest  |
      | https://www.cimbbank.com.sg/en/personal/index.html | 500,000               |  25                   | 3.25                | 3.50                | 3.60                | 3.70                | 3.75                |
