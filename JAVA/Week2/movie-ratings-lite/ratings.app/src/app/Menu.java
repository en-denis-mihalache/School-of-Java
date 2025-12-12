package app;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import core.Logic;
import core.Store;
import core.Rating;
import core.Movie;
import core.User;

public class Menu {
    private static final String SECTION_FORMAT = "\n=== %s ===";
    private static final String OK = "OK";

    public void show(ConsoleIO io) {
        io.printLine(String.format(SECTION_FORMAT, "Movie Ratings Lite"));
        io.printLine("1) List users");
        io.printLine("2) List movies");
        io.printLine("3) Add rating");
        io.printLine("4) Show averages");
        io.printLine("5) Show top movie");
        io.printLine("6) Show high ratings (>=4)");
        io.printLine("7) Exit");
    }

    public void handleListUsers(Store store, ConsoleIO io) {
        io.printLine(String.format(SECTION_FORMAT, "Users"));
        if (store.getUsers().isEmpty()) {
            io.printLine("-- none --");
            return;
        }
        store.getUsers().values().forEach(u -> io.printLine("u" + u.getId() + " -> " + u.getName()));
    }

    public void handleListMovies(Store store, ConsoleIO io) {
        io.printLine(String.format(SECTION_FORMAT, "Movies"));
        if (store.getMovies().isEmpty()) {
            io.printLine("-- none --");
            return;
        }
        store.getMovies().values().forEach(m -> io.printLine("m" + m.getId() + " -> " + m.getTitle()));
    }

    public void handleAddRating(Store store, ConsoleIO io, Logic logic) {
        io.printLine(String.format(SECTION_FORMAT, "Add Rating"));
        String userId = io.readId("User id: ");
        if (userId == null) {
            return;
        }
        String movieId = io.readId("Movie id: ");
        if (movieId == null) {
            return;
        }
        int stars = io.readStars();
        if (stars == 0) {
            return;
        }
        String note = io.readNoteOptional();
        Rating r = logic.addRating(store, userId, movieId, stars, note);
        String msg = logic.getLastMessage();
        if (r != null) {
            io.printLine(String.format(ConsoleIO.FORMAT, Menu.OK, msg));
        } else {
            io.printLine(String.format(ConsoleIO.FORMAT, ConsoleIO.ERROR, msg));
        }
    }

    public void handleShowAverages(Store store, ConsoleIO io) {
        io.printLine(String.format(SECTION_FORMAT, "Averages by Movie"));
        Map<String, Double> byMovie = store.getRatings().stream()
                .collect(Collectors.groupingBy(r -> {
                    Movie m = r.getMovie();
                    return m != null ? m.getTitle() : "(unknown)";
                }, Collectors.averagingDouble(Rating::getStars)));
        if (byMovie.isEmpty()) {
            io.printLine("-- none --");
        } else {
            byMovie.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(e -> io.printLine(e.getKey() + " -> " + io.formatNumber(e.getValue())));
        }

        io.printLine(String.format(SECTION_FORMAT, "Averages by User"));
        Map<String, Double> byUser = store.getRatings().stream()
                .collect(Collectors.groupingBy(r -> {
                    User u = r.getUser();
                    return u != null ? u.getName() : "(unknown)";
                }, Collectors.averagingDouble(Rating::getStars)));
        if (byUser.isEmpty()) {
            io.printLine("-- none --");
        } else {
            byUser.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(e -> io.printLine(e.getKey() + " -> " + io.formatNumber(e.getValue())));
        }
    }

    public void handleShowTop(Store store, ConsoleIO io) {
        io.printLine(String.format(SECTION_FORMAT, "Top Movie"));
        Map<String, Double> avg = store.getRatings().stream()
                .collect(Collectors.groupingBy(r -> r.getMovie().getTitle(), Collectors.averagingDouble(Rating::getStars)));
        Map<String, Long> counts = store.getRatings().stream()
                .collect(Collectors.groupingBy(r -> r.getMovie().getTitle(), Collectors.counting()));
        Optional<Map.Entry<String, Double>> top = avg.entrySet().stream()
                .max(Comparator
                        .comparingDouble((Map.Entry<String, Double> e) -> e.getValue())
                        .thenComparing(e -> counts.getOrDefault(e.getKey(), 0L), Comparator.reverseOrder())
                        .thenComparing(Map.Entry::getKey));
        if (top.isPresent()) {
            io.printLine("Top: " + top.get().getKey() + " -> " + io.formatNumber(top.get().getValue()));
        } else {
            io.printLine("n/a");
        }
    }

    public void handleShowHigh(Store store, ConsoleIO io) {
        io.printLine(String.format(SECTION_FORMAT, "High Ratings (>=4)"));
        List<Rating> highs = store.getRatings().stream()
                .filter(r -> r != null && r.getStars() >= 4)
                .collect(Collectors.toList());
        if (highs.isEmpty()) {
            io.printLine("-- none --");
            return;
        }
        highs.stream()
                .sorted((a, b) -> Integer.compare(b.getStars(), a.getStars()))
                .forEach(r -> io.printLine("u" + r.getUserId() + " -> m" + r.getMovieId() + " : " + r.getStars() + " STARS"));
    }
}
