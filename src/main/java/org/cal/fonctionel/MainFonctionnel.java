package org.cal.fonctionel;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainFonctionnel {

    // Seuls les genres Masculin et Feminin sont retenus.  Libre à vous de changer selon vos préférences
    record Student(String prenom, String nom, String genre, int age, int noteGlobale) {}

    static List<Student> students = List.of(
            new Student("Samir", "Badi", "M", 22, 90),
            new Student("Mathieu", "Ford", "M",21, 92),
            new Student("Medi", "Boue", "M", 22, 89),
            new Student("Yan", "Zhou", "F", 23, 99),
            new Student("Jeremy", "Mailhot", "M", 19, 95),
            new Student("Massi", "Massi", "M", 32, 68),
            new Student("Manolo", "Racine", "M", 39, 59)
    );

    public static void main(String[] args) {
        printStudents(studentsSortedByAge());
        printStudents(studentsAgeGt25SortedDescByAge());
        printStudents(sortedByFirstNameThenByLastName());
        groupByGenre();
    }

    private static void printStudents(List<Student> studentsToPrint) {
        studentsToPrint.forEach(System.out::println);
        System.out.println();
    }

    private static List<Student> studentsSortedByAge() {
        return students.stream().sorted(Comparator.comparingInt(Student::age)).collect(Collectors.toList());
    }

    private static List<Student> studentsAgeGt25SortedDescByAge() {
        return students.stream().filter(student -> student.age() > 25).sorted((s1, s2) -> s2.age() - s1.age()).collect(Collectors.toList());
    }

    private static List<Student> sortedByFirstNameThenByLastName() {
        return students.stream().sorted(Comparator.comparing(Student::prenom).thenComparing(Student::nom)).collect(Collectors.toList());
    }

    private static void groupByGenre() {
        // Completer le code pour obtenir le resultat en commentaire plus bas
       final Map<String, List<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::genre));
        System.out.println(collect);
        System.out.println();

        //{F=[Student[prenom=Yan, nom=Zhou, genre=F, age=23, noteGlobale=99]],
        // M=[Student[prenom=Samir, nom=Badi, genre=M, age=22, noteGlobale=90],
        //    Student[prenom=Mathieu, nom=Ford, genre=M, age=21, noteGlobale=92],
        //    Student[prenom=Medi, nom=Boue, genre=M, age=22, noteGlobale=89],
        //    Student[prenom=Jeremy, nom=Mailhot, genre=M, age=19, noteGlobale=95],
        //    Student[prenom=Massi, nom=Massi, genre=M, age=32, noteGlobale=68],
        //    Student[prenom=Manolo, nom=Racine, genre=M, age=39, noteGlobale=59]]}
    }
}
