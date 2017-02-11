package org.gtlp.ui.views.panes

import org.gtlp.ui.PWindow
import org.gtlp.ui.rect
import org.gtlp.ui.views.AbstractView
import org.gtlp.util.math.Vector
import java.awt.Color

/**
 * Simple pane, nearly forgot to add it.
 */
class Pane(override val parent: PWindow, override var pos: Vector, override var size: Vector) : AbstractView<Pane>(parent) {

    /**
     * Background color for this pane (does it even have a foreground?)
     */
    var color: Color = Color.WHITE

    /**
     * The color this pane has, when it is being hovered.
     */
    var hoverColor: Color = Color.LIGHT_GRAY

    /**
     * Factory method.
     * Set the (background) color of this pane.
     *
     * @param newColor the new color
     *
     * @return this
     */
    fun color(newColor: Color): Pane {
        color = newColor
        return this
    }

    /**
     * Factory method.
     * Set the (background) color when hovering over this pane.
     *
     * @param newColor the new hover color
     *
     * @return this
     */
    fun hoverColor(newColor: Color): Pane {
        hoverColor = newColor
        return this
    }

    override fun draw() {
        parent.noStroke()
        parent.rect(color, pos, size)
    }

    override fun drawHover() {
        parent.noStroke()
        parent.rect(hoverColor, pos, size)
    }
}