package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsBinaryTreeTest {
    private IsBinaryTree obj = new IsBinaryTree();

    @Test
    public void checkBST_symetric_true() {
        final Node root = new Node(4,
            new Node(2,
                new Node(1),
                new Node(3)
            ),
            new Node(6,
                new Node(5),
                new Node(7)
            )
        );
        assertTrue(obj.checkBST(root));
    }

    @Test
    public void checkBST_asymetric_internalfalse() {
        final Node root = new Node(5,
            new Node(2,
                new Node(1),
                    null
            ),
            new Node(10,
                new Node(4),
                new Node(12)
            )
        );
        assertFalse(obj.checkBST(root));
    }

    @Test
    public void checkBST_asymetric_false() {
        final Node root = new Node(3,
            new Node(2,
                new Node(1),
                    null
            ),
            new Node(4,
                new Node(5),
                new Node(6)
            )
        );
        assertFalse(obj.checkBST(root));
    }

    @Test
    public void checkBST_asymetric_true() {
        final Node root = new Node(3,
            new Node(2,
                new Node(1),
                    null
            ),
            new Node(5,
                new Node(4),
                new Node(6)
            )
        );
        assertTrue(obj.checkBST(root));
    }
}