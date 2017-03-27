package com.n26.statistics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.n26.statistics.model.Transaction;
import com.n26.statistics.service.dao.TransactionRepository;

@Component
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepostiory;
	@Override
	public void addTransaction(Transaction transaction) {
		System.out.println("Transaction Amount:" + transaction.getAmount() + "\n Transaction Timestamp:"
				+ transaction.getTimestamp());
		transactionRepostiory.save(transaction);
	}
	@Override
	public List<Transaction> findTransactionAfter(long timestamp) {
		
		return transactionRepostiory.findByTimestampGreaterThan(timestamp);
	}

}
