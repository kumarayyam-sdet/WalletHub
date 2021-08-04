#Author: kumar.beee2007@gmail.com
@ui @BillPayFormVerification @AssignmentA @All
Feature: Bill Pay - Form Verification

  Scenario Outline: Bill Pay - Form Verification - Required Fields
    When User logged into Parabank Site as "Auto Tester"
    Then Account Overview page should be displayed
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
      | Account        | <Account>        |
      | Verify Account | <Verify Account> |
      | Amount         | <Amount>         |
    And User click on Send Payment button
    Then the error should displayed the error "<FieldError>" against "<Field>"

    Examples: 
      | Payee Name | Address         | City      | State | Zip Code | Phone      | Account | Verify Account | Amount | FieldError             | Field      |
      |            | 40,Bridge Water | Manhattan | NY    |     2008 | 9093422874 | 2007890 |        2007890 |    100 | Payee name is required | Payee Name |
      | Kumar      |                 | Manhattan | NY    |     2008 | 9093422874 | 2007890 |        2007890 |     100 | Address is required              | Address        |
      | Kumar      | 40,Bridge Water |           | NY    |     2008 | 9093422874 | 2007890 |        2007890 |     100 | City is required                 | City           |
      | Kumar      | 40,Bridge Water | Manhattan |       |     2008 | 9093422874 | 2007890 |        2007890 |     100 | NY is required                   | State          |
      | Kumar      | 40,Bridge Water | Manhattan | NY    |          | 9093422874 | 2007890 |        2007890 |     100 | Zip Code is required             | Zip Code       |
      | Kumar      | 40,Bridge Water | Manhattan | NY    |     2008 |            | 2007890 |        2007890 |     100 | Phone number is required         | Phone          |
      | Kumar      | 40,Bridge Water | Manhattan | NY    |     2008 | 9093422874 |         |        2007890 |     100 | Account number is required       | Account        |
      | Kumar      | 40,Bridge Water | Manhattan | NY    |     2008 | 9093422874 | 2007890 |                |     100 | Account number is required       | Verify Account |
      | Kumar      | 40,Bridge Water | Manhattan | NY    |     2008 | 9093422874 | 2007890 |        2007890 |         | The amount cannot be empty       | Amount         |
      | Kumar      | 40,Bridge Water | Manhattan | NY    |     2008 | 9093422874 | 2007890 |        2007890 |     100 | The account numbers do not match | Verify Account |
      | Kumar      | 40,Bridge Water | Manhattan | NY    |     2008 | 9093422874 | Invalid |        2007890 |     100 | Please enter a valid number      | Account        |
      | Kumar      | 40,Bridge Water | Manhattan | NY    |     2008 | 9093422874 | 2007890 | Invalid        |     100 | Please enter a valid number      | Verify Account |
      | Kumar      | 40,Bridge Water | Manhattan | NY    |     2008 | 9093422874 | 2007890 |        2007990 |     100 | The account numbers do not match | Verify Account |
      | Kumar      | 40,Bridge Water | Manhattan | NY    |     2008 | 9093422874 | 2007890 |        2007890 | Invalid | Please enter a valid amount      | Amount         |
