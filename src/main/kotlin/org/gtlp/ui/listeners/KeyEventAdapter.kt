package org.gtlp.ui.listeners

import org.gtlp.ui.events.KeyEvent

/**
 * An adapter to handle key events.
 * Fills all methods from [KeyEventListener] with empty ones.
 */
open class KeyEventAdapter(priority: Priority = Priority.NORMAL) : KeyEventListener() {
    override fun keyDown(event: KeyEvent) {
    }

    override fun keyUp(event: KeyEvent) {
    }

    override fun keyTyped(event: KeyEvent) {
    }
}