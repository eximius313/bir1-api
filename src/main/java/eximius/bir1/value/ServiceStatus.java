package eximius.bir1.value;

public enum ServiceStatus implements StatusAware {
    NOT_AVAILABLE(0),
    AVAILABLE(1),
    MAINTENANCE(2);

    private final int status;

    private ServiceStatus(int status) {
        this.status = status;
    }

    @Override
    public int getStatus() {
        return status;
    }
}