package project1;

public class MergeSort {
	
	public int[] mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);            
        }
        
		return array;
    }
	
	/*algorithm from page 31-34 CLRS*/
	private void merge(int[] array, int left, int middle, int right) {

		int leftSize = middle - left + 1;
		int rightSize = right - middle;
		int leftArr[] = new int [leftSize];
		int rightArr[] = new int [rightSize];

		for (int i = 0; i < leftSize; ++i) {
			leftArr[i] = array[left + i];
		}
		
		for (int j = 0; j < rightSize; ++j) {
			rightArr[j] = array[middle + 1 + j];
		}

		int i = 0, j = 0, k = left;

		while (i < leftSize && j < rightSize) {
			if (leftArr[i] <= rightArr[j]) {
				array[k] = leftArr[i];
				i++;
			} else {
				array[k] = rightArr[j];
				j++;
			}
			k++;
		}

		while (i < leftSize) {
			array[k] = leftArr[i];
			i++;
			k++;
		}

		while (j < rightSize) {
			array[k] = rightArr[j];
			j++;
			k++;
		}		
	}
}
