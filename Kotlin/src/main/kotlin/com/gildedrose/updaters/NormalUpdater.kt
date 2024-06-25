package com.gildedrose.updaters
import com.gildedrose.Item

open class NormalUpdater: BaseUpdater() {
    override fun update(item: Item) {
        item.updateQuality()
        cleanUp(item)
    }

     protected fun Item.updateQuality() {
        when {
            this.sellIn <= 0 -> this.quality -= 2
            else -> this.quality -= 1
        }
    }
}