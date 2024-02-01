package org.example

import kotlin.reflect.KClass

class MyMutableIntList {
    private var a = intArrayOf()
    private var nextSlot = 0

    /**
     * Grow the array by a multiplicative factor
     */
    private fun growArray() {
        a = if (a.isEmpty()) {
            IntArray(1)
        } else {
            IntArray(a.size*2)
        }
    }

    /**
     * Add [element] to the end of the list
     */
    fun add(element: Int) {
        if (nextSlot >= a.size) {
            growArray()
        }
        a[nextSlot] = element
        nextSlot++
    }

    /**
     * Remove all elements from the list
     */
    fun clear() {
        nextSlot = 0
    }

    /**
     * @return the size of the list
     */
    fun size(): Int {
        return nextSlot
    }

    /**
     * @parameter index the index to return
     * @return the element at [index]
     */
    operator fun get(index: Int):Int {
        return a[index]
    }

    /**
     * Store [value] at position [index]
     * @parameter index the index to set
     * @parameter value to store at [index]
     */
    operator fun set(index: Int, value: Int) {
        a.set(index, value)
    }

}