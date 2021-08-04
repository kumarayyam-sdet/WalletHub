#Author: kumar.beee2007@gmail.com
@ui @BillPayment @AssignmentA @All
Feature: Bill Payment between Two Accounts

  Scenario Outline: Bill Payment between Two Accounts
  
    When User logged into Parabank Site as "<UserType>"
    Then Account Overview page should be displayed
    And Account Overview table should get displayed
    And User note down the balance and available amount of "<From Account>" accounts as "Pretransaction"
    And User note down the balance and available amount of "<To Account>" accounts as "Pretransaction"
    When User Click Bill Pay in the Account Services section
    Then Bill Payment Service section should get displayed
    When User provide the following Payee details in Bill Payment Service section
      | Payee Name | <Payee Name> |
      | Address    | <Address>    |
      | City       | <City>       |
      | State      | <State>      |
      | Zip Code   | <Zip Code>   |
      | Phone      | <Phone>      |
    And User provide the following account details to pay bill
      | Account        | <To Account>        |
      | Verify Account | <Verify To Account> |
      | Amount         | <Amount>            |
      | From account   | <From Account>      |
    And User click on Send Payment button
    Then Bill payment completion page should get displayed
    When User Click Account Overview in the Account Services section
    Then Account Overview page should be displayed
    And Account Overview table should get displayed
    And User note down the balance and available amount of "<From Account>" accounts as "Posttransaction"
    And User note down the balance and available amount of "<To Account>" accounts as "Posttransaction"
    Then the difference between the "Pretransaction" and "Posttransaction" balance amount of "<From Account>" accounts should be "<Amount>"
    Then the difference between the "Posttransaction" and "Pretransaction" balance amount of "<To Account>" accounts should be "<Amount>"
    When User click on account "<From Account>"
    And transaction table should be displayed with following details for today
      | Transaction | <FromAccount.Transaction> to <Payee Name> |
      | Credit      | <FromAccount.Credit>                      |
      | Debit       | <FromAccount.Debit>                       |
    When User Click Account Overview in the Account Services section
    Then Account Overview page should be displayed
    And Account Overview table should get displayed
    When User click on account "<To Account>"
    And transaction table should be displayed with following details for today
      | Transaction | <ToAccount.Transaction> |
      | Credit      | <ToAccount.Credit>      |
      | Debit       | <ToAccount.Debit>       |
    
    Examples: 
      | UserType    | From Account | To Account | Payee Name | Address       | City      | State | Zip Code | Phone    | Verify To Account | Amount | FromAccount.Transaction | FromAccount.Credit | FromAccount.Debit | ToAccount.Transaction   | ToAccount.Credit | ToAccount.Debit |
      | Auto Tester |        13344 |      14898 | Kumar      | 20,Ridge Loop | Manhattan | NY    |    20089 | 90875178 |             14898 | 200.00 | Bill Payment            |                    | $200.00           | Funds Transfer Received | $200.00          |                 |

      
      
      
      #When User click on account "<From Account>"
    #And transaction table should be displayed with following details
    #| Date        | 05-04-2021                                |
    #| Transaction | <FromAccount.Transaction> to <Payee Name> |
    #| Credit      | <FromAccount.Credit>                      |
    #| Debit       | <FromAccount.Debit>                       |
    #When User Click Account Overview in the Account Services section
    #Then Account Overview page should be displayed
    #And Account Overview table should get displayed
    #When User click on account "<To Account>"
    #And transaction table should be displayed with following details
    #| Date        | 05-04-2021              |
    #| Transaction | <ToAccount.Transaction> |
    #| Credit      | <ToAccount.Credit>      |
    #| Debit       | <ToAccount.Debit>       |
    