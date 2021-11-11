package racinggame.model;

import com.sun.media.sound.InvalidFormatException;
import java.util.List;

public class Games {

  private final String carNames;
  private final int round;
  private static GameRound gameRound;

  private Games(String carNames, int round) {
    this.round = round;
    this.carNames = carNames;
  }

  public static Games of(String carNames, String round) throws InvalidFormatException {
    gameRound = new GameRound(CarList.of(carNames));
    int number = validateNumber(round);
    return new Games(carNames, number);
  }

  private static int validateNumber(String round) throws InvalidFormatException {
    try {
      return Integer.parseInt(round);
    } catch (NumberFormatException e){
      throw new InvalidFormatException();
    }
  }

  public List<Car> getResult() {
    return gameRound.getResultOfRound();
  }

  public String getWinnersString() {
    return gameRound.convertWinnerListToString();
  }


}
