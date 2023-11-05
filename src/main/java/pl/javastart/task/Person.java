package pl.javastart.task;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String pesel;
    private static final int MINAGE = 1;
    private static final int MINLENGHT = 2;

    public void setAge(int age) throws IncorrectAgeException {
        if (checkAge(age)) {
            this.age = age;
        }
    }

    public void setFirstName(String firstName) throws NameUndefinedException {
        if (checkFirstName(firstName)) {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) throws NameUndefinedException {
        if (checkLastName(lastName)) {
            this.lastName = lastName;
        }
    }

    public Person(String firstName, String lastName, int age, String pesel) throws NameUndefinedException, IncorrectAgeException {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", pesel='" + pesel + '\'' +
                '}';
    }

    public boolean checkFirstName(String firstName) throws NameUndefinedException {
        if (firstName == null || firstName.length() < MINLENGHT) {
            throw new NameUndefinedException("Imię nie może być nullem i posiadać mniej niż 2 znaki");
        }
        return true;
    }

    public boolean checkLastName(String lastName) throws NameUndefinedException {
        if (lastName == null || lastName.length() < MINLENGHT) {
            throw new NameUndefinedException("Nazwisko nie może być nullem i posiadać mniej niż 2 znaki");
        }
        return true;
    }

    public boolean checkAge(int age) throws IncorrectAgeException {
        if (age < MINAGE) {
            throw new IncorrectAgeException("Wiek nie może być mniejszy niż 1");
        }
        return true;
    }

}

