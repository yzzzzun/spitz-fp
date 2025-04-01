package chapter2

data class FunctionStack<T> (
    private val elements: List<T> = emptyList()
) {
    fun push(t: T): FunctionStack<T> {
        return FunctionStack(elements + t)
    }

    fun pop(): Pair<T, FunctionStack<T>> {
        val result = elements.last()
        return Pair(result, FunctionStack(elements.dropLast(1)))
    }

    fun size(): Int = elements.size

}