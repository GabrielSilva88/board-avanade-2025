--liquebase formatted sql
--changeset Gabriel:20250219
--comment: blocks table create

CREATE TABLE BLOCKS(
    id BIGINT AUTDO_INCREMENT PRIMARY KEY,
    blocked_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    block_reason VARCHAR(255) NOT NULL,
    unblocked_at TIMESTAMP NULL,
    unblock_reason VARCHAR(255) NOT NULL,
    card_id BIGINT NOT NULL,
    CONSTRAINT cards__blocks_fk FOREIGN KEY (card_id) REFERENCES CARDS(id) ON DELETE CASCADE
) ENGINE = InnoDB;

--rollback DROP TABLE BLOCKS
--DIFERENÇA DO VARCHAR E CHAR QTD DE CARACTERES.

