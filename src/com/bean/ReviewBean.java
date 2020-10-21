package com.bean;

public class ReviewBean {
	
	private int reviewId;
	private String studentEmail;
	private String studentName;
	private String studentCourse;
	private String review;
	
	
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentCourse() {
		return studentCourse;
	}
	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
	
	@Override
	public String toString() {
		return "ReviewBean [reviewId=" + reviewId + ", studentEmail=" + studentEmail + ", studentName=" + studentName
				+ ", studentCourse=" + studentCourse + ", review=" + review + "]";
	}


}
