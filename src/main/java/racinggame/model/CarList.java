package racinggame.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CarList {

  public List<Car> carList;

  public CarList(String nameText) {
    carList = new ArrayList<>();
    String[] names = splitWithComma(nameText);
    for (String name : names) {
      addCar(name);
    }
  }

  public void addCar(String carName) {
    try {
      Car car = new Car(carName);
      carList.add(car);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public String[] splitWithComma(String text) {
    return text.split(",");
  }



}
