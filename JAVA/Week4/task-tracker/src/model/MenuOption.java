package model;

import java.util.*;

public enum MenuOption {
    ADD(1), LIST_ALL(2), LIST_PENDING(3), MARK_DONE(4),
    SEARCH(5), SUMMARY(6), QUIT(7);

    private final int code;

    MenuOption(int code) { this.code = code; }

    public static Optional<MenuOption> fromCode(int code) {
        return Arrays.stream(values())
                .filter(o -> o.code == code)
                .findFirst();
    }
}
