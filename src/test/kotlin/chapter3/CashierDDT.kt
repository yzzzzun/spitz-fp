package chapter3

import chapter3.Item.*
import com.ubertob.pesticide.core.DDT
import com.ubertob.pesticide.core.DomainDrivenTest

class CashierDDT : DomainDrivenTest<CashierActions>(allActions){
    val alice by NamedActor(::CustomerActor)

    @DDT
    fun `customer can buy an item`() = ddtScenario {
        val prices = mapOf(MILK to 1.0, CARROT to 0.5)
        setUp { setupPrices(prices) }
            .thenPlay(
                alice.`can add #qty of #item`(4, CARROT),
                alice.`can add #qty of #item`(3, MILK),
                alice.`check total is #total`(5.0)
            )


    }
}