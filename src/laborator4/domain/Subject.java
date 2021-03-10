package laborator4.domain;

public class Subject {
    private int id;
    private String name;

    public Subject() {
        name = null;
    }

    public Subject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + ".   " + name;
    }
}
