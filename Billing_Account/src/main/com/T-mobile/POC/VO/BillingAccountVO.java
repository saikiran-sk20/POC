package VO;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

    @Entity
    @Table(name = "billing_account")
    @Component
    @JsonInclude(value = Include.NON_NULL)
    public class BillingAccountVO implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "account_id")
        private Integer accountID;

        @Column(name = "customer_id")
        private Integer customerID;

        @Column(name = "current_bal")
        private Double currentBalance;

        @Column(name = "unbilled_debits")
        private Double unbilledDebits;

        @Column(name = "unbilled_credits")
        private Double unbilledCredits;

        @Column(name = "unbilled_payments")
        private Double unbilledPayments;


        public BillingAccountVO(Integer accountID, Integer customerID, Double currentBalance, Double unbilledDebits,
                                Double unbilledCredits, Double unbilledPayments) {
            super();
            this.accountID = accountID;
            this.customerID = customerID;
            this.currentBalance = currentBalance;
            this.unbilledDebits = unbilledDebits;
            this.unbilledCredits = unbilledCredits;
            this.unbilledPayments = unbilledPayments;
        }


        public Integer getAccountID() {
            return accountID;
        }

        public Integer getCustomerID() {
            return customerID;
        }

        public Double getCurrentBalance() {
            return currentBalance;
        }

        public Double getUnbilledDebits() {
            return unbilledDebits;
        }

        public Double getUnbilledCredits() {
            return unbilledCredits;
        }

        public Double getUnbilledPayments() {
            return unbilledPayments;
        }

        public void setAccountID(Integer accountID) {
            this.accountID = accountID;
        }

        public void setCustomerID(Integer customerID) {
            this.customerID = customerID;
        }

        public void setCurrentBalance(Double currentBalance) {
            this.currentBalance = currentBalance;
        }

        public void setUnbilledDebits(Double unbilledDebits) {
            this.unbilledDebits = unbilledDebits;
        }

        public void setUnbilledCredits(Double unbilledCredits) {
            this.unbilledCredits = unbilledCredits;
        }

        public void setUnbilledPayments(Double unbilledPayments) {
            this.unbilledPayments = unbilledPayments;
        }

        @Override
        public String toString() {
            return "BillingAccountVO{" +
                    "accountID=" + accountID +
                    ", customerID=" + customerID +
                    ", currentBalance=" + currentBalance +
                    ", unbilledDebits=" + unbilledDebits +
                    ", unbilledCredits=" + unbilledCredits +
                    ", unbilledPayments=" + unbilledPayments +
                    '}';
        }
    }
