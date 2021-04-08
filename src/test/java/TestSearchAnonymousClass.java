import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSearchAnonymousClass {

    People p;

    @Before
    public void setup() {
        this.p = People.getInstance();

        Person mike = new Person("Mike", 22, Person.Sex.MALE);
        Person kelly = new Person("Kelly", 24, Person.Sex.FEMALE);
        Person lena = new Person("Lena", 23, Person.Sex.FEMALE);
        Person monali = new Person("Monali", 25, Person.Sex.FEMALE);
        Person ryan = new Person("Ryan", 29, Person.Sex.MALE);
        Person abiel = new Person("Abiel", 27, Person.Sex.MALE);

        p.add(mike);
        p.add(kelly);
        p.add(lena);
        p.add(monali);
        p.add(ryan);
        p.add(abiel);

    }

    @Test
    public void testSearchAnonymous() {
        // Given
        String expected = "Person{name=Mike, age=22, gender=MALE}\n";

        // When
            // Search using an anonymous class
            // benefit is you don't have to create new class for each search
            // however, bulky syntax :(
        String actual = p.printPersons(p.getPeopleList(), new CheckPerson() {
                public boolean test(Person p) {
                    return p.getGender() == Person.Sex.MALE
                            && p.getAge() >= 18
                            && p.getAge() <= 25;
                }
            }
        );

        // Then
        Assert.assertEquals(actual, expected);
    }
}


