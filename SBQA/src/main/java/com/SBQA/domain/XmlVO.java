package com.SBQA.domain;

/**
 * @author user
 *
 */
public class XmlVO {
	
	private String ExchangedDocument_ID;
	private String ExchangedDocument_ReferencedDocument_ID;
	private String ExchangedDocument_IssueDateTime;
	private String TaxInvoiceDocument_IssueID;
	private String TaxInvoiceDocument_TypeCode;
	private String TaxInvoiceDocument_DescriptionText;
	private String TaxInvoiceDocument_IssueDateTime;
	private String TaxInvoiceDocument_AmendmentStatusCode;
	private String TaxInvoiceDocument_PurposeCode;
	private String TaxInvoiceDocument_OriginalIssueID;
	private String TaxInvoiceDocument_ReferencedImportDocument_ID;
	private String TaxInvoiceDocument_ReferencedImportDocument_ItemQuantity;
	private String TaxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod_StartDateTime;
	private String TaxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod_EndDateTime;
	private String TaxInvoiceTradeSettlement_InvoicerParty_ID;
	private String TaxInvoiceTradeSettlement_InvoicerParty_TypeCode;
	private String TaxInvoiceTradeSettlement_InvoicerParty_NameText;
	private String TaxInvoiceTradeSettlement_InvoicerParty_ClassificationCode;
	private String TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedOrganization_TaxRegistrationID;
	private String TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedPerson_NameText;
	private String TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_DepartmentNameText;
	private String TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_PersonNameText;
	private String TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_TelephoneCommunication;
	private String TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_URICommunication;
	private String TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedAddress_LineOneText;
	private String TaxInvoiceTradeSettlement_InvoiceeParty_ID;
	private String TaxInvoiceTradeSettlement_InvoiceeParty_TypeCode;
	private String TaxInvoiceTradeSettlement_InvoiceeParty_NameText;
	private String TaxInvoiceTradeSettlement_InvoiceeParty_ClassificationCode;
	private String TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_TaxRegistrationID;
	private String TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_BusinessTypeCode;
	private String TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedPerson_NameText;
	private String TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_DepartmentNameText;
	private String TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_PersonNameText;
	private String TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_TelephoneCommunication;
	private String TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_URICommunication;
	private String TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_DepartmentNameText;
	private String TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_PersonNameText;
	private String TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_TelephoneCommunication;
	private String TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_URICommunication;
	private String TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedAddress_LineOneText;
	private String TaxInvoiceTradeSettlement_BrokerParty_ID;
	private String TaxInvoiceTradeSettlement_BrokerParty_TypeCode;
	private String TaxInvoiceTradeSettlement_BrokerParty_NameText;
	private String TaxInvoiceTradeSettlement_BrokerParty_ClassificationCode;
	private String TaxInvoiceTradeSettlement_BrokerParty_SpecifiedOrganization_TaxRegistrationID;
	private String TaxInvoiceTradeSettlement_BrokerParty_SpecifiedPerson_NameText;
	private String TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_DepartmentNameText;
	private String TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_PersonNameText;
	private String TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_TelephoneCommunication;
	private String TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_URICommunication;
	private String TaxInvoiceTradeSettlement_BrokerParty_SpecifiedAddress_LineOneText;
	private String[] TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode;
	private String[] TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount;
	private String TaxInvoiceTradeSettlement_SpecifiedMonetarySummation_ChargeTotalAmount;
	private String TaxInvoiceTradeSettlement_SpecifiedMonetarySummation_TaxTotalAmount;
	private String TaxInvoiceTradeSettlement_SpecifiedMonetarySummation_GrandTotalAmount;
	private String TaxInvoiceTradeLineItem_SequenceNumeric;
	private String TaxInvoiceTradeLineItem_DescriptionText;
	private String TaxInvoiceTradeLineItem_InvoiceAmount;
	private String TaxInvoiceTradeLineItem_ChargeableUnitQuantity;
	private String TaxInvoiceTradeLineItem_InformationText;
	private String TaxInvoiceTradeLineItem_NameText;
	private String TaxInvoiceTradeLineItem_PurchaseExpiryDateTime;
	private String TaxInvoiceTradeLineItem_TotalTax_CalculatedAmount;
	private String TaxInvoiceTradeLineItem_UnitPrice_UnitAmount;
	
