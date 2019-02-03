package com.kiran.currency.exchange.service.model;

import java.util.HashMap;
import java.util.Map;

import com.kiran.currency.exchange.service.exception.CurrencyConversionException;

/**
 * 
 * @author flexykiran
 *
 */
public class ConverterUtil {
	
	private Map<Currency, Double> euroMap;
	
	public ConverterUtil() {
		loadRates();
	}

	/**
	 * 
	 * @param source
	 * @param target
	 * @param amount
	 * @return
	 * @throws CurrencyConversionException
	 */
	public double convert(Currency source, Currency target, double amount) throws CurrencyConversionException {
		double targetAmount = 0.0;
		try {
			double rateToeuros = euroMap.get(source);
			double rateToTarget =  euroMap.get(target);
			targetAmount = (amount / rateToeuros) * rateToTarget;
		} catch (Exception ex) {
			throw new CurrencyConversionException("Exception while converting currencies");
		}
		return targetAmount;
		
	}

	/**
	 * @return the euroMap
	 */
	public Map<Currency, Double> getEuroMap() {
		
		return euroMap;
	}
	
	/**
	 * loadRates.
	 */
	private void loadRates() {
		if(null == euroMap) {
			euroMap = new HashMap<Currency, Double>();
		}
		if(euroMap.isEmpty()) {
			euroMap.put(Currency.EUR, 1.0);
			euroMap.put(Currency.CHF, 1.11);
			euroMap.put(Currency.GBP, 0.90);
			euroMap.put(Currency.JPY, 1000.01);
			euroMap.put(Currency.USD, 1.20);
		}
	}

	/**
	 * @param euroMap the euroMap to set
	 */
	public void setEuroMap(Map<Currency, Double> euroMap) {
		this.euroMap = euroMap;
	}
	
}
