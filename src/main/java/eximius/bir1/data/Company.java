package eximius.bir1.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "dane")
public class Company {
    private String regon;

    private String name;

    private String voivodeship;

    private String county;

    private String community;

    private String locality;

    private String postCode;

    private String street;

    private String houseNo;

    private String flatNo;

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

    @XmlElement(name = "Wojewodztwo")
    public String getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(String voivodeship) {
        this.voivodeship = voivodeship;
    }

    @XmlElement(name = "Powiat")
    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @XmlElement(name = "Gmina")
    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    @XmlElement(name = "Miejscowosc")
    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
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

    @XmlElement(name = "NrNieruchomosci")
    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    @XmlElement(name = "NrLokalu")
    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
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

    public String getAddress() {
        return (coalesce(getStreet()) + " " + coalesce(getHouseNo())).trim() + (isEmpty(getFlatNo()) ? "" : " lok. "+getFlatNo().trim());
    }

    private String coalesce(final String string) {
        return string == null ? "" : string;
    }

    private boolean isEmpty(final String string) {
        return string == null || string.isEmpty();
    }
}