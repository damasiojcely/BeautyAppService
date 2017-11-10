package pe.com.ctaf.beautyapp.actions;

import com.opensymphony.xwork2.ActionSupport;

public class ReservationAction extends ActionSupport {
    private String id;
    private String reservedat;
    private String requestedfor;
    private float price;
    private String start;
    private String end;
    private String clientid;
    private String scheduleid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReservedat() {
        return reservedat;
    }

    public void setReservedat(String reservedat) {
        this.reservedat = reservedat;
    }

    public String getRequestedfor() {
        return requestedfor;
    }

    public void setRequestedfor(String requestedfor) {
        this.requestedfor = requestedfor;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getScheduleid() {
        return scheduleid;
    }

    public void setScheduleid(String scheduleid) {
        this.scheduleid = scheduleid;
    }
    public String execute(){
        return SUCCESS;
    }
}
