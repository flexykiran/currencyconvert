package com.kiran.currency.exchange.currencyexchange;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.kiran.currency.exchange.service.impl.CurrencyConverterServiceImpl;
import com.kiran.currency.exchange.service.model.ConverterUtil;
import com.kiran.currency.exchange.service.model.Currency;
import com.kiran.currency.exchange.service.model.ExchangeRequest;
import com.kiran.currency.exchange.service.model.ExchangeResponse;

@RunWith(MockitoJUnitRunner.class)
public class CurrencyConverterServiceImplTest {
	
	@InjectMocks
	CurrencyConverterServiceImpl ccsImpl = new CurrencyConverterServiceImpl();
	
	@Mock
	ConverterUtil util = new ConverterUtil();
	
	@Test
	public void testEurToUsd() {
		
		ExchangeRequest request = new ExchangeRequest();
		request.setAmount(20);
		request.setSourceCurrencyCode("EUR");
		request.setTargetCurrencyCode("USD");
		
		ExchangeResponse response = ccsImpl.getExchangeAmount(request);
		assertEquals("SUCCESS", response.getStatus());
	}

}
