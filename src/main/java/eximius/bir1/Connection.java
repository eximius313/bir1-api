package eximius.bir1;

import java.io.Closeable;

import eximius.bir1.data.DataHandler;
import eximius.bir1.report.ReportHandler;
import eximius.bir1.value.ValueHandler;

public interface Connection extends Closeable {

    DataHandler findData();

    ReportHandler getReport();

    ValueHandler getValue();
}