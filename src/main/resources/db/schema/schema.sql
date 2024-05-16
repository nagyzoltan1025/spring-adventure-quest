CREATE TABLE scenes
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    image       BLOB,
    description VARCHAR(1024)
);

CREATE TABLE scene_directions (
                                  id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                  scene_source_id BIGINT NOT NULL,
                                  scene_destination_id BIGINT NOT NULL,
                                  FOREIGN KEY (scene_source_id) REFERENCES scenes(id),
                                  FOREIGN KEY (scene_destination_id) REFERENCES scenes(id)
);
