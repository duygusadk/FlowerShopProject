Feature: Визуализиране на направените поръчки

  Background: отваряне на приложението
    Given отваряне на приложението

  Scenario: Отваряне на Моите поръчки с направените поръчки
    Then Визуализира списък с направените 5 поръчки

  Scenario: Отваряне на Моите поръчки с направените поръчки
    Then Връща съобщение: "Нямате направени поръчки"

  Scenario: Отваряне на Моите поръчки с направените поръчки с избор на период
    When потребителя избира период от време: "3 месеца"
    And натиска бутона за търсене
    Then Визуализира списък с направените 1 поръчки

  Scenario: Отваряне на Моите поръчки с направените поръчки с търсене по номер за проследяване
    When потребителя въвежда номер на поръчкатата "2345678" в полето за търсене
    And натиска бутона за търсене
    Then Визуализира списък с направените 1 поръчки

  Scenario Outline: Отваряне на Моите поръчки с направените поръчки с търсене по номер за проследяване
    When потребителя въвежда номер на поръчкатата <име> в полето за търсене
    And натиска бутона за търсене
    Then Визуализира списък с направените <брои> поръчки
    Examples:
      | име                               | брои |
      | "2345678"                         | 1    |
      | ""                                | 5    |
      | "         "                       | 5    |
      | "$#%$&^^(*&&*()*)(*)(<><df;;;;'>" | 0    |