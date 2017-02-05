package org.gtlp.ui.views.buttons

import org.gtlp.ui.PWindow
import org.gtlp.util.math.Vector
import processing.core.PConstants.CENTER

/**
 * Simple button with some text on it.
 * Can change text on hovering over with the mouse.
 */
class TextButton(override val parent: PWindow, override var pos: Vector, override var size: Vector) : AbstractButton<TextButton>(parent) {

    /**
     * The text that is usually shown.
     * Not null-able
     */
    var text = ""

    /**
     * The text that is shown when the user is hovering their mouse over this button.
     * Set to *null* to disable this text
     */
    var hoverText: String? = null

    override fun draw() {
        parent.apply {
            val pos = this@TextButton.pos
            val size = this@TextButton.size
            fill(200)
            rect(pos.x, pos.y, size.x, size.y)
            textAlign(CENTER, CENTER)
            if (pressed) {
                drawInsets()
            }
            fill(0)
            textSize(12f)
            text(text, pos.x, pos.y, size.x, size.y)
        }
    }

    private fun drawInsets() {
        parent.apply {
            val pos = this@TextButton.pos
            val size = this@TextButton.size
            strokeWeight(2.5f)
            stroke(127f)
            line(pos.x + 2, pos.y + 2, pos.x + 2, pos.y + size.y - 2)
            line(pos.x + 2, pos.y + 2, pos.x + size.x - 2, pos.y + 2)
        }
    }

    override fun drawHover() {
        parent.apply {
            val pos = this@TextButton.pos
            val size = this@TextButton.size
            fill(250)
            rect(pos.x, pos.y, size.x, size.y)
            textAlign(CENTER, CENTER)
            if (pressed) {
                drawInsets()
            }
            fill(0)
            textSize(12f)
            text(hoverText ?: text, pos.x, pos.y, size.x, size.y)
        }
    }

    /**
     * Factory method to set the text this button should show usually.
     *
     * @param text the new text.
     *
     * @return this
     */
    fun text(text: String): TextButton {
        this.text = text
        return this
    }

    /**
     * Factory method to set the text this button should show when hovering over it.
     * Set to *null* to disable the hover text.
     *
     * @param text the new hovering text.
     *
     * @return this
     */
    fun hoverText(text: String?): TextButton {
        this.hoverText = text
        return this
    }
}