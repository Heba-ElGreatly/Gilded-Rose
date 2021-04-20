package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {


//    @Test
//    void quality() {
//        Item[] items = new Item[]{new Item("Elixir of the Mongoose", 5, 7)};
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        assertEquals(6, items[0].quality);
//    }
//
//    @Test
//    void sulfurasItemQuality() {
//        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 7)};
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        assertEquals(6, items[0].quality); // expected eno y-fail 3shan el name sulfuras w howa 2al lw el name mesh sulfuras
//    }
//
//    @Test
//    void AgedBrieItemQuality() {
//        Item[] items = new Item[]{new Item("Aged Brie", 5, 7)};
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        assertEquals(8, items[0].quality); // expected eno y-pass 3shan lw el quality 22al mn 50 yzawedha b 1
//    }
//
//
//    @Test
//    void BackstageItemSellInPass() {
//        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", -1, 51)};
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        assertEquals(0, items[0].quality); // expected eno y-pass 3shan lw el sellIn 22al mn 0 wel name mesh Aged Brie
//                                                    // hyshof b3dha lw name Backstage passes to a TAFKAL80ETC concert
//                                                    // y5ali el quality b zero
//    }
//
//    @Test
//    void BackstageItemSellInFail() {
//        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", -1, 51)};
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        assertEquals(0, items[0].quality);
//    }
//
//    @Test
//    void sellIn() {
//        Item[] items = new Item[]{new Item("Elixir of the Mongoose", 5, 7)};
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        assertEquals(6, items[0].quality);
//    }

    ///////////////////////// After reading read me file ///////////////////////////
    @Test
    void qualityDecreasesBy2(){
        // if name not equal aged brie or back stage wala sulfuras hy2el b 2
        Item[] items = new Item[]{new Item("Elixir of the Mongoose", -1, 7)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, items[0].quality);
    }

    @Test
    void qualityIncreasesTheOlderItGets(){
        // Backstage passes to a TAFKAL80ETC concert and aged brie
        Item[] items = new Item[]{new Item("Aged Brie", 5, 49)};
        GildedRose app = new GildedRose(items);
        items[0].sellIn = 4;
        app.updateQuality();
        assertEquals(50, items[0].quality);
    }

    @Test
    void sulfurasQualityNeverBeDecreased(){
        // fail if the name is Sulfuras, Hand of Ragnaros
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(49, items[0].quality);
    }

    @Test
    void qualityIncreasesBy3BackStageAndAgedBrie(){
        // if name Backstage passes", like aged brie, increases in Quality by 2
        // when 10 days or less and greater than 5 days
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 7)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].quality);
    }

    @Test
    void qualityIncreasesBy1AgedBrie(){
        Item[] items = new Item[]{new Item("Aged Brie", 9, 7)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, items[0].quality);
    }

    @Test
    void qualityIncreasesBy2BackStage(){
        // if name Backstage passes, increases in Quality by 2
        // when 5 days or less and greater than 0 days
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 6, 7)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].quality);
    }

    @Test
    void qualityIncreasesBy3BackStage(){
        // if name Backstage passes, increases in Quality by 3
        // when 5 days or less and greater than 0 days
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 7)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, items[0].quality);
    }


    @Test
    void qualityNeverMoreThan50(){
        // if name Backstage passes, increases in Quality by 3
        // when 5 days or less and greater than 0 days
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 48)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, items[0].quality);
    }

    @Test
    void qualityNeverNegative(){
        // if name Backstage passes, increases in Quality by 3
        // when 5 days or less and greater than 0 days
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
    }


}
