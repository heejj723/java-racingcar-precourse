package racinggame.model;

import nextstep.utils.Randoms;

public class Games {

  private final int MOVE_BOUNDARY = 4;
  private final CarList carList;
  private final int round;

  public Games(String carNames, int round) {
    carList = new CarList(carNames);
    this.round = round;
  }

  public void play() {
    for (int i = 0; i < round; i++) {
      playRound();
    }
  }

  private void playRound() {
    for (Car car: carList.carList) {
      checkMove(car);
    }
  }

  private void checkMove(Car car) {
    if (canIMove(getRandomNumber())) {
      car.move();
    }
  }

  public Boolean canIMove(int randomNumber) {
    return randomNumber >= MOVE_BOUNDARY;
  }

  public int getRandomNumber() {
    return Randoms.pickNumberInRange(0,9);
  }


}
