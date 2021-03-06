//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.03 at 05:25:40 PM CET 
//


package com.kiran.currency.exchange.service.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sourceCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="targetCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="sourceAmount" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="targetAmount" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="exchangeRate" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sourceCurrencyCode",
    "targetCurrencyCode",
    "sourceAmount",
    "targetAmount",
    "exchangeRate",
    "status"
})
@XmlRootElement(name = "ExchangeResponse")
public class ExchangeResponse {

	
    @XmlElement(required = true)
    protected String sourceCurrencyCode;
    @XmlElement(required = true)
    protected String targetCurrencyCode;
    protected double sourceAmount;
    protected double targetAmount;
    protected double exchangeRate;
    @XmlElement(required = true)
    protected String status;
    private static final String SPACE = " ";

    /**
     * Gets the value of the sourceCurrencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceCurrencyCode() {
        return sourceCurrencyCode;
    }

    /**
     * Sets the value of the sourceCurrencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceCurrencyCode(String value) {
        this.sourceCurrencyCode = value;
    }

    /**
     * Gets the value of the targetCurrencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetCurrencyCode() {
        return targetCurrencyCode;
    }

    /**
     * Sets the value of the targetCurrencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetCurrencyCode(String value) {
        this.targetCurrencyCode = value;
    }

    /**
     * Gets the value of the sourceAmount property.
     * 
     */
    public double getSourceAmount() {
        return sourceAmount;
    }

    /**
     * Sets the value of the sourceAmount property.
     * 
     */
    public void setSourceAmount(double value) {
        this.sourceAmount = value;
    }

    /**
     * Gets the value of the targetAmount property.
     * 
     */
    public double getTargetAmount() {
        return targetAmount;
    }

    /**
     * Sets the value of the targetAmount property.
     * 
     */
    public void setTargetAmount(double value) {
        this.targetAmount = value;
    }

    /**
     * Gets the value of the exchangeRate property.
     * 
     */
    public double getExchangeRate() {
        return exchangeRate;
    }

    /**
     * Sets the value of the exchangeRate property.
     * 
     */
    public void setExchangeRate(double value) {
        this.exchangeRate = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    //@Override
	public String printString() {
		return sourceAmount + SPACE + sourceCurrencyCode + SPACE + "is" + SPACE + targetAmount + SPACE + targetCurrencyCode;
	}
}
