package com.n26.statistics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.n26.statistics.model.Statistics;
import com.n26.statistics.model.Transaction;

@Service
@Transactional
public class StatisticsServiceImpl implements StatisticsService {

	@Autowired
	private Statistics statistics;

	@Override
	public void createTransactionResult(List<Transaction> transactions) {
		statistics = new Statistics();
		boolean isNew = true;
		if (transactions != null && !transactions.isEmpty()) {
			for (Transaction transaction : transactions) {
				statistics.setSum(statistics.getSum() + transaction.getAmount());

				if (transaction.getAmount() > statistics.getMax())
					statistics.setMax(transaction.getAmount());
				if (isNew) {
					statistics.setMin(transaction.getAmount());
					isNew = false;
				}
				if (transaction.getAmount() < statistics.getMin())
					statistics.setMin(transaction.getAmount());

			}
			statistics.setAverage(statistics.getSum() / transactions.size());
			statistics.setCount(transactions.size());
		}
	}

	@Override
	public Statistics getTransactionResult() {
		return statistics;
	}

}
