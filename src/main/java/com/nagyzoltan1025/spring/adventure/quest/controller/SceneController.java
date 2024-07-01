package com.nagyzoltan1025.spring.adventure.quest.controller;

import com.nagyzoltan1025.spring.adventure.quest.config.ApiPath;
import com.nagyzoltan1025.spring.adventure.quest.models.Scene;
import com.nagyzoltan1025.spring.adventure.quest.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(ApiPath.SCENES)
public class SceneController {

    private final SceneService sceneService;

    @Autowired
    public SceneController(SceneService sceneService) {
        this.sceneService = sceneService;
    }

    @GetMapping()
    public ResponseEntity<List<Scene>> getAllScenes() {
        return ResponseEntity.ok(this.sceneService.getAllScenes());
    }

    @PostMapping()
    public ResponseEntity<Scene> createOrUpdateScene(@RequestBody Scene newScene) {
        return ResponseEntity.ok(this.sceneService.createScene(newScene));
    }

    @GetMapping(ApiPath.SCENES_ID_PARAM)
    public ResponseEntity<Scene> getSceneById(@PathVariable Long id) {
        Optional<Scene> scene = this.sceneService.getSceneById(id);
        return scene.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping(ApiPath.SCENES_ID_PARAM)
    public ResponseEntity<Scene> updateScene(@PathVariable Long id, @RequestBody Scene newScene) {
        Scene scene = this.sceneService.updateScene(id, newScene);
        return ResponseEntity.ok(scene);
    }


    @DeleteMapping(ApiPath.SCENES_ID_PARAM)
    public void deleteScene(@PathVariable Long id) {
        this.sceneService.deleteScene(id);
    }

    @GetMapping(ApiPath.SCENES_DIRECTIONS_ID_PARAM)
    public ResponseEntity<Set<Scene>> getDirectionForScene(@PathVariable Long id) {
        return ResponseEntity.ok(this.sceneService.getSceneDirections(id));
    }
}
