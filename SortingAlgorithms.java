class SortingAlgorithms {
   public static void main(String []args){
        int[] input = {100, 180, 30, 90, 50, 50, 20};
        
        QuickSort quicksort = new QuickSort();
        quicksort.sort(input,0,6);
       for(int i = 0; i < input.length;i++)
            System.out.print(input[i]+" ,");
       
     }
}

class QuickSort{
    
    public void sort(int arr[],int low,int high){

       int mid=parition(arr,low,high);
       if(low < mid-1)
          sort(arr,low,mid-1);

       if(high > mid)
          sort(arr,mid+1,high);
    }
    
    int parition(int input[], int low, int high){
        
         int length = high-low; 
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

class MergeSort{
    
    
}

class InsertionSort{
    
}

class SelectionSort{
    
    
}

class BubbleSort{
    
}