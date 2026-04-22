package site.shazan.graphQl.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import site.shazan.graphQl.models.Product;
import site.shazan.graphQl.repo.ProductRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepo.findByCategory(category);
    }

    public Product updateStock(int id, int stock) {
        Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setStock(stock);
        return productRepo.save(product);
    }

}