	public String getExchangedDocument_ID() {
		return ExchangedDocument_ID;
	}
	public void setExchangedDocument_ID(String exchangedDocument_ID) {
		ExchangedDocument_ID = exchangedDocument_ID;
	}
	public String getExchangedDocument_ReferencedDocument_ID() {
		return ExchangedDocument_ReferencedDocument_ID;
	}
	public void setExchangedDocument_ReferencedDocument_ID(String exchangedDocument_ReferencedDocument_ID) {
		ExchangedDocument_ReferencedDocument_ID = exchangedDocument_ReferencedDocument_ID;
	}
	public String getExchangedDocument_IssueDateTime() {
		return ExchangedDocument_IssueDateTime;
	}
	public void setExchangedDocument_IssueDateTime(String exchangedDocument_IssueDateTime) {
		ExchangedDocument_IssueDateTime = exchangedDocument_IssueDateTime;
	}
	public String getTaxInvoiceDocument_IssueID() {
		return TaxInvoiceDocument_IssueID;
	}
	public void setTaxInvoiceDocument_IssueID(String taxInvoiceDocument_IssueID) {
		TaxInvoiceDocument_IssueID = taxInvoiceDocument_IssueID;
	}
	public String getTaxInvoiceDocument_TypeCode() {
		return TaxInvoiceDocument_TypeCode;
	}
	public void setTaxInvoiceDocument_TypeCode(String taxInvoiceDocument_TypeCode) {
		TaxInvoiceDocument_TypeCode = taxInvoiceDocument_TypeCode;
	}
	public String getTaxInvoiceDocument_DescriptionText() {
		return TaxInvoiceDocument_DescriptionText;
	}
	public void setTaxInvoiceDocument_DescriptionText(String taxInvoiceDocument_DescriptionText) {
		TaxInvoiceDocument_DescriptionText = taxInvoiceDocument_DescriptionText;
	}
	public String getTaxInvoiceDocument_IssueDateTime() {
		return TaxInvoiceDocument_IssueDateTime;
	}
	public void setTaxInvoiceDocument_IssueDateTime(String taxInvoiceDocument_IssueDateTime) {
		TaxInvoiceDocument_IssueDateTime = taxInvoiceDocument_IssueDateTime;
	}
	public String getTaxInvoiceDocument_AmendmentStatusCode() {
		return TaxInvoiceDocument_AmendmentStatusCode;
	}
	public void setTaxInvoiceDocument_AmendmentStatusCode(String taxInvoiceDocument_AmendmentStatusCode) {
		TaxInvoiceDocument_AmendmentStatusCode = taxInvoiceDocument_AmendmentStatusCode;
	}
	public String getTaxInvoiceDocument_PurposeCode() {
		return TaxInvoiceDocument_PurposeCode;
	}
	public void setTaxInvoiceDocument_PurposeCode(String taxInvoiceDocument_PurposeCode) {
		TaxInvoiceDocument_PurposeCode = taxInvoiceDocument_PurposeCode;
	}
	public String getTaxInvoiceDocument_OriginalIssueID() {
		return TaxInvoiceDocument_OriginalIssueID;
	}
	public void setTaxInvoiceDocument_OriginalIssueID(String taxInvoiceDocument_OriginalIssueID) {
		TaxInvoiceDocument_OriginalIssueID = taxInvoiceDocument_OriginalIssueID;
	}
	public String getTaxInvoiceDocument_ReferencedImportDocument_ID() {
		return TaxInvoiceDocument_ReferencedImportDocument_ID;
	}
	public void setTaxInvoiceDocument_ReferencedImportDocument_ID(String taxInvoiceDocument_ReferencedImportDocument_ID) {
		TaxInvoiceDocument_ReferencedImportDocument_ID = taxInvoiceDocument_ReferencedImportDocument_ID;
	}
	public String getTaxInvoiceDocument_ReferencedImportDocument_ItemQuantity() {
		return TaxInvoiceDocument_ReferencedImportDocument_ItemQuantity;
	}
	public void setTaxInvoiceDocument_ReferencedImportDocument_ItemQuantity(
			String taxInvoiceDocument_ReferencedImportDocument_ItemQuantity) {
		TaxInvoiceDocument_ReferencedImportDocument_ItemQuantity = taxInvoiceDocument_ReferencedImportDocument_ItemQuantity;
	}
	public String getTaxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod_StartDateTime() {
		return TaxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod_StartDateTime;
	}
	public void setTaxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod_StartDateTime(
			String taxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod_StartDateTime) {
		TaxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod_StartDateTime = taxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod_StartDateTime;
	}
	public String getTaxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod_EndDateTime() {
		return TaxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod_EndDateTime;
	}
	public void setTaxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod_EndDateTime(
			String taxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod_EndDateTime) {
		TaxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod_EndDateTime = taxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod_EndDateTime;
	}
	public String getTaxInvoiceTradeSettlement_InvoicerParty_ID() {
		return TaxInvoiceTradeSettlement_InvoicerParty_ID;
	}
	public void setTaxInvoiceTradeSettlement_InvoicerParty_ID(String taxInvoiceTradeSettlement_InvoicerParty_ID) {
		TaxInvoiceTradeSettlement_InvoicerParty_ID = taxInvoiceTradeSettlement_InvoicerParty_ID;
	}
	public String getTaxInvoiceTradeSettlement_InvoicerParty_TypeCode() {
		return TaxInvoiceTradeSettlement_InvoicerParty_TypeCode;
	}
	public void setTaxInvoiceTradeSettlement_InvoicerParty_TypeCode(
			String taxInvoiceTradeSettlement_InvoicerParty_TypeCode) {
		TaxInvoiceTradeSettlement_InvoicerParty_TypeCode = taxInvoiceTradeSettlement_InvoicerParty_TypeCode;
	}
	public String getTaxInvoiceTradeSettlement_InvoicerParty_NameText() {
		return TaxInvoiceTradeSettlement_InvoicerParty_NameText;
	}
	public void setTaxInvoiceTradeSettlement_InvoicerParty_NameText(
			String taxInvoiceTradeSettlement_InvoicerParty_NameText) {
		TaxInvoiceTradeSettlement_InvoicerParty_NameText = taxInvoiceTradeSettlement_InvoicerParty_NameText;
	}
	public String getTaxInvoiceTradeSettlement_InvoicerParty_ClassificationCode() {
		return TaxInvoiceTradeSettlement_InvoicerParty_ClassificationCode;
	}
	public void setTaxInvoiceTradeSettlement_InvoicerParty_ClassificationCode(
			String taxInvoiceTradeSettlement_InvoicerParty_ClassificationCode) {
		TaxInvoiceTradeSettlement_InvoicerParty_ClassificationCode = taxInvoiceTradeSettlement_InvoicerParty_ClassificationCode;
	}
	public String getTaxInvoiceTradeSettlement_InvoicerParty_SpecifiedOrganization_TaxRegistrationID() {
		return TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedOrganization_TaxRegistrationID;
	}
	public void setTaxInvoiceTradeSettlement_InvoicerParty_SpecifiedOrganization_TaxRegistrationID(
			String taxInvoiceTradeSettlement_InvoicerParty_SpecifiedOrganization_TaxRegistrationID) {
		TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedOrganization_TaxRegistrationID = taxInvoiceTradeSettlement_InvoicerParty_SpecifiedOrganization_TaxRegistrationID;
	}

