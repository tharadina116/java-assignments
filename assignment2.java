//1st qn
try {
    int[] arr = {10, 20, 30};
    int result = arr[3] / 0;
}
catch (ArithmeticException e) {
    System.out.println("Division by zero!");
}
catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Array index out of range!");
}
catch (Exception e) {
    System.out.println("General exception!");
}
//2nd qn
import java.io.*;

public class FileReadExample {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("abc.txt"); // file not found
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found! Please check the path.");
        }
    }
}
//3rd qn
class InvalidGradeException extends Exception {
    public InvalidGradeException(String message) {
        super(message);
    }
}

public class GradeTest {
    public static void main(String[] args) {
        try {
            int marks = 120;
            if (marks > 100) {
                throw new InvalidGradeException("Marks cannot exceed 100!");
            }
        } 
        catch (InvalidGradeException e) {
            System.out.println(e.getMessage());
        }
    }
}
//4th qn
class TicketBooking {
    private int tickets = 1;

    public synchronized void bookTicket(String customer) {
        if (tickets > 0) {
            System.out.println(customer + " booked the ticket.");
            tickets--;
        } else {
            System.out.println(customer + " failed! Ticket already booked.");
        }
    }
}

public class BookingTest {
    public static void main(String[] args) {
        TicketBooking tb = new TicketBooking();

        Thread t1 = new Thread(() -> tb.bookTicket("Customer 1"));
        Thread t2 = new Thread(() -> tb.bookTicket("Customer 2"));

        t1.start();
        t2.start();
    }
}
//5th qn
class DownloadPart1 extends Thread {
    public void run() {
        try {
            System.out.println("Part 1 downloading...");
            Thread.sleep(1000);
            System.out.println("Part 1 completed.");
        } 
        catch (Exception e) { }
    }
}

class DownloadPart2 extends Thread {
    public void run() {
        try {
            System.out.println("Part 2 downloading...");
            Thread.sleep(1000);
            System.out.println("File download completed.");
        } 
        catch (Exception e) { }
    }
}

public class FileDownload {
    public static void main(String[] args) {
        new DownloadPart1().start();
        new DownloadPart2().start();
    }
}
//6th qn
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void show() {
        System.out.println("Key: " + key + ", Value: " + value);
    }
}

public class PairTest {
    public static void main(String[] args) {
        Pair<String, Integer> p1 = new Pair<>("Age", 25);
        Pair<String, String> p2 = new Pair<>("Country", "Japan");

        p1.show();
        p2.show();
    }
}
//7th qn
public class PrintArrayDemo {

    public static <T> void printArray(T[] arr) {
        for (T item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] s = {"Java", "Python", "C++"};
        Integer[] n = {1, 2, 3, 4};

        printArray(s);
        printArray(n);
    }
}
//8th qn
public class SentenceAnalysis {
    public static void main(String[] args) {

        String sentence = "Java Programming is FUN and Powerful!";

        // 1. Count characters
        System.out.println("Characters: " + sentence.length());

        // 2. Lowercase
        System.out.println("Lowercase: " + sentence.toLowerCase());

        // 3. Replace spaces with _
        System.out.println("Underscore: " + sentence.replace(" ", "_"));

        // 4. Check contains "Java"
        System.out.println("Contains 'Java'? " + sentence.contains("Java"));

        // 5. Display "FUN" in lowercase
        int start = sentence.indexOf("FUN");
        String funLower = sentence.substring(start, start + 3).toLowerCase();
        System.out.println("FUN lowercase: " + funLower);
    }
}

