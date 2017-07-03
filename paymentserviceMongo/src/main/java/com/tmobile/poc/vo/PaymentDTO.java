package com.tmobile.poc.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Component
@JsonInclude(value=Include.NON_NULL)
public class PaymentDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer customerId;
	private Double lastPaymentAmt;
	private String phoneNumber;
	private Double currentBalance;
	private Double totalUnBilledPayments;
	
	public PaymentDTO()
	{
		
	}

	/**
	 * @param customerId
	 * @param lastPaymentAmt
	 * @param phoneNumber
	 * @param currentBalance
	 * @param totalUnBilledPayments
	 */
	public PaymentDTO(Integer customerId, Double lastPaymentAmt, String phoneNumber, Double currentBalance,
			Double totalUnBilledPayments) {
		super();
		this.customerId = customerId;
		this.lastPaymentAmt = lastPaymentAmt;
		this.phoneNumber = phoneNumber;
		this.currentBalance = currentBalance;
		this.totalUnBilledPayments = totalUnBilledPayments;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Double getLastPaymentAmt() {
		return lastPaymentAmt;
	}

	public void setLastPaymentAmt(Double lastPaymentAmt) {
		this.lastPaymentAmt = lastPaymentAmt;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Double getTotalUnBilledPayments() {
		return totalUnBilledPayments;
	}

	public void setTotalUnBilledPayments(Double totalUnBilledPayments) {
		this.totalUnBilledPayments = totalUnBilledPayments;
	}

	@Override
	public String toString() {
		return "PaymentDTO [customerId=" + customerId + ", lastPaymentAmt=" + lastPaymentAmt + ", phoneNumber="
				+ phoneNumber + ", currentBalance=" + currentBalance + ", totalUnBilledPayments="
				+ totalUnBilledPayments + "]";
	}

}
