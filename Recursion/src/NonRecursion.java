public class NonRecursion {

    public int faculty(int x) {
        int y = 1;
        for (int i = x; i > 1; i--) {
            y = y * i;
        }
        return y;
    }

    public int sum(int x) {
        int y = 0;
        for (int i = x; i >= 1; i--) {
            y = y + i;
        }
        return y;
    }

    public int binaryCountOnes(int x) {
        int binaryCount = 0;
        double rest = x;
        while (rest >= 1) {
            if (rest % 2 == 1) {
                binaryCount++;
            }
            rest = Math.floor(rest / 2);
        }
        return binaryCount;
    }
}