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
  @DisplayName("Games 생성 검증")
  void games_객체_생성_검증() {
    // given
    String invalidCarNames = "e3,213343";
    // when // then
    assertThatThrownBy(() -> {
      Games.of(invalidCarNames, 4);
    }).isInstanceOf(InvalidFormatException.class);

  }

}
