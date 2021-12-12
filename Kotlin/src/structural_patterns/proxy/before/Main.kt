package creational_patterns.proxy.before

open class Service {
    open fun getSomething() {
        /* 앞뒤로 내용 추가해야됨 */
        println("무언가 뚜딱뚜딱 만든다.")
        /* 앞뒤로 내용 추가해야됨 */
    }
}

/* 상속은 하나만 가능하고 final 이면 상속받지 못하는 여러 제약사항이 존재하기 때문에 유연하지 못하다. */
class ServiceProxy : Service() {
    override fun getSomething() {
        val before = System.currentTimeMillis()
        super.getSomething()
        println(System.currentTimeMillis() - before)
    }
}

fun main() {
    var service = Service()
    service.getSomething()

    var serviceProxy = ServiceProxy()
    serviceProxy.getSomething()
}