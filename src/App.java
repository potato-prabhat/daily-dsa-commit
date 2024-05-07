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
    int[] v1 = { 0, 1, 2, 0, 3, 4, 5, 4 };
    int[] v2 = { 1, 2, 3, 3, 4, 5, 6, 6 };
    int[] wt = { 10, 10, 10, 40, 2, 3, 3, 8 };
    ArrayList<Edge>[] graph = new ArrayList[vtces];
    for (int i = 0; i < vtces; i++) {
      graph[i] = new ArrayList<>();
    }
    int edges = 8;
    for (int i = 0; i < edges; i++) {
      graph[v1[i]].add(new Edge(v1[i], v2[i], wt[i]));
      graph[v2[i]].add(new Edge(v2[i], v1[i], wt[i]));
    }
    int criteriaWt = 40;
    int kthLargestPath = 3;
    int src = 0;
    int dest = 6;
    boolean[] visited = new boolean[vtces];
    multiSolver(
      graph,
      src,
      dest,
      visited,
      criteriaWt,
      kthLargestPath,
      src + "",
      0
    );
    System.out.println(spath + " " + spathwt);
    System.out.println(lpath + " " + lpathwt);
    System.out.println(cpath + " " + criteriaWt);
    System.out.println(fpath + " " + fpathwt);
    System.out.println(pq.peek().psf + " " + pq.peek().wsf);
  }

  static class Pair implements Comparable<Pair> {

    int wsf;
    String psf;

    Pair(int wsf, String psf) {
      this.psf = psf;
      this.wsf = wsf;
    }

    public int compareTo(Pair o) {
      return this.wsf - o.wsf;
    }
  }

  static String spath;
  static Integer spathwt = Integer.MAX_VALUE;

  static String lpath;
  static Integer lpathwt = Integer.MIN_VALUE;

  static String cpath;
  static Integer cpathwt = Integer.MAX_VALUE;

  static String fpath;
  static Integer fpathwt = Integer.MIN_VALUE;
  static PriorityQueue<Pair> pq = new PriorityQueue<>();

  public static void multiSolver(
    ArrayList<Edge>[] graph,
    int src,
    int dest,
    boolean[] visited,
    int criteriaWt,
    int kthLargestPath,
    String psf,
    int wsf
  ) {
    if (src == dest) {
      if (wsf < spathwt) {
        spathwt = wsf;
        spath = psf;
      }
      if (wsf > lpathwt) {
        lpathwt = wsf;
        lpath = psf;
      }
      if (wsf > criteriaWt && wsf < cpathwt) {
        cpathwt = wsf;
        cpath = psf;
      }
      if (wsf < criteriaWt && wsf > fpathwt) {
        fpathwt = wsf;
        fpath = psf;
      }
      if (pq.size() < kthLargestPath) {
        pq.add(new Pair(wsf, psf));
      } else {
        if (wsf > pq.peek().wsf) {
          pq.remove();
          pq.add(new Pair(wsf, psf));
        }
      }
      return;
    }
    visited[src] = true;
    for (Edge e : graph[src]) {
      if (visited[e.nbr] == false) {
        multiSolver(
          graph,
          e.nbr,
          dest,
          visited,
          criteriaWt,
          kthLargestPath,
          psf + e.nbr,
          wsf + e.wt
        );
      }
    }
    visited[src] = false;
  }
}
