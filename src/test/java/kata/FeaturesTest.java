package kata;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FeaturesTest {

    private final LocalDateTime frozenTime = LocalDateTime.of(2020,9,13,6,0,0);

    @Test
    void givenAlicePublishesMessageWhenAliceViewsMessageThenAliceSeesMessage() {
        var person = new Person("Alice");
        person.publish("I love the weather today.", frozenTime);

        var result = person.viewTimeLineOf(person, frozenTime);

        assertEquals(1, result.size());
        assertEquals("I love the weather today.", result.get(0));
    }

    @Test
    void givenBobPublishesMessageWhenAliceViewsBobsTimelineThenAliceSeesMessages() {
        var person1 = new Person("Bob");
        person1.publish("Darn! We lost!", frozenTime.minusMinutes(2));
        person1.publish("Good game though.", frozenTime.minusMinutes(1));

        var person2 = new Person("Alice");
        var result = person2.viewTimeLineOf(person1, frozenTime);

        assertEquals(2, result.size());
        assertEquals("Good game though. (1 minute ago)", result.get(0));
        assertEquals("Darn! We lost! (2 minute ago)", result.get(1));
    }
}
