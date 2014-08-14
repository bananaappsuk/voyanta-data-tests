@dst
Feature: Data Submission Test for validating the Data at cell level


  @ignore
  Scenario Outline: Data Submission Test to load the data and check the data uploaded matches the data from Database

    Given The DataSheet exists in the QA Box with name '<FileName>'
    And the data from DST is collected and saved as expected data
    When user uploads the Data from 'UI' with file '<FileName>'
    And the DST have passed through the Validations and Approvals
    And data is collected from database with query '<QueryName>'
    Then the uploaded data from DST should match with database tables

  Examples:

    | FileName            | QueryName       |
    | Lease (v5.1).xlsx   | Lease.sql       |

  @done
  Scenario Outline: Upload data with additional columns and verify the data

   Given The DataSheet exists in the QA Box with name '<FileName>'
   And the data from DST is collected and saved as expected data
   When user uploads the new DST from 'UI' with file '<FileName>'
   And an additional column '<additionalColumn>' is mapped with '<existingColumn>'
   And the DST have passed through the Validations and Approvals
   And data is collected from database with query '<QueryName>'
   Then the uploaded data from DST should match with database tables

 Examples:

   | FileName                    | QueryName              | additionalColumn | existingColumn |
   | Building.xlsx               | Building.sql           | AssetActive      | Active         |
   | Development.xlsx            | Development.sql        |                  |                |
   | Legal Entity Vendor.xlsx    | LegalEntityVendor.sql  |                  |                |
   | Investment.xlsx             | Investment.sql         |                  |                |
   | Account.xlsx                | Account.sql            |                  |                |
   | Farm.xlsx                   | Farm.sql               |                  |                |
#   | LegalEntity.xlsx            | LegalEntity.sql        |                  |                |
   | Asset Transaction.xlsx      | AssetTransaction.sql   |                  |                |
   | InvestmentLimit.xlsx        | Investmentlimit.sql    |                  |                |
   | InvestmentValuation.xlsx    | InvestmentValuation.sql|                  |                |
   | Legal Entity Tenant.xlsx    | Tenant.sql             |                  |                |
   | Debt Facility.xlsx          | DebtFacility.sql       |                  |                |
   | Debt Facility Event.xlsx    | DebtFacilityEvent.sql  |                  |                |
   | Debt Facility Status.xlsx   | DebtFacilityStatus.sql |                  |                |
   | Covenant.xlsx               | Covenant.sql           |                  |                |
#   | Debt Collateral.xlsx        | DebtCollateral.sql     |                  |                |
   | Debt Valuation.xlsx         | DebtValuation.sql      |                  |                |
   | Covenant Limit.xlsx         | CovenantLimit.sql      |                  |                |
   | Covenant Value.xlsx         | CovenantValue.sql      |                  |                |
   | EquityParticipation.xlsx    | EquityParticipation.sql|                  |                |
   | Debt Participation.xlsx     | DebtParticipation.sql  |                  |                |
   | AccountActivity.xlsx        | AccountActivity.sql    |                  |                |
   | MarketStatistics.xlsx       | MarketStatistics.sql   |                  |                |
   | Assumption.xlsx             | Assumption.sql         |                  |                |
   | AssumptionProfile.xlsx      | AssumptionProfile.sql  |                  |                |
   |  Asset Valuation.xlsx       | AssetValuation.sql     |                  |                |
   | GroundLease.xlsx            | GroundLease.sql        |                  |                |
   | Unit (v5.0).xlsx            | Unit.sql               |                  |                |
   | Lease (v5.1).xlsx           | Lease.sql              |                  |                |
   | AccountsReceivable.xlsx     | AccountReceivables.sql |                  |                |
   | Unit Vacancy Cost.xlsx      | UnitVacancyCosts.sql   |                  |                |
   | Lease Unit (v5.1).xlsx      | LeaseUnit.sql          |                  |                |
   | Recurring Billing.xlsx      | RecurringBilling.sql   |                  |                |
   | RentEscalation.xlsx         | RentEscalation.sql     |                  |                |
   | Option.xlsx                 | Option.sql             |                  |                |
   | TenantAllowence.xlsx        | TenantAllowance.sql    |                  |                |
   | Recovery.xlsx               | Recovery.sql           |                  |                |
   | Sales.xlsx                  | Sales.sql              |                  |                |
   | SalesBreakpoint.xlsx        | SalesBreakpoint.sql    |                  |                |

  @inprogress
  Scenario Outline: Upload the edit DST verify the data in Database

    Given The DataSheet exists in the QA Box with name '<FileName>'
    And the data from DST is collected and saved as expected data
    When user uploads the new DST from 'UI' with file '<FileName>'
    And an additional column '<additionalColumn>' is mapped with '<existingColumn>'
    And the DST have passed through the Validations and Approvals
