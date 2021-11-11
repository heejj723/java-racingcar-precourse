package racinggame.model;

import com.sun.media.sound.InvalidFormatException;
import java.util.ArrayList;
import java.util.List;

public class Games {

  private final String carNames;
  private final int round;
  private static Game game;

  public Games(String carNames, int round) {
    this.round = round;
    this.carNames = carNames;
  }

  public static Games of(String carNames, String round) throws InvalidFormatException {
    game = new Game(CarList.of(carNames));
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
    return game.getResultOfRound();
  }

  public String getWinnersString() {
    return game.convertWinnerListToString();
  }


}
