package eximius.bir1.data;

public enum Silos {
    CEIDG(1), // Miejsce prowadzenia działalności zarejestrowanej w CEIDG (tylko typy F i LF))
    ROLNICZA(2), // Miejsce prowadzenia działalności Rolniczej (tylko typy F i LF))
    POZOSTALA(3), // Miejsce prowadzenia działalności pozostałej (tylko typy F i LF))
    ZLIKWIDOWANA(4), // Miejsce prowadzenia działalności zlikwidowanej w starym systemie KRUPGN
    PRAWNA(6); // Miejsce prowadzenia działalności jednostki prawnej (tylko typy P i LP)

    private final int id;

    private Silos(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}