package pe.com.ctaf.beautyapp.actions;

import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

public class LocationAction extends ActionSupport {
    private String id;
    private String departament;
    private String province;
    private String district;
    private String address;
    private List<String> distric;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocationAction(){
        distric = new ArrayList<String>();
        distric.add("ANCÓN");
        distric.add("ATE");
        distric.add("BARRANCO");
        distric.add("BREÑA");
        distric.add("CARABAYLLO");
        distric.add("CHACLACAYO");
        distric.add("CHORRILLOS");
        distric.add("CIENEGUILLA");
        distric.add("COMAS");
        distric.add("EL AGUSTINO");
        distric.add("INDEPENDENCIA");
        distric.add("JESÚS MARÍA");
        distric.add("LA MOLINA");
        distric.add("LA VICTORIA");
        distric.add("LIMA");
        distric.add("LINCE");
        distric.add("LOS OLIVOS");
        distric.add("LURIGANCHO-CHOSICA");
        distric.add("LURÍN");
        distric.add("MAGDALENA DEL MAR");
        distric.add("MIRAFLORES");
        distric.add("PACHACÁMAC");
        distric.add("PUCUSANA");
        distric.add("PUEBLO LIBRE");
        distric.add("PUENTE PIEDRA");
        distric.add("PUNTA HERMOSA");
        distric.add("PUNTA NEGRA");
        distric.add("RÍMAC");
        distric.add("SAN BARTOLO");
        distric.add("SAN BORJA");
        distric.add("SAN ISIDRO");
        distric.add("SAN JUAN DE LURIGANCHO");
        distric.add("SAN JUAN DE MIRAFLORES");
        distric.add("SAN LUIS");
        distric.add("SAN MARTIN DE PORRES");
        distric.add("SAN MIGUEL");
        distric.add("SANTA ANITA");
        distric.add("SANTA MARÍA DEL MAR");
        distric.add("SANTA ROSA");
        distric.add("SANTIAGO DE SURCO");
        distric.add("SURQUILLO");
        distric.add("VILLA EL SALVADOR");
        distric.add("VILLA MARIA DEL TRIUNFO");
    }


    public String execute(){
        return SUCCESS;
    }
}
