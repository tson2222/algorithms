package algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class TopologicalSort {

    public static void main(String[] args) {
        List<Integer> jobs = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        Integer[][] depsArray = new Integer[][] { { 1, 2 }, { 1, 3 }, { 3, 2 }, { 4, 2 }, { 4, 3 } };
        List<Integer[]> deps = new ArrayList<>();
        fillDeps(depsArray, deps);
        List<Integer> order = topologicalSort(jobs, deps);
        System.out.println(Arrays.toString(order.toArray()));
    }

    static void fillDeps(Integer[][] depsArray, List<Integer[]> deps) {
        for (Integer[] depArray : depsArray) {
            deps.add(depArray);
        }
    }

    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        //create a directed graph with adjacency set graph mechanism (not adjacency matrix!)
        DirectedGraph directedGraph = new DirectedGraph(jobs);
        directedGraph.setDeps(deps);
        return topologicalSort(directedGraph);
    }

    public static List<Integer> topologicalSort(DirectedGraph directedGraph) {
        List<Integer> topologicallySortedList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        for (Node node : directedGraph.nodes) {
            if (node.dependendsOn.isEmpty()) {
                System.out.println("added Node " + node.value + " to queue");
                queue.add(node); //add nodes without any dependecies
            }
        }

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            directedGraph.nodes.remove(current);
            System.out.println("current: " + current.value);
            topologicallySortedList.add(current.value);
            //remove dependency if dependency causing node has been removed
            directedGraph.nodes.forEach(n -> n.dependendsOn.remove(current)); //remove dependency if dep has been removed
            //add nodes that are now freed of dependencies and not already in the queue
            directedGraph.nodes.stream().filter(n -> n.dependendsOn.isEmpty() && !queue.contains(n)).forEach(queue::add);
        }

        if (!directedGraph.nodes.isEmpty()) {
            System.out.println("CYCLE DETECTED!");
            return new ArrayList<>();
        }
        return topologicallySortedList;
    }

    static class DirectedGraph {
        List<Node> nodes = new ArrayList<>();

        public DirectedGraph(final List<Integer> ints) {
            ints.stream().distinct().map(Node::new).forEach(i -> nodes.add(i));
        }

        public void setDeps(List<Integer[]> deps) {
            for (Integer[] dep : deps) {
                Node preReqNode = nodes.stream().filter(node -> node.value.equals(dep[0])).findAny().get();
                Node dependentNode = nodes.stream().filter(node -> node.value.equals(dep[1])).findAny().get();
                dependentNode.addIndegree(preReqNode);
            }

        }

    }

    static class Node {
        Integer value;
        Set<Node> dependendsOn = new HashSet<>();

        public Node(final Integer value) {
            this.value = value;
        }

        public void addIndegree(Node dep) {
            dependendsOn.add(dep);
        }

    }

}
