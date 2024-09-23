package zeus.bullets

import arc.graphics.Color
import mindustry.content.Fx
import mindustry.content.StatusEffects
import mindustry.entities.bullet.BulletType
import mindustry.entities.bullet.LightningBulletType

class ArcBulletType(damageMult: Float, lengthMult: Float, air: Boolean) : LightningBulletType() {
    init {
        damage = 20f * damageMult
        lightningLength = (25 * lengthMult).toInt()
        collidesAir = air
        collidesGround = !air
        ammoMultiplier = 1f

        //for visual stats only.
        buildingDamageMultiplier = 0.25f

        lightningType = object : BulletType(0.0001f, 0f) {
            init {
                lifetime = Fx.lightning.lifetime
                hitEffect = Fx.hitLancer
                despawnEffect = Fx.none
                status = StatusEffects.shocked
                statusDuration = 10f
                hittable = false
                lightColor = Color.white
                collidesAir = false
                buildingDamageMultiplier = 0.25f
            }
        }
    }
}