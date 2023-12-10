package com.heap;

public class Heap {

    int arr[];
    int maxSize;
    int heapSize;

    Heap(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize + 1]; // Index 0 is not used, so size is maxSize + 1
        heapSize = 0;
       // arr[0] = -1; // Setting a sentinel value for the root
    }

    void insert(int value) {
        // value insert karo end me
        heapSize = heapSize + 1;
        int index = heapSize;
        arr[index] = value;
        // iss value ko sahi position pr set karo
        while (index > 1) {
            int parentIndex = index / 2;
            if (arr[index] > arr[parentIndex]) {
                int temp = arr[index];
                arr[index] = arr[parentIndex];
                arr[parentIndex] = temp;
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    int delete() {
        // replace root node with last node
        int ans = arr[1];

        arr[1] = arr[maxSize];
        maxSize--;

        // place root node data in the correct position
        int index = 1;
        while (index < maxSize) {
            int left = 2 * index;
            int right = 2 * index + 1;
            int largest = index;
            if (left <= maxSize && arr[largest] < arr[left]) {
                largest = left;
            }
            if (right <= maxSize && arr[largest] < arr[right]) {
                largest = right;
            }
            if (largest == index) {
                // value is at the correct position
                return ans;
            } else {
                int temp = arr[index];
                arr[index] = arr[largest];
                arr[largest] = temp;
                index = largest;
            }
        }

        return ans;
    }

    void heapify(int arr[], int n, int i){
        int index=i;
        int larget=index;
        int leftIndex=2*i;
        int rightIndex =2*i+1;
        if(leftIndex<=n && arr[larget]<arr[leftIndex]){
            larget=leftIndex;
        }
        if(rightIndex<=n && arr[larget]<arr[rightIndex]){
            larget=rightIndex;
        }
        if(index!=larget){
            //left ya right me se koi> current node se
            int temp=arr[index];
            arr[index]=arr[larget];
            arr[larget]=temp;
            index=larget;
            heapify(arr,n,index);
        }
    }

    void buildHeap(int arr[], int n){
        for(int i=n/2;i>0;i--){
            heapify(arr,n,i);
        }
    }

    void sort(int arr[], int n){
        while(n>1){
             int temp = arr[1];
             arr[1]=arr[n];
             arr[n]=temp;
             n--;
             heapify(arr,n,1);
        }
    }


    public static void main(String[] args) {
        Heap heap = new Heap(6);

      //  int[] elementsToAdd = {100, 50, 60, 40, 45, 110};
        int[] elementsToAdd={-1,12,15,13,11,14};
        int n=5;
        heap.buildHeap(elementsToAdd,n);
        for(int i=0;i<=n;i++){
            System.out.print(elementsToAdd[i]+" ");
        }

        System.out.println("Inserting elements into the heap:");
        /*for (int element : elementsToAdd) {
            heap.insert(element);
        }*/
        for (int i=1;i< heap.maxSize;i++){
            heap.insert(elementsToAdd[i]);
        }
        heap.sort(elementsToAdd,n);
        System.out.println("heap sorted");
        for (int i = 1; i <= n; i++) {
            System.out.print(elementsToAdd[i] + " ");
        }

    }
}

/*
public class Heap {

    int arr[];
    int maxSize;
    int heapSize;

    Heap(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        heapSize = 0;
        arr[0] = -1; // Setting a sentinel value for the root
    }

    void insert(int value) {
        // value insert karo end me
        heapSize = heapSize + 1;
        int index = heapSize;
        arr[index] = value;
        // iss value ko sahi position pr set karo
        while (index > 1) {
            int parentIndex = index / 2;
            if (arr[index] > arr[parentIndex]) {
                int temp = arr[index];
                arr[index] = arr[parentIndex];
                arr[parentIndex] = temp;
                index = parentIndex;
            } else {
                break;
            }
        }
    }
    */
/*   int  delete(){
            //replace root node with last node
           int ans =arr[1];

           arr[1]=arr[maxSize];
           maxSize--;

           //place root node data correct position
           int index=1;
           while (index<maxSize){
               int left =2*index;
               int right =2*index+1;
              int largest=index;
              if(left<maxSize && arr[largest]<arr[left]){
                  largest=left;
              }
              if(right<maxSize &&arr[largest]<arr[right]){
                 largest=right;
              }
              if(largest==index){
                  //value is act correct position
                  return ans;
              }else {
                  int temp =arr[index];
                  arr[index]=arr[largest];
                  arr[largest]=temp;
                  index=largest;
              }
           }

         return ans;
       }*//*

    int delete() {
        // replace root node with last node
        int ans = arr[1];

        arr[1] = arr[maxSize];
        maxSize--;

        // place root node data in the correct position
        int index = 1;
        while (index < maxSize) {
            int left = 2 * index;
            int right = 2 * index + 1;
            int largest = index;
            if (left <= maxSize && arr[largest] < arr[left]) {
                largest = left;
            }
            if (right <= maxSize && arr[largest] < arr[right]) {
                largest = right;
            }
            if (largest == index) {
                // value is at the correct position
                return ans;
            } else {
                int temp = arr[index];
                arr[index] = arr[largest];
                arr[largest] = temp;
                index = largest;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
       */
/* Heap heap = new Heap(8);

        heap.arr[0]=-1;
        heap.arr[1]=100;
        heap.arr[2]=50;
        heap.arr[3]=60;
        heap.arr[4]=40;
        heap.arr[5]=45;

        System.out.println("Inserting elements into the heap:");
        for (int i=0;i<8;i++){
            System.out.print(heap.arr[i]+" ");
        }

        heap.insert(110);
        System.out.println("\nPrinting the max-heap:");
        for (int i = 0; i <8; i++) {
            System.out.print(heap.arr[i] + " ");
        }
    }*//*

        Heap heap = new Heap(8);

        int[] elementsToAdd = {100, 50, 60, 40, 45, 110};

        System.out.println("Inserting elements into the heap:");
        for (int element : elementsToAdd) {
            heap.insert(element);
        }
        heap.insert(200);
        System.out.println("Printing the max-heap:");
        for (int i = 0; i <= heap.heapSize; i++) {
            System.out.print(heap.arr[i] + " ");
        }
        int delete = heap.delete();
        System.out.println(delete);
        System.out.println("Printing the max-heap:");
        for (int i = 0; i <= heap.heapSize; i++) {
            System.out.print(heap.arr[i] + " ");
        }
    }

}*/
