package org.gtlp.ui.events

import org.gtlp.ui.PWindow

/**
 * Interface to mark an event that occurs on a [PWindow].
 */
interface IWindowEvent {

    /**
     * Flag to indicate that an event has been cancelled.
     */
    var cancelled: Boolean
}