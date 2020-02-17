package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

/**
 * 二叉树
 */
public class I0077Q020402BinaryTree {

    class AbstractBinarySearchTree{
        public Node root;
        protected int size;

        /**
         * 添加一个节点
         *
         * @param value 节点值
         * @return 返回新加的节点
         */
        public Node insert(int value){
            Node newNode = createNode(value);
            if (root == null){
                root = newNode;
                return newNode;
            }

            Node cur = root;
            Node insertParent = null;
            while (cur != null && cur.value != value){
                insertParent = cur;
                if (value < cur.value){
                    cur = cur.left;
                }else {
                    cur = cur.right;
                }
            }
            if (cur != null){ //要加的节点树中已存在
                return null;
            }
            newNode.parent = insertParent;
            if (value < insertParent.value){
                insertParent.left = newNode;
            }else {
                insertParent.right = newNode;
            }
            size++;
            return newNode;
        }

        /**
         * 找节点
         *
         * @param value 节点值
         * @return 返回节点
         */
        public Node select(int value){
            if (root == null){
                return null;
            }
            Node cur = root;
            while (cur != null && cur.value != value){ //666
                if (value < cur.value){
                    cur = cur.left;
                }else if (value > cur.value){
                    cur = cur.right;
                }
            }
            return cur;
        }

        /**
         * 依节点值, 删除节点
         * @param value 节点值
         * @return 删除位置的新节点
         */
        public Node delete(int value){
            Node delNode = select(value);
            if (delNode == null){
                return null;
            }
            return delete(delNode);
        }

        /**
         * 删除节点
         * @param node 节点
         * @return 删除位置的替换节点
         */
        protected Node delete(Node node) {
            if (node == null){
                return null;
            }
            Node res = null;
            if (node.left == null){ //没左有右
                res = transplant(node, node.right);
            }else if (node.right == null){ //没右有左
                res = transplant(node, node.left);
            }else { //左右双全
                Node successor = successor(node); //后继节点
                if (successor.parent != node){ //后继节点不是node的右孩子
                    transplant(successor, successor.right); //需要处理successor的右孩子
                    successor.right = node.right;
                    successor.right.parent = successor;
                }
                //处理successor的左孩子
                res = transplant(node, successor);
                successor.left = node.left;
                successor.left.parent = successor;
            }
            size--;
            return res;
        }

        /**
         * 将toReplace的parent, 付给newNode
         *
         * @param toReplace 被替换的node
         * @param newNode 替换者
         * @return 替换者
         */
        protected Node transplant(Node toReplace, Node newNode) {
            if (toReplace.parent == null){ //toReplace为root
                this.root = newNode;
            }else if (toReplace.parent.left == toReplace){
                toReplace.parent.left = newNode;
            }else{
                toReplace.parent.right = newNode;
            }
            if (newNode != null){
                newNode.parent = toReplace.parent;
            }
            return newNode;
        }

        protected Node createNode(int value){
            return new Node(value);
        }

        /**
         * head树上的最大节点
         * @param head 节点
         * @return 最大节点
         */
        public Node max(Node head){
            if (head == null){
                return null;
            }
            Node cur = head;
            while (cur.right != null){
                cur = cur.right;
            }
            return cur;
        }

        /**
         * head树上的最小节点
         * @param head 节点
         * @return 最小节点
         */
        public Node min(Node head){
            if (head == null){
                return null;
            }
            Node cur = head;
            while (cur.left != null){
                cur = cur.left;
            }
            return cur;
        }

        /**
         * head的后继节点(中序遍历中, 下个大于head的节点):
         * 1. 有右树, 则是右子树上最小的节点
         * 2. 若无右树, 则是往上到达根节点的过程中, 首次是左树时的节点
         *     (即某个树的左树最右节点是当前节点head, 某个树即为结果)
         *
         * @param head 节点
         * @return 后继
         */
        public Node successor(Node head){
            if (head == null){
                return null;
            }
            Node cur = head;
            if (cur.right != null){
                return min(cur.right);
            }
            //cur -> root过程中, 首次是左树时
            Node parent = cur.parent;
            while (parent != null && parent.left != cur){
                cur = parent;
                parent = parent.parent;
            }
            return parent;
        }

        /**
         * head的前驱节点(中序遍历中, 上个小于head的节点):
         * 1. 有左树, 则是左树的最小节点
         * 2. 无左树, 则是往上到root的过程中, 首次是右树的节点
         *    (即某个树的右树最左节点是当前节点head, 某个树即为结果)
         *
         * @param head
         * @return 前驱
         */
        public Node predecessor(Node head){
            if (head == null){
                return null;
            }
            Node cur = head;
            if (cur.left != null){
                return max(cur.left);
            }
            //cur -> root过程中, 首次出现在右树时
            Node parent = cur.parent;
            while (parent != null && parent.right != cur){
                cur = parent;
                parent = parent.parent;
            }
            return parent;
        }

