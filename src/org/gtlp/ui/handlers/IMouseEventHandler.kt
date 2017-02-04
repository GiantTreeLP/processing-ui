package org.gtlp.ui.handlers

import org.gtlp.ui.events.MouseEvent
import org.gtlp.ui.views.IView

/**
 * Interface to define an [IView] that handles [MouseEvent]s
 */
interface IMouseEventHandler : IView {

    /**
     * Called when the mouse is clicked on an [IView]
     */
    fun onMouseClicked(event: MouseEvent)

    /**
     * Called when the mouse is hovering over an [IView]
     */
    fun onMouseHover(event: MouseEvent)

    /**
     * Called when the mouse held down on an [IView]
     */
    fun onMouseDown(event: MouseEvent)

    /**
     * Called when the mouse released over an [IView]
     */
    fun onMouseUp(event: MouseEvent)
}

