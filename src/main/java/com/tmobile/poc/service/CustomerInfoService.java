package com.tmobile.poc.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.tmobile.poc.vo.CustomerInfoVO;

@Service
public class CustomerInfoService {

	public static Map<String, CustomerInfoVO> customerInfoMap = new HashMap<String, CustomerInfoVO>();

	public CustomerInfoVO getCustomerInfoByPhoneNumber(String phoneNumber) {
		return customerInfoMap.get(phoneNumber);
	}

	public CustomerInfoVO saveCustomerInfo(CustomerInfoVO customer) {
		if (customer != null) {
			customer.setCustomerId(customerInfoMap.size() + 1);
			customerInfoMap.put(customer.getPhoneNumber(), customer);
		}
		return customerInfoMap.get(customer.getPhoneNumber());

	}

	public CustomerInfoVO updateCustomerInfo(CustomerInfoVO customer) {
		customerInfoMap.put(customer.getPhoneNumber(), customer);
		return customerInfoMap.get(customer.getPhoneNumber());
	}
}
