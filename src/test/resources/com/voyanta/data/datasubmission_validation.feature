@dst
Feature: Data Submission Test for validating the Data at cell level


 # Background:
  #  Given the data is deleted from database
  @ignore
  Scenario Outline: Data Submission Test to load the data and check the data uploaded matches the data from Database

    Given The DataSheet exists in the QA Box with name '<FileName>'
    And the data from DST is collected and saved as expected data
    When user uploads the Data from 'UI' with file '<FileName>'
    And the DST have passed through the Validations and Approvals
    And data is collected from database with query '<QueryName>'
    Then the uploaded data from DST should match with database tables

  Examples:

    | FileName          | QueryName |
    | Lease (v5.1).xlsx | Lease.sql |

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

    | FileName                  | QueryName               | additionalColumn | existingColumn |
    | Building.xlsx             | Building.sql            | AssetActive      | Active         |
    | Development.xlsx          | Development.sql         |                  |                |
    | Legal Entity Vendor.xlsx  | LegalEntityVendor.sql   |                  |                |
    | Investment.xlsx           | Investment.sql          |                  |                |
    | Account.xlsx              | Account.sql             |                  |                |
    | Farm.xlsx                 | Farm.sql                |                  |                |
 #   | LegalEntity.xlsx            | LegalEntity.sql        |                  |                |
    | Asset Transaction.xlsx    | AssetTransaction.sql    |                  |                |
    | InvestmentLimit.xlsx      | Investmentlimit.sql     |                  |                |
    | InvestmentValuation.xlsx  | InvestmentValuation.sql |                  |                |
    | Legal Entity Tenant.xlsx  | Tenant.sql              |                  |                |
    | Debt Facility.xlsx        | DebtFacility.sql        |                  |                |
    | Debt Facility Event.xlsx  | DebtFacilityEvent.sql   |                  |                |
    | Debt Facility Status.xlsx | DebtFacilityStatus.sql  |                  |                |
    | Covenant.xlsx             | Covenant.sql            |                  |                |
 #   | Debt Collateral.xlsx        | DebtCollateral.sql     |                  |                |
    | Debt Valuation.xlsx       | DebtValuation.sql       |                  |                |
    | Covenant Limit.xlsx       | CovenantLimit.sql       |                  |                |
    | Covenant Value.xlsx       | CovenantValue.sql       |                  |                |
    | EquityParticipation.xlsx  | EquityParticipation.sql |                  |                |
    | Debt Participation.xlsx   | DebtParticipation.sql   |                  |                |
    | AccountActivity.xlsx      | AccountActivity.sql     |                  |                |
    | MarketStatistics.xlsx     | MarketStatistics.sql    |                  |                |
    | Assumption.xlsx           | Assumption.sql          |                  |                |
    | AssumptionProfile.xlsx    | AssumptionProfile.sql   |                  |                |
    | Asset Valuation.xlsx      | AssetValuation.sql      |                  |                |
    | GroundLease.xlsx          | GroundLease.sql         |                  |                |
    | Unit (v5.0).xlsx          | Unit.sql                |                  |                |
    | Lease (v5.1).xlsx         | Lease.sql               |                  |                |
    | AccountsReceivable.xlsx   | AccountReceivables.sql  |                  |                |
    | Unit Vacancy Cost.xlsx    | UnitVacancyCosts.sql    |                  |                |
    | Lease Unit (v5.1).xlsx    | LeaseUnit.sql           |                  |                |
    | Recurring Billing.xlsx    | RecurringBilling.sql    |                  |                |
    | RentEscalation.xlsx       | RentEscalation.sql      |                  |                |
    | Option.xlsx               | Option.sql              |                  |                |
    | TenantAllowence.xlsx      | TenantAllowance.sql     |                  |                |
    | Recovery.xlsx             | Recovery.sql            |                  |                |
    | Sales.xlsx                | Sales.sql               |                  |                |
    | SalesBreakpoint.xlsx      | SalesBreakpoint.sql     |                  |                |

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

    | FileName                  | EditedFileName                 | QueryName               | additionalColumn | existingColumn  | matchingKeys                               |
