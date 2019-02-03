package com.kiran.currency.exchange.process;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.kiran.currency.exchange.service.exception.CurrencyConversionException;
import com.kiran.currency.exchange.service.model.ConverterUtil;
import com.kiran.currency.exchange.service.model.Currency;
import com.kiran.currency.exchange.service.model.ExchangeRequest;
import com.kiran.currency.exchange.service.model.ExchangeResponse;

@Component
public class CurrencyConveterProcessor implements Processor {

	/*@Autowired
	@Qualifier("CurrencyConverterSvc")
	CurrencyConverterServiceImpl service;
	*/

	/*@Autowired
	private ConverterUtil util;*/
	
	@Override
	public void process(Exchange exchange) throws Exception {
		//String input = (String) exchange.getIn().getBody();
		
		ExchangeResponse response = null;
		ExchangeRequest request = null;
		try {
			//request = unmarshal(input);
			request = (ExchangeRequest) exchange.getIn().getBody();;
			ConverterUtil util = new ConverterUtil();
			util.getEuroMap();
			double targetAmout = util.convert(Currency.valueOf(request.getSourceCurrencyCode()), 
					Currency.valueOf(request.getTargetCurrencyCode()), request.getAmount());
			
			response = mapResponse(request);
			response.setTargetAmount(Math.round(targetAmout*100)/100.f);
			response.setExchangeRate(request.getAmount() / targetAmout);
			response.setStatus("SUCCESS");
		} catch (CurrencyConversionException ccex) {
			response = mapResponse(request);
			response.setStatus("FAILURE");
		}
		exchange.getIn().setBody(response);
	}
	
	/**
	 * 
	 * @param request
	 * @return response
	 */
	private ExchangeResponse mapResponse(ExchangeRequest request) {
		ExchangeResponse response = new ExchangeResponse();
		response.setSourceCurrencyCode(request.getSourceCurrencyCode());
		response.setTargetCurrencyCode(request.getTargetCurrencyCode());
		response.setSourceAmount(request.getAmount());
		
		return response;
	}
	
	/**
	 * 
	 * @param xml
	 * @return
	 * @throws JAXBException
	 */
	private static ExchangeRequest unmarshal(String xml) throws JAXBException {
	    JAXBContext jaxbContext = JAXBContext.newInstance(ExchangeRequest.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

	    StringReader reader = new StringReader(xml);
	    ExchangeRequest exchangeRequest = (ExchangeRequest) jaxbUnmarshaller.unmarshal(reader);

	    return exchangeRequest;
	  }

}
