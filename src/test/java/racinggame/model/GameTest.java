package racinggame.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import org.mockito.Spy;

public class GameTest {

  private Game game;
  private static CarList carList;

  @BeforeEach
  void setUp() {
    carList = new CarList("a,b,c");
    game = new Game(carList);
  }

  @Test
  @DisplayName("car 에 대해 random Number 뽑기")
  void 랜덤_숫자_뽑기() {
    // given
    // when
    // then
    assertThat(game.getRandomNumber()).isBetween(0,9);
  }

  @Test
  @DisplayName("getResultOfRound(): ")
  void 한_라운드에_대한_결과값_반환_4이상() {
    // given
    // when
    List<Car> result = game.getResultOfRound();
    // then
    assertThat(result.get(0).carName).isEqualTo("a");
    assertThat(result.get(1).carName).isEqualTo("b");
    assertThat(result.get(2).carName).isEqualTo("c");
  }
}
