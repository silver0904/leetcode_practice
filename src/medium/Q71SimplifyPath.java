package medium;

import java.util.ArrayList;

public class Q71SimplifyPath {
    // time: O(n)
    // space: O(n)
    public String simplifyPath(String path) {
        String[] pathArray = path.split("/");
        ArrayList<String> resultArray = new ArrayList<>();

        for (String subPath: pathArray){
            // for // and ./ case, ignore it
            if (subPath.isEmpty() || subPath.equals(".")) continue;

            // for .. case, remove the previous added subpath
            if (subPath.equals("..") ){
                if (!resultArray.isEmpty())
                    resultArray.remove(resultArray.size() -1);
            }
            // for other cases, treat them as valid subpath
            else{
                resultArray.add(subPath);
            }
        }

        String result = "";
        // construct the path with the valid sub path array
        for (String subPath: resultArray){
            result += "/" + subPath;
        }
        return result.isEmpty() ? "/" : result;
    }
}
