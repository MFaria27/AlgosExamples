import edu.princeton.cs.algs4.StdOut;

public class Nov8 {
	private Comparable aux[];
	public Nov8() {

	}

	public void mergeSort1(Comparable[] a) {
		aux = new Comparable[a.length];
		mergeSort(a, 0, a.length-1);
	}

	public void mergeSort2(Comparable[] a) {
		int N = a.length;
		aux = new Comparable[N];
		for (int sz = 1; sz < N; sz = sz+sz) {
			for (int low = 0; low < N-sz; low += sz+sz) {
				merge(a, low, low+sz-1, Math.min(low+sz+sz-1, N-1));
			}
		}
	}

	private void mergeSort(Comparable[] a, int low, int high) {
		if(high <= low) return;
		int mid = low + (high - low)/2;
		mergeSort(a, low, mid);
		mergeSort(a, mid+1, high);
		merge(a, low, mid, high);
	}

	private void merge(Comparable[] a, int low, int mid, int high) {
		int i = low, j = mid+1;
		for (int k = low; k <= high; k++) {
			aux[k] = a[k];
		}
		for (int k = low; k <= high; k++) {
			if (i > mid) a[k] = aux[j++];
			else if (j > high) a[k] = aux[i++];
			else if (less(aux[j], aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void show(Comparable[] a) {
		for (Comparable element : a)
			StdOut.print(element + " ");
		StdOut.println();
	}

	private static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i-1])) return false;
		}
		return true;
	}
}
