package com.tmobile.poc.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmobile.poc.vo.PaymentVO;

import io.swagger.annotations.ApiOperation;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@ApiOperation(value = "This method is used for processing the payment!.")
	@PostMapping(value = "/v1/billing/account/payment", produces = "application/json")
	public ResponseEntity<?> processPayment(@RequestBody(required = true) PaymentVO payment) {
		if (payment.getCustomerId() != null) {
			return new ResponseEntity<>(paymentService.processPayment(payment), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Error Occurred while processing the request!", HttpStatus.BAD_REQUEST);
		}
	}

}
