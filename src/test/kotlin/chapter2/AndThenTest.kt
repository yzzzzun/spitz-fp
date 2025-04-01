package chapter2

import strikt.api.expectThat
import strikt.assertions.contains
import strikt.assertions.isEqualTo
import java.net.URI
import kotlin.test.Test

val hof = ::extractListData andThen
        ::fetchListContent andThen
        ::renderHtml andThen
        ::createResponse

fun fetchList(request: Request): Response = hof(request)

class AndThenTest {

    @Test
    fun `concat many functions`() {
        val req = Request("GET", URI("http://example.com/zettai/uberto/mylist"), "")
        val resp = hof(req)

        expectThat(resp) {
            get { status }.isEqualTo(200)
            get { this.body }.contains("<td>uberto buy milk</td>")
            get { this.body }.contains("<td>complete mylist</td>")
            get { this.body }.contains("<td>something else</td>")
        }
    }

}