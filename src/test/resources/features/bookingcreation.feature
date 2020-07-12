Feature: Creation of booking 

Scenario Outline: Creation of a booking End to End 
	Given User is in the login page 
	When User enters login credentials with userID as <UserID> and Password as <Password> 
	Then Uesr navigates to the Booking page 
	And User enters the booking details as <PONumber>,<shipper>,<consignee>,<ETA> 
	When User clicks the save button 
	Then popup window appears with the message <message> 
	And booking number gets genearted upon save 
	
	Examples: 
	|UserID|Password|PONumber  |shipper  |consignee   |ETA|message                     |
	|Auto01|P@ss123 |PO12345678|CN AS VDR|GB CUST01 HQ|3  |Booking created successfully|
    |Auto01|P@ss123 |PO12345678|CN AS VDR|GB CUST01 HQ|3  |Booking created successfully|