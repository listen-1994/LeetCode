package String;

import java.util.Stack;

/**
 * Leetcode 第71题 简化路径
 * 栈，字符串
 */
public class Problem71 {
    public String simplifyPath(String path) {
        if(path==null||path.length()==0){
            return "";
        }
        String result = "";
        Stack<String> folderStack = new Stack<>();
        String[] folderNames = path.split("/");
        for(int i=0;i<folderNames.length;i++){
            String point = folderNames[i];
            if(point.equals(".")||point.equals("")){
                continue;
            }else if(point.equals("..")){
                if(!folderStack.isEmpty()){
                    folderStack.pop();
                }
            }else{
                folderStack.push(point);
            }
        }
        if(folderStack.isEmpty()){
            return "/";
        }
        while(!folderStack.isEmpty()){
            result="/"+folderStack.pop()+result;
        }
        return result;
    }
}
