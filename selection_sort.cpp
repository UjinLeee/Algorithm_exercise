#include <stdio.h>

//Selection_sort exercise_1

int main(void){

	int array[10] = {1, 2, 3, 8, 7, 6, 4, 5, 10, 9};
	 
	int min, temp, first, k;
	for(int i = 0; i < 10; i++){
		first = array[i];
		min = first;
		
		for(int j = i; j<10; j++){
			if(min>=array[j]){/*In this code, I should use '>=' instead of '>', because, in '>' case, k cannot be declared.*/
				min=array[j];
				k=j;
			}
		}
		
		temp = array[i];
		array[i] = array[k];
		array[k] = temp;
	}

	for(int i=0; i < 10; i++){

		printf("%d\n", array[i]);
	}

	return 0;

}
