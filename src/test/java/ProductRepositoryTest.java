import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.Book;
import ru.netology.Product;
import ru.netology.ProductRepository;
import ru.netology.Smartphone;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

public class ProductRepositoryTest {

  ProductRepository mock = Mockito.mock(ProductRepository.class);
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
  public void NullException() {
    doReturn(null).when(mock).findAll(); //Пробуем найти продукты в пустом массиве
    doNothing().when(mock).removeById(4); // Пробуем удалить из пустого массива
  }

}
