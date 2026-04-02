package az.edu.ada.wm2.lab6.model.mapper;

import az.edu.ada.wm2.lab6.model.Category;
import az.edu.ada.wm2.lab6.model.Product;
import az.edu.ada.wm2.lab6.model.dto.ProductRequestDto;
import az.edu.ada.wm2.lab6.model.dto.ProductResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public ProductResponseDto toResponseDto(Product product) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(product.getId());
        dto.setProductName(product.getProductName());
        dto.setPrice(product.getPrice());
        dto.setExpirationDate(product.getExpirationDate());
        dto.setCategoryNames(mapCategoriesToNames(product.getCategories()));
        return dto;
    }

    public Product toEntity(ProductRequestDto dto) {
        Product product = new Product();
        product.setProductName(dto.getProductName());
        product.setPrice(dto.getPrice());
        product.setExpirationDate(dto.getExpirationDate());
        return product;
    }

    private List<String> mapCategoriesToNames(Set<Category> categories) {
        return categories.stream()
                .map(Category::getName)
                .collect(Collectors.toList());
    }
}