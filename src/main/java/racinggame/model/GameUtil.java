package racinggame.model;

import nextstep.utils.Randoms;

public class GameUtil {

  private final int MOVE_BOUNDARY = 4;

  public Boolean canIMove(int randomNumber) {
    return randomNumber >= MOVE_BOUNDARY;
  }

  public int getRandomNumber() {
    return Randoms.pickNumberInRange(0,9);
  }

}
