package project1;

public class SelectionViaPartition {
	public int[] selectionViaPartition(int[] array, int k) {

		int i = 0, j = array.length - 1;

		while (i < j) {
			int p = i, q = j;
			int pivot = array[(p + q) / 2];

			while (p < q) {
				if (array[p] >= pivot) { //if larger than or equal to pivot
					int temp = array[q];
					array[q] = array[p];
					array[p] = temp;
					q--;
				} else { //if smaller than the pivot
					p++;
				}
			}

			if (array[p] > pivot) {
				p--;
			}

			if (k <= p) {
				j = p;
			} else {
				i = p + 1;
			}
		}

		return array;
	}
}
