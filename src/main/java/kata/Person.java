package kata;

public class Person {
    private String message;

    public Person(String name) {
    }

    public void publish(String message) {
        this.message = message;
    }

    public String viewTimeLine() {
        return message;
    }
}
