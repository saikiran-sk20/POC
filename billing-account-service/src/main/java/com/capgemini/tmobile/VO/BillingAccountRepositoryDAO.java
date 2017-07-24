package com.capgemini.tmobile.VO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BillingAccountRepositoryDAO extends CrudRepository<BillingAccountVO, Integer> {

}