        public int size(){
            return size;
        }
    }

    class AbstractSelfBalanceBinarySearchTree extends AbstractBinarySearchTree{

        /**
         * LL型, 左树的数量太多了, 破坏了平衡
         * 右旋(顺时针旋转), head节点左树的数量大于右树的数量, 且破坏平衡了
         *
         * @param head 要调整的子树头节点
         * @return 调整后新的子树头节点
         */
        protected Node rotateRight(Node head){
            //tmp <=> tmp.parent, head的父节点 成了tmp的父节点
            Node tmp = head.left;
            tmp.parent = head.parent;
            if (tmp.parent == null){
                root = tmp;
            }else if (tmp.parent.left == head){ //潜台词: head不是root
                tmp.parent.left = tmp;
            }else { //潜台词: head不是root, 且head不是head.parent的左孩子
                tmp.parent.right = tmp;
            }
            //head.left <=> head.left.parent, tmp的右节点 成了head的左结点
            head.left = tmp.right;
            if (head.left != null){
                head.left.parent = head;
            }
            //head <=> tmp, head成了 tmp的右节点
            head.parent = tmp;
            tmp.right = head;
            return tmp;
        }

        /**
         * RR型, 右树的数量太多了, 破坏了平衡
         * 左旋(逆时针旋转), head节点右树的数量大于左树的数量, 且破坏平衡了
         *
         * @param head 要调整的子树头节点
         * @return 调整后的子树头节点
         */
        protected Node rotateLeft(Node head){
            //tmp <=> tmp.parent, head的父节点 成了 tmp的父节点
            Node tmp = head.right;
            tmp.parent = head.parent;
            if (tmp.parent == null){
                root = tmp;
            }else if (tmp.parent.left == head){
                tmp.parent.left = tmp;
            }else {
                tmp.parent.right = tmp;
            }
            //head.right <=> head.right.parent, tmp的左结点 成了 head的右节点
            head.right = tmp.left;
            if (head.right != null){
                head.right.parent = head;
            }
            //head <=> parent, head成了 tmp的左节点
            head.parent = tmp;
            tmp.left = head;
            return tmp;
        }

    }

    /**
     * 搜索二叉树, 又叫有序二叉树, 其特点:
     * 1. 任何一棵树的左子树上所有节点的值, 小于此树根节点的值
     * 2. 任何一颗树的右子树上所有节点的值, 大于此树根节点的值
     * 3. 数的左子树和右子树, 也是搜索二叉树
     */
    class BinarySearchTree extends AbstractBinarySearchTree{

    }

    /**
     * AVL树
     * 节点的平衡因子是它的左子树的高度减去它的右子树的高度（有时相反）.
     * 带有平衡因子1, 0或 -1的节点被认为是平衡的. 带有平衡因子 -2或2的节点被认为是不平衡的,并需要重新平衡这个树.
     * 平衡因子可以直接存储在每个节点中, 或从可能存储在节点中的子树高度计算出来
     */
    class AVLTree extends AbstractSelfBalanceBinarySearchTree{

        @Override
        public Node insert(int value) {
            Node node = super.insert(value);
            rebalance((AVLNode) node);
            return node;
        }

        @Override
        protected Node delete(Node node) {
            Node newHead = super.delete(node);
            if (newHead != null){ //新头节点不空
                Node min = newHead.right == null ? newHead: //无右树, 仅从newHead开始往上更新
                        min(newHead.right); //有右树, 需从右树最小节点开始往上更新
                reheight((AVLNode) min);
                rebalance((AVLNode) min);
            }else { //新头节点为null
                reheight((AVLNode) node.parent);
                rebalance((AVLNode) node.parent);
            }
            return newHead;
        }

        /**
         * 从head -> root, 更新路径节点上的所有高度
         * @param head 节点
         */
        private void reheight(AVLNode head) {
            while (head != null){
                updateHeight(head);
                head = (AVLNode) head.parent;
            }
        }

        @Override
        protected Node createNode(int value) {
            return new AVLNode(value);
        }

        /**
         * 尝试从node向上到root的路径中(node -> root), 调整每个节点的高度, 使整颗树重新平衡
         * 注意:
         * 1. 添加节点时, 最多破坏一次平衡
         * 2. 删除节点时, 可能破坏node -> root路径上的所有平衡
         * @param node 从node节点开始
         */
        private void rebalance(AVLNode node) {
            while (node != null){
                int leftH = height(node.left);
                int rightH = height(node.right);
                int balance = rightH - leftH;
                if (balance == 2){
                    if (node.right.right != null){
                        this.rotateLeft(node);
                    }else {
                        this.doubleRotateRightLeft(node);
                    }
                }else if (balance == -2){
                    if (node.left.left != null){
                        this.rotateRight(node);
                    }else {
                       this.doubleRotateLeftRight(node);
                    }
                }else {
                    updateHeight(node);
                }
                node = (AVLNode) node.parent;
            }
        }

