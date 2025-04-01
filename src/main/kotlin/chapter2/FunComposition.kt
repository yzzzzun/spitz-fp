package chapter2

typealias FUN<A,B> = (A) -> B
infix fun <A,B,C> FUN<A,B>.andThen(f: FUN<B,C>): FUN<A,C> = { a: A -> f(this(a)) }
