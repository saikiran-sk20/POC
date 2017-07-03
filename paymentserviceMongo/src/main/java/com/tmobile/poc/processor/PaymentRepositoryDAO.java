package com.tmobile.poc.processor;

import com.tmobile.poc.vo.PaymentVO;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepositoryDAO extends MongoRepository<PaymentVO, Integer> {

}
