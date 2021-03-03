package Graph;

public class Q2 {
    public static void main(String[] args) {
        int[] nums = new int[] {2, 5, 10, 15, 20};
        TreeNode minimalTree = makeMinimalTree(nums);
        System.out.println(getTreeHeight(minimalTree));
    }

    static TreeNode makeMinimalTree(int[] nums) {
        return makeMinimalTree(nums, 0, nums.length - 1);
    }

    static TreeNode makeMinimalTree(int[] array, int start, int end) {
        // 當start指標超越end指標，回傳null
        if (start > end) { return null; }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(String.valueOf(array[mid]));
        root.left = makeMinimalTree(array, start, mid - 1);
        root.right = makeMinimalTree(array, mid + 1, end);
        return root;
    }

    static int getTreeHeight(TreeNode root) {
        if (root == null || isLeaf(root)) { return 0; }
        int leftH = getTreeHeight(root.left);
        int leftR = getTreeHeight(root.right);
        return 1 + Math.max(leftH, leftR);
    }

    static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
