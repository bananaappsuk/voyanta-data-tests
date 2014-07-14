Feature: Data Submission Test for validating the Data at cell level


  @done
  Scenario Outline: Data Submission Test to load the data and check the data uploaded matches the data from Database

    Given The DataSheet exits in the QA Box with name '<FileName>'
    And the datasheet data is saved
    When user uploads the Data from 'UI' with file '<FileName>'
    And it also passed through the Validation and Approval
    Then data should be saved in database table with query name '<QueryName>'
    And data in all the cells should match

  Examples:

    | FileName          | QueryName    |
    | Building.xlsx     | Building.sql |
    | Lease (v5.1).xlsx | Lease.sql    |


  @inprogress
  Scenario Outline: Upload data with additional columns and verify the data

    Given The DataSheet exits in the QA Box with name '<FileName>'
    And the datasheet data is saved
    When user uploads the Data from 'UI' with file '<FileName>'
    And an addition column '<additionalColumn>' is mapped with '<existingColumn>'
    And it also passed through the Validation and Approval
    Then data should be saved in database table with query name '<QueryName>'
    And data in all the cells should match

  Examples:

    | FileName          | QueryName    | additionalColumn | existingColumn |
    | Building.xlsx     | Building1.sql | AssetActive      | Active         |
    | Lease (v5.1).xlsx | Lease.sql    |                  |                |