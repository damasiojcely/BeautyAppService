package pe.com.ctaf.beautyapp.actions;

import com.opensymphony.xwork2.ActionSupport;

public class ServiceAction extends ActionSupport {
    private String id;
    private String name;
    private float price;
    private String description;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String execute() {
        return SUCCESS;
    }
}
