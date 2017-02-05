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
    fun drawViews() {
        parent.apply {
            views.filter { it !is PWindow }.forEach {
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
     * Adds views to be handled
     */
    fun add(view: IView) {
        views.add(view)
    }
}