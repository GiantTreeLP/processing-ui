package org.gtlp.ui.views

import org.gtlp.ui.PWindow
import org.gtlp.ui.events.IEventListener
import org.gtlp.ui.events.IWindowEvent
import org.gtlp.ui.events.MouseEventListener
import org.gtlp.util.math.Vector

/**
 * Interface for using views.
 * Some implementations might not use all the available variables, values or functions
 * to their full extent
 */
interface IView {
    /**
     * The parent of this [IView]
     */
    val parent: PWindow

    /**
     * The position
     */
    var pos: Vector

    /**
     * The size
     */
    var size: Vector

    /**
     * The [MouseEventListener]s handling events
     */
    val listeners: List<IEventListener>

    /**
     * Method to handle events
     */
    fun handleEvent(event: IWindowEvent)

    /**
     * The method to draw this view usually
     */
    fun draw()

    /**
     * The method to draw this view when hovered
     */
    fun drawHover()

    /**
     * The method to handle updates
     */
    fun onUpdate()

}