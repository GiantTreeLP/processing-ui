package org.gtlp.ui.views.labels

import org.gtlp.ui.PWindow
import org.gtlp.ui.rect
import org.gtlp.util.math.Vector
import processing.core.PApplet
import java.awt.Color

/**
 * A simple label to be drawn on a [PApplet]
 * @see [PWindow]
 */
class TextLabel(text: String = "", override val parent: PWindow, override var pos: Vector,
                override var size: Vector = Vector.ZERO) : AbstractLabel<TextLabel>(parent, pos, size, text) {

    /**
     * Background color
     */
    var colorBg = Color(0, 0, 0, 0)

    /**
     * Text color
     */
    var colorText: Color = Color.BLACK

    /**
     * Factory method to set the background color (RGB 0 - 255)
     *
     * @param r red value
     * @param g green value
     * @param b blue value
     * @param alpha alpha value
     *
     * @return this
     *
     * @see background
     */
    fun background(r: Int, g: Int, b: Int, alpha: Int = 255): TextLabel {
        colorBg = Color(r, g, b, alpha)
        return this
    }

    /**
     * Factory method to set the background color
     *
     * @param c the [Color] for the background of this label
     *
     * @return this
     *
     * @see background
     */
    fun background(c: Color): TextLabel {
        colorBg = c
        return this
    }

    /**
     * Factory method to set the text color (RGB 0 - 255)
     *
     * @param r red value
     * @param g green value
     * @param b blue value
     * @param alpha alpha value
     *
     * @return this
     *
     * @see color
     */
    fun color(r: Int, g: Int, b: Int, alpha: Int = 255): TextLabel {
        colorText = Color(r, g, b, alpha)
        return this
    }

    /**
     * Factory method to set the text color
     *
     * @param c the color for the text of this label
     *
     * @return this
     *
     * @see color
     */
    fun color(c: Color): TextLabel {
        colorText = c
        return this
    }

    override fun draw() {
        parent.apply {
            val pos = this@TextLabel.pos
            val size = this@TextLabel.size
            noStroke()
            rect(colorBg, pos, size)
            fill(colorText.rgb)
            textSize(textSize)
            textAlign(alignX, alignY)
            if (size == Vector.ZERO) {
                text(text, pos.x, pos.y)
            } else {
                text(text, pos.x, pos.y, size.x, size.y)
            }
        }
    }

}