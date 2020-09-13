package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FeaturesTest {
    @Test
    void givenAlicePublishesMessageWhenAliceViewsMessageThenAliceSeesMessage() {
        var person = new Person("Alice");
        person.publish("I love the weather today.");

        var result = person.viewTimeLine();

        assertEquals("I love the weather today.", result);
    }

    @Test
    void givenBobPublishesMessageWhenAliceViewsBobsTimelineThenAliceSeesMessages() {
        var person1 = new Person("Bob");
        person1.publish("Darn! We lost!");
        person1.publish("Good game though.");

        var person2 = new Person("Alice");
        var timelineMessages = person2.viewTimeLineOf(person1);

        assertEquals(2, timelineMessages.size());
        assertEquals("Good game though.", timelineMessages.get(0));
        assertEquals("Darn! We lost!", timelineMessages.get(1));
    }
}
