Feature: To search for available seats on the website

Scenario Outline: Plan for a journey between two cities
	Given User navigates to the "<url>" website
	When User enter the "<fromCity>" from city
	And User selects the "<destin>" destination city
	And User selects the departure date
	And User selects the return date
	When User clicks on the search button
	Then he should be displayed with a successful search result
	
Examples:
 	|   		url						|				fromCity			| 			destin		|
 	|    https://ksrtc.in/oprs-web/     |	         BENGALURU				|          	TRICHY		|
	 