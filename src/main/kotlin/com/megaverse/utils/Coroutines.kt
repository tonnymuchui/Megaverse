package com.megaverse.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlin.coroutines.CoroutineContext

class Coroutines(
  private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO),
  private val coroutineContext: CoroutineContext = Dispatchers.Default,
  val batchSize: Int = 5, // Default batch size
  val delayInSeconds: Long = 2 // Default delay in seconds
) {

  fun async(func: suspend CoroutineScope.() -> Unit) = coroutineScope.async(coroutineContext) {
    func()
  }

  suspend fun delay() {
    delay(delayInSeconds * 2)
  }
}