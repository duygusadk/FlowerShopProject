Feature: Добавяне в количка
  Background:
    Given Потребителя избира цвете "Роза" от списъка с наличните цветя


  Scenario: Избиране на цвете и въвеждане на броя на съответно цвете
    When Потребителят избира 1 броя цветя
    And Натиска бутона Добави
    Then Вижда съобщение "Успешно добавихте продуктите в количката"

  Scenario: Избиране на цвете и въвеждане на голямо или отрицателно число за броя на съответно цвете
    When Потребителят избира -6 броя цветя
    And Натиска бутона Добави
    Then Вижда съобщение "Броят трябва да е между 1 и 30"

  Scenario: Избиране на цвете и въвеждане на букви или специални знаци за броя на съответно цвете
    When Потребителят избира "аа" броя цветя
    And Натиска бутона Добави
    Then Вижда съобщение "Броят не може да съдържа букви или специални знаци"

  Scenario: Избиране на цвете и без въвеждане на броя на съответно цвете
    When Потребителят не въвежда броя цветя
    And Натиска бутона Добави
    Then Вижда съобщение "Моля изберете броя"

  Scenario: Избиране на цвете и въвеждане на броя на съответно цвете
    When Потребителят избира 5 броя цветя
    And Натиска бутона Добави
    Then Вижда съобщение "Количеството,което искате не е налично,налични са по-малко броя"