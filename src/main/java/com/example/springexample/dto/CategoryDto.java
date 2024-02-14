package com.example.springexample.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Data
@Setter
@Getter
public class CategoryDto {

    private Long id;

    private String title;

    private List<NewsDto> news;
}
