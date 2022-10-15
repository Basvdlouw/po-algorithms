public class Recursion {

    public int faculty(int x) {
        if (x == 1) {
            return 1;
        } else {
            return x * (faculty(x - 1));
        }
    }

    public int sum(int x) {
        if (x == 1) {
            return 1;
        } else {
            return x + (sum(x - 1));
        }
    }

    public int binaryCountOnes(int x) {
        if (x == 1) {
            return 1;
        } else {
            return (x % 2) + (binaryCountOnes(x / 2));
        }
    }

    public String reverseString(String str) {
        int length = str.length();
        if (length == 1) {
            return str;
        } else {
            return str.substring(length - 1, length) + reverseString(str.substring(0, length - 1));
        }
    }

    public StringBuffer reverseStringBuffer(StringBuffer buffer) {
        int length = buffer.length();
        if (length == 1) {
            return buffer;
        } else {
            return new StringBuffer(buffer.substring(length - 1, length) + reverseString(buffer.substring(0, length - 1)));
        }
    }
}