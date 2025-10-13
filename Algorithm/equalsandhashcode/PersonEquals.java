package equalsandhashcode;

import java.util.Objects;

public class PersonEquals {

    String name;
    int age;

    public PersonEquals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        PersonEquals other = (PersonEquals) obj;
        return age == other.age && Objects.equals(name, other.name);
    }
}