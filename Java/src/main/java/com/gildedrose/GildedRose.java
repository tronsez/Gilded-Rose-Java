package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            doUpdateQuality(item);
        }
    }

    private void doUpdateQuality(Item item) {
        switch (item.name) {
            //OBSLUGA PRZEDMIOTU AGED BRIE
            case "Aged Brie":
                AgedBrie (item);
                break;
            //OBSLUGA PRZEDMIOTU BILET
            case "Backstage passes to a TAFKAL80ETC concert":
                BackPass (item);
                break;
            //OBSLUGA PRZEDMIOTU SULFURAS
            case "Sulfuras, Hand of Ragnaros":

                break;
            //OBSLUGA PRZEDMIOTU CONJURED
            case "Conjured Mana Cake":
                Conjured (item);
                break;
            //OBSLUGA POZOSTALYCH PRZEDMIOTOW
            default:
                defaultitem (item);
                break;
        }
    }


    public void decreaseQuality(Item item){
        item.quality=item.quality -1;
    }

    public void increaseQuality(Item item){
        item.quality=item.quality +1;
    }

    public void increasewhenlessthan50 (Item item){
        if (item.quality < 50) {
            increaseQuality(item);
        }
    }

    public void AgedBrie (Item item){
        increasewhenlessthan50 (item);

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            increasewhenlessthan50 (item);
        }
    }

    public void BackPass (Item item){
        if (item.quality < 50) {
            increaseQuality(item);

            if (item.sellIn < 11) {
                increasewhenlessthan50 (item);
            }

            if (item.sellIn < 6) {
                increasewhenlessthan50 (item);
            }
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    public void Conjured (Item item){
        if (item.quality > 0) {
            decreaseQuality(item);
            decreaseQuality(item);
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                decreaseQuality(item);
                decreaseQuality(item);
            }
        }
    }

    public void defaultitem (Item item){
        if (item.quality > 0) {
            decreaseQuality(item);
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                decreaseQuality(item);
            }
        }
    }
}
