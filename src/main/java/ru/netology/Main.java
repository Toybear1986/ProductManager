package ru.netology;

public class Main {

  public static void main(String[] args) {
    ProductRepository repository = new ProductRepository();

    try {
      repository.removeById(-100);
      //System.out.println("Hello!");
    } catch (NegativeArraySizeException e) {
      System.out.println("ERROR");
    }
  }
}
