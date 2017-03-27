package com.n26.statistics.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.n26.statistics.model.Transaction;
@Service
public interface TransactionService {
	/**
	 * Adds transaction to db
	 * @param transaction
	 */
	void addTransaction(Transaction transaction);
	/**
	 * 
	 * @param timestamp
	 * @return
	 */
	List<Transaction> findTransactionAfter(long timestamp);
}
