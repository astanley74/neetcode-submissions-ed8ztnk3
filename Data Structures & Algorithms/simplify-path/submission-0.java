class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");

        for (String curr : paths) {
            if (curr.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!curr.equals("") && !curr.equals(".")) {
                stack.push(curr);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String dir : stack) {
            builder.append("/").append(dir);
        }
        return builder.length() == 0 ? "/" : builder.toString();
    }
}