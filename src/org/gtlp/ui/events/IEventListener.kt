package org.gtlp.ui.events

/**
 * Interface for decorating event listeners and their [active] state.
 */
interface IEventListener {

    /**
     * Flag to indicate whether this event listener is active.
     */
    var active: Boolean
}