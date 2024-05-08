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
    int time;

    Pair(int v, int time) {
      this.v = v;
      this.time = time;
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
    int src = 5;
    int t = 3;
    int[] visited = new int[vtces];

    ArrayDeque<Pair> q = new ArrayDeque<>();
    q.add(new Pair(src, 1));
    int count = 0;

    while (q.size() > 0) {
      Pair rem = q.removeFirst();
      if (visited[rem.v] > 0) {
        continue;
      }
      visited[rem.v] = rem.time;
      if (rem.time > t) break;
      count++;
      for (Edge e : graph[rem.v]) {
        if (visited[e.nbr] == 0) {
          q.add(new Pair(e.nbr, rem.time + 1));
        }
      }
    }
    System.out.println(count);
  }
}
