package com.kiran.currency.exchange.service.model;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ObjectConverter {

	/*public static void main(String[] args) {
		ExchangeRequest request = new ExchangeRequest();
		request.setSourceCurrencyCode("EUR");
		request.setTargetCurrencyCode("USD");
		request.setAmount(20.00);
		jaxbObjectToXML(request);
	}

	
	private static String jaxbObjectToXML(ExchangeRequest request) {
	    String xmlString = "";
	    try {
	        JAXBContext context = JAXBContext.newInstance(ExchangeRequest.class);
	        Marshaller m = context.createMarshaller();

	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

	        StringWriter sw = new StringWriter();
	        m.marshal(request, sw);
	        xmlString = sw.toString();

	    } catch (JAXBException e) {
	        e.printStackTrace();
	    }

	    return xmlString;
	}
*/}
