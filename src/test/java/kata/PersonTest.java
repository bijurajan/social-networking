package kata;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void shouldBeAbleToPublishMultipleMessageToTimeline() {
        var person = new Person("Harry");
        var message1 = "I am awesome";
        var message2 = "Amazing";
        person.publish(message1);
        person.publish(message2);

        var result = person.viewTimeLineOf(person);

        assertEquals(2, result.size());
        assertEquals(message2 + " (1 minute ago)", result.get(0));
        assertEquals(message1 + " (2 minute ago)", result.get(1));
    }

    @Test
    void shouldNotShowTimeIfOnlyOneMessageInTimeline() {
        var person = new Person("Harry");
        var message1 = "I am awesome";
        person.publish(message1);

        var result = person.viewTimeLineOf(person);

        assertEquals("I am awesome", result.get(0));
    }

    @Test
    void shouldShowTimeIfOMoreThanOneMessageInTimeline() {
        var person = new Person("Harry");
        var message1 = "I am awesome";
        var message2 = "Hello there";
        person.publish(message1);
        person.publish(message2);

        var result = person.viewTimeLineOf(person);

        assertEquals("Hello there" + " (1 minute ago)", result.get(0));
        assertEquals("I am awesome" + " (2 minute ago)", result.get(1));
    }
}