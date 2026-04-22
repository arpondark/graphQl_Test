package site.shazan.graphQl.controller;

import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import site.shazan.graphQl.models.Product;
import site.shazan.graphQl.service.ProductService;

import java.util.List;

@Controller
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @QueryMapping(name = "getProducts")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @QueryMapping
    public List<Product> getProductByCategory(@Argument String category) {
        return productService.getProductsByCategory(category);
    }

    @MutationMapping
    public Product updateStock(@Argument Integer id, @Argument Integer stock) {
        return productService.updateStock(id, stock);
    }

}
