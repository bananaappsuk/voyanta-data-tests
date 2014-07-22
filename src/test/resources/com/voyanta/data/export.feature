@export
Feature: Checking the export functionality

@ignore
  Scenario Outline: : Check the given exported actual and expected file

    Given a file with name '<ExpectedFile>' is existing with expected xml data
    And a file with name '<ActualFile>' is existing with actual xml data
    When the data is loaded from actual file with root '<ExpectedRoot>', header '<ExpectedHeader>' and primary key '<primarykey>'
    And the data is loaded from expected file with root '<ActualRoot>', header '<ActualHeader>' and primary key '<primarykey>'
    Then both files should have same set of data with primary key '<primarykey>'

  Examples:

    | ExpectedFile                | ActualFile                  | ExpectedRoot        | ActualRoot          | ExpectedHeader | ActualHeader | primarykey     |
    | BUILDING-Asset.xml          | BUILDING-Asset.xml          | BUILDING_EXTRACT    | BUILDING_EXTRACT    | BUILDING       | BUILDING     | AssetReference |
#    | LEASE-Lease.xml             | LEASE-Lease.xml             | LEASE_EXTRACT       | LEASE_EXTRACT       | LEASE          | LEASE        | LeaseReference |
    | DEVELOPMENT-Development.xml | DEVELOPMENT-Development.xml | DEVELOPMENT_EXTRACT | DEVELOPMENT_EXTRACT | DEVELOPMENT    | DEVELOPMENT  | AssetReference |
#    | INVESTMENT-Investment.xml | INVESTMENT-Investment.xml |INVESTMENT_EXTRACT      |INVESTMENT_EXTRACT  |INVESTMENT      |INVESTMENT    |LegalEntityReference|

  @ram_new
  Scenario Outline: Export functionality

    Given an exported file exists with name '<ExpectedFile>'
    And data is loaded with entity name '<Entity>' with primary key '<primarykey>'
    Then both files should have same set of data

  Examples:

    | ExpectedFile                                 | Entity              | primarykey              |
#    | BUILDING-Asset.xml                           | BUILDING            | AssetReference          |
#    | LEASE-Lease.xml                              | LEASE               | LeaseReference          |
#    | DEVELOPMENT-Development.xml                  | DEVELOPMENT         | AssetReference          |
#    | LEGALENTITY-Legal Entity.xml                 | LEGALENTITY         | LegalEntityReference    |
#    | LEGALENTITYVENDOR-Legal Entity Vendor.xml    | LEGALENTITYVENDOR   | LegalEntityReference    |
#    | ASSETTRANSACTION-Asset Transaction.xml       | ASSETTRANSACTION    | AssetReference          |
#    | INVESTMENTLIMIT-Investment Limit.xml         | INVESTMENTLIMIT     | InvestmentReference     |
#    | INVESTMENTVALUATION-Investment Valuation.xml | INVESTMENTVALUATION | InvestmentReference     |
#    | DEBTFACILITY-Debt Facility.xml               | DEBTFACILITY        | DebtFacilityReference   |
#    | DEBTFACILITYEVENT-Debt Facility Event.xml    | DEBTFACILITYEVENT   | DebtFacilityReference   |
#    | DEBTFACILITYSTATUS-Debt Facility Status.xml  | DEBTFACILITYSTATUS  | DebtFacilityReference   |
    | FARM-Farm.xml                                | FARM                | AssetReference          |
#    | LEGALENTITY-Legal Entity.xml                 | LEGALENTITY         | LegalEntityReference    |
#    | LEGALENTITYVENDOR-Legal Entity Vendor.xml    | LEGALENTITYVENDOR   | LegalEntityReference    |
#    | INVESTMENT-Investment.xml                    | INVESTMENT          | LegalEntityReference    |
#    | ACCOUNT-Account.xml                          | ACCOUNT             | AccountNumber           |
#    | DEBTFACILITY-Debt Facility.xml               | DEBTFACILITY        | DebtFacilityReference   |
#    | ASSETVALUATION-Asset Valuation.xml           | ASSETVALUATION      | AssetReference          |
#    | GROUNDLEASE-Ground Lease.xml                 | GROUNDLEASE         | GroundLeaseReference    |
#    | UNIT-Unit.xml                                | UNIT                | BuildingReference       |
#    | LEASE-Lease.xml                              | LEASE               | BuildingReference       |
#    | ACCOUNTSRECEIVABLE-Accounts Receivable.xml   | ACCOUNTSRECEIVABLE  | LeaseReference          |
#    | UNITVACANCYCOSTS-Unit Vacancy Cost.xml       | UNITVACANCYCOSTS    | AssetReference          |
#    | LEASEUNIT-Lease Unit.xml                     | LEASEUNIT           | AssetReference          |
#    | RECURRINGBILLING-Recurring Billing.xml       | RECURRINGBILLING    | AssetReference          |
#    | RENTESCALATION-Rent Escalation.xml           | RENTESCALATION      | LeaseUnitReference|
#    | OPTION-Option.xml                            | OPTION              | LeaseUnitReference      |
#    | TENANTALLOWANCE-Tenant Allowance.xml         | TENANTALLOWANCE     | LeaseUnitReference      |
#    | RECOVERY-Recovery.xml                        | RECOVERY            | LeaseUnitReference      |
#    | SALES-Sales.xml                              | SALES               | LeaseUnitReference      |
#    | ASSETTRANSACTION-Asset Transaction.xml       | ASSETTRANSACTION    | AssetReference          |
#    | INVESTMENTLIMIT-Investment Limit.xml         | INVESTMENTLIMIT     | InvestmentReference     |
#    | INVESTMENTVALUATION-Investment Valuation.xml | INVESTMENTVALUATION | InvestmentReference     |
#    | DEBTFACILITYEVENT-Debt Facility Event.xml    | DEBTFACILITYEVENT   | DebtFacilityReference   |
#    | DEBTFACILITYSTATUS-Debt Facility Status.xml  | DEBTFACILITYSTATUS  | DebtFacilityReference   |
#    | COVENANT-Covenant.xml                        | COVENANT            | DebtFacilityReference   |
#    | COVENANTVALUE-Covenant Value.xml             | COVENANTVALUE       | DebtFacilityReference   |
#    | COVENANTLIMIT-Covenant Limit.xml             | COVENANTLIMIT       | DebtFacilityReference   |
#    | DEBTCOLLATERAL-Debt Collateral.xml           | DEBTCOLLATERAL      | DebtFacilityReference   |
#    | DEBTVALUATION-Debt Valuation.xml             | DEBTVALUATION       | DebtFacilityReference   |
#    | EQUITYPARTICIPATION-Equity Participation.xml | EQUITYPARTICIPATION | InvestorReference       |
#    | DEBTPARTICIPATION-Debt Participation.xml         | DEBTPARTICIPATION   | DebtFacilityReference   |
#    | ACCOUNTACTIVITY-Account Activity.xml             | ACCOUNTACTIVITY     | TransactionReference    |
#    | MARKETSTATISTICS-Market Statistics.xml          | MARKETSTATISTICS    | AsOfDate                |
#    | ASSUMPTION-Assumption.xml                    | ASSUMPTION          | TopLevelObjectReference |
#    | ASSUMPTIONPROFILE-Assumption Profile.xml     | ASSUMPTIONPROFILE   | TopLevelObjectReference |








