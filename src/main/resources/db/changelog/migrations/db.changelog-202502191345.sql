--liquebase formatted sql
--changeset Gabriel:20250219
--comment: cards table create

CREATE TABLE CARDS(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    `order` int NOT NULL,
    board_column_id BIGINT NOT NULL,
    CONSTRAINT boards_columns__cards_fk FOREIGN KEY (board_column_id) REFERENCES BOARDS_COLUMN(id) ON DELETE CASCADE
) ENGINE = InnoDB;

--rollback DROP TABLE CARDS
-- DIFERENÇA DO VARCHAR E CHAR QTD DE CARACTERES.

