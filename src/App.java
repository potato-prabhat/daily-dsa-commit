import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

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

  static class Pair {

    int v;
    String psf;

    Pair(int v, String psf) {
      this.v = v;
      this.psf = psf;
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
    boolean[] visited = new boolean[vtces];
    boolean isGraphCyclic = false;
    for (int v = 0; v < vtces; v++) {
      if (visited[v] == false) {
        //traverse
        isGraphCyclic = isCyclic(graph, src, visited);
        if (isGraphCyclic) {
          System.out.println(isGraphCyclic);
          return;
        }
      }
    }
    System.out.println(isGraphCyclic);
  }

  public static boolean isCyclic(
    ArrayList<Edge>[] graph,
    int src,
    boolean[] visited
  ) {
    ArrayDeque<Pair> q = new ArrayDeque<>();
    q.add(new Pair(src, src + ""));
    while (q.size() > 0) {
      Pair rem = q.removeFirst();
      if (visited[rem.v]) {
        return true;
      }
      visited[rem.v] = true;
      for (Edge e : graph[rem.v]) {
        if (!visited[e.nbr]) {
          q.add(new Pair(e.nbr, rem.psf + e.nbr));
        }
      }
    }
    return false;
  }
}
