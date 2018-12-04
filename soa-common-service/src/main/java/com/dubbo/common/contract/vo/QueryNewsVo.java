package com.dubbo.common.contract.vo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;

@Data
public class QueryNewsVo implements Serializable {

	@JSONField(name = "docId")
	private String docId;

	private String source;
	private String title;
	private String priority;
	private String url;
	private String skipURL;

	@JSONField(name = "commentCount")
	private String commentCount;
	@JSONField(name = "imgSrc3gType")
	private String imgSrc3gType;
	private String stitle;
	private String digest;
	private String skipType;

	@JSONField(name = "imgSrc3gType")
	private String photosetID;
	@JSONField(name = "imgSrc")
	private String imgSrc;
	private String ptime;
	private String modelmode;

}
