package com.melancholia.educationplatform.product;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void save(Product product) {
        product.setCreationDate(new Date());
        productRepository.save(product);
    }

    public Product findById(String id) {
        return productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Product not found")
        );
    }

    public void delete(String id){
        productRepository.deleteById(id);
    }

    public void update(String id, Product updatedProduct) {
        Product product = findById(id);

        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        save(product);
    }

    public long count(){
        return productRepository.count();
    }

    public double avg(){
        return productRepository.avg();
    }

    public double sum(){
        return productRepository.sumPrice();
    }
}
