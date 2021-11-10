package racinggame.model;

import com.sun.media.sound.InvalidFormatException;

public class Car {

  public static final String NOT_ALPHABET_CAR_NAME = "car name containing not alphabet";
  public static final String CAR_NAME_LENGTH_OVER = "car name length is invalid";
  private static final int CAR_NAME_LENGTH = 5;
  public static final String BLANK_CAR_NAME = "";
  public static final String COMMA_STRING = ",";
  private final String CAR_NAME_VALIDATE_PATTERN = "[a-zA-z]+";
  private final int MOVE_BOUNDARY = 4;
  public String carName;
  public int moveCount;

  public Car(String carName) throws InvalidFormatException {
    validateCarName(carName);
    this.carName = carName;
    this.moveCount = 0;
  }

  private void validateCarName(String carName) throws InvalidFormatException {
    validateCarNameLength(carName);
    validateCarNameAlphabet(carName);
  }

  private void validateCarNameAlphabet(String carName) throws InvalidFormatException {
    if (!carName.matches(CAR_NAME_VALIDATE_PATTERN)) {
      throw new InvalidFormatException(NOT_ALPHABET_CAR_NAME);
    }
  }

  private void validateCarNameLength(String carName) throws InvalidFormatException {
    if (carName.length() > CAR_NAME_LENGTH) {
      throw new InvalidFormatException(CAR_NAME_LENGTH_OVER);
    }
  }

  public void move() {
    this.moveCount++;
  }

  public void decideMoving(int number) {
    if (number >= MOVE_BOUNDARY) {
      this.move();
    }
  }

  public String decideWinner(int maxNumber) {
    if (this.moveCount == maxNumber) return this.carName+COMMA_STRING;
    return BLANK_CAR_NAME;
  }
}
