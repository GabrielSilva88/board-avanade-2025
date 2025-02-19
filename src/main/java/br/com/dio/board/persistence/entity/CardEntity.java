package br.com.dio.board.persistence.entity;

public class CardEntity {

    private String id;
    private String title;
    private String description;
    private BoardColumnEntity borderColumn = new BoardColumnEntity();
}
