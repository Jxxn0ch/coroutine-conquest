package section4

import kotlinx.coroutines.*

fun main() = runBlocking {
  val whileJob = launch(Dispatchers.Default) {
//    while(true) {
    while(isActive) {  // 코루틴에 취소가 요청된 순간 isActive는 false가 된다
      println("작업중")
      //yield() // yield를 사용할 경우 취소 요청을 받았는지 확인하기 위해 주기적으로 정지한다
    }
  }
  delay(100L)
  whileJob.cancel()
}