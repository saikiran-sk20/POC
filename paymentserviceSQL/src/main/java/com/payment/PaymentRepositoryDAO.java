package com.payment;

import org.springframework.data.repository.CrudRepository;
/*import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;*/
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepositoryDAO extends CrudRepository<PaymentVO, Integer> {
	/*
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query(
	 * "UPDATE billing_account_payment c  SET c.status= :status where c.paymentId= :paymentId"
	 * ) void deletePayment(@Param("paymentId")Integer paymentId, @Param
	 * ("status") Integer status);
	 */
}
