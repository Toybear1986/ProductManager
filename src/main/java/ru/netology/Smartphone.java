package ru.netology;

public class Smartphone extends Product {
  private String vendor;

  public Smartphone(int id, String name, int price, String vendor) {
    super(id, name, price);
    this.vendor = vendor;
  }

  public String getVendor() {
    return vendor;
  }

  @Override
  public boolean matches(String search) {
    if (super.matches(search)) { // вызов метода matches в версии описанной в Product
      return true;
    } else {
      return getVendor().contains(search);
    }
  }
}