#    And data is collected from database with query '<QueryName>'
#    Then the uploaded data from DST should match with database tables
    And The Edited DataSheet exists in the QA Box with name '<EditedFileName>'
    And the Edited data from DST is collected and saved as expected data
    When user uploads the edit DST from 'UI' with file '<EditedFileName>'
    And data is collected from database with query '<QueryName>'
    Then the uploaded data from DST should match with database tables sorted with '<matchingKeys>'

  Examples:

    | FileName       |EditedFileName             | QueryName              | additionalColumn | existingColumn |matchingKeys|
#    | Building.xlsx               | Building.sql           | AssetActive      | Active         |
#    | Development.xlsx  | Development-Edit.xlsx         | Development.sql        |                  |                |    developmentReference       |
#    | Legal Entity Vendor.xlsx    | LegalEntityVendor.sql  |                  |                |
#    | Investment.xlsx             | Investment.sql         |                  |                |
#    | Account.xlsx                | Account.sql            |                  |                |
#    | Farm.xlsx                   | Farm.sql               |                  |                |
# #   | LegalEntity.xlsx            | LegalEntity.sql        |                  |                |
#    | Asset Transaction.xlsx      | AssetTransaction.sql   |                  |                |
#    | InvestmentLimit.xlsx        | Investmentlimit.sql    |                  |                |
#    | InvestmentValuation.xlsx    | InvestmentValuation.sql|                  |                |
#    | Legal Entity Tenant.xlsx    | Tenant.sql             |                  |                |
#    | Debt Facility.xlsx          | DebtFacility.sql       |                  |                |
#    | Debt Facility Event.xlsx    | DebtFacilityEvent.sql  |                  |                |
#    | Debt Facility Status.xlsx   | DebtFacilityStatus.sql |                  |                |
#    | Covenant.xlsx               | Covenant.sql           |                  |                |
# #   | Debt Collateral.xlsx        | DebtCollateral.sql     |                  |                |
#    | Debt Valuation.xlsx         | DebtValuation.sql      |                  |                |
#    | Covenant Limit.xlsx         | CovenantLimit.sql      |                  |                |
#    | Covenant Value.xlsx         | CovenantValue.sql      |                  |                |
#    | EquityParticipation.xlsx    | EquityParticipation.sql|                  |                |
#    | Debt Participation.xlsx     | DebtParticipation.sql  |                  |                |
#    | AccountActivity.xlsx        | AccountActivity.sql    |                  |                |
#    | MarketStatistics.xlsx       | MarketStatistics.sql   |                  |                |
    | Assumption.xlsx   |Assumption-Edit.xlsx           | Assumption.sql         |                  |                |Active,Object Type    |
#    | AssumptionProfile.xlsx      | AssumptionProfile.sql  |                  |                |
#    |  Asset Valuation.xlsx       | AssetValuation.sql     |                  |                |
#    | GroundLease.xlsx            | GroundLease.sql        |                  |                |
#    | Unit (v5.0).xlsx            | Unit.sql               |                  |                |
#    | Lease (v5.1).xlsx           | Lease.sql              |                  |                |
#    | AccountsReceivable.xlsx     | AccountReceivables.sql |                  |                |
#    | Unit Vacancy Cost.xlsx      | UnitVacancyCosts.sql   |                  |                |
#    | Lease Unit (v5.1).xlsx      | LeaseUnit.sql          |                  |                |
#    | Recurring Billing.xlsx      | RecurringBilling.sql   |                  |                |
#    | RentEscalation.xlsx         | RentEscalation.sql     |                  |                |
#    | Option.xlsx                 | Option.sql             |                  |                |
#    | TenantAllowence.xlsx        | TenantAllowance.sql    |                  |                |
#    | Recovery.xlsx               | Recovery.sql           |                  |                |
#    | Sales.xlsx                  | Sales.sql              |                  |                |
#    | SalesBreakpoint.xlsx        | SalesBreakpoint.sql    |                  |                |


