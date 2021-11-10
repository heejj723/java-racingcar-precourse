package racinggame.model;

import com.sun.media.sound.InvalidFormatException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CarList {

  private static List<Car> carList;

  private CarList(List<Car> cars) {
    this.carList = cars;
  }

  public static CarList of(String nameText) throws InvalidFormatException {
    List<Car> cars = new ArrayList<>();
    String[] names = splitWithComma(nameText);
    for (String name: names) {
      Car car = new Car(name);
      cars.add(car);
    }

    return new CarList(cars);
  }

  public Car getCar(int index) {
    return carList.get(index);
  }

  public int getSize() {
    return carList.size();
  }

  private static String[] splitWithComma(String text) {
    return text.split(",");
  }

  public int maxMoveCount() {
    int maxNum = 0;
    for(Car car : carList) {
      maxNum = Math.max(car.moveCount, maxNum);
    }
    return maxNum;
  }


  public List<String> maxMoveCarsName() {
    List<String> maxMoveCarsName = new ArrayList<>();
    int maxNumber = maxMoveCount();
    for (Car car : carList) {
      maxMoveCarsName.add(car.decideWinner(maxNumber));
    }
    return maxMoveCarsName;
  }
}
