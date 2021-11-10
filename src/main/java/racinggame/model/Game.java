package racinggame.model;

import static racinggame.model.Car.COMMA_STRING;

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
    for (int i = 0; i < carList.getSize(); i++) {
      carList.getCar(i).decideMoving(getRandomNumber());
      result.add(carList.getCar(i));
    }
    return result;
  }

  public String convertWinnerListToString() {
    List<String> winnerNameList = carList.maxMoveCarsName();
    StringBuilder result = new StringBuilder(Car.BLANK_CAR_NAME);
    for (String winnerName : winnerNameList) {
      result.append(winnerName);
    }
    return result.substring(0, result.length()-1);
  }
}
