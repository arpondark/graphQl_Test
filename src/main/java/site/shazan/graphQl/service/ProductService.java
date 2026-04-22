package site.shazan.graphQl.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import site.shazan.graphQl.models.Product;
import site.shazan.graphQl.repo.ProductRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepo productRepo;

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepo.findByCategory(category);
    }


}
