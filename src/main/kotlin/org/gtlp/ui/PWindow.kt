package org.gtlp.ui

import org.gtlp.ui.events.*
import org.gtlp.ui.handlers.IMouseEventHandler
import org.gtlp.ui.handlers.ViewHandler
import org.gtlp.ui.listeners.IEventListener
import org.gtlp.ui.listeners.KeyEventListener
import org.gtlp.ui.listeners.MouseEventAdapter
import org.gtlp.ui.listeners.MouseEventListener
import org.gtlp.ui.views.IView
import org.gtlp.ui.views.buttons.AbstractButton
import org.gtlp.util.math.Vector
import processing.core.PApplet

/**
 * Class to hold a more advanced window with support for [IView]s and [IMouseEventHandler]
 * Uses [ViewHandler] for exactly those features
 */
abstract class PWindow : PApplet(), IView {

    @Suppress("LeakingThis")
    private val viewHandler = ViewHandler(this)

    override var visible = true

    override var tag: Any? = null
    override val listeners = mutableListOf<IEventListener>()

    @Suppress("LeakingThis")
    override val parent = this

    override var pos = Vector.NAN

    override var size = Vector.NAN

    override fun drawHover() {
        draw()
    }

    override fun handleEvent(event: IWindowEvent) {
        when (event) {
            is MouseEvent -> when (event.mouseEventType) {
                MouseEventType.MOUSE_DOWN -> listeners.forEach { listeners.forEach { if (!event.cancelled && it.active && it is MouseEventListener) it.mouseDown(event) } }
                MouseEventType.MOUSE_UP -> listeners.forEach { if (!event.cancelled && it.active && it is MouseEventListener) it.mouseUp(event) }
                MouseEventType.MOUSE_CLICKED -> listeners.forEach { if (!event.cancelled && it.active && it is MouseEventListener) it.mouseClicked(event) }
                MouseEventType.NONE -> listeners.forEach { if (!event.cancelled && it.active && it is MouseEventListener) it.mouseMoved(event) }
            }
            is KeyEvent -> when (event.keyEventType) {
                KeyEventType.KEY_TYPED -> listeners.forEach { if (!event.cancelled && it.active && it is KeyEventListener) it.keyTyped(event) }
                KeyEventType.KEY_DOWN -> listeners.forEach { if (!event.cancelled && it.active && it is KeyEventListener) it.keyDown(event) }
                KeyEventType.KEY_UP -> listeners.forEach { if (!event.cancelled && it.active && it is KeyEventListener) it.keyUp(event) }
            }
        }
    }

    override fun onUpdate() {}

    final override fun mousePressed(nativeEvent: processing.event.MouseEvent) {
        viewHandler.handleEvent(MouseEvent(Vector(mouseX, mouseY), MouseEventType.MOUSE_DOWN, MouseButton.forInt(mouseButton)))
    }

    final override fun mouseReleased(nativeEvent: processing.event.MouseEvent) {
        viewHandler.handleEvent(MouseEvent(Vector(mouseX, mouseY), MouseEventType.MOUSE_UP, MouseButton.forInt(mouseButton)))
    }

    final override fun mouseClicked(nativeEvent: processing.event.MouseEvent) {
        viewHandler.handleEvent(MouseEvent(Vector(mouseX, mouseY), MouseEventType.MOUSE_CLICKED, MouseButton.forInt(mouseButton)))
    }

    final override fun mouseMoved(nativeEvent: processing.event.MouseEvent) {
        viewHandler.handleEvent(MouseEvent(Vector(mouseX, mouseY), MouseEventType.NONE, MouseButton.forInt(mouseButton)))
    }

    final override fun keyPressed(event: processing.event.KeyEvent) {
        viewHandler.handleEvent(KeyEvent(event.key, KeyEventType.KEY_DOWN))
    }

    final override fun keyReleased(event: processing.event.KeyEvent) {
        viewHandler.handleEvent(KeyEvent(event.key, KeyEventType.KEY_UP))
    }

    final override fun keyTyped(event: processing.event.KeyEvent) {
        viewHandler.handleEvent(KeyEvent(event.key, KeyEventType.KEY_TYPED))
    }

    /**
     * Method that is called prior to creating Processing's window.
     * Set the size of your sketch here.
     * Abstract to force an override on the developers side.
     */
    abstract override fun settings()

    override fun setup() {
        viewHandler.add(this)
        listeners.add(object : MouseEventAdapter() {
            override fun mouseUp(event: MouseEvent) {
                viewHandler.views.filter { it is AbstractButton<*> }.forEach {
                    it as AbstractButton<*>
                    it.pressed = false
                }
            }
        })
    }

    /**
     * Handles the drawing of [IView]s
     *
     * Remember to call `super.draw()` at the end of your [draw] method.
     * If you don't want to do that, use [onDraw].
     *
     * @see PApplet.draw
     * @see onDraw
     */
    override fun draw() {
        viewHandler.handleEvent(MouseEvent(Vector.NAN, MouseEventType.NONE, MouseButton.NONE))
        viewHandler.drawViews { it.pos.z < 0 }
        onDraw()
        viewHandler.drawViews { it.pos.z >= 0 }
    }

    /**
     * Is called whenever the [draw] method is called.
     * You can use this method to draw before the [IView]s are drawn.
     *
     * For more control over drawing on your [PApplet] override [draw].
     *
     * @see draw
     */
    open fun onDraw() {
    }

    /**
     * Used to add [IView]s to this window's [viewHandler]
     *
     * @param view the [IView] to add
     */
    fun add(view: IView) {
        viewHandler.add(view)
    }

    /**
     * Removes an [IView] form this window's [viewHandler]
     *
     * @param view the [IView] that should be removed
     *
     * @return whether or not the [view] was actually removed (ie. found in the list)
     *
     * @see MutableList.remove
     */
    fun remove(view: IView): Boolean {
        return viewHandler.remove(view)
    }

    /**
     * Method to easily determine whether the mouse hit the [IView]
     *
     * @param view the view in question
     * @param pos the position to check for, if not given, the current [mouseX] and [mouseY]
     *
     * @return whether or not the mouse is hovering over the view
     */
    fun hitView(view: IView, pos: Vector = Vector(mouseX, mouseY)): Boolean {
        return pos.x > view.pos.x && pos.x < view.pos.x + view.size.x &&
                pos.y > view.pos.y && pos.y < view.pos.y + view.size.y
    }

}