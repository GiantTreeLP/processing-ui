package org.gtlp.ui.listeners

import org.gtlp.ui.events.MouseEvent

/**
 * Adapter for [MouseEventListener]
 * Fills all events from [MouseEventListener] with empty methods.
 */
open class MouseEventAdapter(priority: Priority = Priority.NORMAL) : MouseEventListener() {
    override fun mouseMoved(event: MouseEvent) {
    }

    override fun mouseClicked(event: MouseEvent) {
    }

    override fun mouseDown(event: MouseEvent) {
    }

    override fun mouseUp(event: MouseEvent) {
    }

    override fun mouseExited(event: MouseEvent) {
    }

    override fun mouseEntered(event: MouseEvent) {
    }

    override fun mouseWheelMoved(event: MouseEvent) {
    }

    override fun mouseDragged(event: MouseEvent) {
    }
}