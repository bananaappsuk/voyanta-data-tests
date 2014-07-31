@export
Feature: Checking the export functionality

  Scenario Outline: Export functionality
    
    Given all the files are saved under 'StandartExport' folder
    Given an exported file exists with name '<ExpectedFile>'
    And data is loaded with entity name '<Entity>' with primary key '<primarykey>'
    Then both files should have same set of data

  Examples:

    | ExpectedFile                                 | Entity              | primarykey              |
    | ACCOUNT-Account.xml                          | ACCOUNT             | AccountNumber           |
    | ACCOUNTACTIVITY-Account Activity.xml         | ACCOUNTACTIVITY     | TransactionReference    |
    | ACCOUNTSRECEIVABLE-Accounts Receivable.xml   | ACCOUNTSRECEIVABLE  | LeaseReference          |    
    | ASSETFINANCIALSUMMARY-Asset Financial Summary.xml| ASSETFINANCIALSUMMARY     | AssetReference      |    
    | ASSETTRANSACTION-Asset Transaction.xml       | ASSETTRANSACTION    | AssetReference          |
    | ASSETVALUATION-Asset Valuation.xml           | ASSETVALUATION      | AssetReference          |    
    | ASSUMPTION-Assumption.xml                    | ASSUMPTION          | TopLevelObjectReference |
    | ASSUMPTIONPROFILE-Assumption Profile.xml     | ASSUMPTIONPROFILE   | TopLevelObjectReference |    
    | BUILDING-Asset.xml                           | BUILDING            | AssetReference          |
    | COVENANT-Covenant.xml                        | COVENANT            | DebtFacilityReference   |
    | COVENANTLIMIT-Covenant Limit.xml             | COVENANTLIMIT       | DebtFacilityReference   |
    | COVENANTVALUE-Covenant Value.xml             | COVENANTVALUE       | DebtFacilityReference   |
    | DEBTCOLLATERAL-Debt Collateral.xml           | DEBTCOLLATERAL      | DebtFacilityReference   |    
    | DEBTFACILITY-Debt Facility.xml               | DEBTFACILITY        | DebtFacilityReference   |
    | DEBTFACILITYEVENT-Debt Facility Event.xml    | DEBTFACILITYEVENT   | DebtFacilityReference   |
    | DEBTFACILITYSTATUS-Debt Facility Status.xml  | DEBTFACILITYSTATUS  | DebtFacilityReference   |
    | DEBTPARTICIPATION-Debt Participation.xml     | DEBTPARTICIPATION   | DebtFacilityReference   |
    | DEBTVALUATION-Debt Valuation.xml             | DEBTVALUATION       | DebtFacilityReference   |
    | DEVELOPMENT-Development.xml                  | DEVELOPMENT         | AssetReference          |    
    | EQUITYPARTICIPATION-Equity Participation.xml | EQUITYPARTICIPATION | InvestorReference       |    
    | FARM-Farm.xml                                | FARM                | AssetReference          |
    | GROUNDLEASE-Ground Lease.xml                 | GROUNDLEASE         | GroundLeaseReference    |    
    | INVESTMENT-Investment.xml                    | INVESTMENT          | LegalEntityReference    |    
    | INVESTMENTLIMIT-Investment Limit.xml         | INVESTMENTLIMIT     | InvestmentReference     |
    | INVESTMENTVALUATION-Investment Valuation.xml | INVESTMENTVALUATION | InvestmentReference     |
    | LEASE-Lease.xml                              | LEASE               | LeaseReference          |
    | LEASEUNIT-Lease Unit.xml                     | LEASEUNIT           | AssetReference          |
    | LEGALENTITY-Legal Entity.xml                 | LEGALENTITY         | LegalEntityReference    |
    | LEGALENTITYVENDOR-Legal Entity Vendor.xml    | LEGALENTITYVENDOR   | LegalEntityReference    |
    | MARKETSTATISTICS-Market Statistics.xml       | MARKETSTATISTICS    | AsOfDate                |
    | OPTION-Option.xml                            | OPTION              | LeaseUnitReference      |
    | RECOVERY-Recovery.xml                        | RECOVERY            | LeaseUnitReference      |    
    | RECURRINGBILLING-Recurring Billing.xml       | RECURRINGBILLING    | AssetReference          |
    | RENTESCALATION-Rent Escalation.xml           | RENTESCALATION      | LeaseUnitReference|
    | SALESBREAKPOINT-Sales Breakpoint.xml         | SALESBREAKPOINT     | LeaseUnitReference      |        
    | SALES-Sales.xml                              | SALES               | LeaseUnitReference      |
    | TENANTALLOWANCE-Tenant Allowance.xml         | TENANTALLOWANCE     | LeaseUnitReference      |
    | TENANT-Legal Entity Tenant.xml               | TENANT              | LegalEntityReference       |
    | UNIT-Unit.xml                                | UNIT                | BuildingReference       |
    | UNITVACANCYCOSTS-Unit Vacancy Cost.xml       | UNITVACANCYCOSTS    | AssetReference          |

