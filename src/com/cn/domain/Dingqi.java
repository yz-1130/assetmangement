package com.cn.domain;

import java.math.BigDecimal;

public class  Dingqi{
  private Integer id;
  private String xinxi;
  private String xingming;

    public Integer getJine() {
        return jine;
    }

    public void setJine(Integer jine) {
        this.jine = jine;
    }

    private Integer jine;
  private String shichang;
  private String daoqi;
  private String remark;
  private String recordDate;
  private Integer userid;
  private String status;
  private BigDecimal interest;
  private BigDecimal totalMoney;
    private String product;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

  public  Integer  getId(){
      return id;
   }
  public void setId(Integer id){
      this.id=id;
	 }
  public  String  getXinxi(){
      return xinxi;
   }
  public void setXinxi(String xinxi){
      this.xinxi=xinxi;
	 }
  public  String  getXingming(){
      return xingming;
   }
  public void setXingming(String xingming){
      this.xingming=xingming;
	 }
  public  String  getShichang(){
      return shichang;
   }
  public void setShichang(String shichang){
      this.shichang=shichang;
	 }
  public  String  getDaoqi(){
      return daoqi;
   }
  public void setDaoqi(String daoqi){
      this.daoqi=daoqi;
	 }
  public  String  getRemark(){
      return remark;
   }
  public void setRemark(String remark){
      this.remark=remark;
	 }
  public  String  getRecordDate(){
      return recordDate;
   }
  public void setRecordDate(String recordDate){
      this.recordDate=recordDate;
	 }
  public  Integer  getUserid(){
      return userid;
   }
  public void setUserid(Integer userid){
      this.userid=userid;
	 }
  public  String  getStatus(){
      return status;
   }
  public void setStatus(String status){
      this.status=status;
	 }
}