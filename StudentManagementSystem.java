import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;
    private String course;
    private double marks;

    public Student(int id, String name, int age, String course, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }

    public int getId() { return id; }
    public double getMarks() { return marks; }

    public void update(String name, int age, String course, double marks) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }

    public String getGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 50) return "C";
        else return "Fail";
    }

    public void display() {
        System.out.printf("%-5d %-15s %-5d %-10s %-8.2f %-5s%n",
                id, name, age, course, marks, getGrade());
    }
}


class StudentService {
    private HashMap<Integer, Student> map = new HashMap<>();

    public void add(Student s) {
        if (map.containsKey(s.getId())) {
            System.out.println("ID already exists!");
            return;
        }
        map.put(s.getId(), s);
        System.out.println("Student added successfully.");
    }

    public void displayAll() {
        if (map.isEmpty()) {
            System.out.println("No records.");
            return;
        }
        System.out.printf("%-5s %-15s %-5s %-10s %-8s %-5s%n",
                "ID", "Name", "Age", "Course", "Marks", "Grade");
        map.values().forEach(Student::display);
    }

    public void search(int id) {
        Student s = map.get(id);
        if (s == null) System.out.println("Not found.");
        else s.display();
    }

    public void delete(int id) {
        if (map.remove(id) != null)
            System.out.println("Deleted.");
        else
            System.out.println("Not found.");
    }

    public void update(int id, Scanner sc) {
        Student s = map.get(id);
        if (s == null) {
            System.out.println("Not found.");
            return;
        }

        sc.nextLine();
        System.out.print("New Name: ");
        String name = sc.nextLine();
        System.out.print("New Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("New Course: ");
        String course = sc.nextLine();
        System.out.print("New Marks: ");
        double marks = sc.nextDouble();

        s.update(name, age, course, marks);
        System.out.println("Updated successfully.");
    }

    public void average() {
        if (map.isEmpty()) {
            System.out.println("No data.");
            return;
        }
        double avg = map.values().stream()
                .mapToDouble(Student::getMarks)
                .average().orElse(0);

        System.out.printf("Average Marks: %.2f%n", avg);
    }

    public void topper() {
        map.values().stream()
                .max(Comparator.comparingDouble(Student::getMarks))
                .ifPresent(s -> {
                    System.out.println("Topper:");
                    s.display();
                });
    }

    public void sortDescending() {
        List<Student> list = new ArrayList<>(map.values());
        list.sort((a, b) -> Double.compare(b.getMarks(), a.getMarks()));

        System.out.println("Sorted (High → Low):");
        list.forEach(Student::display);
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        int choice;

        do {
            System.out.println("\n1.Add 2.Display 3.Search 4.Update 5.Delete");
            System.out.println("6.Average 7.Topper 8.Sort 9.Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Course: ");
                    String course = sc.nextLine();

                    System.out.print("Marks: ");
                    double marks = sc.nextDouble();

                    service.add(new Student(id, name, age, course, marks));
                }

                case 2 -> service.displayAll();

                case 3 -> {
                    System.out.print("Enter ID: ");
                    service.search(sc.nextInt());
                }

                case 4 -> {
                    System.out.print("Enter ID: ");
                    service.update(sc.nextInt(), sc);
                }

                case 5 -> {
                    System.out.print("Enter ID: ");
                    service.delete(sc.nextInt());
                }

                case 6 -> service.average();

                case 7 -> service.topper();

                case 8 -> service.sortDescending();

                case 9 -> System.out.println("Exiting...");

                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 9);

        sc.close();
    }
}
