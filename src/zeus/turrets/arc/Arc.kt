package zeus.turrets.arc

import arc.math.Mathf.pow
import arc.math.Mathf.sqrt
import mindustry.content.Fx
import mindustry.content.Items
import mindustry.entities.bullet.BulletType
import mindustry.gen.Sounds
import mindustry.type.Category
import mindustry.world.blocks.defense.turrets.PowerTurret
import zeus.util.createRequiredStacks

abstract class Arc(name: String, size: Int, shootType: BulletType) : PowerTurret(name) {
    init {
        val sizeRoot = sqrt(size.toFloat())
        val sizeSquare = pow(size, 2)
        val sizeCube = pow(size, 3)

        requirements(Category.turret, createRequiredStacks(buildList {
            add(Pair(Items.copper, 50 * sizeSquare))
            add(Pair(Items.lead, 50 * sizeSquare))
            add(Pair(Items.graphite, 30 * sizeSquare))

            if (size > 2)
                add(Pair(Items.titanium, 25 * sizeSquare))
            if (size > 3)
                add(Pair(Items.silicon, 10 * sizeCube))
            if (size > 4)
                add(Pair(Items.thorium, 50 * sizeSquare))
            if (size > 5)
                add(Pair(Items.plastanium, 6 * sizeCube))
            if (size > 6)
                add(Pair(Items.phaseFabric, 24 * sizeSquare))
            if (size > 7)
                add(Pair(Items.surgeAlloy, 11 * sizeSquare))
        }))

        reload = 35f / sizeRoot
        shootCone = 40f
        rotateSpeed = 8f / sizeRoot
        range = 90f * sizeRoot
        shootEffect = Fx.lightningShoot
        recoil = 1f
        this.size = size
        health = 260 * sizeSquare
        shootSound = Sounds.spark
        consumePower(3.3f * sizeSquare)
        coolant = consumeCoolant(0.1f * size)

        this.shootType = shootType
    }
}