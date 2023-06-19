package com.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter@Setter@ToString
public class BoardVO {

    int num;
    String pass;
    String name;
    String email;
    String title;
    String content;
    int readCount;
    private Timestamp writeDate;

}
