package eximius.bir1.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "dane")
public class Company {
    private String regon;

    private String name;

    private String woj;

    private String pow;

    private String gm;

    private String city;

    private String postCode;

    private String street;

    private CompanyType type;

    private Silos silos;

    @XmlElement(name = "Regon")
    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    @XmlElement(name = "Nazwa")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWoj() {
        return woj;
    }

    @XmlElement(name = "Wojewodztwo")
    public void setWoj(String woj) {
        this.woj = woj;
    }

    @XmlElement(name = "Powiat")
    public String getPow() {
        return pow;
    }

    public void setPow(String pow) {
        this.pow = pow;
    }

    @XmlElement(name = "Gmina")
    public String getGm() {
        return gm;
    }

    public void setGm(String gm) {
        this.gm = gm;
    }

    @XmlElement(name = "Miejscowosc")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlElement(name = "KodPocztowy")
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @XmlElement(name = "Ulica")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @XmlElement(name = "Typ")
    public CompanyType getType() {
        return type;
    }

    public void setType(CompanyType type) {
        this.type = type;
    }

    @XmlElement(name = "SilosID")
    @XmlJavaTypeAdapter(SilosAdapter.class)
    public Silos getSilos() {
        return silos;
    }

    public void setSilos(Silos silos) {
        this.silos = silos;
    }
}