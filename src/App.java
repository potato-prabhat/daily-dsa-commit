import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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

  public static class Pair implements Comparable<Pair> {

    int v;
    int av;
    int w;

    Pair(int v, int av, int w) {
      this.v = v;
      this.av = av;
      this.w = w;
    }

    public int compareTo(Pair o) {
      return this.w - o.w;
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

    boolean[] visited = new boolean[vtces];
    int src = 0;
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.add(new Pair(src, -1, 0));

    while (pq.size() > 0) {
      Pair rem = pq.remove();
      if (visited[rem.v] == true) {
        continue;
      }
      visited[rem.v] = true;
      if (rem.av != -1) {
        System.out.println(rem.v + " via " + rem.av + "@" + rem.w);
      }

      for (Edge e : graph[rem.v]) {
        if (visited[e.nbr] == false) {
          pq.add(new Pair(e.nbr, rem.v, e.wt));
        }
      }
    }
  }
}
