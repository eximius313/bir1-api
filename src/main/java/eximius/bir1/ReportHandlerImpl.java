package eximius.bir1;

import static java.util.Optional.ofNullable;

import java.util.Optional;

import cis.bir.publ._2014._07.IUslugaBIRzewnPubl;
import eximius.bir1.report.ReportHandler;
import eximius.bir1.report.ReportType;

final class ReportHandlerImpl extends AbstractHandler implements ReportHandler {

    ReportHandlerImpl(final ConnectionImpl connection, final IUslugaBIRzewnPubl port) {
        super(connection, port);
    }

    @Override
    public final Optional<String> getFullReport(final String regon, final ReportType reportType) {
        reinitiateConnection();
        return ofNullable(regon)
                .filter(Utils::nonBlank)
                .map(r -> port.danePobierzPelnyRaport(r, reportType.toString()))
                .filter(Utils::nonBlank);
    }
}