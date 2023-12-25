#  Bir önceki Exam Giriş senaryosunu aşağıdaki değerler için çalıştırınız.

#  | ExamName        |  AcademicPeriodOption  |  GradeLevelOption  |
#  | Math exam oz1       |  academicPeriod2  |  gradeLevel4  |
#  | IT exam oz1         |  academicPeriod2  |  gradeLevel2  |
#  | Oracle exam oz1     |  academicPeriod2  |  gradeLevel3  |
#  | Math exam oz1       |  academicPeriod2  |  gradeLevel1  |


Feature: Entrance Exam Functionality

  Background:    # Farklı senaryolarda aynı olan kısımlar ıcın olanları bu bolume YANİ Background a yazdık
    Given Navigate to Campus
    When Enter username and password and click login button
    Then  User should login successfully


  Scenario Outline: Create and Delete an Exam
    And Click on the element in the left Nav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |


    And Click on the element in the Dialog
      | addButton |


    And User sending the keys in Dialog Content
      | nameInput | <ExamName> |


    And Click on the element in the Form Content
      | academicPeriod         |
      | <AcademicPeriodOption> |
      | gradeLevel             |
      | <GradeLevelOption>     |


    And Click on the element in the Dialog
      | saveButton |


    Then Success message should be displayed


    And Click on the element in the left Nav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |


    And User delete item from Dialog
      | <ExamName> |
                           #  eklemıs oldugumuz sey ne ise onu yazıyoruz silmek için

    Then Success message should be displayed


    #  Ctrl + Alt  L  ile alttakı tablonun seklını 1 kerede düzeltıyoruz
    #  CTRL + Z: Bilgisayarda geri alma tuşu olarak bilinen bu kombinasyonla yapılan eylemi geri alabilirsiniz

    Examples:
      | ExamName           | AcademicPeriodOption | GradeLevelOption |
      | Math exam oz1      | academicPeriod1      | gradeLevel2      |
      | IT exam oz1        | academicPeriod1      | gradeLevel2      |
      | Oracle exam oz1    | academicPeriod1      | gradeLevel2      |
      | Chemistry exam oz1 | academicPeriod1      | gradeLevel2      |


    # TODO  Yukarıdaki akademik ve GradeLevelOption için   academicPeriod2  ve  gradeLevel1,3,4  bulunup example koyulacak
   #  TODO  academicPeriod2  ve  gradeLevel1,3,4  bunlar ıcın tekrar locator ıle ugrasmamak ıcın yapmadık