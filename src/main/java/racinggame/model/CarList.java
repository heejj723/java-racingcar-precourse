package racinggame.model;

import com.sun.media.sound.InvalidFormatException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CarList extends CarListUtil{

  private static List<Car> carList;
  private final int MAX_NUMBER_INIT = 0;

  private CarList(List<Car> cars) {
    this.carList = cars;
  }

  public static CarList of(String nameText) throws InvalidFormatException {

    String[] names = splitWithComma(nameText);
    List<Car> cars = makeCarsWithNames(names);
    return new CarList(cars);
  }

  private static List<Car> makeCarsWithNames(String[] names) throws InvalidFormatException {
    List<Car> cars = new ArrayList<>();
    for (String name: names) {
      Car car = Car.of(name);
      cars.add(car);
    }
    return cars;
  }

  public Car getCar(int index) {
    validateIndexRange(index);
    return carList.get(index);
  }

  private void validateIndexRange(int index) {
    if (index >= carList.size()) {
      throw new IndexOutOfBoundsException();
    }
  }

  public int getSize() {
    return carList.size();
  }

  public int maxMoveCount() {
    AtomicInteger maxNum = new AtomicInteger();
    carList.stream().forEach(car -> {
      maxNum.set(Math.max(maxNum.get(), car.moveCount));
    });
    return maxNum.get();
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
