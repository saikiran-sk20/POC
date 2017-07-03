package com.tmobile.poc.processor;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tmobile.poc.vo.PaymentDTO;
import com.tmobile.poc.vo.PaymentVO;

@Service
public class PaymentService {

	public static final Map<Integer, PaymentDTO> paymentMap = new HashMap<Integer, PaymentDTO>();
	private static final Logger logger = Logger.getLogger(PaymentService.class);

	@Value("${billingAccountURI}")
	private String billingAccountURI;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private PaymentRepositoryDAO repository;

	public String processPayment(PaymentVO payment) {
		return process(payment);
	}

	private String process(PaymentVO payment) {
		savePayment(payment);
		String response = updateAccountBalance(payment);
		return null;
	}

	private String updateAccountBalance(PaymentVO payment) {
		ResponseEntity<String> response = null;
		try {
			Map<String, Object> requestMap = new HashMap<String, Object>();
			requestMap.put("customerId", payment.getCustomerId());
			requestMap.put("acctId", payment.getAcctId());
			requestMap.put("transAmt", payment.getPaymentAmt());
			requestMap.put("transType", 3);
			HttpEntity<?> request = new HttpEntity<>(requestMap);
			try {
				response = restTemplate.exchange(billingAccountURI, HttpMethod.PUT, request, String.class);
				System.out.println(response.getBody().toString());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
		}
		return response.getBody();
	}

	private void savePayment(PaymentVO payment) {
		repository.save(payment);

	}

}
