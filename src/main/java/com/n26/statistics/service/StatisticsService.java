package com.n26.statistics.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.n26.statistics.model.Statistics;
import com.n26.statistics.model.Transaction;

@Service
@Transactional
public interface StatisticsService {
	/**
	 * 
	 * @param transactions
	 */
	void createTransactionResult(List<Transaction> transactions);
	/**
	 * 
	 * @return
	 */
	Statistics getTransactionResult();
}
