import java.util.LinkedList;
import java.util.List;

public class Problem93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        core(result, s, sb, 0);
        return result;
    }

    public void core(List<String> result, String s, StringBuilder currentResult, int index) {
        if (index == 3) {
            if (s.length() > 3) {
                return;
            }
            if (s.length() > 1 && s.startsWith("0")) {
                return;
            }
            Integer tmpInteger = Integer.valueOf(s);
            if (0 <= tmpInteger && tmpInteger <= 255) {
                result.add(currentResult.append(".").append(s).toString());
            }
            return;
        }

        String s1 = null;
        String s2 = null;
        String s3 = null;
        String t1 = null;
        String t2 = null;
        String t3 = null;
        Integer integer1 = null;
        Integer integer2 = null;
        Integer integer3 = null;
        if (s.length() > 1) {
            s1 = s.substring(1, s.length());
            t1 = s.substring(0, 1);
            integer1 = Integer.valueOf(t1);
        }

        if (s.length() > 2) {
            s2 = s.substring(2, s.length());
            t2 = s.substring(0, 2);
            if(!t2.startsWith("0")){
                integer2 = Integer.valueOf(t2);
            }
        }

        if (s.length() > 3) {
            s3 = s.substring(3, s.length());
            t3 = s.substring(0, 3);
            if(!t3.startsWith("0")){
                integer3 = Integer.valueOf(t3);
            }
        }


        if (integer1 != null && 0 <= integer1 && integer1 <= 255) {
            StringBuilder sb = new StringBuilder(currentResult);
            if (index != 0) {
                sb.append(".");
            }
            sb.append(t1);
            core(result, s1, sb, index + 1);
        }

        if (integer2 != null && 0 <= integer2 && integer2 <= 255) {
            StringBuilder sb = new StringBuilder(currentResult);
            if (index != 0) {
                sb.append(".");
            }
            sb.append(t2);
            core(result, s2, sb, index + 1);
        }

        if (integer3 != null && 0 <= integer3 && integer3 <= 255) {
            StringBuilder sb = new StringBuilder(currentResult);
            if (index != 0) {
                sb.append(".");
            }
            sb.append(t3);
            core(result, s3, sb, index + 1);
        }
    }

    public static void main(String[] args) {
        Problem93 problem93 = new Problem93();
        System.out.println(problem93.restoreIpAddresses("010010"));
    }

}
