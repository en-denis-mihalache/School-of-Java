package core;

public final class Rating {

    private final User user;
    private final Movie movie;
    private final int stars;
    private final String note;

    public Rating(User user, Movie movie, int stars, String note) {
        this.user = user;
        this.movie = movie;
        this.stars = stars;
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getStars() {
        return stars;
    }

    public String getNote() {
        return note;
    }

    public int getUserId() {
        return user != null ? user.getId() : -1;
    }

    public int getMovieId() {
        return movie != null ? movie.getId() : -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating other = (Rating) o;
        return getUserId() == other.getUserId() && getMovieId() == other.getMovieId();
    }

    @Override
    public int hashCode() {
        int r = Integer.hashCode(getUserId());
        r = 31 * r + Integer.hashCode(getMovieId());
        return r;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "userId=" + getUserId() +
                ", movieId=" + getMovieId() +
                ", stars=" + stars +
                ", note='" + note + "'" +
                '}';
    }
}
