package racinggame.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import com.sun.media.sound.InvalidFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GamesTest {

  @BeforeEach
  void setUp() {

  }

  @Test
  @DisplayName("Games 생성 검증: 잘못된 자동차 이름")
  void games_객체_생성_검증_잘못된_자동차_이름() {
    // given
    String invalidCarNames = "e3,213343";
    // when // then
    assertThatThrownBy(() -> {
      Games.of(invalidCarNames, "4");
    }).isInstanceOf(InvalidFormatException.class);

  }

  @Test
  @DisplayName("Games 생성 검증: 잘못된 경주 횟수")
  void games_객체_생성_검증_잘못된_경주_횟수() {
    // given
    String invalidCarNames = "a,b,c";
    // when // then
    assertThatThrownBy(() -> {
      Games.of(invalidCarNames, "c");
    }).isInstanceOf(InvalidFormatException.class);

  }

}
