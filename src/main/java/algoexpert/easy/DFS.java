package algoexpert.easy;

import java.util.*;

class DFS {

    public static void main(String[] args) {
// Order should be A, B, X, D, C, M, Y, T  (left to right, DEPTH FIRST)
                // A \\
              // B D Y \\
            //  X  C  T \\
          //       M      \\

        DFS.Node test1 = new DFS.Node("A");
        test1.addChild("B").addChild("D").addChild("Y");
        test1.children.get(0).addChild("X");
        test1.children.get(1).addChild("C");
        test1.children.get(1).addChild("M");
        test1.children.get(2).addChild("T");
        System.out.println(test1.children.get(1).children.get(0).name);
        System.out.println(test1.depthFirstSearch(new ArrayList<>()));

    }

    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            array.add(this.name);
            for (int i = 0; i < children.size(); i++) {
                children.get(i).depthFirstSearch(array);
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            // does NOT return the child node! But the current Node.
            return this;
        }
    }

}