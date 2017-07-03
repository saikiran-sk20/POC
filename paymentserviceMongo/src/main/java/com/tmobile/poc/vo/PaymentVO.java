package com.tmobile.poc.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;


@Document (collection= "paymentInfo")
@Component
@JsonInclude(value = Include.NON_NULL)
public class PaymentVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty(required = true)
	private Integer customerId;
	@JsonProperty(required = true)
	private String phoneNumber;
	@JsonProperty(required = true)
	@NotNull 
	private Integer acctId;
	private Integer paymentType;
	@JsonProperty(required = true)
	private Double paymentAmt;
	@JsonProperty(required = true)
	private String paymentReason;
	@JsonProperty(required = true)
	private String paymentDate;

	public PaymentVO() {

	}

	/**
	 * @param customerId
	 * @param phoneNumber
	 * @param paymentType
	 * @param paymentAmt
	 * @param paymentReason
	 * @param paymentDate
	 */
	public PaymentVO(Integer customerId, Integer acctId, String phoneNumber, Integer paymentType, Double paymentAmt,
			String paymentReason, String paymentDate) {
		super();
		this.customerId = customerId;
		this.acctId = acctId;
		this.phoneNumber = phoneNumber;
		this.paymentType = paymentType;
		this.paymentAmt = paymentAmt;
		this.paymentReason = paymentReason;
		this.paymentDate = paymentDate;
	}

	public Integer getAcctId() {
		return acctId;
	}

	public void setAcctId(Integer acctId) {
		this.acctId = acctId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}

	public Double getPaymentAmt() {
		return paymentAmt;
	}

	public void setPaymentAmt(Double paymentAmt) {
		this.paymentAmt = paymentAmt;
	}

	public String getPaymentReason() {
		return paymentReason;
	}

	public void setPaymentReason(String paymentReason) {
		this.paymentReason = paymentReason;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "PaymentVO [customerId=" + customerId + ", acctId="+ acctId +", phoneNumber=" + phoneNumber + ", paymentType=" + paymentType
				+ ", paymentAmt=" + paymentAmt + ", paymentReason=" + paymentReason + ", paymentDate=" + paymentDate
				+ "]";
	}

}
