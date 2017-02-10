package org.gtlp.ui

import org.gtlp.util.math.Vector
import processing.core.PShape
import java.awt.Color


fun PWindow.rect(color: Color, pos: Vector, size: Vector) {
    fill(color.rgb)
    rect(pos.x, pos.y, size.x, size.y)
}

fun PWindow.stroke(color: Color) {
    stroke(color.rgb)
}

fun PWindow.fill(color: Color) {
    fill(color.rgb)
}

fun PWindow.vertex(vector: Vector) {
    vertex(vector.x, vector.y)
}

fun PShape.stroke(color: Color) {
    stroke(color.rgb)
}

fun PShape.fill(color: Color) {
    fill(color.rgb)
}

fun PShape.vertex(vector: Vector) {
    vertex(vector.x, vector.y, vector.z)
}