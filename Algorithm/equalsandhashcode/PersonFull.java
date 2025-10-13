package equalsandhashcode;

import java.util.Objects;

public class PersonFull {

    String name;
    int age;

    public PersonFull(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PersonFull)) return false;
        PersonFull other = (PersonFull) obj;
        return age == other.age && Objects.equals(name, other.name);
    }
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
