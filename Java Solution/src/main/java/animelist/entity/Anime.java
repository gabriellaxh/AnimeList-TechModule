package animelist.entity;

import javax.persistence.*;

@Entity
@Table(name = "animes")
public class Anime {
    private int id;

    private int rating;

    private String name;

    private String description;

    private String watched;

    public Anime(int id, int rating, String name, String description, String watched) {
        this.id = id;
        this.rating = rating;
        this.name = name;
        this.description = description;
        this.watched = watched;
    }

    public Anime() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(nullable = false)
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(nullable = false)
    public String getWatched() {
        return watched;
    }

    public void setWatched(String watched) {
        this.watched = watched;
    }
}
