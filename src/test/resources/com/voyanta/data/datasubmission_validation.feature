
Feature: Data Submission Test for validating the Data at cell level


  @ram
  Scenario Outline: Data Submission Test to load the data and check the data uploaded matches the data from Database

    Given The DataSheet exits in the QA Box with name '<FileName>'
    And the datasheet data is saved
    When user uploads the Data from 'UI' with file '<FileName>'
    And it also passed through the Validation and Approval
    Then data should be saved in database table with query name '<QueryName>'
    And data in all the cells should match

  Examples:

    | FileName            | QueryName       |
  #  | Lease (v5.1).xlsx   | Lease.sql       |
  #  | Development.xlsx    | Development.sql |
  #  | Investment.xlsx | Investment.sql |
  #  | LegalEntity.xlsx    | LegalEntity.sql |
  #  | Legal Entity Vendor.xlsx | LegalEntityVendor.sql |
  #  | Asset Transaction.xlsx | AssetTransaction.sql |
  #  | InvestmentLimit.xlsx | Investmentlimit.sql |
  #  | InvestmentValuation.xlsx | InvestmentValuation.sql |
  #  | Debt Facility.xlsx   | DebtFacility.sql |
  #  | Debt Facility Event.xlsx | DebtFacilityEvent.sql |
  #  | Debt Facility Status.xlsx | DebtFacilityStatus.sql |
  #  | Covenant.xlsx       | Covenant.sql    |
  #  | Covenant Limit.xlsx | CovenantLimit.sql |
  #  | Covenant Value.xlsx | CovenantValue.sql |
  #  | Debt Collateral.xlsx | DebtCollateral.sql |
  #  | Debt Valuation.xlsx | DebtValuation.sql |
  #  | Debt Participation.xlsx | DebtParticipation.sql |
  #  | EquityParticipation.xlsx | EquityParticipation.sql |
  #  | Asset Valuation.xlsx | AssetValuation.sql |
  #  | GroundLease.xlsx    | GroundLease.sql |
  #  | Unit (v5.0).xlsx     | Unit.sql        |
  #  | Lease Unit (v5.1).xlsx | LeaseUnit.sql |
  #  | AccountsReceivable.xlsx | AccountReceivables.sql |
  #  | Recurring Billing.xlsx | RecurringBilling.sql |
  #  | RentEscalation.xlsx | RentEscalation.sql |
  #  | Option.xlsx         | Option.sql      |
  #  | TenantAllowence.xlsx | TenantAllowance.sql |
  #  | Recovery.xlsx       | Recovery.sql    |
  #  | Sales.xlsx          | Sales.sql       |
  #  | SalesBreakpoint.xlsx | SalesBreakpoint.sql |
  #  | Account.xlsx        | Account.sql     |
  #  | AccountActivity.xlsx | AccountActivity.sql |
  #  | MarketStatistics.xlsx | MarketStatistics.sql |
  #  | Assumption.xlsx    | Assumption.sql  |
#    | AssumptionProfile.xlsx | AssumptionProfile.sql |
@hiten@done
  Scenario Outline: Upload data with additional columns and verify the data

   Given The DataSheet exits in the QA Box with name '<FileName>'
   And the datasheet data is saved
   When user uploads the Data from 'UI' with file '<FileName>'
    And an addition column '<additionalColumn>' is mapped with '<existingColumn>'
   And it also passed through the Validation and Approval
    Then data should be saved in database table with query name '<QueryName>'
    And data in all the cells should match

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
   | Debt Collateral.xlsx        | DebtCollateral.sql     |                  |                |
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
