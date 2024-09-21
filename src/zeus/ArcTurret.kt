package zeus

import arc.graphics.Color
import arc.math.Mathf.pow
import arc.math.Mathf.sqrt
import mindustry.content.Fx
import mindustry.content.Items
import mindustry.content.StatusEffects
import mindustry.entities.bullet.BulletType
import mindustry.entities.bullet.LightningBulletType
import mindustry.gen.Sounds
import mindustry.type.Category
import mindustry.type.ItemStack
import mindustry.world.blocks.defense.turrets.PowerTurret

class ArcTurret(name: String, size: Int) : PowerTurret(name) {
    init {
        val sizeRoot = sqrt(size.toFloat())
        val sizeSquare = pow(size, 2)
        val sizeCube = pow(size, 3)

        requirements(Category.turret, ItemStack.with(
            Items.copper,
            50 * sizeSquare,
            Items.lead,
            50 * sizeSquare,
            Items.silicon,
            10 * sizeCube
        ))

        shootType = object : LightningBulletType() {
            init {
                damage = 20f * size
                lightningLength = (25 * sizeRoot).toInt()
                collidesAir = false
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
        reload = 35f / sizeRoot
        shootCone = 40f
        rotateSpeed = 8f / sizeRoot
        targetAir = false
        range = 90f * sizeRoot
        shootEffect = Fx.lightningShoot
        heatColor = Color.red
        recoil = 1f
        this.size = size
        health = 260 * sizeSquare
        shootSound = Sounds.spark
        consumePower(3.3f * sizeSquare)
        coolant = consumeCoolant(0.1f * size)
    }
}