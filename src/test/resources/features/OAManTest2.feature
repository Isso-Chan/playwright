
  @all
  Feature: OAMan-2

    @TC004
    Scenario: TC002 User should be able add Unterlagen-2
      Given User launched SwagLabs application
      And user logs in OAMan
      And User clicks VORHABEN
      Then "8" should be equal to "6"
      And user clicks on "Status" to select an option
      And user selects "Entwurf" from displayed options
      And user clicks on the card of project "A - 204 § ab dem Jahr 2034 Zahlen in 86"
      And user navigates "Unterlagen" tab
      When user clicks on "Unterlage erstellen" button on the page
      And user fills "Titel *" as "Created by Playwright"
      And user clicks "Speichern" button on the dialog
      Then created document should be displayed on the page
      And all softAssertions are executed