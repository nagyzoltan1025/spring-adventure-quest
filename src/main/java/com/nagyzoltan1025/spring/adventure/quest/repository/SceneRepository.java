package com.nagyzoltan1025.spring.adventure.quest.repository;

import com.nagyzoltan1025.spring.adventure.quest.models.Scene;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SceneRepository extends JpaRepository<Scene, Long> {
}
