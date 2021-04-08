public interface CheckPerson {
// this is a functional interface - contains only one abstract method
    // can contain one or more default or static methods, however
    // b/c it has only one abstract method, can omit the name of that method when you implement it...use a lambda expression
    boolean test(Person p);
}
