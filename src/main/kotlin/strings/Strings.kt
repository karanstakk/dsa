package strings

import java.util.PriorityQueue
import kotlin.text.StringBuilder


// LC:387
fun firstUniqChar(string: String): Int {


    val index = -1

    if (string.length == 1) {
        return 0;
    }

    if (string.isEmpty()) {
        return -1
    }

    for(char in string) {
        val currentIndex = string.indexOf(char)
        val lastIndex = string.indexOfLast { it == char }

        if(currentIndex == lastIndex) {
            return index
        }
    }


    // another soultion
//    val imap = mutableMapOf<Char, Int>()
//
//    for (char in string) {
//         if (imap.containsKey(char)) {
//             imap[char] = (imap[char] ?: 0 )+ 1
//         } else {
//             imap[char] = 1
//         }
//    }
//
//
//
//    for (key in imap.keys) {
//
//        if (imap[key] == 1) {
//            return string.indexOfFirst { it == key }
//        }
//    }

    return index
}

// Is Unique : Chap:1.1

fun isUnique(str : String) : Boolean {

    if (str.length >128) {
        return false
    }

    if (str.isEmpty() || str.length == 1) {
        return true
    }

    val boolArray = BooleanArray(128)

    for(char in str) {

        val index = char.code
        if (boolArray[index]) {
            return false
        }
        boolArray[index] = true
    }

    return true
}

// LC:567,
// Is s1 permutation of s2
fun checkInclusion(s1: String, s2: String): Boolean {

    if (s2.length < s1.length) {
        return false
    }

    val window = s1.length

    val sortedS1 = s1.toCharArray().sorted().toString()

    print(sortedS1)

    for(i in s2.indices) {

        println(i)
        val endIndex = i + window

        if( i + window > s2.length) {
            return false
        }

        val substring = s2.substring(i, endIndex).toCharArray().sorted().toString()

        println(substring)

        if (sortedS1 == substring)
            return true

    }

    return false
}

// Chap:1.2
// Is s1 permutation of s2
fun checkPermutation(s1: String, s2: String): Boolean {

    if (s1.length != s2.length) {
        return false
    }
    return s1.toSortedSet() == s2.toSortedSet()
}

fun exist(board: Array<CharArray>, word: String): Boolean {
    val row = board.size
    val col = board[0].size
    return hasValue(0,0, 0,  board, word, row, col)
}

fun hasValue(i : Int, j: Int, pos : Int, board: Array<CharArray>, word: String, row: Int, col : Int) : Boolean {

    if ( i < 0 || j<0 || i>=row || j>=col) {
        println("out of bound")
        return false
    }

    val char = word[pos]

    if (board[i][j] == char && pos == word.length-1) {
        return true
    }

    println("here i "+i)
    println("here j "+j)
    println(char)
    println(board[i][j])

    if (board[i][j] == char) {

        println("if i " + i)
        println("if j " + j)
        return hasValue(i + 1, j, pos + 1, board, word, row, col) ||
                hasValue(i, j + 1, pos + 1, board, word, row, col) ||
                hasValue(i, j - 1, pos + 1, board, word, row, col) ||
                hasValue(i - 1, j, pos + 1, board, word, row, col)
    } else if(j+1 < col  && pos == 0) {
        return hasValue(i, j+1,  pos, board, word, row, col)
    } else if (i+1 < row && pos == 0 ) {
        return hasValue(i+1, j, pos,  board, word ,row, col)
    }
    return false
}

fun urlify(string: String, trueLength: Int) : String {
    val result = StringBuilder()

    for (i in string.indices) {
        if (string[i] == ' ') {
            result.append("%20")
        } else {
            result.append(string[i])
        }
    }
    return result.toString()
}

fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {

    if (hand.isEmpty() || hand.size < groupSize || hand.size%groupSize != 0)
        return false

    if (groupSize == 1 ) {
        return true
    }

    val list = hand.sorted().toCollection(ArrayList())

    while (list.size > 0) {

        val currentNum = list[0]
        list.removeAt(0)

        for (i in currentNum+1 until  currentNum+groupSize ) {
             if (!list.remove(i)) {
                 return false
             }
        }
    }
    return true
}

fun isConsecutive(prev: Int, current : Int): Boolean {
    return current - prev == 1
}

fun main() {

//    println(firstUniqChar("dddccdbba"))
//
//    println(isUnique("abca"))
//
//    println(checkPermutation("abc", "bac"))

//   val array = arrayOf(
//        charArrayOf('A', 'B', 'C', 'E'),
//        charArrayOf('S', 'F', 'C', 'S'),
//        charArrayOf('A', 'D', 'E', 'E')
//    )

//    println(exist(array, "ABCB"))
      println(isNStraightHand(intArrayOf(1,2,3,6,2,3,4,7,8),3))
}