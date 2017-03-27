package com.n26.statistics.schedular;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.n26.statistics.model.Transaction;
import com.n26.statistics.service.StatisticsService;
import com.n26.statistics.service.TransactionService;

@Component
public class StatisticsCalculationSchedular {
	
	@Autowired
	private TransactionService transactionService;
	@Autowired 
	private StatisticsService transactionResultService;

	@Scheduled(fixedRate = 1000)
	@Transactional
	public void calculateResult() {
		long timestamp=System.currentTimeMillis()-(60*1000);
		List<Transaction> transactionsInLastMinute = transactionService.findTransactionAfter(timestamp);
		transactionResultService.createTransactionResult(transactionsInLastMinute);	
	}
}
