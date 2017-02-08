package org.gtlp.ui.listeners

import org.gtlp.ui.PWindow
import org.gtlp.ui.events.KeyEvent
import org.gtlp.ui.handlers.ViewHandler

/**
 * Abstract class for key event listeners.
 * Handles common key events sent by Processing's event handling API.
 * Events are called by a [PWindow]'s [ViewHandler]
 */
abstract class KeyEventListener : IEventListener {

    override var priority = Priority.NORMAL

    override var active = true

    /**
     * Method to handle a key being pressed down.
     *
     * @param event the event that is called
     */
    abstract fun keyDown(event: KeyEvent)

    /**
     * Method to handle a key being released.
     *
     * @param event the event that is called
     */
    abstract fun keyUp(event: KeyEvent)

    /**
     * Method to handle a key being pressed down and then released aka. typed.
     *
     * @param event the event that is called
     */
    abstract fun keyTyped(event: KeyEvent)
}