package com.example.springexample.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@Data
@Getter
@Setter
public class NewsDto {

    private Long id;
    private String title;
    private String text;
    private Instant date;

    private Long categoryId;

}
