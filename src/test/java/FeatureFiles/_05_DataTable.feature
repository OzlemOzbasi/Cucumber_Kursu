Feature: Datatable Functionality

  #  Datatable : Bir tane adımın içine birden fazla değer göndermek için

  #  Scenario Outline  ise : Projeyi birden fazla birden fazla çalıştırmak için


  #  Scenario Outline: da verilen değerler için tüm senaryo her satır kadar tekrar çalıştırılıyordu.
  #  Datatable : da ise , sadece ilgili step için toplu veri gönderme imkanı oluşuyor.


  Background:    # Farklı senaryolarda aynı olan kısımlar ıcın olanları bu bolume yazdık
    Given Navigate to Campus
    When Enter username and password and click login button
    Then  User should login successfully


  Scenario: Create Country
    And Click on the element in the left Nav
      |  setupOne      |
      |  parameters    |
      |  countries     |


    And Click on the element in the Dialog
      |  addButton     |


    And User sending the keys in Dialog Content
       | nameInput | ozlemCountry1 |
       | codeInput | 12345         |


    And Click on the element in the Dialog
      |  saveButton     |


    And Success message should be displayed


    And User delete item from Dialog
      | ozlemCountry1 |
                           #  eklemıs oldugumuz sey ne ise onu yazıyoruz silmek için

    And Success message should be displayed
        #  Sildikten sonra tekrar bakıyoruz mesajına


    Scenario: Create a Nationality
      And Click on the element in the left Nav
        |  setupOne          |
        |  parameters        |
        |  nationalities     |


      And Click on the element in the Dialog
        |  addButton     |


      And User sending the keys in Dialog Content
        | nameInput | ozlemNatt1 |


      And Click on the element in the Dialog
        |  saveButton     |


      And Success message should be displayed


      And User delete item from Dialog
        | ozlemNatt1 |
                           #  eklemıs oldugumuz sey ne ise onu yazıyoruz silmek için

      And Success message should be displayed
        #  Sildikten sonra tekrar bakıyoruz mesajına





  Scenario: Create a Fee , delete Fee

    And Click on the element in the left Nav
      |  setupOne          |
      |  parameters        |
      |  fees              |


    And Click on the element in the Dialog
      |  addButton     |


    And User sending the keys in Dialog Content
      | nameInput       | ozlemFee1   |
      | codeInput       | 1235        |
      | integrationCode | 45876       |
      | priorityCode    | 12346       |


    And Click on the element in the Dialog
      |  saveButton     |


    And Success message should be displayed


    And User delete item from Dialog
      | ozlemFee1 |
                           #  eklemıs oldugumuz sey ne ise onu yazıyoruz silmek için

    And Success message should be displayed