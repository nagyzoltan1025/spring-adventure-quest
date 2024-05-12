package com.letslearnsomething.spring.adventure.quest.models;

import com.letslearnsomething.spring.adventure.quest.utils.enums.Direction;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Scene {

    Long id;

    String image;

    String description;

    Map<Direction, Scene> directionsMap;

    public Scene() {
    }

    public Scene(Long id, String image, String description, Map<Direction, Scene> directionsMap) {
        this.id = id;
        this.image = image;
        this.description = description;
        this.directionsMap = directionsMap;
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

    public Map<Direction, Scene> getDirectionsMap() {
        return directionsMap;
    }

    public void setDirectionsMap(Map<Direction, Scene> directionsMap) {
        this.directionsMap = directionsMap;
    }
}
