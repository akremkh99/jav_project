package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Level2 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /* TO DO 1: Retourner le nombre des enseignants dont le nom commence avec s */
        long nbr = teachers.stream()
                .filter(t -> t.getName().toLowerCase().startsWith("s"))
                .count();
        System.out.println("Nombre enseignants (nom commence par s): " + nbr);

        /* TO DO 2: Retourner la somme des salaires de tous les enseignants Flutter (hint: mapToInt) */
        long sum = teachers.stream()
                .filter(t -> t.getSubject() == Subject.FLUTTER)
                .mapToInt(Teacher::getSalary)
                .sum();
        System.out.println("Somme des salaires Flutter: " + sum);

        /* TO DO 3: Retourner la moyenne des salaires des enseignants dont le nom commence avec a */
        double average = teachers.stream()
                .filter(t -> t.getName().toLowerCase().startsWith("a"))
                .mapToInt(Teacher::getSalary)
                .average()
                .orElse(0.0);
        System.out.println("Moyenne salaires (nom commence par a): " + average);

        /* TO DO 4: Retourner la liste des enseignants dont le nom commence par f */
        List<Teacher> teachers1 = teachers.stream()
                .filter(t -> t.getName().toLowerCase().startsWith("f"))
                .collect(Collectors.toList());
        System.out.println("Enseignants (nom commence par f): " + teachers1);

        /* TO DO 5: Retourner la liste des enseignants dont le nom commence par s */
        List<Teacher> teachers2 = teachers.stream()
                .filter(t -> t.getName().toLowerCase().startsWith("s"))
                .collect(Collectors.toList());
        System.out.println("Enseignants (nom commence par s): " + teachers2);

        /* TO DO 6: Retourner true s'il y a au min un enseignant dont le salaire > 100000, false sinon */
        boolean test = teachers.stream()
                .anyMatch(t -> t.getSalary() > 100000);
        System.out.println("Y a-t-il un enseignant avec salaire > 100000 ? " + test);

        /* TO DO 7: Afficher le premier enseignant Unity dont le nom commence avec g avec 2 manières différentes */
        System.out.println("Premier enseignant Unity (nom commence par g) - première manière:");
        teachers.stream()
                .filter(t -> t.getSubject() == Subject.UNITY)
                .filter(t -> t.getName().toLowerCase().startsWith("g"))
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("Deuxième manière (en variable Optionnelle) :");
        Optional<Teacher> optionalTeacher = teachers.stream()
                .filter(t -> t.getSubject() == Subject.UNITY)
                .filter(t -> t.getName().toLowerCase().startsWith("g"))
                .findFirst();
        optionalTeacher.ifPresent(System.out::println);

        /* TO DO 8: Afficher le deuxième enseignant dont le nom commence avec s */
        System.out.println("Deuxième enseignant (nom commence par s) :");
        teachers.stream()
                .filter(t -> t.getName().toLowerCase().startsWith("s"))
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
