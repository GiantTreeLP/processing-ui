package org.gtlp.ui.events

/**
 * An adapter to handle key events.
 * Fills all methods from [KeyEventListener] with empty ones.
 */
open class KeyEventAdapter : KeyEventListener() {
    override fun keyDown(event: KeyEvent) {
    }

    override fun keyUp(event: KeyEvent) {
    }

    override fun keyTyped(event: KeyEvent) {
    }
}