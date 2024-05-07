import java.util.ArrayList;
import java.util.PriorityQueue;

public class App {

  static class Edge {

    int src;
    int nbr;
    int wt;

    Edge(int src, int nbr, int wt) {
      this.src = src;
      this.nbr = nbr;
      this.wt = wt;
    }
  }

  public static void main(String[] args) {
    int vtces = 7;
    int[] v1 = { 0, 2, 4, 5, 4 };
    int[] v2 = { 1, 3, 5, 6, 6 };
    int[] wt = { 10, 10, 10, 10, 10 };
    ArrayList<Edge>[] graph = new ArrayList[vtces];
    for (int i = 0; i < vtces; i++) {
      graph[i] = new ArrayList<>();
    }
    int edges = 5;
    for (int i = 0; i < edges; i++) {
      graph[v1[i]].add(new Edge(v1[i], v2[i], wt[i]));
      graph[v2[i]].add(new Edge(v2[i], v1[i], wt[i]));
    }
    ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
    boolean[] visited = new boolean[vtces];
    for (int v = 0; v < vtces; v++) {
      if (visited[v] == false) {
        ArrayList<Integer> comp = new ArrayList<>();
        drawTreeAndGenerateComp(graph, v, comp, visited);
        comps.add(comp);
      }
    }
    System.out.println(comps);
  }

  public static void drawTreeAndGenerateComp(
    ArrayList<Edge>[] graph,
    int src,
    ArrayList<Integer> comp,
    boolean[] visited
  ) {
    visited[src] = true;
    comp.add(src);
    for (Edge e : graph[src]) {
      if (visited[e.nbr] == false) {
        drawTreeAndGenerateComp(graph, e.nbr, comp, visited);
      }
    }
  }
}
