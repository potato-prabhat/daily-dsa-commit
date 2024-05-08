import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
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
    int level;

    Pair(int v, String psf, int level) {
      this.v = v;
      this.psf = psf;
      this.level = level;
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
    int[] visited = new int[vtces];
    Arrays.fill(visited, -1);

    for (int v = 0; v < vtces; v++) {
      //traverse
      if (visited[v] == -1) {
        boolean isCompBipartite = checkComponentBipartite(graph, v, visited);
        if (!isCompBipartite) {
          System.out.println(false);
          return;
        }
      }
    }
    System.out.println(true);
  }

  public static boolean checkComponentBipartite(
    ArrayList<Edge>[] graph,
    int src,
    int[] visited
  ) {
    ArrayDeque<Pair> q = new ArrayDeque<>();
    q.add(new Pair(src, src + "", 0));
    while (q.size() > 0) {
      Pair rem = q.removeFirst();

      if (visited[rem.v] != -1) {
        //some work
        if (rem.level != visited[rem.level]) {
          return false;
        }
      } else {
        visited[rem.v] = rem.level;
      }

      for (Edge e : graph[rem.v]) {
        if (visited[e.nbr] == -1) {
          q.add(new Pair(e.nbr, rem.psf + e.nbr, rem.level + 1));
        }
      }
    }
    return true;
  }
}
