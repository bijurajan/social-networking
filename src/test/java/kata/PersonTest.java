package kata;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private final LocalDateTime frozenTime = LocalDateTime.of(2020,9,13,6,0,0);

    @Test
    void shouldBeAbleToPublishMultipleMessageToTimeline() {
        var person = new Person("Harry");
        var message1 = "I am awesome";
        var message2 = "Amazing";
        person.publish(message1, frozenTime.minusMinutes(2));
        person.publish(message2, frozenTime.minusMinutes(1));

        var result = person.viewTimeLineOf(person, frozenTime);

        assertEquals(2, result.size());
        assertEquals(message2 + " (1 minute ago)", result.get(0));
        assertEquals(message1 + " (2 minute ago)", result.get(1));
    }

    @Test
    void shouldNotShowTimeIfOnlyOneMessageInTimeline() {
        var person = new Person("Harry");
        var message1 = "I am awesome";
        person.publish(message1, frozenTime);

        var result = person.viewTimeLineOf(person, frozenTime);

        assertEquals("I am awesome", result.get(0));
    }

    @Test
    void shouldShowTimeIfOMoreThanOneMessageInTimeline() {
        var person = new Person("Harry");
        var message1 = "I am awesome";
        var message2 = "Hello there";
        person.publish(message1, frozenTime.minusMinutes(2));
        person.publish(message2, frozenTime.minusMinutes(1));

        var result = person.viewTimeLineOf(person, frozenTime);

        assertEquals("Hello there" + " (1 minute ago)", result.get(0));
        assertEquals("I am awesome" + " (2 minute ago)", result.get(1));
    }

    @Test
    void shouldViewListOfFollowedPeople() {
        var person = new Person("Harry");
        var person2 = new Person("Nate");

        person.follow(person2);

        assertEquals(Arrays.asList(person2), person.getListOfFollowedPeople());
    }
}