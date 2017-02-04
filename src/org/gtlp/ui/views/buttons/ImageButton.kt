package org.gtlp.ui.views.buttons

import org.gtlp.ui.PWindow
import org.gtlp.util.math.Vector
import processing.core.PImage

/**
 * A button with an image instead of text.
 */
class ImageButton(override val parent: PWindow, override var pos: Vector, override var size: Vector, val image: PImage) : AbstractButton<ImageButton>(parent) {

    override fun draw() {
        parent.apply {
            image(image, pos.x, pos.y, size.x, size.y)
        }
    }

    override fun drawHover() {
        parent.apply {
            image(image, pos.x, pos.y, size.x, size.y)
            fill(255f, 15f)
            rect(pos.x, pos.y, size.x, size.y)
        }
    }
}