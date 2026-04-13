import java.util.*;

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        double basic = sc.nextDouble();

        double hra = basic * 0.2;
        double bonus = basic * 0.1;
        double deduction = basic * 0.05;

        double netSalary = basic + hra + bonus - deduction;

        System.out.println("\n--- Payslip ---");
        System.out.println("Name: " + name);
        System.out.println("Basic: " + basic);
        System.out.println("HRA: " + hra);
        System.out.println("Bonus: " + bonus);
        System.out.println("Deduction: " + deduction);
        System.out.println("Net Salary: " + netSalary);
    }
}
