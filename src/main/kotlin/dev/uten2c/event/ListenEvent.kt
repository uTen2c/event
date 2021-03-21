package dev.uten2c.event

/**
 * Listen to the event
 */
inline fun <reified T : EventBase> listenEvent(noinline handler: (T) -> Unit) {
    EventListeners[T::class] = EventListeners.getOrDefault(T::class, HashSet()).apply {
        @Suppress("UNCHECKED_CAST")
        add(handler as (EventBase) -> Unit)
    }
}