[![Build Status](https://img.shields.io/travis/eximius313/bir1-api.svg)](https://travis-ci.org/eximius313/bir1-api) [![Bintray](https://api.bintray.com/packages/eximius313/bir1-api/maven/images/download.svg)](https://bintray.com/eximius313/bir1-api/maven)
    
# Baza Internetowa REGON - Java API

Java API do [Bazy Internetowej REGON](https://wyszukiwarkaregon.stat.gov.pl/appBIR/index.aspx)

## Podstawowe informacje:
http://bip.stat.gov.pl/dzialalnosc-statystyki-publicznej/rejestr-regon/interfejsyapi/

## Instrukcja techniczna:
[PDF](https://cdn.rawgit.com/eximius313/bir1-api/d841d6a4/docs/regon%20-%20instrukcja%20techniczna%20BIR1%20dla%20podm.komercyjnych_010.pdf)

## DEMO:
```
public class Main {

    private static final String GUS_NIP = "5261040828";
    private static final String INVALID_NIP = "1261040828";

    public static void main(String[] args) throws IOException {
        try (final Connection connection = BIR1.createNewTestConnection()) {
            final ValueHandler valueHandler = connection.getValue();
            System.out.println("Service status: " + valueHandler.getServiceStatus());
            System.out.println("Session status: " + valueHandler.getSessionStatus());

            final DataHandler dataHandler = connection.findData();
            final Company company = dataHandler.getDataByNip(GUS_NIP).orElse(null);
            System.out.println("Found company: " + company.getName());

            final Company invalid = dataHandler.getDataByNip(INVALID_NIP).orElse(null);
            System.out.println("Invalid: " + invalid);
            System.out.println("Last message code: " + valueHandler.getMessageCode());
            System.out.println("Last message: " + valueHandler.getMessageContent());

            final ReportHandler reportHandler = connection.getReport();
            String fullReport = reportHandler.getFullReport(company.getRegon(), ReportType.PublDaneRaportPrawna)
                    .orElse(null);
            System.out.println("Full report:\n" + fullReport);
        }
    }
}
```
