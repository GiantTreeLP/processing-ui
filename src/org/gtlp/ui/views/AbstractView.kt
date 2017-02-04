package org.gtlp.ui.views

import org.gtlp.ui.PWindow
import org.gtlp.ui.events.*
import org.gtlp.util.math.Vector

/**
 * Abstract view to be extended by proper implementations
 * Handles [IEventListener]s as well as position and size.
 * Uses factory methods to aid developers.
 */
abstract class AbstractView<out T>(override val parent: PWindow) : IView {

    /**
     * A list of event listeners that react to events on this [IView]
     */
    override val listeners = mutableListOf<IEventListener>()

    /**
     * Factory method to set the size
     *
     * @param width
     * @param height
     *
     * @return this
     */
    fun size(width: Number, height: Number): T {
        size = Vector(width, height)

        //Cast is safe
        @Suppress("UNCHECKED_CAST")
        return this as T
    }

    /**
     * Factory method to set the position
     *
     * @param x
     * @param y
     *
     * @return this
     */
    fun pos(x: Number, y: Number): T {
        pos = Vector(x, y)

        //Cast is safe
        @Suppress("UNCHECKED_CAST")
        return this as T
    }

    /**
     * Adds an [MouseEventListener] to this view.
     */
    fun addEventListener(listener: IEventListener) {
        listeners.add(listener)
    }

    /**
     * Removes an [MouseEventListener] added by [addEventListener]
     * Make sure the [MouseEventListener]'s class has a working *equals* method
     */
    fun removeEventListener(listener: MouseEventListener) {
        listeners.remove(listener)
    }

    override fun drawHover() {
        draw()
    }

    override fun onUpdate() {
    }

    override fun handleEvent(event: IWindowEvent) {
        if (event is MouseEvent && parent.hitView(this)) {
            when (event.mouseEventType) {
                MouseEventType.MOUSE_DOWN -> onMouseDown(event)
                MouseEventType.MOUSE_UP -> onMouseUp(event)
                MouseEventType.MOUSE_CLICKED -> onMouseClicked(event)
                MouseEventType.NONE -> onMouseHover(event)
            }
        }
        if (event is KeyEvent) {
            when (event.keyEventType) {
                KeyEventType.KEY_TYPED -> onKeyTyped(event)
                KeyEventType.KEY_DOWN -> onKeyDown(event)
                KeyEventType.KEY_UP -> onKeyUp(event)
            }
        }
    }

    /**
     * Calls all the active [MouseEventListener]s listening for events.
     * Calls [MouseEventListener.mouseMoved].
     * Does not send events that are cancelled.
     *
     * @param event the event that is passed to the listeners.
     */
    fun onMouseHover(event: MouseEvent) {
        listeners.forEach { if (!event.cancelled && it.active && it is MouseEventListener) it.mouseMoved(event) }
    }

    /**
     * Calls all the active [MouseEventListener]s listening for events.
     * Calls [MouseEventListener.mouseClicked].
     * Does not send events that are cancelled.
     *
     * @param event the event that is passed to the listeners.
     */
    fun onMouseClicked(event: MouseEvent) {
        listeners.forEach { if (!event.cancelled && it.active && it is MouseEventListener) it.mouseClicked(event) }
    }

    /**
     * Calls all the active [MouseEventListener]s listening for events.
     * Calls [MouseEventListener.mouseDown].
     * Does not send events that are cancelled.
     *
     * @param event the event that is passed to the listeners.
     */
    fun onMouseDown(event: MouseEvent) {
        listeners.forEach { if (!event.cancelled && it.active && it is MouseEventListener) it.mouseDown(event) }
    }

    /**
     * Calls all the active [MouseEventListener]s listening for events.
     * Calls [MouseEventListener.mouseUp].
     * Does not send events that are cancelled.
     *
     * @param event the event that is passed to the listeners.
     */
    fun onMouseUp(event: MouseEvent) {
        listeners.forEach { if (!event.cancelled && it.active && it is MouseEventListener) it.mouseUp(event) }
    }

    /**
     * Calls all the active [KeyEventListener]s listening for events.
     * Calls [KeyEventListener.keyTyped].
     * Does not send events that are cancelled.
     *
     * @param event the event that is passed to the listeners.
     */
    fun onKeyTyped(event: KeyEvent) {
        listeners.forEach { if (!event.cancelled && it.active && it is KeyEventListener) it.keyTyped(event) }
    }

    /**
     * Calls all the active [KeyEventListener]s listening for events.
     * Calls [KeyEventListener.keyDown].
     * Does not send events that are cancelled.
     *
     * @param event the event that is passed to the listeners.
     */
    fun onKeyDown(event: KeyEvent) {
        listeners.forEach { if (!event.cancelled && it.active && it is KeyEventListener) it.keyDown(event) }
    }

    /**
     * Calls all the active [KeyEventListener]s listening for events.
     * Calls [KeyEventListener.keyUp].
     * Does not send events that are cancelled.
     *
     * @param event the event that is passed to the listeners.
     */
    fun onKeyUp(event: KeyEvent) {
        listeners.forEach { if (!event.cancelled && it.active && it is KeyEventListener) it.keyUp(event) }
    }
}