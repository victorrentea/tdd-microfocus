#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Tennis Score 

Scenario: Initial Score 
	Given An empty game 
	Then The score is "Love-Love" 
	##
	
	
Scenario: Fifteen Love 
	Given An empty game 
	When Player1 scores 1 point 
	Then The score is "Fifteen-Love" 
	##
	
Scenario: Fifteen Fifteen 
	Given An empty game 
	When Player1 scores 1 point 
	When Player2 scores 1 point 
	Then The score is "Fifteen-Fifteen" 
	##
	
	
Scenario: Deuce 
	Given An empty game 
	When Player1 scores 3 point 
	When Player2 scores 3 point 
	Then The score is "Deuce" 
	##
	
Scenario Outline: Matrix tata! 
	Given An empty game 
	When Player1 scores <player1Score> point 
	When Player2 scores <player2Score> point 
	Then The score is "<scoreString>" 
	Examples: 
		| player1Score | player2Score | scoreString |
		| 1 | 1 | Fifteen-Fifteen 					|
		| 1 | 2 | Fifteen-Thirty 					|
		| 1 | 3 | Fifteen-Forty 					|
		| 8 | 8 | Deuce 					|
		| 9 | 8 | Advantage player 1 					|
		| 7 | 5 | Game Won Player 1 |
		
		
		
