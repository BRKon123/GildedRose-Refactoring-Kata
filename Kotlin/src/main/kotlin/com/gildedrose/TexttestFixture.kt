package com.gildedrose

import com.gildedrose.updaters.ItemUpdater

fun main(args: Array<String>) {

    val itemUpdater = ItemUpdater()

    val items = listOf(
        Item("+5 Dexterity Vest", 10, 20), //
            Item("Aged Brie", 2, 0), //
            Item("Elixir of the Mongoose", 5, 7), //
            Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            Item("Sulfuras, Hand of Ragnaros", -1, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet. We need to add this feature
            Item("Conjured Mana Cake", 3, 6)
    )

    println(items[8])
    itemUpdater.update(items[8])
    println(items[8])
}
