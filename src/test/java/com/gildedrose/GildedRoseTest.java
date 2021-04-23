package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void qualityDecreasesBy2(){
        // if name not equal aged brie or back stage wala sulfuras hy2el b 2
        Item[] items = new Item[]{new Item("Elixir of the Mongoose", -1, 7)};
//        GildedRose app = new GildedRose(items);
        GildedRoseUpdated app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(5, items[0].quality);
    }

    @Test
    void AgedBriequalityDecreasesBy2(){
        Item[] items = new Item[]{new Item("Conjured Mana Cake", -1, 4)};
//        GildedRose app = new GildedRose(items);
        GildedRoseUpdated app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(2, items[0].quality);
    }

    @Test
    void qualityIncreasesTheOlderItGets(){
        Item[] items = new Item[]{new Item("Aged Brie", 5, 49)};
//        GildedRose app = new GildedRose(items);
        GildedRoseUpdated app = new GildedRoseUpdated(items);
        items[0].sellIn = 4;
        app.updateQuality();
        assertEquals(50, items[0].quality);
    }

    @Test
    void sulfurasQualityNeverBeDecreased(){
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 49)};
//        GildedRose app = new GildedRose(items);
        GildedRoseUpdated app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(49, items[0].quality);
    }

    @Test
    void sulfurasSellInNeverBeDecreased(){
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 49)};
//        GildedRose app = new GildedRose(items);
        GildedRoseUpdated app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(5, items[0].sellIn);
    }

    @Test
    void qualityIncreasesBy3BackStageAndAgedBrie(){
        // if name Backstage passes", like aged brie, increases in Quality by 2
        // when 10 days or less and greater than 5 days
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 7)};
//        GildedRose app = new GildedRose(items);
        GildedRoseUpdated app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(9, items[0].quality);
    }

    @Test
    void qualityIncreasesBy1AgedBrie(){
        Item[] items = new Item[]{new Item("Aged Brie", 12, 7)};
//        GildedRose app = new GildedRose(items);
        GildedRoseUpdated app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(8, items[0].quality);
    }

    @Test
    void qualityIncreasesBy2BackStage(){
        // if name Backstage passes, increases in Quality by 2
        // when 5 days or less and greater than 0 days
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 6, 7)};
//        GildedRose app = new GildedRose(items);
        GildedRoseUpdated app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(9, items[0].quality);
    }

    @Test
    void qualityIncreasesBy3BackStage(){
        // if name Backstage passes, increases in Quality by 3
        // when 5 days or less and greater than 0 days
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 7)};
//        GildedRose app = new GildedRose(items);
        GildedRoseUpdated app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(10, items[0].quality);
    }


    @Test
    void qualityNeverMoreThan50(){
        // if name Backstage passes, increases in Quality by 3
        // when 5 days or less and greater than 0 days
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 48)};
//        GildedRose app = new GildedRose(items);
        GildedRoseUpdated app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(50, items[0].quality);
    }

    @Test
    void qualityNeverNegative(){
        // if name Backstage passes, increases in Quality by 3
        // when 5 days or less and greater than 0 days
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 2)};
//        GildedRose app = new GildedRose(items);
        GildedRoseUpdated app = new GildedRoseUpdated(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
    }


}
