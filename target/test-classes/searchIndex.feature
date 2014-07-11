Feature: user should be able to search by using Object Name, Reference, Tags;

Background: user has signed in succesfully
Given he is on the sign in page
Given he enters "smoketester@smoke.com" as user name and "password1!" as password 
Given he arrives at main page


Scenario Outline: Search by using Object Name or reference
Given User type in object name or reference <searchTerm> to search for object
Then correct <ObjectGroup> should be returned
Then correct PageTitle for <searchTerm> should be returned
Then Download All button should appear on the page 

@smokeTest
Examples: for smoke Test
| searchTerm                  | ObjectGroup|
|"BuildingName001"            | Building   |
|"Building001"                | Building   |

Examples: using object Name
| searchTerm                  | ObjectGroup|
|"BuildingName002"            | Building   |
|"BuildingName"               | Building   |
|"  BuildingName "            | Building   |
|"Name001"                    | Building,Legal Entity,Account,Investment|
|"name001"                    | Building,Legal Entity,Account,Investment|


Examples: using object Reference
| searchTerm                  | ObjectGroup|
|"Ref001"                     | Building,Legal Entity,Investment|

@noResult
Scenario Outline: No Result for not existing Object or objects from another Org
Given User type in object name or reference <searchTerm> to search for object
Then correct PageTitle for <searchTerm> should be returned
Then No result found should be showed

Examples: no result
| searchTerm   |
|"noresult"    | 


 