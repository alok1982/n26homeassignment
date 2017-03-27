package com.n26.statistics.controller;

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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.n26.statistics.TestFixtures;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TransactionsControllerTests {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testTransactions() throws Exception {

		String transactionJson = "{\"amount\":" + TestFixtures.AMOUNT1 + ",\"timestamp\":" + System.currentTimeMillis()
				+ "}";
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/transactions")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(transactionJson);
		mvc.perform(builder).andExpect(MockMvcResultMatchers.status().isCreated());
	}

}
