package src;

import java.util.List;
import java.util.Random;

/**
 * Utility class for analyzing the performance of AVL tree operations.
 */
public class PerformanceAnalyzer {
    private List<Student> students;
    private AVLTree<Student> avlTree;
    private Random random;

    /**
     * Creates a new PerformanceAnalyzer with the specified list of students.
     * 
     * @param students The list of students to analyze.
     */
    public PerformanceAnalyzer(List<Student> students) {
        this.students = students;
        this.avlTree = new AVLTree<>();
        this.random = new Random(System.currentTimeMillis());
    }

    /**
     * Measures the time it takes to insert all students into the AVL tree.
     * 
     * @return The time taken in milliseconds.
     */
    public long measureInsertionTime() {
        System.out.println("Medindo tempo de inserção para " + students.size() + " estudantes...");
        System.out.flush();

        long startTime = System.currentTimeMillis();

        for (Student student : students) {
            avlTree.insert(student);
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Tempo de inserção: " + duration + " ms");
        System.out.println("Tamanho da árvore após inserção: " + avlTree.size());
        System.out.flush();

        return duration;
    }

    /**
     * Measures the time it takes to search for a specified number of random
     * students in the AVL tree.
     * 
     * @param numberOfSearches The number of searches to perform.
     * @return The time taken in milliseconds.
     */
    public long measureSearchTime(int numberOfSearches) {
        if (avlTree.isEmpty()) {
            System.out.println("Árvore vazia. Não é possível medir o tempo de busca.");
            System.out.flush();
            return 0;
        }

        System.out.println("Medindo tempo de busca para " + numberOfSearches + " estudantes aleatórios...");
        System.out.flush();

        long startTime = System.currentTimeMillis();

        int found = 0;
        // Estudante para mostrar como exemplo
        Student exampleStudent = null;
        boolean exampleFound = false;

        for (int i = 0; i < numberOfSearches; i++) {
            Student studentToSearch = students.get(random.nextInt(students.size()));
            boolean isFound = avlTree.search(studentToSearch);

            if (isFound) {
                found++;
            }

            // Seleciona um estudante aleatório para mostrar como exemplo (aproximadamente no meio das buscas)
            if (i == numberOfSearches / 2 && exampleStudent == null) {
                exampleStudent = studentToSearch;
                exampleFound = isFound;
            }
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Tempo de busca: " + duration + " ms");
        System.out.println("Estudantes encontrados: " + found + " de " + numberOfSearches);

        // Mostra o exemplo de busca
        if (exampleStudent != null) {
            System.out.println("\nExemplo de busca:");
            System.out.println("Estudante: " + exampleStudent);
            System.out.println("Resultado: " + (exampleFound ? "Encontrado" : "Não encontrado") + " na árvore");
        }

        System.out.flush();

        return duration;
    }

    /**
     * Measures the time it takes to perform an inorder traversal of the AVL tree.
     * 
     * @return The time taken in milliseconds.
     */
    public long measureTraversalTime() {
        if (avlTree.isEmpty()) {
            System.out.println("Árvore vazia. Não é possível medir o tempo de travessia.");
            System.out.flush();
            return 0;
        }

        System.out.println("Medindo tempo de travessia em ordem...");
        System.out.flush();

        long startTime = System.currentTimeMillis();

        int traversalSize = 0;
        try {
            List<Student> sortedStudents = avlTree.inorderTraversal();
            traversalSize = sortedStudents.size();
            System.out.println("Número de estudantes na travessia: " + traversalSize);

            // Print first few students to verify sort order
            System.out.println("Primeiros 5 estudantes em ordem:");
            for (int i = 0; i < Math.min(5, traversalSize); i++) {
                System.out.println("  " + (i + 1) + ". " + sortedStudents.get(i));
            }
            System.out.flush();
        } catch (Exception e) {
            System.out.println("Erro durante a travessia: " + e.getMessage());
            e.printStackTrace();
            System.out.flush();
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Tempo de travessia: " + duration + " ms");
        System.out.flush();

        return duration;
    }

    /**
     * Measures the time it takes to remove a specified number of random students
     * from the AVL tree.
     * 
     * @param numberOfRemovals The number of removals to perform.
     * @return The time taken in milliseconds.
     */
    public long measureRemovalTime(int numberOfRemovals) {
        if (avlTree.isEmpty()) {
            System.out.println("Árvore vazia. Não é possível medir o tempo de remoção.");
            System.out.flush();
            return 0;
        }

        int actualRemovals = Math.min(numberOfRemovals, students.size());
        System.out.println("Medindo tempo de remoção para " + actualRemovals + " estudantes aleatórios...");
        System.out.flush();

        long startTime = System.currentTimeMillis();

        int removed = 0;
        for (int i = 0; i < actualRemovals; i++) {
            Student studentToRemove = students.get(i);
            if (avlTree.remove(studentToRemove)) {
                removed++;
            }
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Tempo de remoção: " + duration + " ms");
        System.out.println("Estudantes removidos: " + removed + " de " + actualRemovals);
        System.out.println("Tamanho da árvore após remoção: " + avlTree.size());
        System.out.flush();

        return duration;
    }

    /**
     * Runs a complete performance analysis on the AVL tree.
     * 
     * @param numberOfSearches The number of searches to perform.
     * @param numberOfRemovals The number of removals to perform.
     */
    public void runCompleteAnalysis(int numberOfSearches, int numberOfRemovals) {
        System.out.println("\n===== Análise de Desempenho da Árvore AVL =====\n");
        System.out.flush();

        // Insertion test
        long insertionTime = measureInsertionTime();
        System.out.println();

        // Search test
        long searchTime = measureSearchTime(numberOfSearches);
        System.out.println();

        // Traversal test
        long traversalTime = measureTraversalTime();
        System.out.println();

        // Removal test
        long removalTime = measureRemovalTime(numberOfRemovals);
        System.out.println();

        // Calculate average times per operation
        double avgInsertionTime = students.isEmpty() ? 0 : (double) insertionTime / students.size();
        double avgSearchTime = numberOfSearches == 0 ? 0 : (double) searchTime / numberOfSearches;
        double avgRemovalTime = numberOfRemovals == 0 ? 0 : (double) removalTime / numberOfRemovals;

        System.out.println("\n===== Resumo de Desempenho =====");
        System.out.println("Número total de estudantes: " + students.size());
        System.out.println("Tempo total de inserção: " + insertionTime + " ms (média: "
                + String.format("%.6f", avgInsertionTime) + " ms por estudante)");
        System.out.println("Tempo total de busca: " + searchTime + " ms (média: " + String.format("%.6f", avgSearchTime)
                + " ms por busca)");
        System.out.println("Tempo total de travessia: " + traversalTime + " ms");
        System.out.println("Tempo total de remoção: " + removalTime + " ms (média: "
                + String.format("%.6f", avgRemovalTime) + " ms por remoção)");

        System.out.println("=============================\n");
        System.out.flush();
    }
}