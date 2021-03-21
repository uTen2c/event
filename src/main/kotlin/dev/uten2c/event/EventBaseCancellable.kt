package dev.uten2c.event

abstract class EventBaseCancellable(var isCancelled: Boolean = false) : EventBase()
