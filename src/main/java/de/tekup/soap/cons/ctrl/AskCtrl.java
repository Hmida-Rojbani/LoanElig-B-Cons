package de.tekup.soap.cons.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.loan.soap.api.consume.loaneligibilty.CustomerRequest;
import de.tekup.loan.soap.api.consume.loaneligibilty.WsResponse;
import de.tekup.soap.cons.service.CallSoapService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class AskCtrl {
	
	private CallSoapService service;
	
	@GetMapping("/check/client/status")
	public String getClientForm(Model model) {
		model.addAttribute("request", new CustomerRequest());
		return "ask";
	}
	
	@PostMapping("/check/client/status")
	public String postClientForm(@ModelAttribute("request") CustomerRequest request, Model model) {
		
		WsResponse response = service.callService(request);
		model.addAttribute("response", response);
		return "response";
	}

}
