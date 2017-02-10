package org.gtlp.ui.views.shapes

import org.gtlp.ui.PWindow
import org.gtlp.ui.fill
import org.gtlp.ui.stroke
import org.gtlp.ui.vertex
import org.gtlp.ui.views.AbstractView
import org.gtlp.util.math.Vector
import java.awt.Color

/**
 * A custom shape made up of vertices
 */
class CustomShape(override val parent: PWindow, override var pos: Vector, override var size: Vector, vertices: Collection<Vector> = listOf()) : AbstractView<CustomShape>(parent) {

    private val vertexBuffer = mutableListOf<Vector>()

    private var buffer = parent.createShape()

    /**
     * The width of the stroke that will be drawn
     */
    var strokeWidth = 4f

    /**
     * The color of the stroke
     */
    var color = Color.WHITE

    /**
     * The fill color of the resulting shape
     */
    var fillColor = Color.WHITE

    /**
     * Whether or not to fill this shape
     */
    var fill = false

    /**
     * Whether the vertexBuffer are drawn with absolute or relative coordinates
     */
    var absolute = true

    init {
        plus(vertices)
        refreshBuffer()
    }

    /**
     * Add a vertex to this shape
     *
     * @param vector the vector to add
     *
     * @return this
     */
    operator fun plus(vector: Vector): CustomShape {
        vertexBuffer.add(vector)
        refreshBuffer()
        return this
    }

    private fun refreshBuffer() {
        buffer = parent.createShape()
        buffer.apply {
            beginShape()
            strokeWeight(strokeWidth)
            stroke(color)
            fill(fillColor)
            if (!fill) {
                noFill()
            }
            vertexBuffer.forEach { vertex(it) }
            endShape()
        }
    }

    /**
     * Add vertexBuffer to this shape
     *
     * @param vectors the vectors to add
     *
     * @return this
     */
    operator fun plus(vectors: Collection<Vector>): CustomShape {
        vertexBuffer.addAll(vectors)
        refreshBuffer()
        return this
    }

    /**
     * Remove a vertex from this shape
     *
     * @param vector the vector to remove
     *
     * @return this
     */
    operator fun minus(vector: Vector): CustomShape {
        vertexBuffer.remove(vector)
        refreshBuffer()
        return this
    }

    override fun draw() {
        parent.shape(buffer)
    }
}
