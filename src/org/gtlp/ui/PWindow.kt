package org.gtlp.ui

import org.gtlp.ui.events.*
import org.gtlp.ui.handlers.IMouseEventHandler
import org.gtlp.ui.handlers.ViewHandler
import org.gtlp.ui.views.IView
import org.gtlp.util.math.Vector
import processing.core.PApplet

/**
 * Class to hold a more advanced window with support for [IView]s and [IMouseEventHandler]
 * Uses [ViewHandler] for exactly those features
 */
abstract class PWindow : PApplet() {

    @Suppress("LeakingThis")
    private val viewHandler = ViewHandler(this)

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
     * Handles the drawing of [IView]s
     *
     * Remember to call `super.draw()` at the end of your [draw] method.
     * If you don't want to do that, use [onDraw].
     *
     * @see PApplet.draw
     * @see onDraw
     */
    override fun draw() {
        onDraw()
        viewHandler.handleEvent(MouseEvent(Vector.NAN, MouseEventType.NONE, MouseButton.NONE))
        viewHandler.drawViews()
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