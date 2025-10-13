package equalsandhashcode;

import java.util.Objects;

public class PersonImmutable {
    private final String name;
    private final int age;
    public PersonImmutable(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (!(obj instanceof PersonImmutable)) return false;
        PersonImmutable other = (PersonImmutable) obj;
        return age == other.age && Objects.equals(name, other.name);
    }

    public int hashCode() {
        int resutl = 17;
        resutl = 31 * resutl + (name !=null ? Objects.hashCode(name) : 0);
        resutl = 31 * resutl + age;
        return resutl;
    }
}
