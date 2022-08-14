package vip.epss.domain;

import java.math.BigDecimal;

public class Food {
    private Integer foodid;

    private String foodname;

    private String foodexplain;

    private BigDecimal foodprice;

    private Integer businessid;

    private String remarks;

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

    public Integer getBusinessid() {
        return businessid;
    }

    public void setBusinessid(Integer businessid) {
        this.businessid = businessid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public Food() {
    }

    public Food(Integer foodid, String foodname, String foodexplain, BigDecimal foodprice, Integer businessid, String remarks) {
        this.foodid = foodid;
        this.foodname = foodname;
        this.foodexplain = foodexplain;
        this.foodprice = foodprice;
        this.businessid = businessid;
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodid=" + foodid +
                ", foodname='" + foodname + '\'' +
                ", foodexplain='" + foodexplain + '\'' +
                ", foodprice=" + foodprice +
                ", businessid=" + businessid +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}