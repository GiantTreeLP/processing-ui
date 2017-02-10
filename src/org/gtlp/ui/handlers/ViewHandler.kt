package org.gtlp.ui.handlers

import org.gtlp.ui.PWindow
import org.gtlp.ui.events.IWindowEvent
import org.gtlp.ui.views.IView

/**
 * Handler to handle views.
 * Handles events and draw requests.
 */
class ViewHandler(val parent: PWindow) {
    val views = mutableListOf<IView>()

    /**
     * Handle an event
     * Returns after each view has either handled the event or the event was cancelled.
     *
     * @param event event to be handled
     */
    fun handleEvent(event: IWindowEvent) {
        views.forEach {
            if (event.cancelled) return
            it.handleEvent(event)
        }
    }

    /**
     * Draws all views this view handler handles.
     * Each view gets its own matrix and style environment.
     * Handles hovering as well.
     */
    inline fun drawViews(crossinline condition: (IView) -> Boolean) {
        parent.apply {
            views.filter { condition(it) && it !is PWindow }.forEach {
                if (hitView(it)) {
                    pushMatrix()
                    pushStyle()
                    it.drawHover()
                    popStyle()
                    popMatrix()
                } else {
                    pushMatrix()
                    pushStyle()
                    it.draw()
                    popStyle()
                    popMatrix()
                }
            }
        }
    }

    /**
     * Adds views to be handled and sort them by their position on the z-axis.
     */
    fun add(view: IView) {
        views.add(view)
        views.sortBy { it.pos.z }
    }

    /**
     * Removes views from this handler.
     * No need to sort as removing something from a sorted set doesn't shuffle it.
     */
    fun remove(view: IView): Boolean {
        return views.remove(view)
    }
}