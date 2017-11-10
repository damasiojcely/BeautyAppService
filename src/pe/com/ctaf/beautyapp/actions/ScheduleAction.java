package pe.com.ctaf.beautyapp.actions;

import com.opensymphony.xwork2.ActionSupport;

public class ScheduleAction extends ActionSupport {
    private String id;
    private String star;
    private String end;
    private String discount;
    private String stylistid;
    private String serviceid;
    private String salonid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getStylistid() {
        return stylistid;
    }

    public void setStylistid(String stylistid) {
        this.stylistid = stylistid;
    }

    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid;
    }

    public String getSalonid() {
        return salonid;
    }

    public void setSalonid(String salonid) {
        this.salonid = salonid;
    }
    public String execute(){
        return SUCCESS;
    }
}
