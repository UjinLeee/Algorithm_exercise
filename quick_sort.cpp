//quick sort exercise
#include <iostream>
#include <stdio.h>
using namespace std;

int quick_sort(int* array, int m, int n){

	if(n <= m)
		return 0;


	int pivot = array[m];
	int  i, j, temp;


	for(i = m+1; i <=n; i++){
		if(array[i]>pivot)
		break;
	}
	for(j = n; j >=m+1; j--){
		if(array[j] < pivot)
			break;
	}
	
	if(i<j){
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		quick_sort(array, m, n);
	}else{
		temp=pivot;
		array[m] = array[j];
		array[j] = temp;
		quick_sort(array, m, j-1);
		quick_sort(array, j+1, n);
	}
}

int main(void){

	int array[10] = {3, 7, 8, 1, 5, 9, 6, 10, 2, 4};

	quick_sort(array, 0, 9);
	
	for(int i = 0; i<10; i++){
		printf("%d\n", array[i]);
	}

	return 0;
}
