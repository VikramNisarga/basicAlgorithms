package org.Algos.basicAlgorithms.sorting;

public class MergeSort {
	int[] inputArray;


	public int[] sort(int[] inputArray) {
		int startIndex = 0;
		int endIndex = inputArray.length - 1;
		this.inputArray = inputArray;
		return sortAndCount(startIndex, endIndex);

	}

	public int[] sortAndCount(int startIndex, int endIndex) {
		if ((endIndex - startIndex) < 1) {
			return new int[] { inputArray[startIndex] };
		} else {
			int leftHalfStartIndex = startIndex;
			int leftHalfEndIndex = (startIndex + endIndex) / 2;

			int rightHalfStartIndex = leftHalfEndIndex + 1;
			int rightHalfEndIndex = endIndex;

			return mergeAndCountSplit(sortAndCount(leftHalfStartIndex,
					leftHalfEndIndex), sortAndCount(rightHalfStartIndex,
					rightHalfEndIndex));

		}

	}

	public int[] mergeAndCountSplit(int[] leftHalf, int[] rightHalf) {
		int leftLength = leftHalf.length;
		int rightLength = rightHalf.length;

		// length of sorted array is sum of both the arrays
		int[] sortedArray = new int[leftLength + rightLength];

		int leftCursor = 0, rightCursor = 0;

		for (int i = 0; i < leftLength + rightLength; i++) {
			if (leftHalf[leftCursor] > rightHalf[rightCursor]) {
				sortedArray[i] = rightHalf[rightCursor];
				rightCursor++;


				/*
				 * if right_array is exhausted, append all the remaining
				 * elements from left array to the sorted_array
				 */
				if (rightCursor >= rightLength) {
					for (int l = leftCursor; l < leftLength; l++) {
						// Increment the index of the sorted_array before
						// appending
						i++;
						sortedArray[i] = leftHalf[l];
					}
					break;
				}

			} else {
				sortedArray[i] = leftHalf[leftCursor];
				leftCursor++;
				/*
				 * if left_array is exhausted, append all the remaining elements
				 * from right array to the sorted_array
				 */
				if (leftCursor >= leftLength) {
					for (int l = rightCursor; l < rightLength; l++) {
						// increment the index of the sorted_array before
						// appending
						i++;
						sortedArray[i] = rightHalf[l];
					}
					break;
				}
			}

		}
		return sortedArray;
	}
}
