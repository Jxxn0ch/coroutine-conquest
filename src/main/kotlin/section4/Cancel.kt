package section4

import kotlinx.coroutines.*

fun main() = runBlocking {
  val startTime = System.currentTimeMillis()
  val longJob = launch(Dispatchers.Default) {
    repeat(10) { repeatTime ->
      delay(1000L)
      println("[${getElapsedTime(startTime)}] 반복횟수 $repeatTime")
    }
  }
  delay(2500L)
  longJob.cancel()
}

fun getElapsedTime(startTime: Long): String {
  return "지난시간 : ${System.currentTimeMillis() - startTime}밀리초"
}

