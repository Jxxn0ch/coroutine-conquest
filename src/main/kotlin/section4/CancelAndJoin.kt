package section4

import kotlinx.coroutines.*


fun main() = runBlocking {
  val longJob = launch(Dispatchers.Default) {
    delay(1000L) // 만약 Thread.sleep과 같은 기능을 사용하면, 코루틴에서 취소 요청을 받아도 취소되지 않음
    println("longJob 코루틴의 동작")
  }
//  longJob.cancel()
  longJob.cancelAndJoin() // longJob 취소 요청 후 취소 완료될 때까지 호출 코루틴 일시 중단
  executeAfterJobCancelled()
}

fun executeAfterJobCancelled() {
  println("longJob 코루틴 취소 후 실행되야 하는 동작")
}