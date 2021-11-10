package racinggame.model;

import com.sun.media.sound.InvalidFormatException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CarList {

  private static List<Car> carList;

  private CarList() {
    carList = new ArrayList<>();
  }

  public static List<Car> of(String nameText) throws InvalidFormatException {
    String[] names = splitWithComma(nameText);
    for (String name: names) {
      Car car = new Car(name);
      carList.add(car);
    }
    return carList;
  }

  private static String[] splitWithComma(String text) {
    return text.split(",");
  }

  private int maxMoveCount() {
    int maxNum = 0;
    for(Car car : carList) {
      maxNum = Math.max(car.moveCount, maxNum);
    }
    return maxNum;
  }

  public List<Car> getCarsWithMaximumNumber() {
    List<Car> winners = new ArrayList<>();
    int maxNumber = maxMoveCount();
    for(Car car : carList) {
      if (car.moveCount == maxNumber) {
        winners.add(car);
      }
    }
    return winners;
  }



}
