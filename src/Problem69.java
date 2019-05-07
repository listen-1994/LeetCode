public class Problem69 {
    //O(n)
    public int mySqrt(int x) {
        if(x==1){
            return 1;
        }
        int i;
        long check;
        for(i=1;i<=x/2+1;i++){
            check = (long)i*(long)i;
            if(check==x){
                return i;
            }
            if(check>x){
                return i-1;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        Problem69 problem69 = new Problem69();
        System.out.println(problem69.mySqrt(2147483647));
    }
}
