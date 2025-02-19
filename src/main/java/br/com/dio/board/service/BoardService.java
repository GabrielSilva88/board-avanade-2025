package br.com.dio.board.service;

import br.com.dio.board.persistence.dao.BoardColumnDao;
import br.com.dio.board.persistence.dao.BoardDao;
import br.com.dio.board.persistence.entity.BoardEntity;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;

@AllArgsConstructor
public class BoardService {

    private Connection connection;

    public BoardEntity insert(final BoardEntity boardEntity) throws SQLException {
        var boardDao = new BoardDao(connection);
        var boardColumnDao = new BoardColumnDao(connection);
        try {
            boardDao.insert(boardEntity);
            var columns = boardEntity.getBoardColumns().stream().map(c -> {
                c.setBoard(boardEntity);
                return c;
            }).toList();
            for (var column : columns) {
                boardColumnDao.insert(column);
            }
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        }
        return boardEntity;
    }

    public boolean delete(final long id) throws SQLException {
        var dao = new BoardDao(connection);
        try {
            if (!dao.exists(id)) {
                return false;
            }
            dao.delete(id);
            connection.commit();
            return true;
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }
}
