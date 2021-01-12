package exercises;

import com.binarySearch.BinarySearchST;

import java.util.Scanner;

//task 3.1.1
public class NotesClient {
    private BinarySearchST<String,Double> notes;
    public NotesClient()
    {
       notes = new BinarySearchST<>(1);

        notes.put("A+",4.33);
        notes.put("A",4.00);
        notes.put("A-",3.67);
        notes.put("B+",3.33);
        notes.put("B",3.00);
        notes.put("B-",2.67);
        notes.put("B",3.00);
        notes.put("C+",2.33);
        notes.put("C",2.00);
        notes.put("D",1.00);
        notes.put("F",0.00);
    }

    public double typeNotes() {
        double average = 0.0;
        int counter = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Type notes, note which cannot be found will cause application end: \n");


        while (true) {
            try {
                average += notes.get(scan.nextLine());
                counter++;
                System.out.println(average/counter);

            } catch (NullPointerException ex) {
                return average/=counter;
            }
        }

    }
}
