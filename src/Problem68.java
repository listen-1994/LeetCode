import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem68 {
    /**
     * 特例开的太多，不好
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || words.length == 0) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        core(result, words, maxWidth, 0);
        return result;
    }

    public void core(List<String> result, String[] words, int maxWidth, int index) {
        if (index >= words.length) {
            return;
        }
        StringBuilder sb = new StringBuilder(words[index]);
        int length = words[index].length();
        int oldIndex = index;
        while (length <= maxWidth && index < words.length - 1) {
            index++;
            length += words[index].length() + 1;
        }
        if (!(index == words.length - 1 && length <= maxWidth)) {
            length -= words[index].length() + 1;
            index--;
        }
        int num = index - oldIndex;
        if (num == 0) {
            sb.append(blank(maxWidth - sb.length()));
        }
        if (num != 0) {
            if (!(index == words.length - 1)) {
                int ret = (maxWidth - length) % num;
                int dev = (maxWidth - length) / num;
                for (int i = oldIndex + 1; i <= index; i++) {
                    if (i - oldIndex <= ret) {
                        sb.append(blank(dev + 2));
                        sb.append(words[i]);
                        continue;
                    }
                    sb.append(blank(dev + 1));
                    sb.append(words[i]);
                }
            }
            if (index == words.length - 1) {
                for (int i = oldIndex + 1; i <= index; i++) {
                    sb.append(blank(1)).append(words[i]);
                }
                sb.append(blank(maxWidth - sb.length()));
            }
        }
        result.add(sb.toString());
        core(result, words, maxWidth, index + 1);
    }

    public String blank(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem68 problem68 = new Problem68();
        List<String> result = problem68.fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16);
        System.out.println(result);
    }

}
