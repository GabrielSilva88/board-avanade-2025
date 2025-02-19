package br.com.dio.board.persistence.entity;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class BlockEntity {

    private long id;
    private OffsetDateTime blockedAt;
    private String blockedReason;
    private OffsetDateTime unblocked_at;
    private String unblockedReason;

}
