package com.n26.statistics.service.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.n26.statistics.model.Transaction;

@Transactional
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
	List<Transaction> findByTimestampGreaterThan(long timestamp);
}
