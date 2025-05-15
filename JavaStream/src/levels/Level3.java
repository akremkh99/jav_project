package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Level3 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /* TO DO 1: Retourner une chaine de caractère qui contient tous les noms des enseignants en majuscule separés par # */
        String names = teachers.stream()
                .map(t -> t.getName().toUpperCase())
                .collect(Collectors.joining("#"));

        /* TO DO 2: Retourner une set d'enseignants Java dont le salaire > 80000 */
        Set<Teacher> teachers1 = teachers.stream()
                .filter(t -> t.getSubject() == Subject.JAVA && t.getSalary() > 80000)
                .collect(Collectors.toSet());

        /* TO DO 3: Retourner une TreeSet d'enseignants (tri par nom et en cas d'égalité tri par salaire) */
        TreeSet<Teacher> teachers2 = teachers.stream()
                .collect(Collectors.toCollection(() ->
                        new TreeSet<>(Comparator.comparing(Teacher::getName)
                                .thenComparingInt(Teacher::getSalary))));

        /* TO DO 4: Retourner une Map qui regroupe les enseignants parВсе module */
        Map<Subject, List<Teacher>> map = teachers.stream()
                .collect(Collectors.groupingBy(Teacher::getSubject));

        /* TO DO 5: Retourner une Map qui regroupe les nom des enseignants par salaire */
        Map<Integer, String> map1 = teachers.stream()
                .collect(Collectors.toMap(
                        Teacher::getSalary,
                        Teacher::getName,
                        (name1, name2) -> name1 + "," + name2));

        /* TO DO 6: Afficher les nom des enseignants de chaque module */
        teachers.stream()
                .collect(Collectors.groupingBy(
                        Teacher::getSubject,
                        Collectors.mapping(Teacher::getName, Collectors.toList())))
                .forEach((subject, namesList) ->
                        System.out.println(subject + ": " + namesList));
    }
}