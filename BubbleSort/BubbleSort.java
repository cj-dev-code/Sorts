import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Sorts {

    private static void BubbleSort(List<Integer> data) {
        // it takes data.size() - 1 steps to move the smallest element at the back to the front of the vector
        // Loop data.size() - 1 times
        for (int start = 0; start < data.size() - 1; start++) {
            // The greatest element is always at the back after each iteration
            // move through the list from front to back, moving big elements to the front of the list
            for (int target = 0; target < data.size() - 1 - start; target++) {
                // Swap if a big element is before a little element
                if (data.get(target) > data.get(target + 1)) {
                    // Swap without using a new variable to save space.
                    data.set(target, data.get(target) + data.get(target + 1));
                    data.set(target + 1, data.get(target) - data.get(target + 1));
                    data.set(target,  data.get(target) - data.get(target + 1));
                }
            }
        }
    }

    public static LinkedList<Integer> read_dataVec(String file) throws IOException {
        // Create a reader to read the supplied file,
        BufferedReader reader = new BufferedReader(new FileReader(file));
        // A linkedlist to store the read data in,
        LinkedList<Integer> data = new LinkedList<>();
        // A line to store the current line in,
        String line;
        // And a scanner to scan each line with.
        Scanner scanner;

        // Read all the lines, scanning each one for data seperated by commas
        while ((line=reader.readLine()) != null){
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            // And store it in the data linkedlist (When integers)
            while (scanner.hasNext()){
                String dat = scanner.next();
                try{
                    data.add(Integer.valueOf(dat));
                }
                catch (NumberFormatException e){
                }
            }
        }
        // Return the read data.
        return data;
    }

    public static void main(String[] args) throws IOException {
        // Make sure user supplies vector filename and vector filename alone
        if (args.length != 1){
            System.out.println("Usage: javac Sorts.java [dataVecFile]");
            return;
        }

        // Read the random integers from the supplied file
        LinkedList<Integer> data = read_dataVec(args[0]);
        // and bubblesort it.
        BubbleSort(data);

        // Finally, print the sorted data
        for (Integer element : data) {
            System.out.print(element + ", ");
        }
    }
}