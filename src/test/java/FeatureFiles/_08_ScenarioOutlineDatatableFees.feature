#  Daha önceki    Create a Fee , delete Fee   senaryosunu 7.feature dakı gıbı example değerler için çalıştırınız.


Feature: Fee Functionality

  Background:    # Farklı senaryolarda aynı olan kısımlar ıcın olanları bu bolume YANİ Background a yazdık
    Given Navigate to Campus
    When Enter username and password and click login button
    Then  User should login successfully


 Scenario Outline: Create a Fee , delete Fee

    And Click on the element in the left Nav
      |  setupOne          |
      |  parameters        |
      |  fees              |


    And Click on the element in the Dialog
      |  addButton     |


    And User sending the keys in Dialog Content
      | nameInput       | <name>     |
      | codeInput       | <code>     |
      | integrationCode | <intCode>  |
      | priorityCode    | <priority> |


    And Click on the element in the Dialog
      |  saveButton     |


    And Success message should be displayed


    And User delete item from Dialog
      | <name> |
                           #  eklemıs oldugumuz sey ne ise onu yazıyoruz silmek için

    And Success message should be displayed

   Examples:
     | name      | code  | intCode   | priority |
     | ozlemFee1 | 01000 | paypal    | 485      |
     | ozlemFee2 | 02111 | applePay  | 584      |
     | ozlemFee3 | 03154 | googlePay | 845      |
