package com.nagyzoltan1025.spring.adventure.quest.services;

import com.nagyzoltan1025.spring.adventure.quest.models.Scene;
import com.nagyzoltan1025.spring.adventure.quest.repository.SceneRepository;
import com.nagyzoltan1025.spring.adventure.quest.service.SceneService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SceneServiceTest {

    @Mock
    private SceneRepository sceneRepository;

    @InjectMocks
    private SceneService sceneService;

    @Test
    void demoTest() {
        Scene scene = new Scene();
        scene.setId(1L);
        scene.setDescription("Test");

        when(sceneRepository.findAll()).thenReturn(List.of(scene));

        List<Scene> scenes = sceneService.getAllScenes();
        verify(sceneRepository).findAll();

        assertNotNull(scenes);
        assertEquals(scene.getId(), scenes.get(0).getId());
        assertEquals(scene.getDescription(), scenes.get(0).getDescription());
    }
}
