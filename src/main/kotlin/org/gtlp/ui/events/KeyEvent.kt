package org.gtlp.ui.events

/**
 * An [IWindowEvent] when a key is pressed, released or typed.
 *
 * @param key the key that is pressed.
 * @param keyEventType the type of event (whether the key is pressed down, released or typed).
 * @param cancelled whether this event has been cancelled.
 */
data class KeyEvent(val key: Char, val keyEventType: KeyEventType, override var cancelled: Boolean = false) : IWindowEvent


/**
 * The various types of [KeyEvent]s.
 */
enum class KeyEventType {
    KEY_DOWN,
    KEY_UP,
    KEY_TYPED
}