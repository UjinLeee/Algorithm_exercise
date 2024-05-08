//insertion sort practice

#include <stdio.h>

int main(void){

	int array[10] = {1, 10, 5, 8, 7, 6, 4, 3,2, 9};

	int i, j, k, temp;

	for(i=1; i<10; i++){
		
		k = i;
		temp = array[i];

		for(j = 0; j < i; j++){
			if(array[j] <= temp)
				k = j+1;			
		}	

		for(j = i-1; j>=k; j--)
			array[j+1] = array[j];

		array[k] = temp;
	}

	for(i = 0; i<10; i++){
		printf("%d\n", array[i]);
	}

	return 0;
}
