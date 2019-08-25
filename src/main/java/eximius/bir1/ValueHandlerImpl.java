package eximius.bir1;

import static eximius.bir1.Utils.isBlank;

import java.util.stream.Stream;

import org.tempuri.IUslugaBIRzewnPubl;

import eximius.bir1.value.MessageCode;
import eximius.bir1.value.ServiceStatus;
import eximius.bir1.value.SessionStatus;
import eximius.bir1.value.StatusAware;
import eximius.bir1.value.ValueHandler;

class ValueHandlerImpl extends AbstractHandler implements ValueHandler {
    private static enum ValueType {
        StanDanych, KomunikatKod, KomunikatTresc, StatusSesji, StatusUslugi, KomunikatUslugi
    }

    ValueHandlerImpl(final ConnectionImpl connection, final IUslugaBIRzewnPubl port) {
        super(connection, port);
    }

    @Override
    public String getDataState() {
        return getValue(ValueType.StanDanych);
    }

    @Override
    public MessageCode getMessageCode() {
        return getByStatus(MessageCode.class, getValue(ValueType.KomunikatKod));
    }

    @Override
    public String getMessageContent() {
        return getValue(ValueType.KomunikatTresc);
    }

    @Override
    public SessionStatus getSessionStatus() {
        return getByStatus(SessionStatus.class, getValue(ValueType.StatusSesji));
    }

    @Override
    public ServiceStatus getServiceStatus() {
        return getByStatus(ServiceStatus.class, getValue(ValueType.StatusUslugi));
    }

    @Override
    public String getServiceMessage() {
        return getValue(ValueType.KomunikatUslugi);
    }

    private String getValue(final ValueType valueType) {
        reinitiateConnection();
        return port.getValue(valueType.toString());
    }

    private <T extends Enum<?> & StatusAware> T getByStatus(final Class<T> enumClass, final String statusStr) {
        if (isBlank(statusStr)) {
            return null;
        }
        final int status = Integer.parseInt(statusStr);
        return Stream.of(enumClass.getEnumConstants()).filter(s -> s.getStatus() == status).findAny().orElse(null);
    }
}