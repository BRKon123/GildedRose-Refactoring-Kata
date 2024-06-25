package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun foo() {
        val items = listOf(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)
    }

    @Test
    fun updateQualityDecrementsSellInForNonLegendaryItems() {
        val items = listOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", -15, 20),
        )
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(14, app.items[0].sellIn)
        assertEquals(-16, app.items[1].sellIn)
    }

    @Test
    fun updateQualityDoesNotChangeSellInForLegendaryItems() {
        val items = listOf(
            Item("Sulfuras, Hand of Ragnaros", -1, 80) //legendary items does not change
        )
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
    }

    @Test
    fun qualityChangesCorrectlyForNormalItems() {
        val items = listOf(
            Item("Elixir of the Mongoose", 5, 7),
            Item("Dexterity Vest", 6, 0),
            Item("Dexterity Vest", 0, 10),
        )
        val app = GildedRose(items)
        app.updateQuality()
        //quality should be decremented by one
        assertEquals(6, app.items[0].quality)
        //quality decreases twice as fast for items past sellIn
        assertEquals(8, app.items[2].quality)
    }

    @Test
    fun qualityChangesCorrectlyForLegendaryItems() {
        val items = listOf(
            Item("Sulfuras, Hand of Ragnaros", -1, 80),
        )
        val app = GildedRose(items)
        app.updateQuality()
        //quality should remain the same
        assertEquals(80, app.items[0].quality)
    }

    @Test
    fun qualityChangesCorrectlyForAgedBrie() {
        val items = listOf(
            Item("Aged Brie", 2, 10),
            Item("Aged Brie", 9, 15),
            Item("Aged Brie", 5, 10),
        )
        val app = GildedRose(items)
        app.updateQuality()
        //quality should increase
        assertEquals(11, app.items[0].quality)
        assertEquals(16, app.items[1].quality)
        assertEquals(11, app.items[2].quality)
    }

    @Test
    fun qualityChangesCorrectlyForBackStagePasses() {
        val items = listOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 10),
            Item("Backstage passes to a TAFKAL80ETC concert", 9, 10),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 10),
            Item("Backstage passes to a TAFKAL80ETC concert", 0, 10),
        )
        val app = GildedRose(items)
        app.updateQuality()
        //quality should increase
        assertEquals(11, app.items[0].quality)
        //quality increases by 2 when there are 10 days or less
        assertEquals(12, app.items[1].quality)
        //quality increases by 3 when there are 5 days or less
        assertEquals(13, app.items[2].quality)
        //quality turned to 0
        assertEquals(0, app.items[3].quality)
    }

    @Test
    fun maxQualityIs50ForNonLegendaryItems() {
        val items = listOf(
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 50),
            Item("Backstage passes to a TAFKAL80ETC concert", 9, 49),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            Item("Aged Brie", 2, 50),
        )
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
        assertEquals(50, app.items[1].quality)
        assertEquals(50, app.items[2].quality)
        assertEquals(50, app.items[3].quality)
    }

    @Test
    fun minQualityIs0() {
        val items = listOf(
            Item("+5 Dexterity Vest", 10, 0),
            Item("Elixir of the Mongoose", 5, 0),
        )
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
        assertEquals(0, app.items[1].quality)

    }



}


