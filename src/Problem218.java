import java.util.*;

public class Problem218 {
    class Node {
        public Integer x;
        public Integer height;
        //0进1出
        public Integer type;

        public Node(Integer x, Integer height, Integer type) {
            this.x = x;
            this.height = height;
            this.type = type;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();

        if (null == buildings || buildings.length == 0 || buildings[0].length == 0) {
            return result;
        }

        Map<Integer, List<Node>> xMapNodeList = new TreeMap<>();
        for (int[] building : buildings) {
            int left = building[0];
            int right = building[1];
            int height = building[2];
            if (null == xMapNodeList.get(left)) {
                xMapNodeList.put(left, new ArrayList<Node>());
            }
            if (null == xMapNodeList.get(right)) {
                xMapNodeList.put(right, new ArrayList<Node>());
            }

            xMapNodeList.get(left).add(new Node(left, height, 0));
            xMapNodeList.get(right).add(new Node(right, height, 1));
        }

        List<Integer> heightList = new LinkedList<>();
        for (Map.Entry<Integer, List<Node>> entry : xMapNodeList.entrySet()) {
            List<Node> nodeList = entry.getValue();
            Integer x = entry.getKey();
            Integer inHeight = 0;
            Integer outHeight = 0;
            Integer inCurrentHeight = 0;
            for (Node node : nodeList) {
                if (node.type == 0) {
                    if (node.height>inHeight){
                        inHeight = node.height;
                        inCurrentHeight = getCurrentHeight(heightList);
                    }
                    sortInsert(heightList,node.height);
                }
                if (node.type==1){
                    if (node.height>outHeight){
                        outHeight = node.height;
                    }
                    deleteHeight(heightList,node.height);
                }
            }
            if (inHeight>outHeight){
                doInsert(x,inHeight,Math.max(outHeight,inCurrentHeight),result);
            }
            if(outHeight>inHeight){
                doDelete(x,outHeight,heightList,result);
            }
        }
        return result;
    }

    private void doDelete(Integer x,Integer outHeight,List<Integer> heightList,List<List<Integer>> result) {
        Integer currentHeight = getCurrentHeight(heightList);
        if (outHeight>currentHeight){
            List<Integer> subResult = new ArrayList<>();
            subResult.add(x);
            subResult.add(currentHeight);
            result.add(subResult);
        }
    }

    private void doInsert(Integer x,Integer inHeight,Integer currentHeight,List<List<Integer>> result) {
        if (inHeight>currentHeight){
            List<Integer> subResult = new ArrayList<>();
            subResult.add(x);
            subResult.add(inHeight);
            result.add(subResult);
        }
    }

    public Integer getCurrentHeight(List<Integer> heightList) {
        if (heightList.isEmpty()) {
            return 0;
        }
        return heightList.get(0);
    }

    public void sortInsert(List<Integer> heightList, Integer height) {
        Iterator<Integer> iterator = heightList.iterator();

        int i = 0;
        while (iterator.hasNext()) {
            if (iterator.next().compareTo(height) <= 0) {
                break;
            }
            i++;
        }
        heightList.add(i, height);
    }

    public void deleteHeight(List<Integer> heightList, Integer height) {
        if (heightList.isEmpty()) {
            return;
        }
        Iterator<Integer> iterator = heightList.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().compareTo(height) == 0) {
                iterator.remove();
                break;
            }
        }
    }

    public static void main(String[] args) {
        Problem218 problem218 = new Problem218();
        int[][] test = new int[][]{{2, 9, 10}, {3 ,7 ,15}, {5 ,12 ,12}, {15, 20 ,10}, {19, 24, 8}};
        List<List<Integer>> result = problem218.getSkyline(test);
        System.out.println(result);
    }
}
