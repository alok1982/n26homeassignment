package com.n26.statistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.n26.statistics.model.Transaction;
import com.n26.statistics.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

	@Autowired
	private TransactionService transactionService;

	@RequestMapping(value = {"","/"}, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void index(@RequestBody Transaction transaction) {
		transactionService.addTransaction(transaction);
	}
	
}
