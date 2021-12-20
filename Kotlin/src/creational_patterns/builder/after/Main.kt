package creational_patterns.builder.after

/* 기본적으로 named argument 제공 */
data class User (
    var id : String,
    var password : String,
    var email : String,
    var name : String,
    var age : Int
) {}

fun main() {
    var user = User(
        id = "id",
        password = "password",
        email = "email@email.com",
        name = "tester",
        age = 26
    )
    println(user.toString())
}