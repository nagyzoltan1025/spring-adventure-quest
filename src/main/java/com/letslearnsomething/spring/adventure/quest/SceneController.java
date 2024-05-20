package com.letslearnsomething.spring.adventure.quest;

import com.letslearnsomething.spring.adventure.quest.models.Scene;
import com.letslearnsomething.spring.adventure.quest.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/scenes")
public class SceneController {

    @Autowired
    private SceneService sceneService;

    @GetMapping()
    public List<Scene> getAllScenes() {
        return this.sceneService.getAllScenes();
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
