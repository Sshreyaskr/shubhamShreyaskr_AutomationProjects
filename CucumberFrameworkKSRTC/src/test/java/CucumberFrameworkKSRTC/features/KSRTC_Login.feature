Feature: Login into the KSRTC website

Scenario Outline: Login using different sets of data
	Given User navigates to the KSRTC website
	When User clicks the Sign In button
	And fills the form with the given sheetname "<SheetName>" and rownumber <RowNumber>
	When User clicks on the Login button
	Then the username will be visible on the website upon successful login otherwise not

Examples:
	|	SheetName		| 	RowNumber	|
	|	Sheet1			|     0			|
	|	Sheet1			|     1			|