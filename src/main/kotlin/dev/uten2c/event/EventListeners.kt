package dev.uten2c.event

import kotlin.reflect.KClass

object EventListeners : HashMap<KClass<*>, HashSet<(EventBase) -> Unit>>()