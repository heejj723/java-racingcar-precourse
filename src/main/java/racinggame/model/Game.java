package racinggame.model;

import java.util.ArrayList;
import java.util.List;
import nextstep.utils.Randoms;

public class Game {

  public final CarList carList;

  public Game(CarList carList) {
    this.carList = carList;
  }

  public int getRandomNumber() {
    return Randoms.pickNumberInRange(0,9);
  }

  public List<Car> getResultOfRound() {
    List<Car> result = new ArrayList<>();
    for (int i = 0; i < carList.carList.size(); i++) {
      Car car = carList.carList.get(i);
      car.decideMoving(getRandomNumber());
      result.add(car);
      updateCarList(i, car);
    }
    return result;
  }

  public void updateCarList(int index, Car car) {
    carList.carList.set(index, car);
  }
}
