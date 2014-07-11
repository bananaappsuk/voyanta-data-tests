@login
Feature: Customer login to the page
As a customer, I already have an account at Voyanta, now I am going
to login to the page. Or as a customer I forgot my password, I want to reset my password


Background: on the Sign In page
Given he is on the sign in page 

Scenario Outline: Sign In
When he enters <username> as user name and <password> as password
Then ensure the <result>

Examples: valide Sign In
| username               |password  | result|
|"voyanta@talosdigital.com" |"password1!" | valid |

Examples: Invalide Sign In
|username               |password   |result     |
|"glueck_li@hotmail.com"|"Ting%123" |security.login.failed    |
|"glueck_li@hotmail.com"|"Ting%1234"|security.login.failed    |
|"glueck_li"            |"Ting%1234"|EmailTopLevelDomain.loginRequest.email |
|""|"password1!"|NotBlank.loginRequest.email|
|"voyanta.qa@gmail.com"|""|NotBlank.loginRequest.password|

@forgetPW
Scenario: forget password
Given he click forget password link
Then ensure he should be linked to forget Password page