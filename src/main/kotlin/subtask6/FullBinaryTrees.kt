package subtask6

import java.util.*

class FullBinaryTrees {

    // Complete the following function
    fun stringForNodeCount(count: Int): String {
        // throw NotImplementedError("Not implemented")
        var resultString = "[]"



        if (count == 1) {
            resultString = "[[0]]"
        } else if (count >= 3 && count % 2 != 0) {

            val topologyCreator = FNF()
            topologyCreator.createAllTopologies(count)

            val resultList = java.util.ArrayList<String>()
            val rawArr = arrayOfNulls<String>(count - 1)
            for (i in rawArr.indices) {
                rawArr[i] = ""
            }
            Collections.reverse(FNF.list)
            var counter = 0
            for (i in FNF.list.indices) {
                if (FNF.list[i] == "*") {
                    // System.out.println("worked");
                    var g = i + 1
                    while (g < FNF.list.size) {
                        if (FNF.list[g] == ">") {
                            counter++
                        } else {
                            rawArr[counter - 1] = "${rawArr[counter - 1]}null,"
                            counter = 0
                            g = FNF.list.size
                        }
                        g++
                    }
                    counter = 0
                }
                if (FNF.list[i] == "0") {
                    //  System.out.println("worked");
                    var g = i + 1
                    while (g < FNF.list.size) {
                        if (FNF.list[g] == ">") {
                            counter++
                        } else {
                            rawArr[counter - 1] = "${rawArr[counter - 1]}0,"
                            counter = 0
                            g = FNF.list.size
                        }
                        g++
                    }
                    counter = 0
                }
                if (FNF.list[i] == "|") {
                    val sumStr = StringBuilder()
                    for (w in 0 until rawArr.size - 1) {
                        sumStr.append(rawArr[w])
                    }
                    for (t in rawArr.indices) {
                        rawArr[t] = ""
                    }
                    resultList.add(sumStr.substring(0, sumStr.lastIndexOf("0") + 1))
                }

            }
            FNF.list.clear()
            val sumStr = StringBuilder()
            for (w in 0 until rawArr.size - 1) {
                sumStr.append(rawArr[w])
            }
            for (t in rawArr.indices) {
                rawArr[t] = ""
            }
            resultList.add(sumStr.substring(0, sumStr.lastIndexOf("0") + 1))

            for (str in resultList) {
                if (str.isNotEmpty())
                    resultString = "$resultString,[${str}]"
            }

        }

        return resultString

    }

}

class FNF {
    inner class Node(var data: Int) {
        var left: Node?
        var right: Node? = null
        override fun toString(): String {
            return data.toString()
        }

        fun clone(): Node {
            val nNode = Node(data)
            if (left != null) nNode.left = left!!.clone()
            if (right != null) nNode.right = right!!.clone()
            return nNode
        }

        init {
            left = right
        }
    }

    fun createAllTopologies(n: Int) {
        if (n % 2 == 0) return
        val topologies: MutableMap<Int, MutableList<Node>> =
            HashMap()
        topologies[1] = java.util.ArrayList()
        topologies[1]!!.add(Node(1))
        run {
            var i = 3
            while (i <= n) {
                val list: MutableList<Node> = java.util.ArrayList()
                var j = 1
                while (j < i) {
                    val left: List<Node> = topologies[j]!!
                    val right: List<Node> = topologies[i - j - 1]!!
                    list.addAll(generateAllCombinations(left, right))
                    j += 2
                }
                topologies[i] = list
                i += 2
            }
        }
        val result: List<Node> = topologies[n]!!
        for (i in result.indices) {
            printTree(result[i], 0)
            //  System.out.println("-----------------------------");
            list.add("|")
        }
    }

    private fun generateAllCombinations(
        left: List<Node>,
        right: List<Node>
    ): List<Node> {
        val list: MutableList<Node> = java.util.ArrayList()
        for (i in left.indices) {
            for (j in right.indices) {
                val nNode = Node(1)
                nNode.left = left[i].clone()
                nNode.right = right[j].clone()
                list.add(nNode)
            }
        }
        return list
    }

    protected fun printTree(nNode: Node?, pos: Int) {
        if (nNode == null) {
            for (i in 0 until pos) {
                //    System.out.print("\t");
                list.add(">")
            }
            list.add(">")
            list.add("*")
            // System.out.println("*");
            return
        }
        printTree(nNode.right, pos + 1)
        for (i in 0 until pos) {
            //  System.out.print("\t");
            list.add(">")
        }
        list.add(">")
        list.add("0")
        // System.out.println(nNode.data);
        printTree(nNode.left, pos + 1)
    }

    companion object {
        var list = java.util.ArrayList<String?>()
    }
}

