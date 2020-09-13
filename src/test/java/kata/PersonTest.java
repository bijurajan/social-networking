package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void shouldBeAbleToPublishMultipleMessageToTimeline() {
        var person = new Person("Harry");
        var message1 = "I am awesome";
        var message2 = "Amazing";
        person.publish(message1);
        person.publish(message2);

        var timeLineMessages = person.viewTimeLineOf(person);

        assertEquals(2, timeLineMessages.size());
        assertEquals(message2, timeLineMessages.get(0));
        assertEquals(message1, timeLineMessages.get(1));
    }
}