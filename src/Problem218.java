import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem218 {
    class Node{
        public Integer x;
        public Integer height;
        //0进1出
        public Integer type;

        public Node(Integer x,Integer height,Integer type){
            this.x = x;
            this.height = height;
            this.type = type;
        }

    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();

        if (null==buildings||buildings.length==0||buildings[0].length==0){
            return result;
        }

        List<Node> nodeList = new ArrayList<>();
        for (int[] building : buildings) {
            int left = building[0];
            int right = building[1];
            int height = building[2];
            nodeList.add(new Node(left,height,0));
            nodeList.add(new Node(right,right,1));
        }
        Collections.sort(nodeList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.x-o2.x;
            }
        });

        List<Integer>
    }
}
