package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {

    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Movie> movies = new HashMap<>();
    
    private final List<Rating> ratings = new ArrayList<>();

    public void addRating(Rating rating) {
        if (rating != null) {
            ratings.add(rating);
        }
    }

    public void seed() {
        User u1 = new User(1, "Alice");
        User u2 = new User(2, "Bob");
        User u3 = new User(3, "Charlie");
        users.put(u1.getName(), u1);
        users.put(u2.getName(), u2);
        users.put(u3.getName(), u3);

        Movie m1 = new Movie(1, "Inception");
        Movie m2 = new Movie(2, "Matrix");
        movies.put(m1.getTitle(), m1);
        movies.put(m2.getTitle(), m2);

        ratings.add(new Rating(u1, m1, 5, "Brilliant"));
        ratings.add(new Rating(u1, m2, 4, "Classic"));
        ratings.add(new Rating(u2, m1, 5, "Mind-bending"));
        ratings.add(new Rating(u2, m2, 3, "Good"));
    }

    public Map<String, User> getUsers() {
        return Collections.unmodifiableMap(users);
    }

    public Map<String, Movie> getMovies() {
        return Collections.unmodifiableMap(movies);
    }

    public List<Rating> getRatings() {
        return Collections.unmodifiableList(ratings);
    }
}
