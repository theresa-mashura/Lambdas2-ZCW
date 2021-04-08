import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public final class People {

    private static final People INSTANCE = new People();

    List<Person> peopleList;

    private People() {
        this.peopleList = new ArrayList<Person>();
    }

    public static People getInstance() {
        return INSTANCE;
    }

    public List<Person> getPeopleList() {
        return this.peopleList;
    }

    public void add(Person newPerson) {
        this.peopleList.add(newPerson);
    }

    public String printPersons(List<Person> people, CheckPerson tester) {
        StringBuilder result = new StringBuilder();
        for (Person p : people) {
            if (tester.test(p)) {
                result.append(p.toString()).append("\n");
            }
        }
        return result.toString();
    }

    // Using the Predicate functional interface instead of our CheckPerson functional interface
    public String printPersonsPredicate(List<Person> people, Predicate<Person> tester) {
        StringBuilder result = new StringBuilder();
        for (Person p : people) {
            if(tester.test(p)) {
                result.append(p.toString()).append("\n");
            }
        }
        return result.toString();
    }

    // Using Predicate and Function functional interfaces....allows you to choose what you want to do with the data you've searched
    public String processPersons(List<Person> people, Predicate<Person> tester, Function<Person, String> block) {
        StringBuilder result = new StringBuilder();
        for (Person p : people) {
            if (tester.test(p)) {
                result.append(block.apply(p));
            }
        }
        return result.toString();
    }

}
