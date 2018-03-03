package eximius.bir1.report;

import java.util.Optional;

public interface ReportHandler {

    Optional<String> getFullReport(String regon, ReportType reportType);

}