package chapter2

object RpnCalc {

    val operators = mapOf<String, (Double, Double) -> Double>(
        "+" to Double::plus,
        "-" to Double::minus,
        "*" to Double::times,
        "/" to Double::div
    )

    val funStack = FunctionStack<Double>()

    fun calc(expr : String) :Double =
        expr.split(" ")
            .fold(funStack) { stack, element -> reduce(stack, element) }
            .pop().first

    private fun reduce(stack: FunctionStack<Double>, operator: String): FunctionStack<Double> =
        if (operators.containsKey(operator)) {
            val (b, tempStack) = stack.pop()
            val (a, newStack) = tempStack.pop()
            newStack.push(operation(operator, a, b))
        } else {
            stack.push(operator.toDouble())
        }

    private fun operation(operator: String, a:Double, b:Double): Double =
        operators[operator]?.invoke(a, b) ?: throw IllegalArgumentException("Unknown operator $operator")
}