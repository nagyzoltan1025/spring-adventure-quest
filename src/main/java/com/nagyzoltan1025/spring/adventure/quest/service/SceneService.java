package com.nagyzoltan1025.spring.adventure.quest.service;

import com.nagyzoltan1025.spring.adventure.quest.models.Scene;
import com.nagyzoltan1025.spring.adventure.quest.repository.SceneRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SceneService {

    private final SceneRepository sceneRepository;

    @Autowired
    public SceneService(SceneRepository sceneRepository) {
        this.sceneRepository = sceneRepository;
    }

    public List<Scene> getAllScenes() {
        return this.sceneRepository.findAll();
    }

    public Set<Scene> getSceneDirections(Long currentSceneId) {
        return this.sceneRepository.findById(currentSceneId).map(Scene::getDirections).orElse(Set.of());
    }

    public Optional<Scene> getSceneById(Long id) {
        return this.sceneRepository.findById(id);
    }

    public Scene createScene(Scene scene) {
        return this.sceneRepository.save(scene);
    }

    public Scene updateScene(Long id, Scene sceneArg) {
        return this.sceneRepository.findById(id)
                                   .map(scene -> {
                                       BeanUtils.copyProperties(sceneArg, scene, "id");
                                       return this.sceneRepository.save(scene);
                                   }).orElseThrow(() -> new EntityNotFoundException("Scene not found with id: " + id));
    }

    public void deleteScene(Long id) {
        this.sceneRepository.deleteById(id);
    }
}
