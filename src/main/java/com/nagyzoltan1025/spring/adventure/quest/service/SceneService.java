package com.nagyzoltan1025.spring.adventure.quest.service;

import com.nagyzoltan1025.spring.adventure.quest.models.Scene;
import com.nagyzoltan1025.spring.adventure.quest.repository.SceneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SceneService {

    @Autowired
    private SceneRepository sceneRepository;

    public List<Scene> getAllScenes() {
        return this.sceneRepository.findAll();
    }

    public Set<Scene> getSceneDirections(Long currentSceneId) {
        return this.sceneRepository.getReferenceById(currentSceneId).getDirections();
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

    public Scene save(Scene newScene) {
        return this.sceneRepository.save(newScene);
    }
}