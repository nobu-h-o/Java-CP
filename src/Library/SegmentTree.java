package Library;

// https://www.geeksforgeeks.org/segment-tree-in-java/
class SegmentTreeNode {
    // Range of indices covered by this node
    int start, end;

    // Sum of values in the range
    int sum;

    // Pointers to left and right child nodes
    SegmentTreeNode left, right;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.sum = 0;
        this.left = null;
        this.right = null;
    }
}

// Segment Tree Class
class SegmentTree {
    // Root of the segment tree
    private SegmentTreeNode root;

    public SegmentTree(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    // Build the segment tree recursively
    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null; // Empty node
        }
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if (start == end) {
            // Leaf node: store the value directly
            node.sum = nums[start];
        } else {
            int mid = start + (end - start) / 2;

            // Build left subtree
            node.left = buildTree(nums, start, mid);

            // Build right subtree
            node.right = buildTree(nums, mid + 1, end);

            // Combine values from children
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }

    // Query the range sum [i, j]
    public int rangeSum(int i, int j) {
        return rangeSum(root, i, j);
    }

    private int rangeSum(SegmentTreeNode node, int start, int end) {
        if (node == null || start > node.end || end < node.start) {
            // Out of range or null node
            return 0;
        }
        if (start <= node.start && end >= node.end) {
            // Fully covered by this node
            return node.sum;
        }
        return rangeSum(node.left, start, end) + rangeSum(node.right, start, end);
    }

    // Update the value at index i
    public void update(int i, int val) {
        update(root, i, val);
    }

    private void update(SegmentTreeNode node, int index, int val) {
        if (node.start == node.end) {
            // Leaf node: update the value
            node.sum = val;
        } else {
            int mid = node.start + (node.end - node.start) / 2;
            if (index <= mid) {
                // Update left subtree
                update(node.left, index, val);
            } else {
                // Update right subtree
                update(node.right, index, val);
            }

            // Recalculate sum
            node.sum = node.left.sum + node.right.sum;
        }
    }
}