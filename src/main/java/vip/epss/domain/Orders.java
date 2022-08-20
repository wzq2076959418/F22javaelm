package vip.epss.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Orders {
    private Integer orderid;

    private String userid;

    private Integer businessid;

    private String orderdate;

    private BigDecimal ordertotal;

    private Integer daid;

    private Integer orderstate;
    private Business business = new Business();
    //一对多：某订单下的订单明细
    private List<Orderdetailet> odList = new ArrayList<>();

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public List<Orderdetailet> getOdList() {
        return odList;
    }

    public void setOdList(List<Orderdetailet> odList) {
        this.odList = odList;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getBusinessid() {
        return businessid;
    }

    public void setBusinessid(Integer businessid) {
        this.businessid = businessid;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public BigDecimal getOrdertotal() {
        return ordertotal;
    }

    public void setOrdertotal(BigDecimal ordertotal) {
        this.ordertotal = ordertotal;
    }

    public Integer getDaid() {
        return daid;
    }

    public void setDaid(Integer daid) {
        this.daid = daid;
    }

    public Integer getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(Integer orderstate) {
        this.orderstate = orderstate;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderid=" + orderid +
                ", userid='" + userid + '\'' +
                ", businessid=" + businessid +
                ", orderdate='" + orderdate + '\'' +
                ", ordertotal=" + ordertotal +
                ", daid=" + daid +
                ", orderstate=" + orderstate +
                ", business=" + business +
                ", odList=" + odList +
                '}';
    }
}