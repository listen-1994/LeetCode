public class Problem67 {
    public String addBinary(String a, String b) {
        String longbin = a.length()>b.length()?a:b;
        String shortbin = a.length()>b.length()?b:a;

        int index = 1;
        String result="";
        int borrow = 0;
        while(index<=shortbin.length()){
            int one = Integer.valueOf(shortbin.substring(shortbin.length()-index,shortbin.length()-index+1));
            int two = Integer.valueOf(longbin.substring(longbin.length()-index,longbin.length()-index+1));

            int subResult = one+two+borrow;
            if(subResult==3){
                borrow=1;
                result="1"+result;
            }else if(subResult==2){
                result="0"+result;
                borrow=1;
            }else if(subResult==1){
                result="1"+result;
                borrow=0;
            }else if(subResult==0){
                result="0"+result;
                borrow=0;
            }
            index++;
        }

        while(index<=longbin.length()){
            int one = Integer.valueOf(longbin.substring(longbin.length()-index,longbin.length()-index+1));
            int subResult = one+borrow;
            if(subResult==2){
                result="0"+result;
                borrow=1;
            }else if(subResult==1){
                result="1"+result;
                borrow=0;
            }else if(subResult==0){
                result="0"+result;
                borrow=0;
            }
            index++;
        }

        if(borrow==1){
            result="1"+result;
        }
        return result;
    }

    public static void main(String[] args){
        Problem67 problem67 = new Problem67();
        System.out.println(problem67.addBinary("1","11"));
    }
}
