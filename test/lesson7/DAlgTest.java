package lesson7;

import org.junit.Test;

import static org.junit.Assert.*;

public class DAlgTest {
    @Test
    public void checkPath(){
        Graph graph = new Graph(10);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(5, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);
        graph.addEdge(0, 9);

        int a = 0;

        DAlg dAlg = new DAlg(graph, a);
        int[] dist = dAlg.getD();
        System.out.println();
        for (int i = 0; i < graph.vertexCount(); i++){
            System.out.println("Кратчайший путь " + a + "-" + i + " = " + dist[i]);
        }


        System.out.println("BreadthFirstPaths");
        BreadthFirstPaths b = new BreadthFirstPaths(graph, a);
        for (int i = 0; i < graph.vertexCount(); i++) {
            System.out.println("Кратчайший путь " + b.distTo(i));
            // Проверим, что два способа работают одинаково
            assertEquals(b.distTo(i), dist[i]);
        }
    }

}