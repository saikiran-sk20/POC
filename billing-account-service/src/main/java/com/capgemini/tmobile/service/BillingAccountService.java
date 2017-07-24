package com.capgemini.tmobile.service;



import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.tmobile.VO.BillingAccountRepositoryDAO;
import com.capgemini.tmobile.VO.BillingAccountVO;

@Service
public class BillingAccountService {
	
	@Autowired
	private BillingAccountRepositoryDAO repository;

	   /* public static Map<Integer, BillingAccountVO> billingAccountVOMap = new HashMap<Integer,BillingAccountVO>();

	    public BillingAccountVO getBillingAccountInfoByAccountID(Integer accountId) { 
	        return billingAccountVOMap.get(accountId);
	    }

	    public BillingAccountVO saveBillingAccountInfo(BillingAccountVO billingAccountVO) {
	        if (billingAccountVO != null) {
	            billingAccountVO.setCustomerID(billingAccountVOMap.size() + 1);
	            billingAccountVOMap.put(billingAccountVO.getAccountID(), billingAccountVO);
	        }
	        return billingAccountVOMap.get(billingAccountVO.getAccountID());

	    }

	    public BillingAccountVO updateBillingAccountInfo(BillingAccountVO billingAccountVO) {
	        billingAccountVOMap.put(billingAccountVO.getAccountID(), billingAccountVO);
	        return billingAccountVOMap.get(billingAccountVO.getAccountID());
	    }*/
	
	

	public BillingAccountVO getBillingAccountInfoByAccountID(Integer accountId) {
		return repository.findOne(accountId);
	}

	public BillingAccountVO saveBillingAccountInfo(BillingAccountVO billingAccountVO) {
		return repository.save(billingAccountVO);
	}

	public BillingAccountVO updateBillingAccountInfo(BillingAccountVO billingAccountVO) {
		return repository.save(billingAccountVO);
	}
	public void deleteAccount(Integer accountId) {
		repository.delete(accountId);
	}

	
}
