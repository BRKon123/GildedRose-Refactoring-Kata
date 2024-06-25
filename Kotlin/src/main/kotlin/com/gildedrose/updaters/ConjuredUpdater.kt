package com.gildedrose.updaters

import com.gildedrose.Item

class ConjuredUpdater: NormalUpdater() {
    override fun update(item: Item) {
        item.updateQuality()
        item.updateQuality()
        cleanUp(item)
    }
}