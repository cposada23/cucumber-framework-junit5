#
#  TST05-HexactaMainPage: Verificar que al menos un resultado de búsqueda coincida con una búsqueda realizada.
#
#  Steps:
#
#  1. https://www.hexacta.com/
#
#  2. Click en el menú superior derecho "Search". Un campo de búsqueda se mostrará en pantalla.
#
#  3. Tipear el texto "Outsource". Un conjunto de resultados de búsqueda se mostrarán en pantalla.
#
#  4. Ver que en alguno de los resultados se encuentre el texto "Outsourced software team"
@google
Feature: Google search
  @web
  Scenario: Search for Outsource
    Given the user navigates to "https://www.google.com"
    When the user searches for "Outsource"
    Then the user navigates to the firs result

  @web
  Scenario: Search for Outsource
    Given the user navigates to "https://www.google.com"
    When the user searches for "Test"
    Then the user navigates to the firs result
