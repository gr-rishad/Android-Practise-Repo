package com.example.volleyparse.Model;

public class Anime {

   private String name;
   private String description;
   private String rating;
   private int nb_episode;
   private String categorie;
   private String studio;
   private String image_url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getNb_episode() {
        return nb_episode;
    }

    public void setNb_episode(int nb_episode) {
        this.nb_episode = nb_episode;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rating='" + rating + '\'' +
                ", nb_episode=" + nb_episode +
                ", categorie='" + categorie + '\'' +
                ", studio='" + studio + '\'' +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
