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

    var color: Color = Color.WHITE
    var hoverColor: Color = Color.LIGHT_GRAY

    fun color(newColor: Color): Pane {
        color = newColor
        return this
    }

    fun hoverColor(newColor: Color): Pane {
        hoverColor = newColor
        return this
    }

    override fun draw() {
        parent.rect(color, pos, size)
    }

    override fun drawHover() {
        parent.rect(hoverColor, pos, size)
    }
}