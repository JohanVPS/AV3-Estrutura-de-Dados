# Análise de Desempenho de Árvores AVL

Este projeto analisa o desempenho da estrutura de dados de árvore AVL com um grande conjunto de registros de estudantes. Ele mede e reporta métricas de desempenho para operações de inserção, busca, percurso e remoção.

## Estrutura do Projeto

- `src/` - Diretório do código-fonte  
  - `AVLNode.java` - Representa um nó na árvore AVL  
  - `AVLTree.java` - Implementação da estrutura de dados de árvore AVL  
  - `Student.java` - Representa um registro de estudante do conjunto de dados  
  - `CSVReader.java` - Classe utilitária para leitura e análise de dados CSV  
  - `PerformanceAnalyzer.java` - Analisa e reporta métricas de desempenho  
  - `App.java` - Classe principal para executar a análise  

- `data/` - Diretório de dados  
  - `dataset.csv` - Conjunto de dados contendo registros de estudantes  

## Funcionalidades

- **Implementação da Árvore AVL**: Uma árvore binária de busca balanceada com complexidade O(log n) para inserção, busca e remoção  
- **Análise de Desempenho**: Mede e reporta o tempo gasto em várias operações  
- **Processamento de Grandes Conjuntos de Dados**: Lida com um conjunto de mais de 11.000 registros de estudantes  

## Como Compilar e Executar

### Compilação

```
javac src/AVLNode.java src/AVLTree.java src/CSVReader.java src/PerformanceAnalyzer.java src/Student.java src/App.java
```

### Execução

```
java src.App
```

## Métricas de Desempenho

A aplicação mede e reporta as seguintes métricas de desempenho:

1. **Tempo de Inserção**: Tempo necessário para inserir todos os estudantes na árvore AVL  
2. **Tempo de Busca**: Tempo necessário para buscar um número específico de estudantes aleatórios  
3. **Tempo de Percurso**: Tempo necessário para realizar um percurso em ordem na árvore  
4. **Tempo de Remoção**: Tempo necessário para remover um número específico de estudantes da árvore  

## Saída de Exemplo

```
Iniciando Análise de Desempenho da Árvore AVL
=============================================
11000 estudantes carregados de data/dataset.csv
Estudante de exemplo: Student{studentId='S1000', age=23, examScore=56.2}

Executando análise de desempenho com:
- Total de estudantes: 11000
- Número de buscas: 5000
- Número de remoções: 1000

===== Análise de Desempenho da Árvore AVL =====

Medindo tempo de inserção para 11000 estudantes...
Tempo de inserção: 10 ms
Tamanho da árvore após inserção: 11000

Medindo tempo de busca para 5000 estudantes aleatórios...
Tempo de busca: 7 ms
Estudantes encontrados: 5000 de 5000

Medindo tempo de percurso em ordem...
Número de estudantes no percurso: 11000
Primeiros 5 estudantes em ordem crescente:
  1. Student{studentId='S1000', age=23, examScore=56.2}
  2. Student{studentId='S10000', age=23, examScore=76.8}
  3. Student{studentId='S10001', age=20, examScore=57.6}
  4. Student{studentId='S10002', age=24, examScore=36.1}
  5. Student{studentId='S10003', age=19, examScore=85.7}
Tempo de percurso: 2 ms

Medindo tempo de remoção para 1000 estudantes aleatórios...
Tempo de remoção: 3 ms
Estudantes removidos: 1000 de 1000
Tamanho da árvore após remoção: 10000

===== Resumo de Desempenho =====
Número total de estudantes: 11000
Tempo total de inserção: 10 ms (média: 0.000909 ms por estudante)
Tempo total de busca: 7 ms (média: 0.001400 ms por busca)
Tempo total de percurso: 2 ms
Tempo total de remoção: 3 ms (média: 0.003000 ms por remoção)
=============================

Análise de desempenho concluída com sucesso!
```
