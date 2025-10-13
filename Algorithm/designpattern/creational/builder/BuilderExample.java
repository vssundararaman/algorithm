package designpattern.creational.builder;

public class BuilderExample {

    public static class Person {
        private String name;
        private int age;
        private String address;

        private Person(PersonBuilder builder) {
            this.name = builder.name;
            this.age = builder.age;
            this.address = builder.address;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getAddress() {
            return address;
        }

        public static class PersonBuilder {
            private String name;
            private int age;
            private String address;

            public PersonBuilder name(String name) {
                this.name = name;
                return this;
            }

            public PersonBuilder age(int age) {
                this.age = age;
                return this;
            }

            public PersonBuilder address(String address) {
                this.address = address;
                return this;
            }

            public Person build() {
                return new Person(this);
            }
        }
    }

    public static void main(String[] args) {
        Person person = new Person.PersonBuilder()
                .name("John Doe")
                .age(30)
                .address("123 Main St")
                .build();

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Address: " + person.getAddress());
    }
}
