package com.jeju.vo;

public class QnaCategoryVO {

	private int QnA_Cate_Num;
	private String QnA_Cate_Name;
	
	public QnaCategoryVO() {
		
	}
	
	public QnaCategoryVO(int qnA_Cate_Num, String qnA_Cate_Name) {
		super();
		QnA_Cate_Num = qnA_Cate_Num;
		QnA_Cate_Name = qnA_Cate_Name;
	}

	public int getQnA_Cate_Num() {
		return QnA_Cate_Num;
	}

	public void setQnA_Cate_Num(int qnA_Cate_Num) {
		QnA_Cate_Num = qnA_Cate_Num;
	}

	public String getQnA_Cate_Name() {
		return QnA_Cate_Name;
	}

	public void setQnA_Cate_Name(String qnA_Cate_Name) {
		QnA_Cate_Name = qnA_Cate_Name;
	}
	
	
	
}
