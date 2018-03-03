package eximius.bir1;

import java.util.Objects;

public final class Utils {

    public static final boolean isNull(final Object o) {
        return Objects.isNull(o);
    }

    public static final boolean nonNull(final Object o) {
        return Objects.nonNull(o);
    }

    public static final boolean isBlank(final String s) {
        return s == null || s.trim().isEmpty();
    }

    public static final boolean nonBlank(final String s) {
        return s != null && s.trim().isEmpty() == false;
    }
}