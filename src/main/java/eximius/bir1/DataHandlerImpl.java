package eximius.bir1;

import static java.util.Optional.ofNullable;

import java.io.StringReader;
import java.util.Optional;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.tempuri.IUslugaBIRzewnPubl;

import cis.bir.publ._2014._07.datacontract.ObjectFactory;
import cis.bir.publ._2014._07.datacontract.ParametryWyszukiwania;
import eximius.bir1.data.Company;
import eximius.bir1.data.DataHandler;

final class DataHandlerImpl extends AbstractHandler implements DataHandler {
    private final ObjectFactory factory = new ObjectFactory();

    DataHandlerImpl(final ConnectionImpl connection, final IUslugaBIRzewnPubl port) {
        super(connection, port);
    }

    @Override
    public final Optional<Company> getDataByNip(final String nip) {
        return ofNullable(nip)
                .map(v -> v.replaceAll("[-\\s]", ""))
                .filter(Utils::nonBlank)
                .map(factory::createParametryWyszukiwaniaNip)
                .map(this::createParamsByNip)
                .flatMap(this::searchForCompany);
    }

    private ParametryWyszukiwania createParamsByNip(final JAXBElement<String> elem) {
        final ParametryWyszukiwania p = factory.createParametryWyszukiwania();
        p.setNip(elem);
        return p;
    }

    @Override
    public final Optional<Company> getDataByKrs(final String krs) {
        return ofNullable(krs)
                .filter(Utils::nonBlank)
                .map(factory::createParametryWyszukiwaniaKrs)
                .map(this::createParamsByKrs)
                .flatMap(this::searchForCompany);
    }

    private ParametryWyszukiwania createParamsByKrs(final JAXBElement<String> elem) {
        final ParametryWyszukiwania p = factory.createParametryWyszukiwania();
        p.setKrs(elem);
        return p;
    }

    @Override
    public final Optional<Company> getDataByRegon(final String regon) {
        return ofNullable(regon)
                .filter(Utils::nonBlank)
                .map(factory::createParametryWyszukiwaniaRegon)
                .map(this::createParamsByRegon)
                .flatMap(this::searchForCompany);
    }

    private ParametryWyszukiwania createParamsByRegon(final JAXBElement<String> elem) {
        final ParametryWyszukiwania p = factory.createParametryWyszukiwania();
        p.setRegon(elem);
        return p;
    }

    private final Optional<Company> searchForCompany(final ParametryWyszukiwania p) {
        reinitiateConnection();
        return ofNullable(port.daneSzukajPodmioty(p))
                .filter(Utils::nonBlank)
                .map(str -> {
                    try {
                        System.out.println("RES:"+str);
                        final JAXBContext context = JAXBContext.newInstance(Root.class);
                        return (Root) context.createUnmarshaller().unmarshal(new StringReader(str));
                    } catch (JAXBException e) {
                        e.printStackTrace();
                        return null;
                    }
                }).map(Root::getCompany);
    }

    @XmlRootElement(name = "root")
    static class Root {

        private Company company;

        @XmlElement(name = "dane")
        public Company getCompany() {
            return company;
        }

        public void setCompany(Company company) {
            this.company = company;
        }
    }
}