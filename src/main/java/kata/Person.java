package kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Person {
    private String message;
    private List<String> messages = new ArrayList<>();

    public Person(String name) {
    }

    public void publish(String message) {
        this.message = message;
        this.messages.add(message);
    }

    public String viewTimeLine() {
        return message;
    }

    public List<String> viewTimeLineOf(Person person) {
        Collections.reverse(person.messages);
        return person.messages;
    }
}
