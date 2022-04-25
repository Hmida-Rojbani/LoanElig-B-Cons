package de.tekup.soap.cons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import de.tekup.loan.soap.api.consume.loaneligibilty.CustomerRequest;
import de.tekup.loan.soap.api.consume.loaneligibilty.WsResponse;

@Service
public class CallSoapService {
	
	@Autowired
	private  Jaxb2Marshaller marshaller;
	
	private WebServiceTemplate template;
	
	private static final String SERVICE_URL="http://localhost:8080/ws";
	
	public WsResponse callService(CustomerRequest request) {
		template = new WebServiceTemplate(marshaller);
		WsResponse response = (WsResponse) template.marshalSendAndReceive(SERVICE_URL, request);
		return response;
	}

}
