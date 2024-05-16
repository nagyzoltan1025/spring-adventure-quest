package com.letslearnsomething.spring.adventure.quest.service;

import com.letslearnsomething.spring.adventure.quest.models.Scene;
import com.letslearnsomething.spring.adventure.quest.repository.SceneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SceneService {

    @Autowired
    private SceneRepository sceneRepository;

    public List<Scene> getAllScenes() {
        return this.sceneRepository.findAll();
    }

    public Optional<Scene> getSceneById(Long id) {
        return this.sceneRepository.findById(id);
    }

    public Scene createOrUpdateScene(Scene scene) {
        return this.sceneRepository.save(scene);
    }

    public void deleteScene(Long id) {
        this.sceneRepository.deleteById(id);
    }
}
