package chapter2

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class FunctionStackTest {
    @Test
    fun `push into the stack`() {
        val stack1= FunctionStack<Char>()
        val stack2 = stack1.push('A')
        expectThat(stack1.size()).isEqualTo(0)
        expectThat(stack2.size()).isEqualTo(1)
    }

    @Test
    fun `push push pop`() {
        val (b,stack) = FunctionStack<Char>()
            .push('A')
            .push('B')
            .pop()
        expectThat(stack.size()).isEqualTo(1)
        expectThat(b).isEqualTo('B')
    }
}