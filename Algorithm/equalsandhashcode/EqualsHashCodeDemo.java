package equalsandhashcode;

import java.util.HashSet;
import java.util.Set;

public class EqualsHashCodeDemo {
    public static void main(String[] args) {

        // Without equals and hashcode
        PersonBasic person1 = new PersonBasic("Ram", 20);
        PersonBasic person2 = new PersonBasic("Ram", 20);

        System.out.println("Without equals and hashcode: "
                + (person1.equals(person2)));

        // With only equals
        PersonEquals person3 = new PersonEquals("Ram", 20);
        PersonEquals person4 = new PersonEquals("Ram", 20);
        System.out.println("With only equals: "
                + (person3.equals(person4)));
        Set<PersonEquals> set1 = new HashSet<>();
        set1.add(person3);
        set1.add(person4);
        System.out.println("Set size: " + set1.size());

        PersonFull person5 = new PersonFull("Ram", 20);
        PersonFull person6 = new PersonFull("Ram", 20);
        System.out.println("With equals and hashcode: "
                + (person5.equals(person6)));
        Set<PersonFull> set2 = new HashSet<>();
        set2.add(person5);
        set2.add(person6);
        System.out.println("Set size: " + set2.size());

        PersonImmutable person7 = new PersonImmutable("Ram", 20);
        PersonImmutable person8 = new PersonImmutable("Ram", 20);
        System.out.println("With equals and hashcode: "
                + (person7.equals(person8)));
        Set<PersonImmutable> set3 = new HashSet<>();
        set3.add(person7);
        set3.add(person8);
        System.out.println("Set size: " + set3.size());

        PersonRecord person9 = new PersonRecord("Ram", 20);
        PersonRecord person10 = new PersonRecord("Ram", 20);
        System.out.println("With equals and hashcode: "
                + (person9.equals(person10)));
        Set<PersonRecord> set4 = new HashSet<>();
        set4.add(person9);
        set4.add(person10);
        System.out.println("Set size: " + set4.size());
    }
}


