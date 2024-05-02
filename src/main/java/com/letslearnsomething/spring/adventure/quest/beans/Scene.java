package com.letslearnsomething.spring.adventure.quest.beans;

import com.letslearnsomething.spring.adventure.quest.enums.Direction;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Scene {

    String image;

    String description;

    Map<Direction, Scene> directionsMap;

    public Scene() {
    }

    public Scene(String image, String description, Map<Direction, Scene> directionsMap) {
        this.image = image;
        this.description = description;
        this.directionsMap = directionsMap;
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
