--liquebase formatted sql
--changeset Gabriel:20250219
--comment: board_columns table create

CREATE TABLE BOARDS_COLUMNS(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    `order` int NOT NULL,
    kind CHAR(7) NOT NULL,
    board_id BIGINT NOT NULL,
    CONSTRAINT boards__boards__columns_fk FOREIGN KEY (board_id) REFERENCES BOARDS(id) ON DELETE CASCADE,
    CONSTRAINT id_order_uk UNIQUE KEY unique_board_id_order (board_id, `order`)
) ENGINE = InnoDB;

--rollback DROP TABLE BOARDS_COLUMNS
-- DIFERENÇA DO VARCHAR E CHAR QTD DE CARACTERES.

