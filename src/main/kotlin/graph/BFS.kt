package graph

class Graph(private val vertices: Int) {
    private var adjList : ArrayList<ArrayList<Int>> = arrayListOf<ArrayList<Int>>()

    init {
        for (i in 0..vertices) {
            adjList.add(arrayListOf())
        }
    }

    fun addEdge(u: Int, v: Int) {
        adjList[u].add(v)
    }

    fun bfs(startNode: Int) {

        val queue : ArrayDeque<Int> = ArrayDeque(vertices)
        queue.addLast(startNode)

        val visited = BooleanArray(vertices) {false}
        visited[startNode] = true

        while (!queue.isEmpty()) {

            val currentNode = queue.removeFirst()
            println("$currentNode ")

            for (neighbour in adjList[currentNode]) {
                if (!visited[neighbour]) {
                    queue.addLast(neighbour)
                    visited[neighbour] = true
                }
            }
        }
    }


}

fun main(args: Array<String>) {

    val graph = Graph(5)
    graph.addEdge(0,1)
    graph.addEdge(0,2)
    graph.addEdge(1,3)
    graph.addEdge(1,4)
    graph.addEdge(2,4)

    graph.bfs(0)
}