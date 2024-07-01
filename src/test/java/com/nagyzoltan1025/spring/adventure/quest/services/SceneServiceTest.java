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
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SceneServiceTest {

    @Mock
    private SceneRepository sceneRepository;

    @InjectMocks
    private SceneService sceneService;

    @Test
    void getAllScenes_shouldReturnAllScenesWhenScenesExist() {
        long testId = 1L;
        Scene scene = getTestScene(testId);

        when(sceneRepository.findAll()).thenReturn(List.of(scene));

        List<Scene> scenes = sceneService.getAllScenes();
        verify(sceneRepository).findAll();

        assertNotNull(scenes);
        assertEquals(scene.getId(), scenes.get(0).getId());
        assertEquals(scene.getDescription(), scenes.get(0).getDescription());
    }

    @Test
    void getAllScenes_shouldReturnNoScenesWhenNoSceneExists() {
        List<Scene> scenes = sceneService.getAllScenes();
        verify(sceneRepository).findAll();

        assertNotNull(scenes);
        assertEquals(scenes.size(), 0);
    }

    @Test
    void getSceneDirections_shouldFindTheRightDirectionsBySceneId() {
        long testId = 1L;
        Scene scene = getTestScene(testId);
        Set<Scene> expectedDirections = scene.getDirections();

        when(sceneRepository.findById(1L)).thenReturn(Optional.of(scene));

        Set<Scene> directions = sceneService.getSceneDirections(testId);
        verify(sceneRepository).findById(testId);

        assertNotNull(directions);
        assertEquals(directions.size(), expectedDirections.size());
        assertTrue(directions.containsAll(expectedDirections) && expectedDirections.containsAll(directions));
    }

    @Test
    void getSceneDirections_shouldNotReturnAnyDirectionsWhenNoSceneFoundById() {
        final long NO_SCENE_ID = 4L;

        when(sceneRepository.findById(NO_SCENE_ID)).thenReturn(Optional.empty());

        Set<Scene> directions = sceneService.getSceneDirections(NO_SCENE_ID);
        verify(sceneRepository).findById(NO_SCENE_ID);

        assertNotNull(directions);
        assertTrue(directions.isEmpty());
    }

    @Test
    void getSceneById_shouldFindSceneByIdIfExists() {
        long testId = 1L;
        Scene scene = getTestScene(testId);

        when(sceneRepository.findById(testId)).thenReturn(Optional.of(scene));

        Optional<Scene> result = sceneService.getSceneById(testId);
        verify(sceneRepository).findById(testId);

        assertTrue(result.isPresent());
        assertSame(scene, result.get());
    }

    @Test
    void getSceneById_shouldReturnWhenNoSceneFoundById() {
        final long NO_SCENE_ID = 4L;

        when(sceneRepository.findById(NO_SCENE_ID)).thenReturn(Optional.empty());
        Optional<Scene> result = sceneRepository.findById(NO_SCENE_ID);

        assertFalse(result.isPresent());
    }

    @Test
    void createScene_shouldReturnTheSavedScene() {
        Scene scene = getTestScene(1L);

        when(sceneRepository.save(scene)).thenReturn(scene);

        Scene result = sceneRepository.save(scene);

        assertSame(scene, result);
    }


    private static Scene getTestScene(long id) {
        Scene scene = new Scene();
        scene.setId(id);
        scene.setDescription("This is the first scene");

        Scene firstChild = new Scene();
        firstChild.setId(id + 1);
        Scene secondChild = new Scene();
        secondChild.setId(id + 2);

        scene.setDirections(Set.of(firstChild, secondChild));

        return scene;
    }
}
