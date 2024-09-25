package zeus.turrets.lancer

import arc.graphics.Color
import mindustry.content.Fx
import mindustry.content.Items
import mindustry.entities.bullet.LaserBulletType
import mindustry.entities.effect.MultiEffect
import mindustry.gen.Sounds
import mindustry.graphics.Pal
import mindustry.type.Category
import mindustry.type.ItemStack
import mindustry.world.blocks.defense.turrets.PowerTurret

class Lancer(name: String, modify: Lancer.() -> Unit) : PowerTurret(name) {
    init {
        requirements(
            Category.turret,
            ItemStack.with(Items.copper, 60, Items.lead, 70, Items.silicon, 60, Items.titanium, 30)
        )
        range = 165f

        shoot.firstShotDelay = 40f

        recoil = 2f
        reload = 80f
        shake = 2f
        shootEffect = Fx.lancerLaserShoot
        smokeEffect = Fx.none
        heatColor = Color.red
        size = 2
        scaledHealth = 280f
        targetAir = false
        moveWhileCharging = false
        accurateDelay = false
        shootSound = Sounds.laser
        coolant = consumeCoolant(0.2f)

        consumePower(6f)

        shootType = object : LaserBulletType(140f) {
            init {
                colors = arrayOf(Pal.lancerLaser.cpy().a(0.4f), Pal.lancerLaser, Color.white)
                chargeEffect = MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin)

                buildingDamageMultiplier = 0.25f
                hitEffect = Fx.hitLancer
                hitSize = 4f
                lifetime = 16f
                drawSize = 400f
                collidesAir = false
                length = 173f
                ammoMultiplier = 1f
                pierceCap = 4
            }
        }

        modify()
    }
}