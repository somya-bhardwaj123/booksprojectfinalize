Feature: Search the book on the search bar

@positivescenario
  Scenario Outline: Seaching the book on the bookSite
   Given user navigates to the book website
    When user enters the "<Email>" and "<Password>" credentials 
    Then user navigates to the home page
    When user clicks on search bar and enter the book name
    And user click on search button 
    #Then user see list of the books
    When user refine your search based on title on the books
    And user refine your search based on price on the books
    #And user refine your search based on discount on the books
    And user refine your search based on shipping on the books
    
    
    
    
    Examples: 
    |Email                  | Password  | 
    |userdemo578@gmail.com  |Demo@1234  |
    
