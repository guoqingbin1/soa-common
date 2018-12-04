package com.dubbo.common.service.impl;

import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.dubbo.common.contract.vo.QueryNewsVo;
import com.dubbo.common.dao.NeteaseNewsMapper;
import com.dubbo.common.model.NeteaseNews;
import com.dubbo.common.service.IQueryNeteaseNewsService;
import com.dubbo.common.utils.HttpsUtils;
import com.dubbo.common.utils.UUIDUtils;

@Service
@Slf4j
public class QueryNeteaseNewsServiceImpl implements IQueryNeteaseNewsService {

	@Autowired
	private NeteaseNewsMapper neteaseNewsMapper;

	@Value("${filter.news.api.server}")
	private String apiServer;

	@Override
	@Transactional
	public void queryNewsForJobs() {

		String resp = HttpsUtils.doGet(String.format(apiServer, "BA10TA81wangning", "0", "10"));
		resp = resp.replace("artiList(", "");
		resp = resp.substring(0, resp.length() - 1);
		JSONObject jsonResp = JSONObject.parseObject(resp);
		List<QueryNewsVo> list = jsonResp.getJSONArray("BA10TA81wangning").toJavaList(QueryNewsVo.class);
		log.info("job result news:{}", JSONObject.toJSONString(list));

		for (QueryNewsVo vo : list) {
			NeteaseNews news = new NeteaseNews();
			news.setUuid(UUIDUtils.getUUID());
			news.setNewsType("BA10TA81wangning");
			news.setCreateTime(new Date());
			BeanUtils.copyProperties(vo, news);
			neteaseNewsMapper.insert(news);

		}

	}

}
