public class array {
    public static void main(String[] args){
//        int[] arr = {5, 2, 8, 1, 3};
//        for(int i = 0; i<= arr.length - 1; i++){
//            System.out.println("Element at index " + i + ": " + arr[i]);
//        }
//        String[] names = {"Alice", "Bob", "Charlie"};
//        for(int i = 0; i < names.length; i++) {
//            System.out.println("Name at index " + i + ": " + names[i]);
//        }
        int[] numbers = {34, 12, 5, 67, 23};
//        for(int i = 0; i < numbers.length; i++){
//            System.out.println("Element at index " + i + ": " + numbers[i]);
//        }
//        System.out.println("Reversed Array:");
//        for(int i = numbers.length -1 ; i >= 0; i--){
//            System.out.println(numbers[i]);
//        }
         int sum = 0;
         int max = numbers[0];
         int min = numbers[0];
             for (int num : numbers) {
                 sum += num;
                 if (max < num) {
                     max = num;
                 } if(num < min){
                     min = num;
                 }
             }
                double average = (double) sum / numbers.length;
             System.out.println("Sum: " + sum);
             System.out.println("Average: " + average);
             System.out.println("Max: " + max);
             System.out.println("Min: " + min);

         }



         }