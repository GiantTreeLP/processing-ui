package org.gtlp.ui.handlers

import org.gtlp.ui.events.KeyEvent
import org.gtlp.ui.views.IView

/**
 * Interface to define an [IView] that handles [KeyEvent]s
 */
interface IKeyEventHandler : IView {

    /**
     * Called when a key has been pressed.
     */
    fun onKeyDown(event: KeyEvent)

    /**
     * Called when a key has been released.
     */
    fun onKeyUp(event: KeyEvent)

    /**
     * Called when a key has been typed.
     */
    fun onKeyTyped(event: KeyEvent)
}