/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Node>[] nodes;
    static int nodeCount;
    static int treeWeight = 0;
    static boolean[] visited;
    static int deepNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nodeCount = Integer.parseInt(br.readLine());

        nodes = new ArrayList[nodeCount + 1];

        for (int i = 0; i <= nodeCount; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < nodeCount - 1; i++) {
            String[] t = br.readLine().split(" ");
            int parent = Integer.parseInt(t[0]);
            int child = Integer.parseInt(t[1]);
            int weight = Integer.parseInt(t[2]);
            nodes[parent].add(new Node(child, weight));
            nodes[child].add(new Node(parent, weight));
        }

        visited = new boolean[nodeCount + 1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[nodeCount + 1];
        visited[deepNode] = true; // 1차 dfs에서 가장 깊은 노드
        dfs(deepNode, 0);
        System.out.println(treeWeight);

    }

    public static void dfs(int node, int weight) {
        if (treeWeight < weight) {
            treeWeight = weight; // 트리 지름 더 큰 걸로 업데이트 (최대 지금으로 갱신)
            deepNode = node; // 지름이 더 깊어지는 노드가, 제일 깊은 노드임
        }

        for (Node newNode : nodes[node]) {
            if (!visited[newNode.node2]) {
                visited[newNode.node2] = true;
                // node - node2 정점간의 거리 = weight + newNode.weight
                dfs(newNode.node2, weight + newNode.weight);
            }
        }
    }
}

class Node {
    int node2, weight;

    Node(int node2, int weight) {
        this.node2 = node2;
        this.weight = weight;
    }
}*/
