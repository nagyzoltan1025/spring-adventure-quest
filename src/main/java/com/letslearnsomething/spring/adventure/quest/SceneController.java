package com.letslearnsomething.spring.adventure.quest;

import com.letslearnsomething.spring.adventure.quest.models.Scene;
import com.letslearnsomething.spring.adventure.quest.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/scenes")
public class SceneController {

    @Autowired
    private SceneService sceneService;

    @GetMapping()
    public List<Scene> getAllStudents() {
        return this.sceneService.getAllScenes();
    }

}
