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

  public int maxMoveCount() {
    int maxNum = 0;
    for(Car car : this.carList) {
      maxNum = Math.max(car.moveCount, maxNum);
    }
    return maxNum;
  }

  public List<Car> getCarsWithMaximumNumber() {
    List<Car> winners = new ArrayList<>();
    int maxNumber = maxMoveCount();
    for(Car car : this.carList) {
      if (car.moveCount == maxNumber) {
        winners.add(car);
      }
    }
    return winners;
  }



}
