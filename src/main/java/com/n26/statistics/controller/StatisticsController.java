package com.n26.statistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.n26.statistics.model.Statistics;
import com.n26.statistics.service.StatisticsService;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {
	@Autowired
	private StatisticsService staticsService;

	@RequestMapping(value = {"","/"}, method = RequestMethod.GET)
	public Statistics index() {
		return staticsService.getTransactionResult();
	}
}
