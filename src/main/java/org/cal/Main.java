package org.cal;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<String> students = List.of("SamirBadi", "ManoloRacine", "MathieuFord",
                "MediBoue", "JeremyMailhot", "MassiMassi", "YanZhou");
        var listOfStringLengths = students.stream()
            // Ligne qui met la longueur de la string.
                .toList();
        listOfStringLengths
                .forEach(System.out::println);

    }
}