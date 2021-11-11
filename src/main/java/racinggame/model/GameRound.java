package racinggame.model;

import static racinggame.model.Car.COMMA_STRING;

import java.util.ArrayList;
import java.util.List;
import nextstep.utils.Randoms;

public class GameRound {

  public final CarList carList;
  private final int BEGIN_INDEX = 0;
  private final int RANDOM_RANGE_START = 0;
  private final int RANDOM_RANGE_END = 9;

  public GameRound(CarList carList) {
    this.carList = carList;
  }

  public int getRandomNumber() {
    return Randoms.pickNumberInRange(RANDOM_RANGE_START,RANDOM_RANGE_END);
  }

  public List<Car> getResultOfRound() {
    List<Car> result = new ArrayList<>();
    for (int i = BEGIN_INDEX; i < carList.getSize(); i++) {
      carList.getCar(i).decideMoving(getRandomNumber());
      result.add(carList.getCar(i));
    }
    return result;
  }

  public List<String> convertWinnerListToString() {
    return carList.maxMoveCarsName();
  }
}
