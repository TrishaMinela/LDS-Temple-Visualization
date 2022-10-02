Latter-day Temples Visualization
================================

#### [Latter-day Temples Visualization Android App](https://litianzhang.com/latter-day-temples-visualization-android-app/)

#### [Official temples list website](https://www.churchofjesuschrist.org/temples/list?lang=eng) provided by [The Church of Jesus Christ of Latter-day Saints](https://www.churchofjesuschrist.org/?lang=eng)

#### Temples order is based on [This Website](https://churchofjesuschristtemples.org/temples/chronology/)

#### Developed by professors and students at [Brigham Young Univerisity Hawawii](https://www.byuh.edu/)

# Instructions for maintenance

## Adding new temples: 

### in res/raw folder:
add new temple to the end of temple_names.txt. If adding multiple, add them in the order announced. Follow the format of the other temple names in the file.

### in res/drawable folder:
2. add new temple webp images in drawable:
    1. small: 200*200
    2. large: 500*500
Images should be cropped into circles.

### in TempleView.java:
in TempleView.java, adjust field howManyTemples to the number of total temples. This will be equal to the number of lines in temple_names.txt
