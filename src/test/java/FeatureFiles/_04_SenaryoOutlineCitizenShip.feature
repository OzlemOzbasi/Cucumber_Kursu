Feature: Citizenship with scenario Outline
   #  Outline  --- TESTNG  deki   Data Provider   mantıgında calısıyor yanı tekrar ettırme, kac kez ıstıyorsan

   #  Given ---  Site verilen durumlarda kullanılır
   #  When  --- Aksiyon alınması gereken zamanlarda kullanılır
   #  Then  --- Aksiyondan sonraki kontroller için kullanılır


  Background:    # Farklı senaryolarda aynı olan kısımlar ıcın olanları bu bolume yazdık
    Given Navigate to Campus
    When Enter username and password and click login button
    Then  User should login successfully
    And Navigate to Citizenship page



    # ilk kayıtta basarılı kayıt mesajı
    Scenario Outline: Citizenship create
      When User a Citizenship name as "<CitizenshipName>"   short name as "<ShortName>"
      Then Success message should be displayed


      # 2. aynı kayıtta hata alma mesajı
      When User a Citizenship name as "<CitizenshipName>"   short name as "<ShortName>"
      Then Already exist message should be displayed
      And Click on close button

      # Silme işlemi
      When User delete the "<CitizenshipName>"
      Then Success message should be displayed


      Examples:
        |  CitizenshipName | ShortName |
        |  ozvatan1        | ozvat1    |
        |  ozvatan2        | ozvat2    |
        |  ozvatan3        | ozvat3    |
        |  ozvatan4        | ozvat4    |