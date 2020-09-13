package kata;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private List<String> messages = new ArrayList<>();

    public Person(String name) {
    }

    public void publish(String message) {
        this.messages.add(message);
    }

    public List<String> viewTimeLineOf(Person person) {
        if(person.messages.size() == 1){
            return person.messages;
        }

        Collections.reverse(person.messages);
        List<String> messagesWithTime = new ArrayList<>();
        for(int i=0; i < person.messages.size(); i++){
            messagesWithTime.add(person.messages.get(i) + " (" + (i+1) +" minute ago)");
        }
        return messagesWithTime;
    }

}