        /**
         * RR型, 右树高
         * 左旋并调整 当前节点和左树的高度
         *
         * @param head 节点
         * @return 新的头节点
         */
        @Override
        protected Node rotateLeft(Node head) {
            AVLNode node = (AVLNode) super.rotateLeft(head);
            updateHeight((AVLNode) node.left);
            updateHeight(node);
            return node;
        }

        /**
         * LL型, 左树高
         * 右旋并调整 当前节点和右树的高度
         * @param head 节点
         * @return 新的头部
         */
        @Override
        protected Node rotateRight(Node head) {
            AVLNode node = (AVLNode) super.rotateRight(head);
            updateHeight((AVLNode) node.right);
            updateHeight(node);
            return node;
        }

        /**
         * RL型, 右树高:
         * 先对右树右旋, 整体成RR型, 然后左旋
         * @param head 节点
         * @return 新的头部
         */
        private AVLNode doubleRotateRightLeft(AVLNode head) {
            head.right = this.rotateRight(head.right);
            return (AVLNode) this.rotateLeft(head);
        }

        /**
         * LR型, 左树高:
         * 先左树左旋, 整体成LL型, 然后右旋
         * @param head 节点
         * @return 新的头部
         */
        private AVLNode doubleRotateLeftRight(AVLNode head) {
            head.left = this.rotateLeft(head.left);
            return (AVLNode) this.rotateRight(head);
        }

        /**
         * 根据孩子节点的高度, 更新节点的高度
         * @param node 要更新的节点
         * @return 更新后的节点高度
         */
        private int updateHeight(AVLNode node) {
            node.height = Math.max(height(node.left), height(node.right)) + 1;
            return node.height;
        }

        /**
         * 节点的高度
         * @param node 节点
         * @return -1是空节点的高度
         */
        private int height(Node node) {
            return node == null ? -1 : ((AVLNode) node).height;
        }

        private class AVLNode extends Node{
            int height;
            AVLNode(int value) {
                super(value);
            }
        }

    }

    /**
     * 红黑树:
     *
     * 红黑树是每个节点都带有颜色属性的二叉查找树, 颜色为红色或黑色. 
     * 在二叉查找树强制一般要求以外, 对于任何有效的红黑树我们增加了如下的额外要求：
     *
     * 1. 节点是红色或黑色.
     * 2. 根是黑色.
     * 3. 每个叶子节点都是黑色的空节点（NIL节点）.
     * 4. 每个红色节点必须有两个黑色的子节点. （从每个叶子到根的所有路径上不能有两个连续的红色节点. ）
     * 5. 从任一节点到其每个叶子的所有简单路径都包含相同数目的黑色节点
     *
     * 删除的详细解释: https://zhuanlan.zhihu.com/p/25402654
     */
    class RedBlackTree extends AbstractSelfBalanceBinarySearchTree{
        private final boolean RED = false;
        private final boolean BLACK = true;

        @Override
        public Node insert(int value) {
            Node node = super.insert(value);
            if (node == null){
                return null;
            }
            fixAfterInsert((RBNode) node);
            return node;
        }

        @Override
        protected Node delete(Node head) {
            Node ret = null; //head位置替代节点
            Node toReplace = head; //被替换的且同时破坏平衡的节点
            Node replace = null; //需要从哪个节点开始调整, 重新平衡
            if (head.left == null){
                ret = replace = transplant(head, head.right);
            }else if (head.right == null){
                ret = replace = transplant(head, head.left);
            }else {
                Node successor = toReplace = successor(head);
                if (successor.parent != head){
                    replace = transplant(successor, successor.right);
                    successor.right = head.right;
                    successor.right.parent = successor;
                }
                ret = transplant(head, successor);
                successor.left = head.left;
                successor.left.parent = successor;
                ((RBNode) successor).color = ((RBNode) head).color;
            }
            if (((RBNode) toReplace).color){
                if (replace == null){ //head没孩子时, 调整head本身
                    replace = head;
                }
                fixAfterDelete((RBNode) replace);
            }
            return ret;
        }

        @Override
        protected Node createNode(int value) {
            return new RBNode(value);
        }

