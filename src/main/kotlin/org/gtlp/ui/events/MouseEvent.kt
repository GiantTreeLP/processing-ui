package org.gtlp.ui.events

import org.gtlp.util.math.Vector
import processing.core.PApplet

/**
 * An [IWindowEvent] when the mouse is used.
 *
 * @param pos the position where this event occurred.
 * @param mouseEventType the type of this event.
 * @param mouseButton the button used to create this event.
 * @param cancelled whether this event has been cancelled.
 */
data class MouseEvent(val pos: Vector, val mouseEventType: MouseEventType, var mouseButton: MouseButton, override var cancelled: Boolean = false) : IWindowEvent

enum class MouseEventType {
    MOUSE_DOWN,
    MOUSE_UP,
    MOUSE_CLICKED,
    NONE
}

enum class MouseButton(val button: Int) {
    NONE(0),
    LEFT(PApplet.LEFT),
    RIGHT(PApplet.RIGHT),
    MIDDLE(PApplet.CENTER);

    companion object {
        fun forInt(num: Int): MouseButton {
            return values().firstOrNull { it.button == num } ?: NONE
        }
    }
}