package creational_patterns.singleton.after

object Singleton {}

class Singleton2 private constructor(){
    companion object {
        private var instance: Singleton2? = null

        fun getInstance(): Singleton2 {
            return instance ?: synchronized(this) {
                instance ?: Singleton2().also {
                    instance = it
                }
            }
        }
    }
}

fun main() {
    var singleton = Singleton
    var singleton2 = Singleton
    println(singleton == singleton2)

    var singleton3 = Singleton2.getInstance()
    var singleton4 = Singleton2.getInstance()
    print(singleton3 == singleton4)
}