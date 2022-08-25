package ru.netology;

public class ProductRepository {
  protected Product[] products = new Product[0];

  public void save(Product product) {
    for (Product newProduct :products) {
      if (newProduct.getId() == product.id) {
        throw new AlreadyExistsException(
                "Product with required id " + product.id + " already exist"
        );
      }
    }
    Product[] tmp = new Product[products.length + 1];
    System.arraycopy(products, 0, tmp, 0, products.length);
    tmp[tmp.length - 1] = product;
    products = tmp;
  }

  public Product[] findAll() {
    return products;
  }

  public Product findById(int id) {
    for (Product product : products) {
      if (id == product.getId()) {
        return product;
      }
    }
    return null;
  }

  public void removeById(int id) {
    if (findById(id) == null) {
      throw new NotFoundException(
              "Element with id: " + id + " not found"
      );
    }
    Product[] tmp = new Product[products.length - 1];
    int copyToIndex = 0;
    for (Product product : products) {
      if (product.getId() != id) {
        tmp[copyToIndex] = product;
        copyToIndex++;
      }
    }
    products = tmp;
  }
}
