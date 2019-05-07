package String;

/**
 * LeetCode 第28题
 * 实现strStr()
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean result = true;
            for (int j = 0; j < needle.length(); j++) {
                if(needle.charAt(j)==haystack.charAt(i+j)){
                    continue;
                }else{
                    result=false;
                    break;
                }
            }
            if(result){
                return i;
            }else{
                continue;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        ImplementStrStr implementStrStr = new ImplementStrStr();
        System.out.println(implementStrStr.strStr("mississippi","mississippi"));
    }
}