	public String getTaxInvoiceTradeSettlement_InvoicerParty_SpecifiedPerson_NameText() {
		return TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedPerson_NameText;
	}
	public void setTaxInvoiceTradeSettlement_InvoicerParty_SpecifiedPerson_NameText(
			String taxInvoiceTradeSettlement_InvoicerParty_SpecifiedPerson_NameText) {
		TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedPerson_NameText = taxInvoiceTradeSettlement_InvoicerParty_SpecifiedPerson_NameText;
	}
	public String getTaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_DepartmentNameText() {
		return TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_DepartmentNameText;
	}
	public void setTaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_DepartmentNameText(
			String taxInvoiceTradeSettlement_InvoicerParty_DefinedContact_DepartmentNameText) {
		TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_DepartmentNameText = taxInvoiceTradeSettlement_InvoicerParty_DefinedContact_DepartmentNameText;
	}
	public String getTaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_PersonNameText() {
		return TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_PersonNameText;
	}
	public void setTaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_PersonNameText(
			String taxInvoiceTradeSettlement_InvoicerParty_DefinedContact_PersonNameText) {
		TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_PersonNameText = taxInvoiceTradeSettlement_InvoicerParty_DefinedContact_PersonNameText;
	}
	public String getTaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_TelephoneCommunication() {
		return TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_TelephoneCommunication;
	}
	public void setTaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_TelephoneCommunication(
			String taxInvoiceTradeSettlement_InvoicerParty_DefinedContact_TelephoneCommunication) {
		TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_TelephoneCommunication = taxInvoiceTradeSettlement_InvoicerParty_DefinedContact_TelephoneCommunication;
	}
	public String getTaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_URICommunication() {
		return TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_URICommunication;
	}
	public void setTaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_URICommunication(
			String taxInvoiceTradeSettlement_InvoicerParty_DefinedContact_URICommunication) {
		TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_URICommunication = taxInvoiceTradeSettlement_InvoicerParty_DefinedContact_URICommunication;
	}
	public String getTaxInvoiceTradeSettlement_InvoicerParty_SpecifiedAddress_LineOneText() {
		return TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedAddress_LineOneText;
	}
	public void setTaxInvoiceTradeSettlement_InvoicerParty_SpecifiedAddress_LineOneText(
			String taxInvoiceTradeSettlement_InvoicerParty_SpecifiedAddress_LineOneText) {
		TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedAddress_LineOneText = taxInvoiceTradeSettlement_InvoicerParty_SpecifiedAddress_LineOneText;
	}
	public String getTaxInvoiceTradeSettlement_InvoiceeParty_ID() {
		return TaxInvoiceTradeSettlement_InvoiceeParty_ID;
	}
	public void setTaxInvoiceTradeSettlement_InvoiceeParty_ID(String taxInvoiceTradeSettlement_InvoiceeParty_ID) {
		TaxInvoiceTradeSettlement_InvoiceeParty_ID = taxInvoiceTradeSettlement_InvoiceeParty_ID;
	}
	public String getTaxInvoiceTradeSettlement_InvoiceeParty_TypeCode() {
		return TaxInvoiceTradeSettlement_InvoiceeParty_TypeCode;
	}
	public void setTaxInvoiceTradeSettlement_InvoiceeParty_TypeCode(
			String taxInvoiceTradeSettlement_InvoiceeParty_TypeCode) {
		TaxInvoiceTradeSettlement_InvoiceeParty_TypeCode = taxInvoiceTradeSettlement_InvoiceeParty_TypeCode;
	}
	public String getTaxInvoiceTradeSettlement_InvoiceeParty_NameText() {
		return TaxInvoiceTradeSettlement_InvoiceeParty_NameText;
	}
	public void setTaxInvoiceTradeSettlement_InvoiceeParty_NameText(
			String taxInvoiceTradeSettlement_InvoiceeParty_NameText) {
		TaxInvoiceTradeSettlement_InvoiceeParty_NameText = taxInvoiceTradeSettlement_InvoiceeParty_NameText;
	}
	public String getTaxInvoiceTradeSettlement_InvoiceeParty_ClassificationCode() {
		return TaxInvoiceTradeSettlement_InvoiceeParty_ClassificationCode;
	}
	public void setTaxInvoiceTradeSettlement_InvoiceeParty_ClassificationCode(
			String taxInvoiceTradeSettlement_InvoiceeParty_ClassificationCode) {
		TaxInvoiceTradeSettlement_InvoiceeParty_ClassificationCode = taxInvoiceTradeSettlement_InvoiceeParty_ClassificationCode;
	}
	public String getTaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_TaxRegistrationID() {
		return TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_TaxRegistrationID;
	}
	public void setTaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_TaxRegistrationID(
			String taxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_TaxRegistrationID) {
		TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_TaxRegistrationID = taxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_TaxRegistrationID;
	}
	public String getTaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_BusinessTypeCode() {
		return TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_BusinessTypeCode;
	}
	public void setTaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_BusinessTypeCode(
			String taxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_BusinessTypeCode) {
		TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_BusinessTypeCode = taxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_BusinessTypeCode;
	}
	public String getTaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedPerson_NameText() {
		return TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedPerson_NameText;
	}
	public void setTaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedPerson_NameText(
			String taxInvoiceTradeSettlement_InvoiceeParty_SpecifiedPerson_NameText) {
		TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedPerson_NameText = taxInvoiceTradeSettlement_InvoiceeParty_SpecifiedPerson_NameText;
	}
	public String getTaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_DepartmentNameText() {
		return TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_DepartmentNameText;
	}
	public void setTaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_DepartmentNameText(
			String taxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_DepartmentNameText) {
		TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_DepartmentNameText = taxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_DepartmentNameText;
	}
	public String getTaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_PersonNameText() {
		return TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_PersonNameText;
	}
	public void setTaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_PersonNameText(
			String taxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_PersonNameText) {
		TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_PersonNameText = taxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_PersonNameText;
	}
	public String getTaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_TelephoneCommunication() {
		return TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_TelephoneCommunication;
	}
	public void setTaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_TelephoneCommunication(
			String taxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_TelephoneCommunication) {
		TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_TelephoneCommunication = taxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_TelephoneCommunication;
	}
	public String getTaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_URICommunication() {
		return TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_URICommunication;
	}
	public void setTaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_URICommunication(
			String taxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_URICommunication) {
		TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_URICommunication = taxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_URICommunication;
	}
	public String getTaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_DepartmentNameText() {
		return TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_DepartmentNameText;
	}
	public void setTaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_DepartmentNameText(
			String taxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_DepartmentNameText) {
		TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_DepartmentNameText = taxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_DepartmentNameText;
	}
	public String getTaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_PersonNameText() {
		return TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_PersonNameText;
	}
	public void setTaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_PersonNameText(
			String taxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_PersonNameText) {
		TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_PersonNameText = taxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_PersonNameText;
	}
	public String getTaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_TelephoneCommunication() {
		return TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_TelephoneCommunication;
	}
	public void setTaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_TelephoneCommunication(
			String taxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_TelephoneCommunication) {
		TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_TelephoneCommunication = taxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_TelephoneCommunication;
	}
	public String getTaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_URICommunication() {
		return TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_URICommunication;
	}
	public void setTaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_URICommunication(
			String taxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_URICommunication) {
		TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_URICommunication = taxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_URICommunication;
	}
	public String getTaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedAddress_LineOneText() {
		return TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedAddress_LineOneText;
	}
	public void setTaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedAddress_LineOneText(
			String taxInvoiceTradeSettlement_InvoiceeParty_SpecifiedAddress_LineOneText) {
		TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedAddress_LineOneText = taxInvoiceTradeSettlement_InvoiceeParty_SpecifiedAddress_LineOneText;
	}
	public String getTaxInvoiceTradeSettlement_BrokerParty_ID() {
		return TaxInvoiceTradeSettlement_BrokerParty_ID;
	}
	public void setTaxInvoiceTradeSettlement_BrokerParty_ID(String taxInvoiceTradeSettlement_BrokerParty_ID) {
		TaxInvoiceTradeSettlement_BrokerParty_ID = taxInvoiceTradeSettlement_BrokerParty_ID;
	}
	public String getTaxInvoiceTradeSettlement_BrokerParty_TypeCode() {
		return TaxInvoiceTradeSettlement_BrokerParty_TypeCode;
	}
	public void setTaxInvoiceTradeSettlement_BrokerParty_TypeCode(String taxInvoiceTradeSettlement_BrokerParty_TypeCode) {
		TaxInvoiceTradeSettlement_BrokerParty_TypeCode = taxInvoiceTradeSettlement_BrokerParty_TypeCode;
	}
	public String getTaxInvoiceTradeSettlement_BrokerParty_NameText() {
		return TaxInvoiceTradeSettlement_BrokerParty_NameText;
	}
	public void setTaxInvoiceTradeSettlement_BrokerParty_NameText(String taxInvoiceTradeSettlement_BrokerParty_NameText) {
		TaxInvoiceTradeSettlement_BrokerParty_NameText = taxInvoiceTradeSettlement_BrokerParty_NameText;
	}
	public String getTaxInvoiceTradeSettlement_BrokerParty_ClassificationCode() {
		return TaxInvoiceTradeSettlement_BrokerParty_ClassificationCode;
	}
	public void setTaxInvoiceTradeSettlement_BrokerParty_ClassificationCode(
			String taxInvoiceTradeSettlement_BrokerParty_ClassificationCode) {
		TaxInvoiceTradeSettlement_BrokerParty_ClassificationCode = taxInvoiceTradeSettlement_BrokerParty_ClassificationCode;
	}
	public String getTaxInvoiceTradeSettlement_BrokerParty_SpecifiedOrganization_TaxRegistrationID() {
		return TaxInvoiceTradeSettlement_BrokerParty_SpecifiedOrganization_TaxRegistrationID;
	}
	public void setTaxInvoiceTradeSettlement_BrokerParty_SpecifiedOrganization_TaxRegistrationID(
			String taxInvoiceTradeSettlement_BrokerParty_SpecifiedOrganization_TaxRegistrationID) {
		TaxInvoiceTradeSettlement_BrokerParty_SpecifiedOrganization_TaxRegistrationID = taxInvoiceTradeSettlement_BrokerParty_SpecifiedOrganization_TaxRegistrationID;
	}
	public String getTaxInvoiceTradeSettlement_BrokerParty_SpecifiedPerson_NameText() {
		return TaxInvoiceTradeSettlement_BrokerParty_SpecifiedPerson_NameText;
	}
	public void setTaxInvoiceTradeSettlement_BrokerParty_SpecifiedPerson_NameText(
			String taxInvoiceTradeSettlement_BrokerParty_SpecifiedPerson_NameText) {
		TaxInvoiceTradeSettlement_BrokerParty_SpecifiedPerson_NameText = taxInvoiceTradeSettlement_BrokerParty_SpecifiedPerson_NameText;
	}
	public String getTaxInvoiceTradeSettlement_BrokerParty_DefinedContact_DepartmentNameText() {
		return TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_DepartmentNameText;
	}
	public void setTaxInvoiceTradeSettlement_BrokerParty_DefinedContact_DepartmentNameText(
			String taxInvoiceTradeSettlement_BrokerParty_DefinedContact_DepartmentNameText) {
		TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_DepartmentNameText = taxInvoiceTradeSettlement_BrokerParty_DefinedContact_DepartmentNameText;
	}
	public String getTaxInvoiceTradeSettlement_BrokerParty_DefinedContact_PersonNameText() {
		return TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_PersonNameText;
	}
	public void setTaxInvoiceTradeSettlement_BrokerParty_DefinedContact_PersonNameText(
			String taxInvoiceTradeSettlement_BrokerParty_DefinedContact_PersonNameText) {
		TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_PersonNameText = taxInvoiceTradeSettlement_BrokerParty_DefinedContact_PersonNameText;
	}
	public String getTaxInvoiceTradeSettlement_BrokerParty_DefinedContact_TelephoneCommunication() {
		return TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_TelephoneCommunication;
	}
	public void setTaxInvoiceTradeSettlement_BrokerParty_DefinedContact_TelephoneCommunication(
			String taxInvoiceTradeSettlement_BrokerParty_DefinedContact_TelephoneCommunication) {
		TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_TelephoneCommunication = taxInvoiceTradeSettlement_BrokerParty_DefinedContact_TelephoneCommunication;
	}
	public String getTaxInvoiceTradeSettlement_BrokerParty_DefinedContact_URICommunication() {
		return TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_URICommunication;
	}
	public void setTaxInvoiceTradeSettlement_BrokerParty_DefinedContact_URICommunication(
			String taxInvoiceTradeSettlement_BrokerParty_DefinedContact_URICommunication) {
		TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_URICommunication = taxInvoiceTradeSettlement_BrokerParty_DefinedContact_URICommunication;
	}
	public String getTaxInvoiceTradeSettlement_BrokerParty_SpecifiedAddress_LineOneText() {
		return TaxInvoiceTradeSettlement_BrokerParty_SpecifiedAddress_LineOneText;
	}
	public void setTaxInvoiceTradeSettlement_BrokerParty_SpecifiedAddress_LineOneText(
			String taxInvoiceTradeSettlement_BrokerParty_SpecifiedAddress_LineOneText) {
		TaxInvoiceTradeSettlement_BrokerParty_SpecifiedAddress_LineOneText = taxInvoiceTradeSettlement_BrokerParty_SpecifiedAddress_LineOneText;
	}
	public String[] getTaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode() {
		return TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode;
	}
	public void setTaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode(
			String[] taxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode) {
		TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode = taxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode;
	}
	public String[] getTaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount() {
		return TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount;
	}
	public void setTaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount(
			String[] taxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount) {
		TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount = taxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount;
	}
	public String getTaxInvoiceTradeSettlement_SpecifiedMonetarySummation_ChargeTotalAmount() {
		return TaxInvoiceTradeSettlement_SpecifiedMonetarySummation_ChargeTotalAmount;
	}
	public void setTaxInvoiceTradeSettlement_SpecifiedMonetarySummation_ChargeTotalAmount(
			String taxInvoiceTradeSettlement_SpecifiedMonetarySummation_ChargeTotalAmount) {
		TaxInvoiceTradeSettlement_SpecifiedMonetarySummation_ChargeTotalAmount = taxInvoiceTradeSettlement_SpecifiedMonetarySummation_ChargeTotalAmount;
	}
	public String getTaxInvoiceTradeSettlement_SpecifiedMonetarySummation_TaxTotalAmount() {
		return TaxInvoiceTradeSettlement_SpecifiedMonetarySummation_TaxTotalAmount;
	}
	public void setTaxInvoiceTradeSettlement_SpecifiedMonetarySummation_TaxTotalAmount(
			String taxInvoiceTradeSettlement_SpecifiedMonetarySummation_TaxTotalAmount) {
		TaxInvoiceTradeSettlement_SpecifiedMonetarySummation_TaxTotalAmount = taxInvoiceTradeSettlement_SpecifiedMonetarySummation_TaxTotalAmount;
	}
	public String getTaxInvoiceTradeSettlement_SpecifiedMonetarySummation_GrandTotalAmount() {
		return TaxInvoiceTradeSettlement_SpecifiedMonetarySummation_GrandTotalAmount;
	}
	public void setTaxInvoiceTradeSettlement_SpecifiedMonetarySummation_GrandTotalAmount(
			String taxInvoiceTradeSettlement_SpecifiedMonetarySummation_GrandTotalAmount) {
		TaxInvoiceTradeSettlement_SpecifiedMonetarySummation_GrandTotalAmount = taxInvoiceTradeSettlement_SpecifiedMonetarySummation_GrandTotalAmount;
	}
	public String getTaxInvoiceTradeLineItem_SequenceNumeric() {
		return TaxInvoiceTradeLineItem_SequenceNumeric;
	}
	public void setTaxInvoiceTradeLineItem_SequenceNumeric(String taxInvoiceTradeLineItem_SequenceNumeric) {
		TaxInvoiceTradeLineItem_SequenceNumeric = taxInvoiceTradeLineItem_SequenceNumeric;
	}
	public String getTaxInvoiceTradeLineItem_DescriptionText() {
		return TaxInvoiceTradeLineItem_DescriptionText;
	}
	public void setTaxInvoiceTradeLineItem_DescriptionText(String taxInvoiceTradeLineItem_DescriptionText) {
		TaxInvoiceTradeLineItem_DescriptionText = taxInvoiceTradeLineItem_DescriptionText;
	}
	public String getTaxInvoiceTradeLineItem_InvoiceAmount() {
		return TaxInvoiceTradeLineItem_InvoiceAmount;
	}
	public void setTaxInvoiceTradeLineItem_InvoiceAmount(String taxInvoiceTradeLineItem_InvoiceAmount) {
		TaxInvoiceTradeLineItem_InvoiceAmount = taxInvoiceTradeLineItem_InvoiceAmount;
	}
	public String getTaxInvoiceTradeLineItem_ChargeableUnitQuantity() {
		return TaxInvoiceTradeLineItem_ChargeableUnitQuantity;
	}
	public void setTaxInvoiceTradeLineItem_ChargeableUnitQuantity(String taxInvoiceTradeLineItem_ChargeableUnitQuantity) {
		TaxInvoiceTradeLineItem_ChargeableUnitQuantity = taxInvoiceTradeLineItem_ChargeableUnitQuantity;
	}
	public String getTaxInvoiceTradeLineItem_InformationText() {
		return TaxInvoiceTradeLineItem_InformationText;
	}
	public void setTaxInvoiceTradeLineItem_InformationText(String taxInvoiceTradeLineItem_InformationText) {
		TaxInvoiceTradeLineItem_InformationText = taxInvoiceTradeLineItem_InformationText;
	}
	public String getTaxInvoiceTradeLineItem_NameText() {
		return TaxInvoiceTradeLineItem_NameText;
	}
	public void setTaxInvoiceTradeLineItem_NameText(String taxInvoiceTradeLineItem_NameText) {
		TaxInvoiceTradeLineItem_NameText = taxInvoiceTradeLineItem_NameText;
	}
	public String getTaxInvoiceTradeLineItem_PurchaseExpiryDateTime() {
		return TaxInvoiceTradeLineItem_PurchaseExpiryDateTime;
	}
	public void setTaxInvoiceTradeLineItem_PurchaseExpiryDateTime(String taxInvoiceTradeLineItem_PurchaseExpiryDateTime) {
		TaxInvoiceTradeLineItem_PurchaseExpiryDateTime = taxInvoiceTradeLineItem_PurchaseExpiryDateTime;
	}
	public String getTaxInvoiceTradeLineItem_TotalTax_CalculatedAmount() {
		return TaxInvoiceTradeLineItem_TotalTax_CalculatedAmount;
	}
	public void setTaxInvoiceTradeLineItem_TotalTax_CalculatedAmount(
			String taxInvoiceTradeLineItem_TotalTax_CalculatedAmount) {
		TaxInvoiceTradeLineItem_TotalTax_CalculatedAmount = taxInvoiceTradeLineItem_TotalTax_CalculatedAmount;
	}
	public String getTaxInvoiceTradeLineItem_UnitPrice_UnitAmount() {
		return TaxInvoiceTradeLineItem_UnitPrice_UnitAmount;
	}
	public void setTaxInvoiceTradeLineItem_UnitPrice_UnitAmount(String taxInvoiceTradeLineItem_UnitPrice_UnitAmount) {
		TaxInvoiceTradeLineItem_UnitPrice_UnitAmount = taxInvoiceTradeLineItem_UnitPrice_UnitAmount;
	}
	
	

}
