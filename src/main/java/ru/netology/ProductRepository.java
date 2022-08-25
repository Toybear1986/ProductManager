package ru.netology;

public class ProductRepository {
  protected Product[] products = new Product[0];

  public void save(Product product) {
    Product[] tmp = new Product[products.length + 1];
    System.arraycopy(products, 0, tmp, 0, products.length);
    tmp[tmp.length - 1] = product;
    products = tmp;
  }

  public Product[] findAll() {
    return products;
  }

  public void removeById(int id) /*throws Exception - для 3 варианта*/ {
/*    if (id < 0) {   //Из лекции по экспешенам вариант 1
      RuntimeException e = new RuntimeException(
              "ID не может быть отрицательным: " + id
      );
      throw e;
    }*/
/*    if (id < 0) {     //Из лекции по экспешенам вариант 2
      throw new RuntimeException(
              "ID не может быть отрицательным: " + id
      );
    }*/
/*    if (id < 0) {     //Из лекции по экспешенам вариант 3
      throw new Exception(
              "ID не может быть отрицательным: " + id
      );
    }*/
/*    if (id < 0) {
      throw new NegativeIdException(
              "ID не может быть отрицательным: " + id
      );
    }*/

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
