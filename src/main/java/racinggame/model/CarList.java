package racinggame.model;

import com.sun.media.sound.InvalidFormatException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CarList extends CarListUtil{

  private static List<Car> carList;
  private final int MAX_NUMBER_INIT = 0;

  private CarList(List<Car> cars) {
    this.carList = cars;
  }

  public static CarList of(String nameText) throws InvalidFormatException {
    List<Car> cars = new ArrayList<>();
    String[] names = splitWithComma(nameText);
    for (String name: names) {
      Car car = Car.of(name);
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

  public int maxMoveCount() {
    int maxNum = MAX_NUMBER_INIT;
    for(Car car : carList) {
      maxNum = Math.max(car.moveCount, maxNum);
    }
    return maxNum;
  }

  public List<String> maxMoveCarsName() {
    List<String> maxMoveCarsNameList = new ArrayList<>();
    int maxNumber = maxMoveCount();
    for (Car car : carList) {
      maxMoveCarsNameList.add(car.getCarNameMoveCountIsMaxNumber(maxNumber));
    }
    return maxMoveCarsNameList;
  }
}
