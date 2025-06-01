package src;

import java.io.IOException;
import java.util.List;

/**
 * Classe principal para executar a análise de desempenho da árvore AVL.
 */
public class App {
    /**
     * O ponto de entrada principal para a aplicação.
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        try {
            System.out.println("Iniciando Análise de Desempenho da Árvore AVL");
            System.out.println("============================================");
            
            // Carrega o conjunto de dados
            String datasetPath = "data/dataset.csv";
            CSVReader csvReader = new CSVReader(datasetPath);
            List<Student> students = csvReader.readStudents();
            
            System.out.println("Carregados " + students.size() + " estudantes de " + datasetPath);
            System.out.println("Exemplo de estudante: " + students.get(0));
            
            // Cria e executa o analisador de desempenho
            PerformanceAnalyzer analyzer = new PerformanceAnalyzer(students);
            
            // Vamos buscar 5000 estudantes aleatórios e remover 1000
            int numberOfSearches = 5000;
            int numberOfRemovals = 1000;
            
            System.out.println("\nExecutando análise de desempenho com:");
            System.out.println("- Total de estudantes: " + students.size());
            System.out.println("- Número de buscas: " + numberOfSearches);
            System.out.println("- Número de remoções: " + numberOfRemovals);
            
            analyzer.runCompleteAnalysis(numberOfSearches, numberOfRemovals);
            
            System.out.println("Análise de desempenho concluída com sucesso!");
            
        } catch (IOException e) {
            System.err.println("Erro ao ler o conjunto de dados: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
} 