package org.gtlp.ui.views.buttons

import org.gtlp.ui.PWindow
import org.gtlp.ui.events.KeyEvent
import org.gtlp.ui.events.MouseButton
import org.gtlp.ui.events.MouseEvent
import org.gtlp.ui.events.MouseEventType
import org.gtlp.ui.handlers.IKeyEventHandler
import org.gtlp.ui.handlers.IMouseEventHandler
import org.gtlp.ui.listeners.KeyEventAdapter
import org.gtlp.ui.listeners.MouseEventAdapter
import org.gtlp.ui.views.AbstractView
import org.gtlp.util.math.Vector
import processing.core.PConstants

/**
 * Abstract class for defining a button.
 * Calls [onMouseClicked] when the user is hovering over it and the [acceleratorKey] is pressed.
 * The implementation is responsible for proper drawing.
 */
abstract class AbstractButton<out T>(parent: PWindow) : AbstractView<T>(parent), IMouseEventHandler, IKeyEventHandler {

    /**
     * The key that accelerates pressing this button.
     */
    var acceleratorKey = PConstants.ENTER

    /**
     * Flag to determine whether the button is pressed down or not.
     */
    var pressed = false

    init {
        addEventListener(object : KeyEventAdapter() {
            override fun keyTyped(event: KeyEvent) {
                if (event.key == acceleratorKey && parent.hitView(this@AbstractButton)) {
                    onMouseClicked(MouseEvent(Vector(parent.mouseX, parent.mouseY), MouseEventType.MOUSE_CLICKED, MouseButton.LEFT))
                }
            }

            override fun keyDown(event: KeyEvent) {
                if (event.key == acceleratorKey && parent.hitView(this@AbstractButton)) {
                    pressed = true
                }
            }

            override fun keyUp(event: KeyEvent) {
                if (event.key == acceleratorKey) {
                    pressed = false
                }
            }
        })
        addEventListener(object : MouseEventAdapter() {
            override fun mouseDown(event: MouseEvent) {
                pressed = true
            }

            override fun mouseUp(event: MouseEvent) {
                pressed = false
            }
        })
    }

}