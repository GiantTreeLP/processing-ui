package org.gtlp.ui.listeners

import org.gtlp.ui.PWindow
import org.gtlp.ui.events.MouseEvent
import org.gtlp.ui.handlers.ViewHandler

/**
 * Abstract class for mouse event listeners.
 * Handles common mouse events sent by Processing's event handling API.
 * Events are called by a [PWindow]'s [ViewHandler]
 */
abstract class MouseEventListener : IEventListener {

    override var priority = Priority.NORMAL

    override var active = true
    /**
     * Method to handle the mouse moving over a view.
     *
     * @param event the event that has been called
     */
    abstract fun mouseMoved(event: MouseEvent)

    /**
     * Method to handle the mouse clicking on a view.
     *
     * @param event the event that has been called
     */
    abstract fun mouseClicked(event: MouseEvent)

    /**
     * Method to handle the mouse pressing down on a view.
     *
     * @param event the event that has been called
     */
    abstract fun mouseDown(event: MouseEvent)

    /**
     * Method to handle the mouse being released on a view.
     *
     * @param event the event that has been called
     */
    abstract fun mouseUp(event: MouseEvent)

    /**
     * Method to handle the mouse exiting the window.
     *
     * @param event the event that has been called
     */
    abstract fun mouseExited(event: MouseEvent)

    /**
     * Method to handle the mouse entering the window.
     *
     * @param event the event that has been called
     */
    abstract fun mouseEntered(event: MouseEvent)

    /**
     * Method to handle the mouse wheel being rotated while hovering over a view.
     *
     * @param event the event that has been called
     */
    abstract fun mouseWheelMoved(event: MouseEvent)

    /**
     * Method to handle the mouse being moved while being held down.
     *
     * @param event the event that has been called
     */
    abstract fun mouseDragged(event: MouseEvent)
}