package eximius.bir1.value;

public interface ValueHandler {

    String getDataState();

    MessageCode getMessageCode();

    String getMessageContent();

    SessionStatus getSessionStatus();

    ServiceStatus getServiceStatus();

    String getServiceMessage();
}