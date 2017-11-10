package pe.com.ctaf.beautyapp.actions;

import com.opensymphony.xwork2.ActionSupport;

public class SkillAction extends ActionSupport {
    private String stylistid;
    private String serviceid;
    private float timeof;

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

    public float getTimeof() {
        return timeof;
    }

    public void setTimeof(float timeof) {
        this.timeof = timeof;
    }
    public String execute(){
        return SUCCESS;
    }
}
