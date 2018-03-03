package eximius.bir1.value;

public enum SessionStatus implements StatusAware {
    EXISTS(1),
    NOT_EXISTS(0);

    private final int status;

    private SessionStatus(int status) {
        this.status = status;
    }

    @Override
    public int getStatus() {
        return status;
    }
}