#    | Building.xlsx             | Building-Edit.xlsx             | Building.sql             | Active           | Asset Reference |      Asset Reference                                      |to handle additional columns
#    | Development.xlsx          | Development-Edit.xlsx          | Development.sql         |                  |                 | developmentReference                       |
#    | Legal Entity Vendor.xlsx  | Legal Entity Vendor-Edit.xlsx  | LegalEntityVendor.sql   |                  |                 | Legal Entity Reference                     |Hiten to have a look, resutls not matching
#    | Investment.xlsx           | Investment-Edit.xlsx           | Investment.sql          |                  |                 | Legal Entity Reference                     |Hiten to have a look, resutls not matching
#    | Account.xlsx              | Account-Edit.xlsx              | Account.sql             |                  |                 | Account Number                             |
#    | Farm.xlsx                 | Farm-Edit.xlsx                 | Farm.sql                |                  |                 | Asset Reference                            |
#    | LegalEntity.xlsx          | LegalEntity-Edit.xlsx          | LegalEntity.sql         |                  |                 | Legal Entity Reference                     |looks like a bug, pls have a look
#    | Asset Transaction.xlsx    | Asset Transaction-Edit.xlsx    | AssetTransaction.sql    |                  |                 | Asset Reference,Owner Entity Reference     |Failing to approve the DST from UIStepDefs
#    | InvestmentLimit.xlsx      | InvestmentLimit-Edit.xlsx      | Investmentlimit.sql     |                  |                 | Limit Reference                            |Errors in uploading
#    | InvestmentValuation.xlsx  | InvestmentValuation-Edit.xlsx  | InvestmentValuation.sql |                  |                 | Valuation Date                             |Error in uploading
#    | Legal Entity Tenant.xlsx  | Legal Entity Tenant-Edit.xlsx  | Tenant.sql              |                  |                 | Legal Entity Reference                     |Column name :providerreference Actual Value :'PROV001' Expected Value :'PROV002'
#    | Debt Facility.xlsx        | Debt Facility-Edit.xlsx        | DebtFacility.sql        |                  |                 | Debt Facility Reference                    |Error in uploading
#    | Debt Facility Event.xlsx  | Debt Facility Event-Edit.xlsx  | DebtFacilityEvent.sql   |                  |                 | Provider Reference,Debt Facility Reference |
#    | Debt Facility Status.xlsx | Debt Facility Status-Edit.xlsx | DebtFacilityStatus.sql  |                  |                 | As of Date                                 |
#    | Covenant.xlsx             | Covenant-Edit.xlsx             | Covenant.sql            |                  |                 | Covenant Reference                         |
#    | Debt Collateral.xlsx      | Debt Collateral-Edit.xlsx      | DebtCollateral.sql      |                  |                 | Debt Collateral Reference                  |
#    | Debt Valuation.xlsx       | Debt Valuation-Edit.xlsx       | DebtValuation.sql       |                  |                 | Valuation Date                             |
#    | Covenant Limit.xlsx       | Covenant Limit-Edit.xlsx       | CovenantLimit.sql       |                  |                 | Test Date                                  |
#    | Covenant Value.xlsx       | Covenant Value-Edit.xlsx       | CovenantValue.sql       |                  |                 | As of Date                                 |
#    | EquityParticipation.xlsx  | EquityParticipation-Edit.xlsx  | EquityParticipation.sql |                  |                 | Equity Participation Reference             |
#    | Debt Participation.xlsx   | Debt Participation-Edit.xlsx   | DebtParticipation.sql   |                  |                 | Debt Participation Reference               |
#    | AccountActivity.xlsx      | AccountActivity-Edit.xlsx      | AccountActivity.sql     |                  |                 | Transaction Date                           |
#    | MarketStatistics.xlsx     | MarketStatistics-Edit.xlsx     | MarketStatistics.sql    |                  |                 | As of Date                                 |
#    | Assumption.xlsx           | Assumption-Edit.xlsx           | Assumption.sql          |                  |                 | Active,Object Type                         |
#    | AssumptionProfile.xlsx    | AssumptionProfile-Edit.xlsx    | AssumptionProfile.sql   |                  |                 | Top Level Object Reference,Object Type     |
#    | Asset Valuation.xlsx      | Asset Valuation-Edit.xlsx      | AssetValuation.sql      |                  |                 | Provider Reference,Asset Reference         |
#    | GroundLease.xlsx          | GroundLease-Edit.xlsx          | GroundLease.sql         |                  |                 | Ground Lease Reference                     |
#    | Unit (v5.0).xlsx          | Unit (v5.0)-Edit.xlsx          | Unit.sql                |                  |                 | Unit Reference                             |
#    | Lease (v5.1).xlsx         | Lease (v5.1)-Edit.xlsx         | Lease.sql               |                  |                 | Lease Reference                            |
#    | AccountsReceivable.xlsx   | AccountsReceivable-Edit.xlsx   | AccountReceivables.sql  |                  |                 | As of Date                                 |
#    | Unit Vacancy Cost.xlsx    | Unit Vacancy Cost-Edit.xlsx    | UnitVacancyCosts.sql    |                  |                 | Unit Reference                             |
#    | Lease Unit (v5.1).xlsx    | Lease Unit (v5.1)-Edit.xlsx    | LeaseUnit.sql           |                  |                 | Unit Reference                             |
#    | Recurring Billing.xlsx    | Recurring Billing-Edit.xlsx    | RecurringBilling.sql    |                  |                 | Recurring Billing Beginning Date           |
#    | RentEscalation.xlsx       | RentEscalation-Edit.xlsx       | RentEscalation.sql      |                  |                 | Review Date                                |
#    | Option.xlsx               | Option-Edit.xlsx               | Option.sql              |                  |                 | Option Reference                           |
#    | TenantAllowence.xlsx      | TenantAllowence-Edit.xlsx      | TenantAllowance.sql     |                  |                 | Tenant Allowance Basis                     |
#    | Recovery.xlsx             | Recovery-Edit.xlsx             | Recovery.sql            |                  |                 | Recovery Reference                         |
#    | Sales.xlsx                | Sales-Edit.xlsx                | Sales.sql               |                  |                 | Period Month                               |
#    | SalesBreakpoint.xlsx      | SalesBreakpoint-Edit.xlsx      | SalesBreakpoint.sql     |                  |                 | Breakpoint End Date                        |


