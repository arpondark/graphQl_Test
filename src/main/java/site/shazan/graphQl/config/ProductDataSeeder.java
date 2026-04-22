//package site.shazan.graphQl.config;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import site.shazan.graphQl.models.Product;
//import site.shazan.graphQl.repo.ProductRepo;
//
//import java.util.List;
//
//@Component
//public class ProductDataSeeder implements CommandLineRunner {
//
//    private final ProductRepo productRepo;
//
//    public ProductDataSeeder(ProductRepo productRepo) {
//        this.productRepo = productRepo;
//    }
//
//    @Override
//    public void run(String... args) {
//        if (productRepo.count() > 0) {
//            return;
//        }
//
//        List<Product> products = List.of(
//                createProduct("iPhone 15", "Electronics", 999.99, 40),
//                createProduct("Galaxy S24", "Electronics", 899.99, 38),
//                createProduct("Pixel 9", "Electronics", 799.99, 32),
//                createProduct("Sony Headphones", "Electronics", 199.99, 60),
//                createProduct("Logitech Mouse", "Electronics", 49.99, 120),
//                createProduct("Office Chair", "Furniture", 149.50, 25),
//                createProduct("Standing Desk", "Furniture", 299.00, 18),
//                createProduct("LED Lamp", "Furniture", 34.99, 85),
//                createProduct("Water Bottle", "Lifestyle", 14.99, 200),
//                createProduct("Yoga Mat", "Lifestyle", 24.50, 95),
//                createProduct("Running Shoes", "Fashion", 119.99, 55),
//                createProduct("Denim Jacket", "Fashion", 89.99, 44),
//                createProduct("Coffee Maker", "Appliances", 129.00, 35),
//                createProduct("Air Fryer", "Appliances", 159.00, 30),
//                createProduct("Blender", "Appliances", 79.99, 42),
//                createProduct("Notebook Set", "Stationery", 12.00, 180),
//                createProduct("Gel Pens", "Stationery", 8.99, 220),
//                createProduct("Backpack", "Accessories", 59.99, 68),
//                createProduct("Sunglasses", "Accessories", 39.99, 75),
//                createProduct("Smart Watch", "Electronics", 249.99, 28)
//        );
//
//        productRepo.saveAll(products);
//    }
//
//    private Product createProduct(String name, String category, Double price, Integer stock) {
//        Product product = new Product();
//        product.setName(name);
//        product.setCategory(category);
//        product.setPrice(price);
//        product.setStock(stock);
//        return product;
//    }
//}
//
