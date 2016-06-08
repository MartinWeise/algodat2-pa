package ad2.ss16.pa;

import java.util.*;

/**
 * Klasse zum Berechnen eines k-MST mittels Branch-and-Bound. Hier sollen Sie
 * Ihre L&ouml;sung implementieren.
 */
public class KMST extends AbstractKMST {

	private Edge[] edges;
	private Edge[] solution;
	private boolean[] taken;

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
		this.edges = edges.toArray(new Edge[0]);
		this.solution = new Edge[k-1];
		this.taken = new boolean[numNodes];
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

	}

	private class MinHeap {

		ArrayList<Integer> storage = new ArrayList<>();

		public void push(Integer v) {
			int pos = this.storage.size();
			this.storage.add(pos, v);
			this.heapifyUp(pos);
		}
		
		public Integer pull() {
			Integer ret = this.storage.remove(0);
			this.heapifyDown(0);
			return ret;
		}

		public int getPosition(int v) {
			return this.storage.indexOf(v);
		}

		public Integer getValue(int k) {
			return this.storage.get(k);
		}

		public Integer getLeftChild(int k) {
			return this.storage.get(2*k + 1);
		}

		public Integer getRightChild(int k) {
			return this.storage.get(2*k + 2);
		}

		public Integer getParent(int k) {
			return this.storage.get((int) Math.floor((k-1)/2));
		}

		private void heapifyUp(int i) {
			if (i > 1) {
				int j = (int) Math.floor(i / 2);
				if (this.storage.get(i) < this.storage.get(j)) {
					// swap
					Integer temp = this.storage.get(i);
					this.storage.set(i, this.storage.get(j));
					this.storage.set(j, temp);
					this.heapifyUp(j);
				}
			}
		}

		private void heapifyDown(int i) {
			int n = this.storage.size() - 1;
			int j;
			if (2*i > n) { // Leaf
				return;
			} else if (2*i < n) {
				int l = 2*i;
				int r = 2*i + 1;
				j = this.storage.indexOf(Math.min(this.storage.get(l),this.storage.get(r)));
			} else {
				j = 2*i;
			}
			if (this.storage.get(j) < this.storage.get(i)) {
				Integer temp = this.storage.get(i);
				this.storage.set(i, this.storage.get(j));
				this.storage.set(j, temp);
				this.heapifyDown(j);
			}
		}

		private boolean check(int root)	{
			int l = 2 * root + 1, r = 2 * root + 2;

			if (r < this.storage.size()) {
				if (this.storage.get(l) < this.storage.get(root) || this.storage.get(r) < this.storage.get(root)) {
					return false;
				}
				return check(l) && check(r);
			} else if (l < this.storage.size()) {
				if (this.storage.get(l) < this.storage.get(root)) {
					return false;
				}
				return check(l);
			} else {
				return true;
			}
		}

		public String toString() {
			return this.storage.toString();
		}

	}

}
