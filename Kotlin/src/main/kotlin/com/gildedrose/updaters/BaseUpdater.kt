package com.gildedrose.updaters

import com.gildedrose.Item

abstract class BaseUpdater {

    abstract fun update(item: Item)

    // final logic logic is to decrement days and ensure quality in right range
    protected fun cleanUp(item: Item) {
        item.updateSellIn()
        item.checkQualityValid()
    }

    private fun Item.updateSellIn() {
        this.sellIn -= 1
    }

    private fun Item.checkQualityValid() {
        this.quality.coerceIn(MIN_QUALITY, MAX_QUALITY)
    }


    companion object {
        val MAX_QUALITY = 50
        val MIN_QUALITY = 0
    }
}