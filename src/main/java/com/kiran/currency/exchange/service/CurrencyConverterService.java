package com.kiran.currency.exchange.service;

import com.kiran.currency.exchange.service.model.ExchangeRequest;
import com.kiran.currency.exchange.service.model.ExchangeResponse;

public interface CurrencyConverterService {

	ExchangeResponse getExchangeAmount(ExchangeRequest request);
}
