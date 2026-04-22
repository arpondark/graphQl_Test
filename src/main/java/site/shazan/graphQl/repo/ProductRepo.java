package site.shazan.graphQl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import site.shazan.graphQl.models.Product;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    List<Product> findByCategory(String category);
}
