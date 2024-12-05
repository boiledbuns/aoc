import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*


class Day1 {

    suspend fun main(cookie: String) {
        val client = HttpClient(CIO)
        val response: HttpResponse = client.get("https://adventofcode.com/2024/day/1/input") {
            headers {
                append(HttpHeaders.Cookie, cookie)
            }
        }

        println(response.bodyAsText())

        val leftList = ArrayList<Int>()
        val rightList = ArrayList<Int>()
        response.bodyAsText().split("\n")
            .forEach {
                if (it.isNotEmpty()) {
                    val splitVals = it.split("   ")
                    leftList.add(splitVals[0].toInt())
                    rightList.add(splitVals[1].toInt())
                }
            }

        leftList.sort()
        rightList.sort()

        var sumOfDiffs = 0
        for (i in 0..<leftList.size) {
           sumOfDiffs += Math.abs(leftList[i] - rightList[i])
        }

        println("left: $leftList")
        println("right: $rightList")
        println("sumOfDiffs: $sumOfDiffs")
    }

}