Feature: Cash Withdrawal
  Scenario: Successful withdrawl from an account in credit
    Given I have deposited $100.00 in my account
    When I request $20
    Then $20 should be dispensed
    And the balance of my account should be $80.00
