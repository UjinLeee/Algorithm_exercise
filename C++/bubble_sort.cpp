//bubble sort practice
#include <stdio.h>

int main(void){

	int array[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

	/*
		1. for swapping : temp
	*/

	int temp;

	for(int i = 9; i>=0; i--){
		for(int j = 0; j<i; j++){
/*	for(int i = 0; i< 10; i++)
		for(int j = ; j<9-i;j++)
*/
			if(array[j]>=array[j+1]){
				temp=array[j];
				array[j]=array[j+1];
				array[j+1] = temp;				
			}
		}
	}

	for(int i = 0; i <10;i++){
	printf("%d\n", array[i]);

	}
	return 0;
}
