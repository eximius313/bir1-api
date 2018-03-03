package eximius.bir1;

import cis.bir.publ._2014._07.IUslugaBIRzewnPubl;

abstract class AbstractHandler {
    private final ConnectionImpl connection;

    protected final IUslugaBIRzewnPubl port;

    protected AbstractHandler(final ConnectionImpl connection, final IUslugaBIRzewnPubl port) {
        this.connection = connection;
        this.port = port;
    }

    protected final void reinitiateConnection() {
        connection.reinitiate();
    }
}