        /**
         * 添加新节点后, 调整树结构:
         * 左右子树各有三种情况
         * @param node 节点
         */
        private void fixAfterInsert(RBNode node) {
            RBNode parent = (RBNode) node.parent;
            if (parent == null){
                node.color = BLACK;
                return;
            }
            if (parent.color){
                return;
            }
            while (parent != null && !parent.color){
                RBNode grand = (RBNode) parent.parent;
                if (parent == grand.left){ //1.左树
                    RBNode uncle = (RBNode) grand.right;
                    if (uncle != null && !uncle.color){ //情况1.1: 叔叔节点是红色
                        parent.color = uncle.color = BLACK;
                        grand.color = RED;
                        node = grand;
                        parent = (RBNode) grand.parent;
                    }else { //潜台词: 叔叔节点是黑色
                        if (node == parent.right){ //情况1.2: 叔叔节点黑色, 且为LR型
                            node = parent;
                            parent = (RBNode) rotateLeft(parent);
                        }
                        //情况1.3: 叔叔节点黑色, 且为LL型
                        parent.color = BLACK;
                        grand.color = RED;
                        rotateRight(grand);
                    }
                }else { //2.右树
                    RBNode uncle = (RBNode) grand.left;
                    if (uncle != null && !uncle.color){ //情况2.1: 叔叔节点红色
                        parent.color = uncle.color = BLACK;
                        grand.color = RED;
                        node = grand;
                        parent = (RBNode) grand.parent;
                    }else { //潜台词: 叔叔节点黑色
                        if (node == parent.left){ //情况2.2: 叔叔节点黑色, 且为RL型
                            node = parent;
                            parent = (RBNode) rotateRight(parent);
                        }
                        //情况2.3: 叔叔节点黑色, 且为RR型
                        parent.color = BLACK;
                        grand.color = RED;
                        rotateLeft(grand);
                    }
                }
            }

            ((RBNode) root).color = BLACK;
        }

        /**
         * 删除的详细解释: https://zhuanlan.zhihu.com/p/25402654
         * @param node
         */
        private void fixAfterDelete(RBNode node) {
            while (node != root && node.color){
                if (node.parent.left == node){ //左树
                    RBNode sib = (RBNode) node.parent.right;
                    if (!sib.color){ //情况1.1: 兄弟节点红色(父节点和兄弟孩子节点, 都是黑色)
                        sib.color = BLACK;
                        ((RBNode) node.parent).color = RED;
                        rotateLeft(node.parent);
                        sib = (RBNode) node.parent.right;
                    }
                    if (((RBNode) sib.left).color
                            && ((RBNode) sib.right).color){ //情况1.2: 兄弟节点的两个孩子都是黑色(兄弟节点黑色)
                        sib.color = RED;
                        node = (RBNode) node.parent;
                    }else {
                        if (((RBNode) sib.right).color){ //情况1.3: 兄弟节点右孩子黑色(兄弟节点黑色, 其左孩子红色)
                            sib.color = RED;
                            ((RBNode) sib.left).color = BLACK;
                            rotateRight(sib);
                            sib = (RBNode) node.parent.right;
                        }
                        //情况1.4: 兄弟节点右孩子红色(兄弟节点黑色, 其左孩子黑色)
                        sib.color = ((RBNode) node.parent).color;
                        ((RBNode) node.parent).color = BLACK;
                        rotateLeft(node.parent);
                        node = (RBNode) root;
                    }
                }else { //右树
                    RBNode sib = (RBNode) node.parent.left;
                    if (!sib.color){ //情况2.1:
                        sib.color = BLACK;
                        ((RBNode) node.parent).color = RED;
                        rotateRight(node.parent);
                        sib = (RBNode) node.parent.left;
                    }
                    if (((RBNode) sib.left).color
                            && ((RBNode) sib.right).color){ //情况2.2:
                        sib.color = RED;
                        node = (RBNode) node.parent;
                    }else {
                        if (((RBNode) sib.left).color){ //情况2.3: 兄弟节点左孩子黑色(兄弟节点黑色, 其右孩子红色)
                            sib.color = RED;
                            ((RBNode) sib.right).color = BLACK;
                            rotateLeft(sib);
                            sib = (RBNode) node.parent.left;
                        }
                        //情况2.4: 兄弟节点左孩子红色(兄弟节点黑色, 其右孩子黑色)
                        sib.color = ((RBNode) node.parent).color;
                        ((RBNode) node.parent).color = BLACK;
                        rotateRight(node.parent);
                        node = (RBNode) root;
                    }
                }
            }
            node.color = BLACK;
        }

        private class RBNode extends Node{
            /** true黑色, false红色 */
            boolean color;
            public RBNode(int value) {
                super(value);
            }
        }
    }

    /**
     * 满足s[R]≥s[A],s[B], 同时s[L]≥s[C],S[D]. 
     * 也就是说每个子树的大小大于所有侄子的大小. 
     */
    class SizeBalanceTree{
        
    }

    private class Node{
        int value;
        Node parent;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

}


