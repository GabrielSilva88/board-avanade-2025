package br.com.dio.board.service;

import lombok.AllArgsConstructor;

import java.sql.Connection;

@AllArgsConstructor
public class BoardQueryService {
    private final Connection connection;
}
