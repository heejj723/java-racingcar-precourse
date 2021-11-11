package racinggame.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import com.sun.media.sound.InvalidFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GamesTest {

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
