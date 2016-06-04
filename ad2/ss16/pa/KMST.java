package ad2.ss16.pa;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Klasse zum Berechnen eines k-MST mittels Branch-and-Bound. Hier sollen Sie
 * Ihre L&ouml;sung implementieren.
 */
public class KMST extends AbstractKMST {

	private Integer numNodes;
	private Integer numEdges;
	private HashSet<Edge> edges;
	private int k;

	private HashSet<Integer> nodes;
	private ArrayList<PriorityQueue<Integer>> G;

	/**
	 * Der Konstruktor. Hier ist die richtige Stelle f&uuml;r die
	 * Initialisierung Ihrer Datenstrukturen.
	 * 
	 * @param numNodes
	 *            Die Anzahl der Knoten
	 * @param numEdges
	 *            Die Anzahl der Kanten
	 * @param edges
	 *            Die Menge der Kanten
	 * @param k
	 *            Die Anzahl der Knoten, die Ihr MST haben soll
	 */
	public KMST(Integer numNodes, Integer numEdges, HashSet<Edge> edges, int k) {
		this.numEdges = numEdges;
		this.numNodes = numNodes;
		this.edges = edges;
		this.k = k;

		// Knotenliste
		this.nodes = new HashSet<>(this.numNodes);
		for (int i = 0; i < this.numNodes; i++) {
			this.nodes.add(i);
		}

		// Adjaszenzliste
		G = new ArrayList<>();
		for (Integer n : this.nodes) {
			this.G.add(n, new PriorityQueue<>());
		}
		for (Edge e : this.edges) {
			this.G.get(e.node1).add(e.node2);
			this.G.get(e.node2).add(e.node1);
		}



	}

	/**
	 * Diese Methode bekommt vom Framework maximal 30 Sekunden Zeit zur
	 * Verf&uuml;gung gestellt um einen g&uuml;ltigen k-MST zu finden.
	 * 
	 * <p>
	 * F&uuml;gen Sie hier Ihre Implementierung des Branch-and-Bound Algorithmus
	 * ein.
	 * </p>
	 */
	@Override
	public void run() {
//		int s = 0;
//		for (Integer node : this.getComponentNodes(s)) {
//			this.prim(node);
//		}
	}

	/**
	 * Liefert bei &uuml;bergebenen Knoten alle erreichbaren Knoten im Graphen zur&uuml;ck.
	 * @param node: Knoten
	 * @return Liste der erreichbaren Knoten
     */
	private ArrayList<Integer> getComponentNodes(int node) {
		boolean[] visited = new boolean[this.numNodes];

		// erreichbare Knoten markieren
		getComponentNodesR(node, visited);

		// in Liste packen
		ArrayList<Integer> ret = new ArrayList<>();
		for (int i = 0; i < this.nodes.size(); i++) {
			if (visited[i]) {
				ret.add(i);
			}
		}
		return ret;
	}

	private void getComponentNodesR(int node, boolean[] visited) {
		visited[node] = true;
		for (Integer u : this.G.get(node)) {
			if (!visited[u]) {
				getComponentNodesR(u, visited);
			}
		}
	}




}
