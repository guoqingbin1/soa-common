package com.dubbo.common.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dubbo.common.ProviderStart;
import com.dubbo.common.service.IQueryNeteaseNewsService;

@RunWith(SpringRunner.class) 
@SpringBootTest(classes={ProviderStart.class})
public class QueryNeteaseNewsServiceImplTest {


	@Autowired
	private IQueryNeteaseNewsService queryNeteaseNewsService;
	@Test
	public void testQueryNewsForJobs() {
		
		queryNeteaseNewsService.queryNewsForJobs();
	}

}
