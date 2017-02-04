package org.gtlp.ui.views.labels

import org.gtlp.ui.PWindow
import org.gtlp.ui.views.AbstractView
import org.gtlp.util.math.Vector
import processing.core.PConstants

/**
 * Abstract class to define a label.
 * Drawing is handled by the specific implementation.
 */
abstract class AbstractLabel<out T>(override val parent: PWindow, override var pos: Vector,
                                    override var size: Vector, var text: String = "") : AbstractView<T>(parent) {

    /**
     * Text size
     */
    var textSize = 12f

    /**
     * Alignment on the X axis
     */
    var alignX = PConstants.LEFT

    /**
     * Alignment on the Y axis
     */
    var alignY = PConstants.BASELINE

    /**
     * Factory method to set the text
     *
     * @param newText the new text
     *
     * @return this
     */
    fun text(newText: String): T {
        text = newText

        //Cast is safe
        @Suppress("UNCHECKED_CAST")
        return this as T
    }

    /**
     * Factory method to set the text size
     *
     * @param newSize the new text size
     *
     * @return this
     */
    fun textSize(newSize: Number): T {
        textSize = newSize.toFloat()

        //Cast is safe
        @Suppress("UNCHECKED_CAST")
        return this as T
    }

    /**
     *  Factory method to set the text alignment
     *
     *  @param alignX the alignment on the X axis
     *  @param alignY the alignment on the Y axis, defaulted to [PConstants.BASELINE]
     */
    fun align(alignX: Int, alignY: Int = PConstants.BASELINE): T {
        this.alignX = alignX
        this.alignY = alignY

        //Cast is safe
        @Suppress("UNCHECKED_CAST")
        return this as T
    }

}