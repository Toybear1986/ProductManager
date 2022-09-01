package ru.netology;

public class ProductManager {
  // добавьте необходимые поля, конструкторы и методы
  protected ProductRepository repository;

  public ProductManager(ProductRepository repository) {
    this.repository = repository;
  }

  public void add(Product product) {
    repository.save(product);
  }

  public Product[] searchBy(String text) {
    Product[] result = new Product[0];
    ProductRepository tmp = new ProductRepository();
    for (Product product : repository.findAll()) {
      if (matches(product, text)) {
        tmp.save(product);
        result = tmp.findAll();
      }
    }
    return result;
  }

  public boolean matches(Product product, String search) {
    return product.matches(search);
  }
}
