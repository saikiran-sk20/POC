package com.payment;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "billing_account_payment")
@JsonInclude(value = Include.NON_NULL)
@Component
public class PaymentVO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty(required = true)
	@Column(name = "paymentId")
	private Integer paymentId;

	@JsonProperty(required = true)
	@Column(name = "phoneNumber")
	private Integer phoneNumber;

	@JsonProperty(required = true)
	@Column(name = "customerId")
	private Integer customerId;

	@Column(name = "acct_id")
	@NotNull
	private Integer acctId;

	@JsonProperty(required = true)
	@Column(name = "paymentDate")
	private String paymentDate;

	@JsonProperty(required = true)
	@Column(name = "paymentAmount")
	private Double paymentAmount;

	@JsonProperty(required = true)
	@Column(name = "paymentType")
	private String paymentType;

	@JsonProperty(required = true)
	@Column(name = "paymentReason")
	private String paymentReason;

	/*
	 * @JsonIgnore private Integer status;
	 */

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getAcctId() {
		return acctId;
	}

	public void setAcctId(Integer acctId) {
		this.acctId = acctId;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentReason() {
		return paymentReason;
	}

	public void setPaymentReason(String paymentReason) {
		this.paymentReason = paymentReason;
	}

	public PaymentVO() {

	}

	public PaymentVO(Integer phoneNumber, Integer customerId, Integer acctId, String paymentDate, Double paymentAmount,
			String paymentType, String paymentReason) {
		super();
		this.phoneNumber = phoneNumber;
		this.customerId = customerId;
		this.acctId = acctId;
		this.paymentDate = paymentDate;
		this.paymentAmount = paymentAmount;
		this.paymentType = paymentType;
		this.paymentReason = paymentReason;
	}

	@Override
	public String toString() {
		return "PaymentVO [phoneNumber=" + phoneNumber + ", customerId=" + customerId + ", acctId=" + acctId
				+ ", paymentDate=" + paymentDate + ", paymentAmount=" + paymentAmount + ", paymentType=" + paymentType
				+ ", paymentReason=" + paymentReason + "]";
	}

	/*
	 * public Integer getStatus() { return status; }
	 * 
	 * public void setStatus(Integer status) { this.status = status; }
	 */

}
