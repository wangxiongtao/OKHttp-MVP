package com.dawn.httplib.http.request;

import java.util.List;

/**
 * Created by wind on 2017/7/13 16:19
 */
public class GoodsListBean {

	public String productId;
	public String productName;
	public String price;
	public String activityId;
	public String activityPrice;
	public List<String> proImg;
	//	public List<String> proImg;
	public String proSizeDescribe;
	public String stock;
	public String cartNumber;

	public List<PromotionList> promotionList;

	public class PromotionList {
		public String typeName;
		public String type;
		public String name;
		public String activityTag;
		public String promotionTag;
		public String color;
	}


}
