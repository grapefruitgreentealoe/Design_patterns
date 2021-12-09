package creational_patterns.proxy.after

/* Subject */
interface Service {
    fun getSomething();
}

/* RealSubject */
class ServiceImpl : Service {
    override fun getSomething() {
        println("무언가 뚜딱뚜딱 만든다.")
    }
}

/* Proxy */
class Proxy : Service {
    private var service: Service? = null;

    override fun getSomething() {
        /* lazy initialization */
        if (service == null)
            service = ServiceImpl()
        var before = System.currentTimeMillis()
        service!!.getSomething()
        println(System.currentTimeMillis() - before)
    }

}

/**
 * 정의
 * - 특정한 객체를 직접 접근하지않고 프록시 객체를 지나 접근하는 것을 말한다. (대리인(프록시)을 거쳐서 사용한다.)
 * 장점
 * - 기존 소스를 수정하지 않고 새로운 기능을 추가할 수 있다.(Open-Close Principle)
 * - 기존 코드는 건들지 않고 해야 할 일을 유지할 수 있다.
 * - ServiceImpl 를 만드는 비용이 크다면 사용하지 않는 메모리를 아껴 실제 사용할 때 생성하여 애플리케이션 구동 시간에 유용할 수 있다.
 * - 새로운 기능, 로깅, 캐싱을 추가할 수 있다.
 * 단점
 * - 기존 코드보다 좀 더 복잡해진다.
 */
fun main() {
    var service = Proxy()
    service.getSomething()
}