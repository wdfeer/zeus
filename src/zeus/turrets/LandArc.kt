package zeus.turrets

import arc.graphics.Color
import zeus.bullets.ArcBulletType
import kotlin.math.sqrt

class LandArc(size: Int) : Arc("arc-$size", size, ArcBulletType(size.toFloat(), sqrt(size.toFloat()), false)) {
    init {
        targetAir = false

        heatColor = Color.red
    }
}