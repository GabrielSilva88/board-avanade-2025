--liquebase formatted sql
--changeset Gabriel:20250219
--comment: board table create

CREATE TABLE BOARDS(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
) ENGINE = InnoDB;

--rollback DROP TABLE BOARDS
