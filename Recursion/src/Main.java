public class Main {

    public static void main(String[] args) {
        int n = 5;
        String str = "Hallo";
        NonRecursion nr = new NonRecursion();
        Recursion r = new Recursion();
        System.out.println("Non Recursive Faculty of " + n + " is: " + nr.faculty(n));
        System.out.println("Recursive Faculty: of " + n + " is: " + r.faculty(n));
        System.out.println("Non Recursive Sum of " + n + " is: " + nr.sum(n));
        System.out.println("Recursive Sum of " + n + " is: " + r.sum(n));
        System.out.println("Non Recursive Binary Count Ones in " + n + " is: " + nr.binaryCountOnes(n));
        System.out.println("Recursive Binary Count Ones in " + n + " is: " + r.binaryCountOnes(n));
        System.out.println("Recursive Reverse String of " + str + " is: " + r.reverseString(str));
        System.out.println("Recursive Reverse StringBuffer of " + str + " is: " + r.reverseStringBuffer(new StringBuffer(str)));
    }
}