package com.example.springexample.services;

import com.example.springexample.dto.CategoryDto;
import com.example.springexample.entity.Category;
import com.example.springexample.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryCRUDService implements CRUDService<CategoryDto> {

    private final CategoryRepository repository;

    @Override
    public CategoryDto getById(Long id) {
        log.info("Get by ID: " + id);
        return mapToDto(repository.findById(id).orElseThrow());
    }

    @Override
    public Collection<CategoryDto> getAll() {
        log.info("Get all");
        return repository.findAll()
                .stream()
                .map(CategoryCRUDService::mapToDto).toList();
    }

    @Override
    public void create(CategoryDto item) {
        log.info("Create");
        repository.save(mapToEntity(item));
    }

    @Override
    public void update(CategoryDto item) {
        log.info("Update");
        Category category = mapToEntity(item);
        repository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Delete");
        repository.deleteById(id);
    }

    public static Category mapToEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setTitle(categoryDto.getTitle());
        category.setNews(categoryDto.getNews()
                .stream()
                .map(NewsCRUDService::mapToEntity)
                .toList());
        return category;
    }

    public static CategoryDto mapToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setTitle(category.getTitle());
        categoryDto.setNews(category.getNews()
                .stream()
                .map(NewsCRUDService::mapToDto)
                .toList());
        return categoryDto;
    }
}
