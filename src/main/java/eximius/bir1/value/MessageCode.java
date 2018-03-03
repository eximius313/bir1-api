package eximius.bir1.value;

public enum MessageCode implements StatusAware {
    CAPTCHA_REQUIRED(1), // Konieczne jest pobranie i sprawdzenie kodu Captcha (metody PobierzCaptcha i SprawdzCaptcha).
    TOO_MANY_IDS(2), // Do metody DaneSzukaj przekazano zbyt wiele identyfikatorów
    NO_RESULTS_FOUND(4), // Nie znaleziono podmiotów
    PERMISSION_DENIED(5), // Brak uprawnień do raportu
    NO_SESSION(7); // Brak sesji. Sesja wygasła lub przekazano nieprawidłową wartość nagłówka sid

    private final int status;

    private MessageCode(int status) {
        this.status = status;
    }

    @Override
    public int getStatus() {
        return status;
    }
}