package kata;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

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

//    @Test
    void something() {
        var alice = new Person("Alice");
        alice.publish("I love the weather today.", frozenTime.minusMinutes(5));
        var bob = new Person("Bob");
        bob.publish("Darn! We lost!", frozenTime.minusMinutes(2));
        bob.publish("Good game though.", frozenTime.minusMinutes(1));
        var charlie = new Person("Charlie");
        charlie.publish("I'm in New York today! Anyone wants to have a coffee?", frozenTime.minusSeconds(15));

        charlie.follow(alice);
        charlie.follow(bob);
        var timeLine = charlie.viewTimeLine();

        assertEquals(4, timeLine.size());
        assertEquals("Charlie - I'm in New York today! Anyone wants to have a coffee? (15 seconds ago)", timeLine.get(0));
        assertEquals("Bob - Good game though. (1 minute ago)", timeLine.get(1));
        assertEquals("Bob - Damn! We lost! (2 minutes ago)", timeLine.get(2));
        assertEquals("Alice - I love the weather today (5 minutes ago)", timeLine.get(3));





    }
}
