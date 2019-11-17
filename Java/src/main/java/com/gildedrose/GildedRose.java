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
                if (item.quality < 50) {
                    increaseQuality(item);
                }

                decreasesellIn(item);

                if (item.sellIn < 0 && item.quality < 50) {
                    increaseQuality(item);
                }
                break;
            //OBSLUGA PRZEDMIOTU BILET
            case "Backstage passes to a TAFKAL80ETC concert":
                if (item.quality < 50) {
                    increaseQuality(item);

                    if (item.sellIn < 11 && item.quality < 50) {
                        increaseQuality(item);
                    }

                    if (item.sellIn < 6 && item.quality < 50) {
                        increaseQuality(item);
                    }
                }

                decreasesellIn(item);

                if (item.sellIn < 0) {
                    item.quality = 0;
                }
                break;
            //OBSLUGA PRZEDMIOTU SULFURAS
            case "Sulfuras, Hand of Ragnaros":

                break;
            //OBSLUGA PRZEDMIOTU CONJURED
            case "Conjured Mana Cake":
                if (item.quality > 0) {
                    decreaseQuality(item);
                    decreaseQuality(item);
                }

                decreasesellIn(item);

                if (item.sellIn < 0 && item.quality > 0 ) {
                    decreaseQuality(item);
                    decreaseQuality(item);
                }
                break;
            //OBSLUGA POZOSTALYCH PRZEDMIOTOW
            default:
                if (item.quality > 0) {
                    decreaseQuality(item);
                }

                decreasesellIn(item);

                if (item.sellIn < 0 && item.quality > 0) {
                    decreaseQuality(item);
                }
                break;
        }
    }

    public void decreaseQuality(Item item){
        item.quality=item.quality -1;
    }

    public void increaseQuality(Item item){
        item.quality=item.quality +1;
    }

    public void decreasesellIn(Item item) {item.sellIn = item.sellIn -1;}
}
