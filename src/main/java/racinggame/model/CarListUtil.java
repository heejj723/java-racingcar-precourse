package racinggame.model;

public class CarListUtil {

  public static String[] splitWithComma(String text) {
    return text.split(Car.COMMA_STRING);
  }
}
