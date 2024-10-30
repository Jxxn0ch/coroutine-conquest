package section4

import kotlinx.coroutines.*

fun main() {
//  new()
  active()
//  completed()
//  cancelling()
//  cancelled()
}

private fun new() = runBlocking {
  val job = launch(start = CoroutineStart.LAZY) {
    delay(1000L)
  }
  println(job)
  printJobState(job)
}

private fun completed() = runBlocking {
  val job = launch {
    delay(1000L)
  }
  job.join()
  println(job)
  printJobState(job)
}

private fun active() = runBlocking {
  val job = launch(Dispatchers.IO) {
    delay(1000L)
  }
  println(job)
  printJobState(job)
}

private fun cancelling() = runBlocking {
  val whileJob = launch(Dispatchers.IO) {
    while (true) {
      println("작업중")
    }
  }
  whileJob.cancel()
  println(whileJob)
  printJobState(whileJob)
}

private fun cancelled() = runBlocking {
  val whileJob = launch(Dispatchers.IO) {
    while (isActive) {
      println("작업중")
    }
  }
  whileJob.cancelAndJoin()
  println(whileJob)
  printJobState(whileJob)
}

fun printJobState(job: Job) {
  println(
    """
      job state
        isActive: ${job.isActive}
        isCancelled: ${job.isCancelled}
        isCompleted: ${job.isCompleted}
    """.trimIndent()
  )
}