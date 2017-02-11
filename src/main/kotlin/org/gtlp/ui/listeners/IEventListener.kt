package org.gtlp.ui.listeners

/**
 * Interface for decorating event listeners and their [active] state.
 */
interface IEventListener {

    /**
     * Flag to indicate whether this event listener is active.
     */
    var active: Boolean

    /**
     * The priority of this event listener
     * Higher priority event listeners get executed first to get a
     * chance to cancel events before any other listener can react.
     */
    var priority: Priority
}

enum class Priority(val level: Int) {
    LOWEST(-2),
    LOW(-1),
    NORMAL(0),
    HIGH(1),
    HIGHEST(2),
    CRITICAL(Int.MAX_VALUE)
}