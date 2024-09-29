package doItAlgoCoTe.정렬;

public class test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (Integer i = 5000000; i >= 0; i--) {
            sb.append(i).append('\n');
        }
        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.print("\n" + usedMemory + " bytes");
    }
}
