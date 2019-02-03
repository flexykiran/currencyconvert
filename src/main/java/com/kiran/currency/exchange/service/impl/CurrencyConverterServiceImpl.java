package com.kiran.currency.exchange.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kiran.currency.exchange.service.CurrencyConverterService;
import com.kiran.currency.exchange.service.exception.CurrencyConversionException;
import com.kiran.currency.exchange.service.model.ConverterUtil;
import com.kiran.currency.exchange.service.model.Currency;
import com.kiran.currency.exchange.service.model.ExchangeRequest;
import com.kiran.currency.exchange.service.model.ExchangeResponse;

/**
 * 
 * @author flexykiran
 *
 */
@Component("CurrencyConverterSvc")
public class CurrencyConverterServiceImpl implements CurrencyConverterService {

	@Autowired
	private ConverterUtil util;
	
	@Override
	public ExchangeResponse getExchangeAmount(ExchangeRequest request) {
		
		ExchangeResponse response = null;
		try {
			util.getEuroMap();
			double targetAmout = util.convert(Currency.valueOf(request.getSourceCurrencyCode()), 
					Currency.valueOf(request.getTargetCurrencyCode()), request.getAmount());
			
			response = mapResponse(request);
			response.setTargetAmount(targetAmout);
			response.setExchangeRate(request.getAmount() / targetAmout);
			response.setStatus("SUCCESS");
		} catch (CurrencyConversionException ccex) {
			response = mapResponse(request);
			response.setStatus("FAILURE");
		}
		return response;
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

}
