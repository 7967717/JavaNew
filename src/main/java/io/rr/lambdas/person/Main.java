package io.rr.lambdas.person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author romanr on 2/16/2017.
 */
public class Main {
    static List<Person> roster;

    public static void main(String[] args) {
        printPersons(
                roster,
                new CheckPerson() {
                    public boolean test(Person p) {
                        return p.gender == Person.Sex.MALE
                                && p.getAge() >= 18
                                && p.getAge() <= 25;
                    }
                }
        );

        processPersons(
                roster,
                p -> p.gender == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
//                p -> p.printPerson()
                Person::printPerson
        );

        processPersonsWithFunction(
                roster,
                p -> p.gender == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.emailAddress,
//                email -> System.out.println(email)
                System.out::println
        );

        processElements(
                roster,
                p -> p.gender == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.emailAddress,
//                email -> System.out.println(email)
                System.out::println
        );

//        ---------------------------------------------------

        Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);

        class PersonAgeComparator implements Comparator<Person> {
            public int compare(Person a, Person b) {
                return a.birthday.compareTo(b.birthday);
            }
        }

        Arrays.sort(rosterAsArray, new PersonAgeComparator());

        Arrays.sort(rosterAsArray,
                (Person a, Person b) -> {
                    return a.birthday.compareTo(b.birthday);
                }
        );
        Arrays.sort(rosterAsArray,
                (a, b) -> Person.compareByAge(a, b)
        );
        Arrays.sort(rosterAsArray,
                Person::compareByAge
        );
//        -----------
        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray, String::compareToIgnoreCase);


    }

    private static void printPersons(
            List<Person> roster,
            CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    private static void processPersons(
            List<Person> roster,
            Predicate<Person> tester,
            Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    public static void processPersonsWithFunction(
            List<Person> roster,
            Predicate<Person> tester,
            Function<Person, String> mapper,
            Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static <X, Y> void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function<X, Y> mapper,
            Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }


}
