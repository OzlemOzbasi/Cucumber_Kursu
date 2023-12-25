#  1 sınav girişi yapın
#  sonrasında silmesini yapınız


Feature: Entrance Exam Functionality

  Background:    # Farklı senaryolarda aynı olan kısımlar ıcın olanları bu bolume YANİ Background a yazdık
    Given Navigate to Campus
    When Enter username and password and click login button
    Then  User should login successfully


  Scenario: Create and Delete an Exam
    And Click on the element in the left Nav
      |  entranceExamsOne    |
      |  setupTwo            |
      |  entranceExamsTwo    |


    And Click on the element in the Dialog
      |  addButton     |


    And User sending the keys in Dialog Content
      | nameInput | ozlemExam1 |


    And Click on the element in the Form Content
      |  academicPeriod     |
      |  academicPeriod1    |
      |  gradeLevel         |
      |  gradeLevel2        |


    And Click on the element in the Dialog
      |  saveButton     |


    Then Success message should be displayed


    And Click on the element in the left Nav
      |  entranceExamsOne    |
      |  setupTwo            |
      |  entranceExamsTwo    |


    And User delete item from Dialog
      | ozlemExam1 |
                           #  eklemıs oldugumuz sey ne ise onu yazıyoruz silmek için

    Then Success message should be displayed







