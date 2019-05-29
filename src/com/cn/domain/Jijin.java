package com.cn.domain;
public class  Jijin{
  private Integer id;
  private String leixing;

    public Integer getJine() {
        return jine;
    }

    public void setJine(Integer jine) {
        this.jine = jine;
    }

    private Integer jine;
  private String shijian;
  private String shuhui;
  private String recordDate;
  private Integer userid;
  private String status;
    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    private String planDate;
  public  Integer  getId(){
      return id;
   }
  public void setId(Integer id){
      this.id=id;
	 }
  public  String  getLeixing(){
      return leixing;
   }
  public void setLeixing(String leixing){
      this.leixing=leixing;
	 }

  public  String  getShijian(){
      return shijian;
   }
  public void setShijian(String shijian){
      this.shijian=shijian;
	 }
  public  String  getShuhui(){
      return shuhui;
   }
  public void setShuhui(String shuhui){
      this.shuhui=shuhui;
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