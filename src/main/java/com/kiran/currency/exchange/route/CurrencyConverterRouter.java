package com.kiran.currency.exchange.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kiran.currency.exchange.process.CurrencyConveterProcessor;
import com.kiran.currency.exchange.service.model.ExchangeRequest;
import com.kiran.currency.exchange.service.model.ExchangeResponse;

@Component
public class CurrencyConverterRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		restConfiguration().component("jetty").host("0.0.0.0").port("8888").contextPath("/rest");
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		
		/*ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.PASCAL_CASE_TO_CAMEL_CASE);*/

		rest("/currency")
			.get("/output")
				.to("direct:output")
			.post("/convert")
				.to("direct:convert");

		from("direct:output")
			.log("OUT PUT!!");
		
		from("direct:convert")
			.log("${body}")
			.marshal().json(JsonLibrary.Jackson, ExchangeRequest.class)
			//.convertBodyTo(ExchangeRequest.class)
			//.convertBodyTo(String.class)
			.process(new CurrencyConveterProcessor())
			.convertBodyTo(String.class)
			.unmarshal().json(JsonLibrary.Jackson, ExchangeResponse.class)
			.log("${body}");
	}
}
