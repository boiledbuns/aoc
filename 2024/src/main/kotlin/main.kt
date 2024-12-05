private const val COOKIE_ENV_VAR = "cookie"

suspend fun main(args: Array<String>) {
    val cookie = System.getenv(COOKIE_ENV_VAR)
    Day1().main(cookie)
}