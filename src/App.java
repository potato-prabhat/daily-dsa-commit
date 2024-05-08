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

    HashSet<Integer> visited = new HashSet<>();
    int osrc = src;
    hamiltonian(graph, src, visited, src + "", osrc);
  }

  public static void hamiltonian(
    ArrayList<Edge>[] graph,
    int src,
    HashSet<Integer> visited,
    String psf,
    int osrc
  ) {
    if (visited.size() == graph.length - 1) {
      System.out.print(psf);
      boolean closingEdgeFound = false;
      for (Edge e : graph[src]) {
        if (e.nbr == osrc) {
          closingEdgeFound = true;
          break;
        }
      }
      if (closingEdgeFound) {
        System.out.println("*");
      } else {
        System.out.println(".");
      }
      return;
    }
    visited.add(src);
    for (Edge e : graph[src]) {
      if (visited.contains(e.nbr) == false) {
        hamiltonian(graph, e.nbr, visited, psf + e.nbr, osrc);
      }
    }
    visited.remove(src);
  }
}
