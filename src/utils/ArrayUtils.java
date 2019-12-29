package utils;

public class ArrayUtils {
    public static <T> void printArray (T[] array){
        if (isEmpty(array)){
            System.out.println("array is empty!");
        }
        StringBuilder sb = new StringBuilder("[");
        for (T t : array) {
            sb.append(t.toString());
            sb.append(", ");
        }
        sb.delete(sb.length()-2,sb.length());
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static <T> Boolean isEmpty(T[] array){
        return null==array||array.length==0;
    }
}
