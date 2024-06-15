package array

import java.util.*

class FirstLastPos {
    var arrayList = arrayListOf<Int>()

    fun searchRange(nums: IntArray, target: Int): IntArray {
        var left = 0
        var right = nums.size - 1
        search(left, right, target, nums)
        return arrayList.toIntArray()
    }

    fun search(startIndex: Int, endIndex: Int, target: Int, nums: IntArray) {
        var left = startIndex
        var right = endIndex

        while (left <= right) {

            val mid = (left + right) / 2

            if (nums[mid] < target) {
                left = mid + 1
            } else if (nums[mid] > target) {
                right = mid - 1
            } else {
                
            }


            return
        }
    }
}

fun main(args: Array<String>) {
    val intArray = intArrayOf(1, 2, 4, 5, 6, 6, 8)
    var result = FirstLastPos().searchRange(intArray, 6)
    println(result.contentToString())
}