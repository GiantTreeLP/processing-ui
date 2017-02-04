package org.gtlp.ui.views.labels

import org.gtlp.ui.PWindow
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
     */
    fun background(r: Int, g: Int, b: Int, alpha: Int = 255): TextLabel {
        colorBg = Color(r, g, b, alpha)
        return this
    }

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
     */
    fun color(r: Int, g: Int, b: Int, alpha: Int = 255): TextLabel {
        colorText = Color(r, g, b, alpha)
        return this
    }

    fun color(c: Color): TextLabel {
        colorText = c
        return this
    }

    override fun draw() {
        parent.apply {
            noStroke()
            fill(colorBg.red.toFloat(), colorBg.green.toFloat(), colorBg.blue.toFloat(), colorBg.alpha.toFloat())
            rect(pos.x, pos.y, size.x, size.y)
            fill(colorText.red.toFloat(), colorText.green.toFloat(), colorText.blue.toFloat(), colorText.alpha.toFloat())
            parent.textSize(textSize)
            textAlign(alignX, alignY)
            if (size == Vector.ZERO) {
                text(text, pos.x, pos.y)
            } else {
                text(text, pos.x, pos.y, size.x, size.y)
            }
        }
    }

}