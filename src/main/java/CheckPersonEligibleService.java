public class CheckPersonEligibleService implements CheckPerson {

    // Specifying the search criteria in a local class
    // To specify search criteria, we implement the CheckPerson interface

    public boolean test(Person p) {
        return p.getGender() == Person.Sex.MALE &&
                p.getAge() >= 18 &&
                p.getAge() <= 25;
    }
}
