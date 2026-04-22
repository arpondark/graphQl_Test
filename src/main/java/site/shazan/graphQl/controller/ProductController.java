package site.shazan.graphQl.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import site.shazan.graphQl.models.Product;
import site.shazan.graphQl.service.ProductService;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/products/{category}")
    public List<Product> getProductByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

}
