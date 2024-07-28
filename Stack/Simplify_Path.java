/*
71.
Given an absolute path for a Unix-style file system, which begins with a slash '/', transform this path into its simplified canonical path.

In Unix-style file system context, a single period '.' signifies the current directory, a double period ".." denotes moving up one directory level, and multiple slashes such as "//" are interpreted as a single slash. In this problem, treat sequences of periods not covered by the previous rules (like "...") as valid names for files or directories.

The simplified canonical path should adhere to the following rules:

It must start with a single slash '/'.
Directories within the path should be separated by only one slash '/'.
It should not end with a slash '/', unless it's the root directory.
It should exclude any single or double periods used to denote current or parent directories.
Return the new path.

 

Example 1:

Input: path = "/home/"

Output: "/home"

Explanation:

The trailing slash should be removed.

 
Example 2:

Input: path = "/home//foo/"

Output: "/home/foo"

Explanation:

Multiple consecutive slashes are replaced by a single one.
*/

class Solution {
    public String simplifyPath(String path) {
        // Stack<String> st = new Stack<String>();
        // String regex="/";
        // String[] arrOfStr = path.split(regex);
        // String result ="";
        // for(int i=0;i<arrOfStr.length;i++){
        //     System.out.println(arrOfStr[i]);
        // }
        // for(int i=1;i<arrOfStr.length;i++){
        //     String val = arrOfStr[i];
        //     if(!st.isEmpty() && arrOfStr[i].equals("..")){
        //         st.pop();
        //     }
        //     else{
        //         System.out.println(val);
        //         if(!val.equals(".") && !val.equals("..") && !val.equals("  ")){
        //         st.push(val);
        //         }
                
        //     }
        // }
        // System.out.println(st.size());
        // while(!st.isEmpty()){
        //     System.out.println("ddfgh");
        //     result = "/" + st.pop() + result;
        // }
        // if(result.isEmpty()){
        //     return "/";
        // }
        // return result;



        Stack<String> st = new Stack<>();
        String[] arrOfStr = path.split("/");

        for (String val : arrOfStr) {
            if (val.equals("") || val.equals(".") || val.trim().isEmpty()) {
                // Ignore empty strings, current directory references, and whitespace strings
                continue;
            } else if (val.equals("..")) {
                // Go up one directory level if possible
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                // Add the directory to the stack
                st.push(val);
            }
        }

        // Construct the result from the stack
        String result = "";
        while(!st.isEmpty()){
            System.out.println("ddfgh");
            result = "/" + st.pop() + result;
        }
        // for (String dir : st) {
        //     result = "/" + dir + result;
        // }

        // Return the root directory if the result is empty
        return result.isEmpty() ? "/" : result;



    }
}
