package vip.epss.domain.dto;

import java.math.BigDecimal;

public class OrderDto {
    private Integer businessid;

    private String businessname;

    private String businessaddress;

    private String businessexplain;

    private Integer ordertypeid;

    private BigDecimal starprice;

    private BigDecimal deliveryprice;

    private String remarks;

    private Integer foodid;

    private String foodname;

    private String foodexplain;

    private BigDecimal foodprice;

    public Integer getBusinessid() {
        return businessid;
    }

    public void setBusinessid(Integer businessid) {
        this.businessid = businessid;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }

    public String getBusinessaddress() {
        return businessaddress;
    }

    public void setBusinessaddress(String businessaddress) {
        this.businessaddress = businessaddress;
    }

    public String getBusinessexplain() {
        return businessexplain;
    }

    public void setBusinessexplain(String businessexplain) {
        this.businessexplain = businessexplain;
    }

    public Integer getOrdertypeid() {
        return ordertypeid;
    }

    public void setOrdertypeid(Integer ordertypeid) {
        this.ordertypeid = ordertypeid;
    }

    public BigDecimal getStarprice() {
        return starprice;
    }

    public void setStarprice(BigDecimal starprice) {
        this.starprice = starprice;
    }

    public BigDecimal getDeliveryprice() {
        return deliveryprice;
    }

    public void setDeliveryprice(BigDecimal deliveryprice) {
        this.deliveryprice = deliveryprice;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getFoodid() {
        return foodid;
    }

    public void setFoodid(Integer foodid) {
        this.foodid = foodid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFoodexplain() {
        return foodexplain;
    }

    public void setFoodexplain(String foodexplain) {
        this.foodexplain = foodexplain;
    }

    public BigDecimal getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(BigDecimal foodprice) {
        this.foodprice = foodprice;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "businessid=" + businessid +
                ", businessname='" + businessname + '\'' +
                ", businessaddress='" + businessaddress + '\'' +
                ", businessexplain='" + businessexplain + '\'' +
                ", ordertypeid=" + ordertypeid +
                ", starprice=" + starprice +
                ", deliveryprice=" + deliveryprice +
                ", remarks='" + remarks + '\'' +
                ", foodid=" + foodid +
                ", foodname='" + foodname + '\'' +
                ", foodexplain='" + foodexplain + '\'' +
                ", foodprice=" + foodprice +
                '}';
    }
}
