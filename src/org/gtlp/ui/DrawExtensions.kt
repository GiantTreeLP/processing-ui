package org.gtlp.ui

import org.gtlp.util.math.Vector
import java.awt.Color


fun PWindow.rect(color: Color, pos: Vector, size: Vector) {
    fill(color.rgb)
    rect(pos.x, pos.y, size.x, size.y)
}