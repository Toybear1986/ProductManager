import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;

public class ProductRepositoryTest {

  Product product = new Product(1, "Не книга и не смартфон", 1_000);
  Book book = new Book(2, "Самая интересная книга", 2_000, "Незнайка");
  Smartphone smartphone = new Smartphone(3, "Xiaomi Mi 8 Pro", 10_000, "Xiaomi");

  @Test
  public void test() {
    ProductRepository repo = new ProductRepository();
    //Добавление
    repo.save(product);
    repo.save(book);
    repo.save(smartphone);

    //Проверяем поиск продуктов в массиве и заодно корректность их добавления
    Product[] expectedFindAll = {product, book, smartphone};
    Assertions.assertArrayEquals(expectedFindAll, repo.findAll());

    //Проверяем удаление продукта по Id
    repo.removeById(1);
    Product[] expectedWithoutRemoved = {book, smartphone};
    Assertions.assertArrayEquals(expectedWithoutRemoved, repo.findAll());
  }

  @Test
  public void testExceptions() {
    ProductRepository repo = new ProductRepository();
    //Добавление
    repo.save(product);
    repo.save(book);
    repo.save(smartphone);

    //Проверяем удаление продукта по Id, чтобы убедиться, что все работает после правок
    repo.removeById(1);
    Product[] expectedWithoutRemoved = {book, smartphone};
    Assertions.assertArrayEquals(expectedWithoutRemoved, repo.findAll());

    //Проверяем эксепшн при значениее несуществующем (удаленном в первом случае) в массиве
    Assertions.assertThrows(NotFoundException.class, () -> repo.removeById(1));

    //Проверяем эксепшн при отрицательном значении
    Assertions.assertThrows(NotFoundException.class, () -> repo.removeById(-100));


  }
}
