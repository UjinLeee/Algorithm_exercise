#include <stdio.h>

int main(void){ // Typical answer

	int i, j, min, index, temp;
	/* i&j : for searching elements in array.
	   min : the smallest value
	   index: the index which the smallest value exists
	   temp : for swapping
	*/

	int array[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
	for(i = 0; i< 10; i++){
		min = 9999; //A number which larger than all elements
		for(j = i; j < 10; j++){
			if(min>array[j]){ //In here, min is 9999, so '>' could be possible.
				min = array[j];
				index=j;
			}
		}
		temp = array[i];
		array[i] = array[index];
		array[index] = temp; //swapping
	}

	for(i = 0; i < 10; i++){
		printf("%d", array[i]);	
	}
	return 0;
}
