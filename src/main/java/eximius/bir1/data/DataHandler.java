package eximius.bir1.data;

import java.util.Optional;

public interface DataHandler {

    Optional<Company> getDataByNip(String nip);

    Optional<Company> getDataByKrs(String krs);

    Optional<Company> getDataByRegon(String regon);

}