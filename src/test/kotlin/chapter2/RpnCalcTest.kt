package chapter2

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo


class RpnCalcTest {
    @Test
    fun `calculation test`() {
        val res1 = calc("4 5 +")
        val res2 = calc("6 2 /")
        val res3 = calc("5 6 2 1 + / *")
        val res4 = calc("2 5 * 4 + 3 2 * 1 + /")
        expectThat(res1).isEqualTo(9)
        expectThat(res2).isEqualTo(3)
        expectThat(res3).isEqualTo(10)
        expectThat(res4).isEqualTo(2)
    }
}