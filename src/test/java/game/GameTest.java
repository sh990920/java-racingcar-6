package game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import car.Car;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameTest {

    @Test
    public void testAddPerson(){
        Game game = new Game();

        List<String> result = game.addPerson("user1,user2");

        assertThat(result).containsExactly("user1", "user2");
    }

    @Test
    public void testAddPersonException(){
        Game game = new Game();

        assertThatThrownBy(() -> game.addPerson("user1,userLongName"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    public void testAddCar(){
        Game game = new Game();

        List<String> people = game.addPerson("user1,user2");

        List<Car> carList = game.addCar(people);

        assertThat(carList).hasSize(2);

        assertThat(carList.get(0).getName()).isEqualTo("user1");
        assertThat(carList.get(1).getName()).isEqualTo("user2");
    }
}