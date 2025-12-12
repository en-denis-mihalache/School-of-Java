package core;

import java.util.List;
import java.util.stream.Collectors;

public final class Logic {

    private String lastMessage = "";

    public String getLastMessage() {
        return lastMessage;
    }

    public Rating addRating(Store store, String userId, String movieId, int stars, String note) {
        if (store == null) {
            lastMessage = "Store is null";
            return null;
        }
        int uid;
        int mid;

        try {
            uid = Integer.parseInt(userId.trim());
            mid = Integer.parseInt(movieId.trim());
        } catch (NumberFormatException e) {
            lastMessage = "Ids must be numeric";
            return null;
        }

        User user = store.getUsers().values().stream().filter(u -> u.getId() == uid).findFirst().orElse(null);
        if (user == null) {
            lastMessage = "User id " + userId + " - does not exist";
            return null;
        }
        Movie movie = store.getMovies().values().stream().filter(m -> m.getId() == mid).findFirst().orElse(null);
        if (movie == null) {
            lastMessage = "Movie id " + movieId + " - does not exist";
            return null;
        }
        if (stars < 1 || stars > 5) {
            lastMessage = "Stars must be between 1 and 5";
            return null;
        }

        List<Rating> existing = store.getRatings().stream()
                .filter(r -> r.getUserId() == uid && r.getMovieId() == mid)
                .collect(Collectors.toList());
        if (!existing.isEmpty()) {
            lastMessage = "Rating already exists for user id " + userId + " and movie id " + movieId;
            return null;
        }

        Rating rating = new Rating(user, movie, stars, note);
        store.addRating(rating);
        lastMessage = "Rating stored";
        return rating;
    }

}
