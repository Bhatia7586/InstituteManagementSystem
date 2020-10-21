package com.service;

import java.util.ArrayList;

import com.bean.ReviewBean;
import com.dao.ReviewDao;

public class ReviewService {
	
	ReviewDao rd = null;
	
	public ReviewService() {
		
		rd = new ReviewDao();
	}

	public void saveReview(ReviewBean rb) {

		rd.saveReview(rb);
		
	}
	
	public ArrayList<ReviewBean> getReview()
	{
		return rd.getReview();
	}
	

}
