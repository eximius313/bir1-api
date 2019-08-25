package demo;

import java.io.IOException;

import eximius.bir1.BIR1;
import eximius.bir1.Connection;
import eximius.bir1.data.Company;
import eximius.bir1.data.DataHandler;
import eximius.bir1.report.ReportHandler;
import eximius.bir1.report.ReportType;
import eximius.bir1.value.ValueHandler;

class Main {

    private static final String GUS_NIP = "5261040828";
    private static final String INVALID_NIP = "1261040828";

    public static void main(String[] args) throws IOException {
        try (final Connection connection = BIR1.createNewTestConnection()) {
            final ValueHandler valueHandler = connection.getValue();
            System.out.println("Service status: " + connection.getValue().getServiceStatus());
            System.out.println("Session status: " + valueHandler.getSessionStatus());

            final DataHandler dataHandler = connection.findData();
            final Company company = dataHandler.getDataByNip(GUS_NIP).orElse(null);
            System.out.println("Found company: " + company.getName());

            final Company invalid = dataHandler.getDataByNip(INVALID_NIP).orElse(null);
            System.out.println("Invalid: " + invalid);
            System.out.println("Last message code: " + valueHandler.getMessageCode());
            System.out.println("Last message: " + valueHandler.getMessageContent());

            final ReportHandler reportHandler = connection.getReport();
            String fullReport = reportHandler.getFullReport(company.getRegon(), ReportType.PublDaneRaportPrawna).orElse(null);
            System.out.println("Full report:\n" + fullReport);
        }
    }
}