package com.n26.statistics.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.n26.statistics.TestFixtures;
import com.n26.statistics.model.Statistics;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class StatisticsControllerTests {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
		String transactionJson = "{\"amount\":" + TestFixtures.AMOUNT1 + ",\"timestamp\":" + System.currentTimeMillis()
				+ "}";
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/transactions")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(transactionJson);
		mvc.perform(builder);
		Thread.sleep(59*1000);
	}

	@Test
	public void testStatistics() throws Exception {

		
		String transactionJson = "{\"amount\":" + TestFixtures.AMOUNT1 + ",\"timestamp\":" + System.currentTimeMillis()
				+ "}";
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/statistics")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(transactionJson);
		MvcResult mvcResult = (MvcResult) mvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		String statisticsString = mvcResult.getResponse().getContentAsString();
		ObjectMapper mapper = new ObjectMapper();
		Statistics stats = mapper.readValue(statisticsString, Statistics.class);
		Assert.assertEquals(stats.getAverage(), TestFixtures.AMOUNT1, 0.0);
		Assert.assertEquals(stats.getCount(), 1, 0.0);
		Assert.assertEquals(stats.getMax(), TestFixtures.AMOUNT1, 0.0);
		Assert.assertEquals(stats.getMin(), TestFixtures.AMOUNT1, 0.0);


	}

}
