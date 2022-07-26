Feature: Choose writer

  Scenario: Choose csvWriter for Person
    Given Return right writer
    When I'll send an object of Person type
    Then factory return a writer with path - person.csv

  Scenario: Choose csvWriter for Interaction
    Given Return right writer
    When I'll send an object of interaction type
    Then factory return a writer with path - interaction.csv
#    Then Add new "Person"
