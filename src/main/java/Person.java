public class Person implements Comparable {
    @Override
    public int compareTo(Object o) {
        Person p2 = (Person) o;
        if (firstName != p2.firstName) {
            return firstName.compareTo(p2.firstName);
        } else return lastName.compareTo(p2.lastName);
    }

    private String firstName;

    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
