package com.nagyzoltan1025.spring.adventure.quest.services;

import com.nagyzoltan1025.spring.adventure.quest.repository.SceneRepository;
import com.nagyzoltan1025.spring.adventure.quest.service.SceneService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class SceneServiceTest {

    @Mock
    private SceneRepository sceneRepository;

    @InjectMocks
    private SceneService sceneService;

    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @Test
    void demoTest() {
        assertTrue(true);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }
}
