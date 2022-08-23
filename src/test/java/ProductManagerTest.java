import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;

public class ProductManagerTest {
  ProductRepository repository = new ProductRepository();
  ProductManager manager = new ProductManager(repository);

  Product product = new Product(1, "Не книга и не смартфон", 1_000);
  Book book = new Book(2, "Самая интересная книга", 2_000, "Незнайка");
  Smartphone smartphone = new Smartphone(3, "Xiaomi Mi 8 Pro", 10_000, "Xiaomi");

  @Test
  public void test() {
    Product[] products = new Product[0];
    manager.add(product);
    manager.add(book);
    manager.add(smartphone);

    //Проверяем добавление
    Product[] expectedArrayAll = {product, book, smartphone};
    Assertions.assertArrayEquals(expectedArrayAll, repository.findAll());

    //Поищем по имени
    //Один продукт с совпадением
    Product[] expectedArray1 = {book};
    Assertions.assertArrayEquals(expectedArray1, manager.searchBy("Самая интересная книга"));

    //Несколько продуктов с совпадением
    Product[] expectedArray2 = {product, book};
    Assertions.assertArrayEquals(expectedArray2, manager.searchBy("книга"));

    //Поищем то, чего нет
    Product[] expectedArray3 = {};
    Assertions.assertArrayEquals(expectedArray3, manager.searchBy("ничего"));
  }
}
