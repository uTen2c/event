package dev.uten2c.event

abstract class EventBase {

    /**
     * Calling an event
     * @return False if the event is canceled
     */
    fun callEvent(): Boolean {
        val set = EventListeners.getOrDefault(this::class, HashSet())
        for (handler in set) {
            handler(this)
        }
        EventListeners[this::class] = set
        return if (this is EventBaseCancellable) !isCancelled else true
    }
}