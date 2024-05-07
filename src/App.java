import java.util.ArrayList;

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
    int[] v1 = { 0, 1, 2, 0, 3, 4, 5, 4 };
    int[] v2 = { 1, 2, 3, 3, 4, 5, 6, 6 };
    int[] wt = { 10, 10, 10, 10, 10, 10, 10, 10 };
    ArrayList<Edge>[] graph = new ArrayList[vtces];
    for (int i = 0; i < vtces; i++) {
      graph[i] = new ArrayList<>();
    }
    int edges = 8;
    for (int i = 0; i < edges; i++) {
      graph[v1[i]].add(new Edge(v1[i], v2[i], wt[i]));
      graph[v2[i]].add(new Edge(v2[i], v1[i], wt[i]));
    }

    int src = 0;
    int dest = 6;
    boolean[] visited = new boolean[vtces];
    printAllPaths(graph, src, dest, visited, src + "");
  }

  public static void printAllPaths(
    ArrayList<Edge>[] graph,
    int src,
    int dest,
    boolean[] visited,
    String psf
  ) {
    if (src == dest) {
      System.out.println(psf);
      return;
    }
    visited[src] = true;
    for (Edge edge : graph[src]) {
      if (visited[edge.nbr] == false) {
        printAllPaths(graph, edge.nbr, dest, visited, psf + edge.nbr);
      }
    }
    visited[src] = false;
  }
}
