package vip.epss.domain;

public class Deliveryaddress {
    private Integer daid;

    private String contactname;

    private Integer contactsex;

    private String contacttel;

    private String address;

    private String userid;

    public Deliveryaddress() {

    }

    public Integer getDaid() {
        return daid;
    }

    public void setDaid(Integer daid) {
        this.daid = daid;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public Integer getContactsex() {
        return contactsex;
    }

    public void setContactsex(Integer contactsex) {
        this.contactsex = contactsex;
    }

    public String getContacttel() {
        return contacttel;
    }

    public void setContacttel(String contacttel) {
        this.contacttel = contacttel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Deliveryaddress(Integer daid, String contactname, Integer contactsex, String contacttel, String address, String userid) {
        this.daid = daid;
        this.contactname = contactname;
        this.contactsex = contactsex;
        this.contacttel = contacttel;
        this.address = address;
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Deliveryaddress{" +
                "daid=" + daid +
                ", contactname='" + contactname + '\'' +
                ", contactsex=" + contactsex +
                ", contacttel='" + contacttel + '\'' +
                ", address='" + address + '\'' +
                ", userid='" + userid + '\'' +
                '}';
    }
}