@Taliance
  Scenario Outline: Taliance Export Test
    
    Given all the files are saved under 'TalianceExport' folder
    Given an exported file exists with name '<ExpectedFile>'
    And data is loaded with entity name '<Entity>' with primary key '<primarykey>'
    And ignore the validation taking today's value for '<NodeList>'
    Then both files should have same set of data

  Examples:

    | ExpectedFile                                 | Entity              | primarykey              | NodeList         |
    | _ACCOUNTING_-Account Activity.xml            | ACCOUNTING          | IDENTITY                | DSYS1            |
    | _AXISAFFECT_-Asset.xml                       | AXISAFFECT          | IDENTITY                | DSYS1, DSTART    |
    | _COMPANY_-Investment.XML                     | COMPANY             | IDCOMPANY               | DSYS1            |
    | _LEASE_-Lease.xml                            | LEASE               | IDLEASE                 | DSYS1            |
    | _LEASEEVENT_-Recurring Billing.xml               | LEASEEVENT          | IDLEASE                 | DSYS1            |
    | _LEASEKEYDATE_-Lease.xml                     | LEASEKEYDATE        | IDLEASE                 | DSYS1            |
    | _LEASEREBILL_-Recovery.xml                   | LEASEREBILL         | IDLEASE                 | DSYS1            |
    | _LEASETURNOVERSLICE_-Sales Breakpoint.xml    | LEASETURNOVERSLICE  | IDLEASE                 | DSYS1            |
    | _OPEXBUDGET_-Account Activity.XML            | OPEXBUDGET          | IDPROPERTY              | DSYS1            |
    | _OWNERSHIP_-Asset.xml                        | OWNERSHIP           | IDPROPERTY              | DSYS1            |
    | _OWNERSHIP_-Development.xml                  | OWNERSHIP           | IDPROPERTY              | DSYS1            |
    | _PLAINVAL_-Asset Valuation.xml               | PLAINVAL            | IDPROPERTY              | DSYS1            |
    | _PROPERTY_-Asset.xml                         | PROPERTY            | IDPROPERTY              | DSYS1            |
    | _REFACCOUNT_-Account.xml                     | REF_ACCOUNT         | IDACCOUNT               |                  |
    | _REFOPEXBUDHEAD_-Account.xml                 | REF_OPEXBUDHEAD     | CCODE               |                  |
    | _REFWKBUDHEAD_-Account.xml                       | REF_WKBUDHEAD       | CCODE               |                  |
    | _RENTREVIEW_-Rent Escalation.xml             | RENTREVIEW          | IDPROPERTY              | DSYS1            |
    | _TENANT_-Legal Entity Tenant.xml             | TENANT              | IDTENANT                | DSYS1            |
    | _UNIT_-Unit.xml                              | UNIT                | IDUNIT                  | DSYS1            |
    | _UNITEXPENSE_-Unit.xml                       | UNITEXPENSE         | IDUNIT                  | DSYS1            |
    | _UNITMKTVALUE_-Unit.xml                      | UNITMKTVALUE        | IDUNIT                  | DSYS1, DMKTVALUE |
    | _UNITOCC_-Unit.xml                           | UNITOCC             | IDUNIT                  | DSYS1            |
    | _WKBUDGET_-Account Activity.xml              | WKBUDGET            | IDPROPERTY              | DSYS1            |