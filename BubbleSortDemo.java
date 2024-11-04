package program;
public class BubbleSortDemo {
    public static void display(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println(); 
    }

    public static void selectionSort(int a[]) {
      
        for (int i = 0; i < a.length - 1; i++) { 
            int min = i; 
            for (int j = i + 1; j < a.length; j++) { 
                if (a[j] < a[min]) {
                    min = j; 
                }
            }
          
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }

    public static void bubbleSort(int a[]) { 
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                   
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {10, 7, 21, 4, 65};

       System.out.print("Original array: ");
        display(a);
        
      selectionSort(a);
        System.out.print("Sorted array (Selection Sort): ");
        display(a);

    
         int b[] = {10, 7, 21, 4, 65}; 
       bubbleSort(b);
      System.out.print("Sorted array (Bubble Sort): ");
        display(b);
    }
}
    

