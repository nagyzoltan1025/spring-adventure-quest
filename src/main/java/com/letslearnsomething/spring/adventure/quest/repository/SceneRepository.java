package com.letslearnsomething.spring.adventure.quest.repository;

import com.letslearnsomething.spring.adventure.quest.models.Scene;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SceneRepository extends JpaRepository<Scene, Long> {
}
