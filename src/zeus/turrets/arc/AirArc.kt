package zeus.turrets.arc

import arc.graphics.Color
import zeus.bullets.ArcBulletType
import kotlin.math.sqrt

class AirArc(size: Int) : Arc("air-arc-$size", size, ArcBulletType(size.toFloat(), sqrt(size.toFloat()), true)) {
    init {
        targetAir = true
        targetGround = false

        heatColor = Color.cyan
    }
}