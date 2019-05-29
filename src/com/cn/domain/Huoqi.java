package com.cn.domain;
public class  Huoqi{
  private Integer id;
  private String xinxi;
  private String xingming;
  private int jine;
  private String recordDate;
  private Integer userid;
  private String status;
    private String product;
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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
  public int getJine(){
      return jine;
   }
  public void setJine(int jine){
      this.jine=jine;
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