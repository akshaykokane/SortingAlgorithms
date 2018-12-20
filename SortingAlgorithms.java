import java.util.Scanner;
class SortingAlgorithms {
   public static void main(String []args){
        int[] input = {100, 180, 30, 40, 50, 80, 20};
        
        System.out.println("\nEnter which algorithm to use? 1) QuickSort 2) Merge Sort 3) Bubble Sort 4) Insertion Sort 5) Selection Sort");
       Scanner s= new Scanner(System.in);
       int choice = s.nextInt();

        switch (choice){
          
          case 1:
                System.out.print("Sorting using QuickSort..\n");
                QuickSort quicksort = new QuickSort();
                quicksort.sort(input,0,6);

                for(int i = 0; i < input.length;i++)
                    System.out.print(input[i]+" ,");
                break;
        

        case 2: 
              System.out.print("\n\nSorting using MergeSort..\n");
              MergeSort mergesort = new MergeSort();
              mergesort.sort(input,0,6);

              for(int i = 0; i < input.length;i++)
                  System.out.print(input[i]+" ,");
              
              break;

         case 3: 
              System.out.print("\n\nSorting using BubbleSort..\n");
              BubbleSort bubbleSort = new BubbleSort();
              bubbleSort.sort(input);

              for(int i = 0; i < input.length;i++)
                  System.out.print(input[i]+" ,");
              
              break;

        case 4: 
              System.out.print("\n\nSorting using InsertionSort..\n");
              InsertionSort insertionSort = new InsertionSort();
              insertionSort.sort(input);

              for(int i = 0; i < input.length;i++)
                  System.out.print(input[i]+" ,");
              
              break;
        case 5: 
              System.out.print("\n\nSorting using Selection Sort..\n");
              SelectionSort selectionSort = new SelectionSort();
              selectionSort.sort(input);

              for(int i = 0; i < input.length;i++)
                  System.out.print(input[i]+" ,");
              
              break;
        }
        
       
     }
}
/***
Quick Sort function, partion the input according to pivot element. I have choosen middle element as pivot, so to get O(nlogn)
***/
class QuickSort{
    
    public void sort(int arr[],int low,int high){

       int mid=parition(arr,low,high);
       if(low < mid-1)
          sort(arr,low,mid-1);

       if(high > mid)
          sort(arr,mid+1,high);
    }
    
    int parition(int input[], int low, int high){
        
         int leftPtr = low;
         int rightPtr = high;
         int pivot =  input[(low+high) / 2];
       
         while(leftPtr < rightPtr){

            while(input[leftPtr] <= pivot && leftPtr < rightPtr){
                  leftPtr++;
              }
                
            while(input[rightPtr] > pivot){
                  rightPtr--;
              }
                
            if(leftPtr <= rightPtr)
                  swap(input,leftPtr,rightPtr);
           
        
            }
            swap(input,rightPtr,((low+high) / 2));
            return rightPtr;
        
    }
    public void swap(int input[], int leftPtr, int rightPtr){
        
        int temp=input[leftPtr];
        input[leftPtr] = input[rightPtr];
        input[rightPtr] = temp;
        
    }
    
    
}
/***
Merge  Sort function, partion the input according till only one element. And then merge the partioned input one by one
***/
class MergeSort{

  public void sort(int input[], int low, int high){

    if(low < high){

      int mid = (low + high) / 2;

      sort(input, low, mid);
      sort(input,mid+1, high);
      
      Merge(input, low, high, mid);

    }
    
  }

  public void Merge(int input[], int low, int high, int mid){

    int lengthAuxArray1 = (mid - low)+1;
    int lengthAuxArray2 = high - mid;
    
    int[] auxArray1 = new int[lengthAuxArray1];
    int[] auxArray2 = new int[lengthAuxArray2];

    //Copy the input elements into auxilary arrays
   
    for(int i = 0;  i < lengthAuxArray1 ; i++ )  
        auxArray1[i] = input[i+low];

  
    for(int i = 0; i < lengthAuxArray2 ; i++ )  
        auxArray2[i] = input[i+mid+1];

    int i = 0;int j = 0;

    //compare elements and rewrite in input array
    while(i < lengthAuxArray1 && j < lengthAuxArray2){

      if(auxArray1[i] <= auxArray2[j])
        input[low++] = auxArray1[i++];
      else      
        input[low++] = auxArray2[j++];
    

    }

    //copy remaning elements of auxArray1 into input
    while(i < lengthAuxArray1)
      input[low++] = auxArray1[i++];

    //copy remaning elements of auxArray2 into input
    while(j < lengthAuxArray2-1)
      input[low++] = auxArray2[j++];

  }
    
    
}

class InsertionSort{

  public void sort(int input[]){

    for(int i = 1; i < input.length; i++){

        int key = input[i];
        int j = i-1;

        while(j >= 0 && input[j] > key){
            input[j+1] = input[j];
            j--;

        }
        input[j+1] = key;

    }

  }
    
}

class SelectionSort{

  public void sort(int input[]){
    int length = input.length;

    for(int i = 0; i < length-1 ; i++){
      
      int min_index = i;
      for(int j = i+1; j < length; j++)
        if(input[j] < input[min_index])
            min_index = j;
      
      swap(input, i, min_index);
      

    }
  }

  public void swap(int input[], int leftPtr, int rightPtr){
        
        int temp=input[leftPtr];
        input[leftPtr] = input[rightPtr];
        input[rightPtr] = temp;
        
    }

}

class BubbleSort{


  public void sort(int input[]){
      int n = input.length;
      boolean swapped = false;
      for(int i = 0; i < n ; i++){
          swapped = false;
          for(int j = 0; j < (n - i-1); j++){
              if(input[j] > input[j+1]){
                  swap(input,j,j+1);
                  swapped = true;
              }
            }
          if(swapped == false)
            break;

      }



  }
  public void swap(int input[], int leftPtr, int rightPtr){
        
        int temp=input[leftPtr];
        input[leftPtr] = input[rightPtr];
        input[rightPtr] = temp;
        
  }
    
}