package com.kiran.currency.exchange.service.model;

public class ExchangeRate {

	private final Currency currency;
	private final double rate;

	public ExchangeRate(Currency currency, double rate) {
		this.currency = currency;
		this.rate = rate;
	}

	/**
	 * @return the currency
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * @return the rate
	 */
	public double getRate() {
		return rate;
	}

}
