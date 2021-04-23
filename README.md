Latter-day Temples Visualization
================================

#### [Latter-day Temples Visualization Android App](https://litianzhang.com/latter-day-temples-visualization-android-app/)

### Instructions for maintenance

## adding new temples: 
1. declare a temple bitmap object at position 1 (search for positions 1)
2. load and scale bitmap in "init" method
(in the following three tasks, temples must have the same order)
3. add new temple objects into templesObejcts list in "getTempleObjectsList" method [order matters!] 
4. store all images large version in "getAllImageIds" method [order matters!]
5. store all temple info in "getAllTempleInfoFileIds" method [order matters!]

# in res folder:
6. add new temple images in drawable:
    1. small: 200*200
    2. large: 500*500
7. add new temple info files in raw (multiple languages)
8. update temple_info file, that is a summary of all temples
9. update all_temple_links file

## adjust temple orders: 
1. refer to the [order matters!] tasks (3-5) above