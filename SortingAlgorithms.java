class SortingAlgorithms {
   public static void main(String []args){
        int[] input = {100, 180, 30, 90, 50, 50, 20};
        
        System.out.println("\nEnter which algorithm to use? 1) QuickSort 2)Merge Sort")
        int choice = 2;

        switch (choice){
          
          case 1:
                System.out.print("Sorting using QuickSort..");
                QuickSort quicksort = new QuickSort();
                quicksort.sort(input,0,6);

                for(int i = 0; i < input.length;i++)
                  System.out.print(input[i]+" ,");
                break;
          case 2:
              System.out.print("\n\nSorting using MergeSort..");
              MergeSort mergesort = new MergeSort();
              mergesort.sort(input,0,6);

              for(int i = 0; i < input.length;i++)
                  System.out.print(input[i]+" ,");

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
    
}

class SelectionSort{
    
    
}

class BubbleSort{
    
}