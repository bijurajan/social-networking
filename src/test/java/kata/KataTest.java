package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KataTest {
    @Test
    void givenAlicePublishesMessageWhenAliceViewsMessageThenAliceSeesMessage() {
        var person = new Person("Alice");
        person.publish("I love the weather today.");

        var result = person.viewTimeLine();

        assertEquals("I love the weather today.", result);
    }
}
