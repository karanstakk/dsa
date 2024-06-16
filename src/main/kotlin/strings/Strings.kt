package strings


fun main() {

    println(firstUniqChar("dddccdbba"))
}

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

// Is Unique : Chapt:1.1

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
