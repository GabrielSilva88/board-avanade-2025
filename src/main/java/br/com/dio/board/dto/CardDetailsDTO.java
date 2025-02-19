package br.com.dio.board.dto;

import java.time.OffsetDateTime;

public record CardDetailsDTO(Long id, String title, String description, boolean blocked, OffsetDateTime blockedAt,
                             String blockedReason, int blocksAmount, Long columnsId, String columnsName) {
}
