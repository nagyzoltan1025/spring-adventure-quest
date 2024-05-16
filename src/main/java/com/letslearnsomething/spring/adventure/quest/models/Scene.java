package com.letslearnsomething.spring.adventure.quest.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="scenes")
public class Scene {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;

    String image;

    String description;

    @ManyToMany
    @JoinTable(
            name="scene_directions",
            joinColumns = @JoinColumn(name="scene_source_id"),
            inverseJoinColumns = @JoinColumn(name="scene_destination_id")
    )
    Set<Scene> directions;

    public Scene() {
        this.directions = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Scene> getDirections() {
        return directions;
    }

    public void setDirections(Set<Scene> directions) {
        this.directions = directions;
    }
}
