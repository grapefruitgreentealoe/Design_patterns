package creational_patterns.singleton.before

class Singleton {}

fun main() {
    var singleton = Singleton()
    var singleton2 = Singleton()
    println(singleton == singleton2)
}
