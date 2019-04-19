package lesson7;

import java.util.HashSet;
import java.util.LinkedList;

public class DAlg {

    private int d[]; // стоимость пути до вершины от вершины a
    private LinkedList<Integer>[] p;
    private HashSet<Integer> U = new HashSet<>();
    Graph graph;

    public int[] getD() {
        return d;
    }

    public DAlg(Graph graph, int a) {
        this.graph = graph;
        d = new int[graph.vertexCount()];

        p = new LinkedList[graph.vertexCount()];
        for (int i = 0; i < graph.vertexCount(); i++) {
            p[i] = new LinkedList<>();
        }

        d[a] = 0;
        for (int i = 0; i < d.length; i++) {
            if (a != i) d[i] = Integer.MAX_VALUE;
        }

        // Задаем первоначальную вершину
        // Если ни одна цена не была изменена, прекращаем цикл, иначе продолжаем
        int v = a;
        while (true) {
            U.clear();
            if (!search(v)) break;
        }
    }

    // Оценка пути к вершинам

    private boolean search(int v) {

        boolean result = false;
        while (true) {
            if (!(U.contains(v))) {
                U.add(v);

                // Берем связанный список для V и переоцениваем стоимость
                LinkedList<Integer> list = graph.adjList(v);
                for (Integer u : list) {
                    if (d[u] > d[v] + 1) {
                        d[u] = d[v] + 1;
                        p[u].add(v);
                        result = true;
                    }
                }

                v = minD(graph.adjList(v));
                if (v == Integer.MAX_VALUE) v = getFirstNotVisited();
            }

            if (U.size() == graph.vertexCount() || v == Integer.MIN_VALUE) break;

        }
        return result;

    }

    // Находит вершину с минимальной стоимостью из переданного списка связности

    private int minD(LinkedList<Integer> adjList) {
        int min = Integer.MAX_VALUE; // берем стоимость пути до первой вершины
        int minIndex = Integer.MAX_VALUE;
        // Находим первоначальный минимум с неотмеченной вершиной
        for (Integer l : adjList) {
            if (!(U.contains(l)) && d[l] < min) {
                min = d[l]; // берем стоимость пути до первой вершины
                minIndex = l;
            }
        }
        return minIndex;
    }

    // Если вершина не найдена в списке связности, возьмем первую не отработанную

    private int getFirstNotVisited() {
        for (int i = 0; i < d.length; i++) {
            if (!(U.contains(i))) return i;
        }
        return Integer.MIN_VALUE;
    }


}
