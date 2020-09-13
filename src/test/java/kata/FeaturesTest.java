package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FeaturesTest {

    @Test
    void givenAlicePublishesMessageWhenAliceViewsMessageThenAliceSeesMessage() {
        var person = new Person("Alice");
        person.publish("I love the weather today.");

        var result = person.viewTimeLineOf(person);

        assertEquals(1, result.size());
        assertEquals("I love the weather today.", result.get(0));
    }

    @Test
    void givenBobPublishesMessageWhenAliceViewsBobsTimelineThenAliceSeesMessages() {
        var person1 = new Person("Bob");
        person1.publish("Darn! We lost!");
        person1.publish("Good game though.");

        var person2 = new Person("Alice");
        var result = person2.viewTimeLineOf(person1);

        assertEquals(2, result.size());
        assertEquals("Good game though. (1 minute ago)", result.get(0));
        assertEquals("Darn! We lost! (2 minute ago)", result.get(1));
    }
}
