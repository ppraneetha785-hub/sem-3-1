package week8;

import java.util.*;
import java.time.*;

abstract class LibraryItem {
    String title;
    LibraryItem(String t) { title = t; }
    abstract LocalDate dueDate(LocalDate current);
}

class Book extends LibraryItem {
    Book(String t) { super(t); }
    LocalDate dueDate(LocalDate current) { return current.plusDays(14); }
}

class DVD extends LibraryItem {
    DVD(String t) { super(t); }
    LocalDate dueDate(LocalDate current) { return current.plusDays(7); }
}

class Magazine extends LibraryItem {
    Magazine(String t) { super(t); }
    LocalDate dueDate(LocalDate current) { return current.plusDays(3); }
}
 class LibraryDueDateDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // consume newline
        LocalDate current = LocalDate.of(2023, 10, 26);
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ", 2);
            String type = parts[0];
            String title = parts[1].replace("\"", "");
            LibraryItem item;
            switch (type) {
                case "BOOK": item = new Book(title); break;
                case "DVD": item = new DVD(title); break;
                default: item = new Magazine(title);
            }
            System.out.println(title + ": " + item.dueDate(current));
        }
    }
}
