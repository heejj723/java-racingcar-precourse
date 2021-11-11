package racinggame.model;

import com.sun.media.sound.InvalidFormatException;
import java.util.List;

public class Games {

  private static GameRound gameRound;

  private Games() {
  }

  public static Games of(String carNames, String round) throws InvalidFormatException {
    gameRound = new GameRound(CarList.of(carNames));
    validateNumber(round);
    return new Games();
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

  public List<String> getWinnersString() {
    return gameRound.convertWinnerListToString();
  }


}
