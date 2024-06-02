package com.nagyzoltan1025.spring.adventure.quest;

import com.nagyzoltan1025.spring.adventure.quest.models.Scene;
import com.nagyzoltan1025.spring.adventure.quest.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api/scenes")
public class SceneController {

    private final SceneService sceneService;

    @Autowired
    public SceneController(SceneService sceneService) {
        this.sceneService = sceneService;
    }

    @GetMapping()
    public List<Scene> getAllScenes() {
        return this.sceneService.getAllScenes();
    }

    @GetMapping("/{id}")
    public Scene getSceneById(@PathVariable Long id) {
        Optional<Scene> scene = this.sceneService.getSceneById(id);
        return scene.orElse(null);
    }

    @GetMapping("directions/{id}")
    public Set<Scene> getDirectionForScene(@PathVariable Long id) {
        return this.sceneService.getSceneDirections(id);
    }

    @PostMapping()
    public Scene addScene(@RequestBody Scene newScene) {
        return this.sceneService.save(newScene);
    }
}
