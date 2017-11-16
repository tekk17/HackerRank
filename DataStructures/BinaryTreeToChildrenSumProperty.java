package problems;


public class BinaryTreeToChildrenSumProperty {

    /*
    Check If Children Sum Property Holds Good For a Binary Tree
     */
    public int checkIfChildrenSumProperty(Node start) {
        int left_data = 0;
        int right_data = 0;

        if(start == null || (start.left == null && start.right == null)) {
            return 1;
        } else {
            checkIfChildrenSumProperty(start.left);
            checkIfChildrenSumProperty(start.right);

            if(start.left != null) {
                left_data = start.left.data;
            }
            if(start.right != null) {
                right_data = start.right.data;
            }

            if((start.data == (left_data + right_data)) && (checkIfChildrenSumProperty(start.left)!= 0) && (checkIfChildrenSumProperty(start.right)!= 0)) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    /*
    Convert a Binary Tree To Children Sum Property Tree
     */
    public void convertTreeToChildrenSum(Node start) {
        int left_data = 0;
        int right_data = 0;
        int diff = 0;

        if(start == null || (start.left == null && start.right == null)) {
            return;
        } else {
            convertTreeToChildrenSum(start.left);
            convertTreeToChildrenSum(start.right);

            if(start.left != null) {
                left_data = start.left.data;
            }
            if(start.right != null) {
                right_data = start.right.data;
            }

            diff = (left_data+right_data)-(start.data);

            if(diff == 0) return;
            else if(diff > 0) {
                start.data += diff;
            } else if(diff < 0) {
                diff *= -1;
                incrementNode(start,diff);
            }
        }
    }

    public void incrementNode(Node start,int diff) {
        if(start.left != null) {
            start.left.data = start.left.data+diff;
            incrementNode(start.left,diff);
        } else if(start.right != null) {
            start.right.data = start.right.data+diff;
            incrementNode(start.right,diff);
        }
    }

    public static void inOrderTraversal(Node start) {
        if(start != null) {
            inOrderTraversal(start.left);
            System.out.print(start.data + " ");
            inOrderTraversal(start.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        Node rootLeft = new Node(8);
        Node rootRight = new Node(2);
        Node rootLeftLeft = new Node(3);
        Node rootLeftRight = new Node(5);
        Node rootRightLeft = new Node(1);
        Node rootRightRight = new Node(30);

        root.addLink(rootLeft,rootRight);
        rootLeft.addLink(rootLeftLeft,rootLeftRight);
        rootRight.addLink(rootRightLeft,rootRightRight);

        BinaryTreeToChildrenSumProperty currentPtr = new BinaryTreeToChildrenSumProperty();
        int isTrue = currentPtr.checkIfChildrenSumProperty(root);
        if(isTrue == 1) {
            System.out.println("Children Sum Property Satisfied");
        } else {
            System.out.println("Children Sum Property Not Satisfied, Performing Corrections");
            currentPtr.convertTreeToChildrenSum(root);
        }

        inOrderTraversal(root);
    }
}
