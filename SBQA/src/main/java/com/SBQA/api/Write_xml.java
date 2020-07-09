package com.SBQA.api;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.SBQA.domain.DBXmlVO;
import com.SBQA.domain.XmlVO;

public class Write_xml {
	
	public HashMap<String, Object> write_xml(XmlVO vo) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		try {
			
			//xml 생성
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.newDocument();
			doc.setXmlStandalone(true);
			
			Element TaxInvoice = doc.createElement("TaxInvoice");
			doc.appendChild(TaxInvoice);
			TaxInvoice.setAttribute("xmlns", "urn:kr:or:kec:standard:Tax:ReusableAggregateBusinessInformationEntitySchemaModule:1:0");
			TaxInvoice.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
			TaxInvoice.setAttribute("xsi:schemaLocation", "urn:kr:or:kec:standard:Tax:ReusableAggregateBusinessInformationEntitySchemaModule:1:0 http://www.kec.or.kr/standard/Tax/TaxInvoiceSchemaModule_1.0.xsd");
			
			
			//관리정보
			Element ExchangedDocument = doc.createElement("ExchangedDocument");
			TaxInvoice.appendChild(ExchangedDocument);
			
			Element ExchangedDocument_ID = doc.createElement("ID");
			ExchangedDocument_ID.appendChild(doc.createTextNode(vo.getExchangedDocument_ID()));
			ExchangedDocument.appendChild(ExchangedDocument_ID);
			
			Element ExchangedDocument_IssueDateTime = doc.createElement("IssueDateTime");
			ExchangedDocument_IssueDateTime.appendChild(doc.createTextNode(vo.getExchangedDocument_IssueDateTime()));
			ExchangedDocument.appendChild(ExchangedDocument_IssueDateTime);	
			
			Element ExchangedDocument_ReferencedDocument = doc.createElement("ReferencedDocument");
			ExchangedDocument.appendChild(ExchangedDocument_ReferencedDocument);
			
			Element ExchangedDocument_ReferencedDocument_ID = doc.createElement("ID");
			ExchangedDocument_ReferencedDocument_ID.appendChild(doc.createTextNode(vo.getExchangedDocument_ReferencedDocument_ID()));
			ExchangedDocument_ReferencedDocument.appendChild(ExchangedDocument_ReferencedDocument_ID);
			
			
			//기본정보
			Element TaxInvoiceDocument = doc.createElement("TaxInvoiceDocument");
			TaxInvoice.appendChild(TaxInvoiceDocument);
			
			Element TaxInvoiceDocument_IssueID = doc.createElement("IssueID");
			TaxInvoiceDocument_IssueID.appendChild(doc.createTextNode(vo.getTaxInvoiceDocument_IssueID()));
			TaxInvoiceDocument.appendChild(TaxInvoiceDocument_IssueID);
			
			Element TaxInvoiceDocument_TypeCode = doc.createElement("TypeCode");
			TaxInvoiceDocument_TypeCode.appendChild(doc.createTextNode(vo.getTaxInvoiceDocument_TypeCode()));
			TaxInvoiceDocument.appendChild(TaxInvoiceDocument_TypeCode);
			
			Element TaxInvoiceDocument_DescriptionText = doc.createElement("DescriptionText");
			TaxInvoiceDocument_DescriptionText.appendChild(doc.createTextNode(vo.getTaxInvoiceDocument_DescriptionText()));
			TaxInvoiceDocument.appendChild(TaxInvoiceDocument_DescriptionText);
			
			Element TaxInvoiceDocument_IssueDateTime = doc.createElement("IssueDateTime");
			TaxInvoiceDocument_IssueDateTime.appendChild(doc.createTextNode(vo.getTaxInvoiceDocument_IssueDateTime()));
			TaxInvoiceDocument.appendChild(TaxInvoiceDocument_IssueDateTime);
			
			Element TaxInvoiceDocument_AmendmentStatusCode = doc.createElement("AmendmentStatusCode");
			TaxInvoiceDocument_AmendmentStatusCode.appendChild(doc.createTextNode(vo.getTaxInvoiceDocument_AmendmentStatusCode()));
			TaxInvoiceDocument.appendChild(TaxInvoiceDocument_AmendmentStatusCode);
			
			Element TaxInvoiceDocument_PurposeCode = doc.createElement("PurposeCode");
			TaxInvoiceDocument_PurposeCode.appendChild(doc.createTextNode(vo.getTaxInvoiceDocument_PurposeCode()));
			TaxInvoiceDocument.appendChild(TaxInvoiceDocument_PurposeCode);
			
			Element TaxInvoiceDocument_OriginalIssueID = doc.createElement("OriginalIssueID");
			TaxInvoiceDocument_OriginalIssueID.appendChild(doc.createTextNode(vo.getTaxInvoiceDocument_OriginalIssueID()));
			TaxInvoiceDocument.appendChild(TaxInvoiceDocument_OriginalIssueID);
			

			//수입세금계산서관련정보
			if (vo.getTaxInvoiceDocument_ReferencedImportDocument_ID().isEmpty() == false) {	//빈 노드 제거 함수가 잘 안먹어서 임시로 로직 추가		
				Element TaxInvoiceDocument_ReferencedImportDocument = doc.createElement("ReferencedImportDocument");
				TaxInvoiceDocument.appendChild(TaxInvoiceDocument_ReferencedImportDocument);
				
				Element TaxInvoiceDocument_ReferencedImportDocument_ID = doc.createElement("ID");
				TaxInvoiceDocument_ReferencedImportDocument_ID.appendChild(doc.createTextNode(vo.getTaxInvoiceDocument_ReferencedImportDocument_ID()));
				TaxInvoiceDocument_ReferencedImportDocument.appendChild(TaxInvoiceDocument_ReferencedImportDocument_ID);
				
				Element TaxInvoiceDocument_ReferencedImportDocument_ItemQuantity = doc.createElement("ItemQuantity");
				TaxInvoiceDocument_ReferencedImportDocument_ItemQuantity.appendChild(doc.createTextNode(vo.getTaxInvoiceDocument_ReferencedImportDocument_ItemQuantity()));
				TaxInvoiceDocument_ReferencedImportDocument.appendChild(TaxInvoiceDocument_ReferencedImportDocument_ItemQuantity);
				
				Element TaxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod = doc.createElement("AcceptablePeriod");
				TaxInvoiceDocument_ReferencedImportDocument.appendChild(TaxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod);
				
				Element TaxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod_StartDateTime = doc.createElement("StartDateTime");
				TaxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod_StartDateTime.appendChild(doc.createTextNode(vo.getTaxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod_StartDateTime()));
				TaxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod.appendChild(TaxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod_StartDateTime);
				
				Element TaxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod_EndDateTime = doc.createElement("EndDateTime");
				TaxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod_EndDateTime.appendChild(doc.createTextNode(vo.getTaxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod_EndDateTime()));
				TaxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod.appendChild(TaxInvoiceDocument_ReferencedImportDocument_AcceptablePeriod_EndDateTime);
			}			
			
			//공급자정보
			Element TaxInvoiceTradeSettlement = doc.createElement("TaxInvoiceTradeSettlement");
			TaxInvoice.appendChild(TaxInvoiceTradeSettlement);
			
			Element TaxInvoiceTradeSettlement_InvoicerParty = doc.createElement("InvoicerParty");
			TaxInvoiceTradeSettlement.appendChild(TaxInvoiceTradeSettlement_InvoicerParty);
			
			Element TaxInvoiceTradeSettlement_InvoicerParty_ID = doc.createElement("ID");
			TaxInvoiceTradeSettlement_InvoicerParty_ID.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoicerParty_ID()));
			TaxInvoiceTradeSettlement_InvoicerParty.appendChild(TaxInvoiceTradeSettlement_InvoicerParty_ID);
			
			Element TaxInvoiceTradeSettlement_InvoicerParty_TypeCode = doc.createElement("TypeCode");
			TaxInvoiceTradeSettlement_InvoicerParty_TypeCode.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoicerParty_TypeCode()));
			TaxInvoiceTradeSettlement_InvoicerParty.appendChild(TaxInvoiceTradeSettlement_InvoicerParty_TypeCode);
			
			Element TaxInvoiceTradeSettlement_InvoicerParty_NameText = doc.createElement("NameText");
			TaxInvoiceTradeSettlement_InvoicerParty_NameText.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoicerParty_NameText()));
			TaxInvoiceTradeSettlement_InvoicerParty.appendChild(TaxInvoiceTradeSettlement_InvoicerParty_NameText);
			
			Element TaxInvoiceTradeSettlement_InvoicerParty_ClassificationCode = doc.createElement("ClassificationCode");
			TaxInvoiceTradeSettlement_InvoicerParty_ClassificationCode.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoicerParty_ClassificationCode()));
			TaxInvoiceTradeSettlement_InvoicerParty.appendChild(TaxInvoiceTradeSettlement_InvoicerParty_ClassificationCode);

			if (vo.getTaxInvoiceTradeSettlement_InvoicerParty_SpecifiedOrganization_TaxRegistrationID().isEmpty() == false) {	//빈 노드 제거 함수가 잘 안먹어서 임시로 로직 추가
				Element TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedOrganization = doc.createElement("SpecifiedOrganization");
				TaxInvoiceTradeSettlement_InvoicerParty.appendChild(TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedOrganization);			

				Element TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedOrganization_TaxRegistrationID = doc.createElement("TaxRegistrationID");
				TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedOrganization_TaxRegistrationID.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoicerParty_SpecifiedOrganization_TaxRegistrationID()));
				TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedOrganization.appendChild(TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedOrganization_TaxRegistrationID);
			}
			
			Element TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedPerson = doc.createElement("SpecifiedPerson");
			TaxInvoiceTradeSettlement_InvoicerParty.appendChild(TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedPerson);
			
			Element TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedPerson_NameText = doc.createElement("NameText");
			TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedPerson_NameText.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoicerParty_SpecifiedPerson_NameText()));
			TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedPerson.appendChild(TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedPerson_NameText);
			
			Element TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact = doc.createElement("DefinedContact");
			TaxInvoiceTradeSettlement_InvoicerParty.appendChild(TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact);
			
			Element TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_DepartmentNameText = doc.createElement("DepartmentNameText");
			TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_DepartmentNameText.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_DepartmentNameText()));
			TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact.appendChild(TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_DepartmentNameText);
			
			Element TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_PersonNameText = doc.createElement("PersonNameText");
			TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_PersonNameText.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_PersonNameText()));
			TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact.appendChild(TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_PersonNameText);
			
			Element TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_TelephoneCommunication = doc.createElement("TelephoneCommunication");
			TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_TelephoneCommunication.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_TelephoneCommunication()));
			TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact.appendChild(TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_TelephoneCommunication);
			
			Element TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_URICommunication = doc.createElement("URICommunication");
			TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_URICommunication.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_URICommunication()));
			TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact.appendChild(TaxInvoiceTradeSettlement_InvoicerParty_DefinedContact_URICommunication);
			
			Element TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedAddress = doc.createElement("SpecifiedAddress");
			TaxInvoiceTradeSettlement_InvoicerParty.appendChild(TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedAddress);
			
			Element TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedAddress_LineOneText = doc.createElement("LineOneText");
			TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedAddress_LineOneText.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoicerParty_SpecifiedAddress_LineOneText()));
			TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedAddress.appendChild(TaxInvoiceTradeSettlement_InvoicerParty_SpecifiedAddress_LineOneText);
			
			
			//공급받는자정보
			Element TaxInvoiceTradeSettlement_InvoiceeParty = doc.createElement("InvoiceeParty");
			TaxInvoiceTradeSettlement.appendChild(TaxInvoiceTradeSettlement_InvoiceeParty);
			
			Element TaxInvoiceTradeSettlement_InvoiceeParty_ID = doc.createElement("ID");
			TaxInvoiceTradeSettlement_InvoiceeParty_ID.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoiceeParty_ID()));
			TaxInvoiceTradeSettlement_InvoiceeParty.appendChild(TaxInvoiceTradeSettlement_InvoiceeParty_ID);
			
			Element TaxInvoiceTradeSettlement_InvoiceeParty_TypeCode = doc.createElement("TypeCode");
			TaxInvoiceTradeSettlement_InvoiceeParty_TypeCode.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoiceeParty_TypeCode()));
			TaxInvoiceTradeSettlement_InvoiceeParty.appendChild(TaxInvoiceTradeSettlement_InvoiceeParty_TypeCode);
			
			Element TaxInvoiceTradeSettlement_InvoiceeParty_NameText = doc.createElement("NameText");
			TaxInvoiceTradeSettlement_InvoiceeParty_NameText.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoiceeParty_NameText()));
			TaxInvoiceTradeSettlement_InvoiceeParty.appendChild(TaxInvoiceTradeSettlement_InvoiceeParty_NameText);
			
			Element TaxInvoiceTradeSettlement_InvoiceeParty_ClassificationCode = doc.createElement("ClassificationCode");
			TaxInvoiceTradeSettlement_InvoiceeParty_ClassificationCode.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoiceeParty_ClassificationCode()));
			TaxInvoiceTradeSettlement_InvoiceeParty.appendChild(TaxInvoiceTradeSettlement_InvoiceeParty_ClassificationCode);
			
			Element TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization = doc.createElement("SpecifiedOrganization");
			TaxInvoiceTradeSettlement_InvoiceeParty.appendChild(TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization);
			
			if (vo.getTaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_TaxRegistrationID().isEmpty() == false) {	//빈 노드 제거 함수가 잘 안먹어서 임시로 로직 추가
				Element TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_TaxRegistrationID = doc.createElement("TaxRegistrationID");
				TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_TaxRegistrationID.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_TaxRegistrationID()));
				TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization.appendChild(TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_TaxRegistrationID);
			}
				
			Element TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_BusinessTypeCode = doc.createElement("BusinessTypeCode");
			TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_BusinessTypeCode.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_BusinessTypeCode()));
			TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization.appendChild(TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedOrganization_BusinessTypeCode);
			
			
			Element TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedPerson = doc.createElement("SpecifiedPerson");
			TaxInvoiceTradeSettlement_InvoiceeParty.appendChild(TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedPerson);
			
			Element TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedPerson_NameText = doc.createElement("NameText");
			TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedPerson_NameText.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedPerson_NameText()));
			TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedPerson.appendChild(TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedPerson_NameText);
			
			Element TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact = doc.createElement("PrimaryDefinedContact");
			TaxInvoiceTradeSettlement_InvoiceeParty.appendChild(TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact);
			
			Element TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_DepartmentNameText = doc.createElement("DepartmentNameText");
			TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_DepartmentNameText.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_DepartmentNameText()));
			TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact.appendChild(TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_DepartmentNameText);
			
			Element TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_PersonNameText = doc.createElement("PersonNameText");
			TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_PersonNameText.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_PersonNameText()));
			TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact.appendChild(TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_PersonNameText);
			
			Element TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_TelephoneCommunication = doc.createElement("TelephoneCommunication");
			TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_TelephoneCommunication.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_TelephoneCommunication()));
			TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact.appendChild(TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_TelephoneCommunication);
			
			Element TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_URICommunication = doc.createElement("URICommunication");
			TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_URICommunication.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_URICommunication()));
			TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact.appendChild(TaxInvoiceTradeSettlement_InvoiceeParty_PrimaryDefinedContact_URICommunication);
			
			Element TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact = doc.createElement("SecondaryDefinedContact");
			TaxInvoiceTradeSettlement_InvoiceeParty.appendChild(TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact);
			
			Element TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_DepartmentNameText = doc.createElement("DepartmentNameText");
			TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_DepartmentNameText.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_DepartmentNameText()));
			TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact.appendChild(TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_DepartmentNameText);
			
			Element TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_PersonNameText = doc.createElement("PersonNameText");
			TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_PersonNameText.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_PersonNameText()));
			TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact.appendChild(TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_PersonNameText);
			
			Element TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_TelephoneCommunication = doc.createElement("TelephoneCommunication");
			TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_TelephoneCommunication.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_TelephoneCommunication()));
			TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact.appendChild(TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_TelephoneCommunication);
			
			Element TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_URICommunication = doc.createElement("URICommunication");
			TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_URICommunication.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_URICommunication()));
			TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact.appendChild(TaxInvoiceTradeSettlement_InvoiceeParty_SecondaryDefinedContact_URICommunication);

			
			Element TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedAddress = doc.createElement("SpecifiedAddress");
			TaxInvoiceTradeSettlement_InvoiceeParty.appendChild(TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedAddress);
			
			Element TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedAddress_LineOneText = doc.createElement("LineOneText");
			TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedAddress_LineOneText.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedAddress_LineOneText()));
			TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedAddress.appendChild(TaxInvoiceTradeSettlement_InvoiceeParty_SpecifiedAddress_LineOneText);
			
			
			//수탁사업자자정보
			if(vo.getTaxInvoiceTradeSettlement_BrokerParty_ID().isEmpty() == false) {	//빈 노드 제거 함수가 잘 안먹어서 임시로 로직 추가
				Element TaxInvoiceTradeSettlement_BrokerParty = doc.createElement("BrokerParty");
				TaxInvoiceTradeSettlement.appendChild(TaxInvoiceTradeSettlement_BrokerParty);
				
				Element TaxInvoiceTradeSettlement_BrokerParty_ID = doc.createElement("ID");
				TaxInvoiceTradeSettlement_BrokerParty_ID.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_BrokerParty_ID()));
				TaxInvoiceTradeSettlement_BrokerParty.appendChild(TaxInvoiceTradeSettlement_BrokerParty_ID);
				
				Element TaxInvoiceTradeSettlement_BrokerParty_TypeCode = doc.createElement("TypeCode");
				TaxInvoiceTradeSettlement_BrokerParty_TypeCode.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_BrokerParty_TypeCode()));
				TaxInvoiceTradeSettlement_BrokerParty.appendChild(TaxInvoiceTradeSettlement_BrokerParty_TypeCode);
				
				Element TaxInvoiceTradeSettlement_BrokerParty_NameText = doc.createElement("NameText");
				TaxInvoiceTradeSettlement_BrokerParty_NameText.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_BrokerParty_NameText()));
				TaxInvoiceTradeSettlement_BrokerParty.appendChild(TaxInvoiceTradeSettlement_BrokerParty_NameText);
				
				Element TaxInvoiceTradeSettlement_BrokerParty_ClassificationCode = doc.createElement("ClassificationCode");
				TaxInvoiceTradeSettlement_BrokerParty_ClassificationCode.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_BrokerParty_ClassificationCode()));
				TaxInvoiceTradeSettlement_BrokerParty.appendChild(TaxInvoiceTradeSettlement_BrokerParty_ClassificationCode);
				
				Element TaxInvoiceTradeSettlement_BrokerParty_SpecifiedOrganization = doc.createElement("SpecifiedOrganization");
				TaxInvoiceTradeSettlement_BrokerParty.appendChild(TaxInvoiceTradeSettlement_BrokerParty_SpecifiedOrganization);
				
				Element TaxInvoiceTradeSettlement_BrokerParty_SpecifiedOrganization_TaxRegistrationID = doc.createElement("TaxRegistrationID");
				TaxInvoiceTradeSettlement_BrokerParty_SpecifiedOrganization_TaxRegistrationID.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_BrokerParty_SpecifiedOrganization_TaxRegistrationID()));
				TaxInvoiceTradeSettlement_BrokerParty_SpecifiedOrganization.appendChild(TaxInvoiceTradeSettlement_BrokerParty_SpecifiedOrganization_TaxRegistrationID);
				
				Element TaxInvoiceTradeSettlement_BrokerParty_SpecifiedPerson = doc.createElement("SpecifiedPerson");
				TaxInvoiceTradeSettlement_BrokerParty.appendChild(TaxInvoiceTradeSettlement_BrokerParty_SpecifiedPerson);
				
				Element TaxInvoiceTradeSettlement_BrokerParty_SpecifiedPerson_NameText = doc.createElement("NameText");
				TaxInvoiceTradeSettlement_BrokerParty_SpecifiedPerson_NameText.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_BrokerParty_SpecifiedPerson_NameText()));
				TaxInvoiceTradeSettlement_BrokerParty_SpecifiedPerson.appendChild(TaxInvoiceTradeSettlement_BrokerParty_SpecifiedPerson_NameText);
				
				Element TaxInvoiceTradeSettlement_BrokerParty_DefinedContact = doc.createElement("DefinedContact");
				TaxInvoiceTradeSettlement_BrokerParty.appendChild(TaxInvoiceTradeSettlement_BrokerParty_DefinedContact);
				
				Element TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_DepartmentNameText = doc.createElement("DepartmentNameText");
				TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_DepartmentNameText.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_BrokerParty_DefinedContact_DepartmentNameText()));
				TaxInvoiceTradeSettlement_BrokerParty_DefinedContact.appendChild(TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_DepartmentNameText);
				
				Element TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_PersonNameText = doc.createElement("PersonNameText");
				TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_PersonNameText.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_BrokerParty_DefinedContact_PersonNameText()));
				TaxInvoiceTradeSettlement_BrokerParty_DefinedContact.appendChild(TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_PersonNameText);
				
				Element TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_TelephoneCommunication = doc.createElement("TelephoneCommunication");
				TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_TelephoneCommunication.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_BrokerParty_DefinedContact_TelephoneCommunication()));
				TaxInvoiceTradeSettlement_BrokerParty_DefinedContact.appendChild(TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_TelephoneCommunication);
				
				Element TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_URICommunication = doc.createElement("URICommunication");
				TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_URICommunication.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_BrokerParty_DefinedContact_URICommunication()));
				TaxInvoiceTradeSettlement_BrokerParty_DefinedContact.appendChild(TaxInvoiceTradeSettlement_BrokerParty_DefinedContact_URICommunication);
				
				Element TaxInvoiceTradeSettlement_BrokerParty_SpecifiedAddress = doc.createElement("SpecifiedAddress");
				TaxInvoiceTradeSettlement_BrokerParty.appendChild(TaxInvoiceTradeSettlement_BrokerParty_SpecifiedAddress);
				
				Element TaxInvoiceTradeSettlement_BrokerParty_SpecifiedAddress_LineOneText = doc.createElement("LineOneText");
				TaxInvoiceTradeSettlement_BrokerParty_SpecifiedAddress_LineOneText.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_BrokerParty_SpecifiedAddress_LineOneText()));
				TaxInvoiceTradeSettlement_BrokerParty_SpecifiedAddress.appendChild(TaxInvoiceTradeSettlement_BrokerParty_SpecifiedAddress_LineOneText);
			}	

			//결제방법별금액
			if(vo.getTaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount()[0].isEmpty() == false
			|| vo.getTaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount()[1].isEmpty() == false
			|| vo.getTaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount()[2].isEmpty() == false
			|| vo.getTaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount()[3].isEmpty() == false) {
				
				Element TaxInvoiceTradeSettlement_SpecifiedPaymentMeans = doc.createElement("SpecifiedPaymentMeans");
				TaxInvoiceTradeSettlement.appendChild(TaxInvoiceTradeSettlement_SpecifiedPaymentMeans);
				
				if(vo.getTaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount()[0].isEmpty() == false) {
					Element TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode1 = doc.createElement("TypeCode");
					TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode1.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode()[0]));
					TaxInvoiceTradeSettlement_SpecifiedPaymentMeans.appendChild(TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode1);
					
					Element TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount1 = doc.createElement("PaidAmount");
					TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount1.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount()[0]));
					TaxInvoiceTradeSettlement_SpecifiedPaymentMeans.appendChild(TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount1);
				}
				
				if(vo.getTaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount()[1].isEmpty() == false) {
					Element TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode2 = doc.createElement("TypeCode");
					TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode2.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode()[1]));
					TaxInvoiceTradeSettlement_SpecifiedPaymentMeans.appendChild(TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode2);
					
					Element TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount2 = doc.createElement("PaidAmount");
					TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount2.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount()[1]));
					TaxInvoiceTradeSettlement_SpecifiedPaymentMeans.appendChild(TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount2);
				}	
				
				if(vo.getTaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount()[2].isEmpty() == false) {
					Element TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode3 = doc.createElement("TypeCode");
					TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode3.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode()[2]));
					TaxInvoiceTradeSettlement_SpecifiedPaymentMeans.appendChild(TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode3);
					
					Element TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount3 = doc.createElement("PaidAmount");
					TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount3.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount()[2]));
					TaxInvoiceTradeSettlement_SpecifiedPaymentMeans.appendChild(TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount3);
				}
				
				if(vo.getTaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount()[3].isEmpty() == false) {
					Element TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode4 = doc.createElement("TypeCode");
					TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode4.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode()[3]));
					TaxInvoiceTradeSettlement_SpecifiedPaymentMeans.appendChild(TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_TypeCode4);
					
					Element TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount4 = doc.createElement("PaidAmount");
					TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount4.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount()[3]));
					TaxInvoiceTradeSettlement_SpecifiedPaymentMeans.appendChild(TaxInvoiceTradeSettlement_SpecifiedPaymentMeans_PaidAmount4);
				}
			}
			
			//Summary
			Element TaxInvoiceTradeSettlement_SpecifiedMonetarySummation = doc.createElement("SpecifiedMonetarySummation");
			TaxInvoiceTradeSettlement.appendChild(TaxInvoiceTradeSettlement_SpecifiedMonetarySummation);
			
			Element TaxInvoiceTradeSettlement_SpecifiedMonetarySummation_ChargeTotalAmount = doc.createElement("ChargeTotalAmount");
			TaxInvoiceTradeSettlement_SpecifiedMonetarySummation_ChargeTotalAmount.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_SpecifiedMonetarySummation_ChargeTotalAmount()));
			TaxInvoiceTradeSettlement_SpecifiedMonetarySummation.appendChild(TaxInvoiceTradeSettlement_SpecifiedMonetarySummation_ChargeTotalAmount);
			
			Element TaxInvoiceTradeSettlement_SpecifiedMonetarySummation_TaxTotalAmount = doc.createElement("TaxTotalAmount");
			TaxInvoiceTradeSettlement_SpecifiedMonetarySummation_TaxTotalAmount.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_SpecifiedMonetarySummation_TaxTotalAmount()));
			TaxInvoiceTradeSettlement_SpecifiedMonetarySummation.appendChild(TaxInvoiceTradeSettlement_SpecifiedMonetarySummation_TaxTotalAmount);
			
			Element TaxInvoiceTradeSettlement_SpecifiedMonetarySummation_GrandTotalAmount = doc.createElement("GrandTotalAmount");
			TaxInvoiceTradeSettlement_SpecifiedMonetarySummation_GrandTotalAmount.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeSettlement_SpecifiedMonetarySummation_GrandTotalAmount()));
			TaxInvoiceTradeSettlement_SpecifiedMonetarySummation.appendChild(TaxInvoiceTradeSettlement_SpecifiedMonetarySummation_GrandTotalAmount);
			
			//상품정보
			Element TaxInvoiceTradeLineItem = doc.createElement("TaxInvoiceTradeLineItem");
			TaxInvoice.appendChild(TaxInvoiceTradeLineItem);
			
			Element TaxInvoiceTradeLineItem_SequenceNumeric = doc.createElement("SequenceNumeric");
			TaxInvoiceTradeLineItem_SequenceNumeric.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeLineItem_SequenceNumeric()));
			TaxInvoiceTradeLineItem.appendChild(TaxInvoiceTradeLineItem_SequenceNumeric);
			
			Element TaxInvoiceTradeLineItem_DescriptionText = doc.createElement("DescriptionText");
			TaxInvoiceTradeLineItem_DescriptionText.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeLineItem_DescriptionText()));
			TaxInvoiceTradeLineItem.appendChild(TaxInvoiceTradeLineItem_DescriptionText);

			Element TaxInvoiceTradeLineItem_InvoiceAmount = doc.createElement("InvoiceAmount");
			TaxInvoiceTradeLineItem_InvoiceAmount.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeLineItem_InvoiceAmount()));
			TaxInvoiceTradeLineItem.appendChild(TaxInvoiceTradeLineItem_InvoiceAmount);
			
			Element TaxInvoiceTradeLineItem_ChargeableUnitQuantity = doc.createElement("ChargeableUnitQuantity");
			TaxInvoiceTradeLineItem_ChargeableUnitQuantity.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeLineItem_ChargeableUnitQuantity()));
			TaxInvoiceTradeLineItem.appendChild(TaxInvoiceTradeLineItem_ChargeableUnitQuantity);
			
			if(vo.getTaxInvoiceTradeLineItem_InformationText().isEmpty() == false) {
				Element TaxInvoiceTradeLineItem_InformationText = doc.createElement("InformationText");
				TaxInvoiceTradeLineItem_InformationText.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeLineItem_InformationText()));
				TaxInvoiceTradeLineItem.appendChild(TaxInvoiceTradeLineItem_InformationText);
			}
			
			Element TaxInvoiceTradeLineItem_NameText = doc.createElement("NameText");
			TaxInvoiceTradeLineItem_NameText.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeLineItem_NameText()));
			TaxInvoiceTradeLineItem.appendChild(TaxInvoiceTradeLineItem_NameText);
			
			if(vo.getTaxInvoiceTradeLineItem_PurchaseExpiryDateTime().isEmpty() == false) {
				Element TaxInvoiceTradeLineItem_PurchaseExpiryDateTime = doc.createElement("PurchaseExpiryDateTime");
				TaxInvoiceTradeLineItem_PurchaseExpiryDateTime.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeLineItem_PurchaseExpiryDateTime()));
				TaxInvoiceTradeLineItem.appendChild(TaxInvoiceTradeLineItem_PurchaseExpiryDateTime);
			}
				
			Element TaxInvoiceTradeLineItem_TotalTax = doc.createElement("TotalTax");
			TaxInvoiceTradeLineItem.appendChild(TaxInvoiceTradeLineItem_TotalTax);
			
			Element TaxInvoiceTradeLineItem_TotalTax_CalculatedAmount = doc.createElement("CalculatedAmount");
			TaxInvoiceTradeLineItem_TotalTax_CalculatedAmount.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeLineItem_TotalTax_CalculatedAmount()));
			TaxInvoiceTradeLineItem_TotalTax.appendChild(TaxInvoiceTradeLineItem_TotalTax_CalculatedAmount);
			
			Element TaxInvoiceTradeLineItem_UnitPrice = doc.createElement("UnitPrice");
			TaxInvoiceTradeLineItem.appendChild(TaxInvoiceTradeLineItem_UnitPrice);
			
			Element TaxInvoiceTradeLineItem_UnitPrice_UnitAmount = doc.createElement("UnitAmount");
			TaxInvoiceTradeLineItem_UnitPrice_UnitAmount.appendChild(doc.createTextNode(vo.getTaxInvoiceTradeLineItem_UnitPrice_UnitAmount()));
			TaxInvoiceTradeLineItem_UnitPrice.appendChild(TaxInvoiceTradeLineItem_UnitPrice_UnitAmount);
			
			//빈 노드 제거
			removeNodes(doc);
			
			//xml 파일로 쓰기
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			
			Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); //정렬 스페이스4칸
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); //들여쓰기
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes"); //doc.setXmlStandalone(true); 했을때 붙어서 출력되는부분 개행
            
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new FileOutputStream(new File("D:\\SBQA\\xml\\"+vo.getTaxInvoiceDocument_IssueID()+".xml")));
            
            transformer.transform(source, result);
            
            System.out.println("=========END=========");
            
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            data.put("xml", writer.getBuffer().toString());
            data.put("issueId", vo.getTaxInvoiceDocument_IssueID());

			
		} catch(Exception e) {
			System.out.println("getMessage : " + e.getMessage());
			System.out.println("getStackTrace : " + e.getStackTrace());
		}
		
		return data;
	}
	
	public static void removeNodes(Node node) {
	    NodeList list = node.getChildNodes();
	    for (int i = 0; i < list.getLength(); i++) {
	        removeNodes(list.item(i));
	    }
	    boolean emptyElement = node.getNodeType() == Node.ELEMENT_NODE
	            && node.getChildNodes().getLength() == 0;
	    boolean emptyText = node.getNodeType() == Node.TEXT_NODE
	            && node.getNodeValue().trim().isEmpty();
	    if (emptyElement || emptyText) {
	        node.getParentNode().removeChild(node);
	    }
	}

}
