Latter-day Temples Visualization
================================

#### [Latter-day Temples Visualization Android App](https://litianzhang.com/latter-day-temples-visualization-android-app/)

#### [Official temples list website](https://www.churchofjesuschrist.org/temples/list?lang=eng) provided by [The Church of Jesus Christ of Latter-day Saints](https://www.churchofjesuschrist.org/?lang=eng)

#### Temples order is based on [This Website](https://churchofjesuschristtemples.org/temples/chronology/)

#### Developed by professors and students at [Brigham Young Univerisity Hawawii](https://www.byuh.edu/)

# Instructions for maintenance

## Adding new temples: 

### in res folder:
1. add new temple to the end of temple_names.txt in res/raw. If adding multiple, add them in the order announced. Follow the format of the other temple names in the file. Copy the new temples into res/raw-en and res/raw-zh as well.

2. add a text file for each temple into each of these three folders: raw, raw-en, and raw-zh. Name each file following the naming convention used in the templenames.txt, and add the .txt extension. If you're using Linux, I recommend the "touch" command, which will let you create all your files at once in each folder.

3. Fill the new text files with relevant information, like any announcement, groundbreaking, or dedication dates. Follow the format found in existing temple files.

### in res/drawable folder:
add new temple webp images in drawable: <br/>
    1. small: 200x200 <br/>
    2. large: 500x500 <br/>
Images should be cropped into circles.

### in TempleView.java:
in TempleView.java, adjust field howManyTemples to the number of total temples. This will be equal to the number of lines in temple_names.txt

UPDATE ---> This should no longer be necessary through the implementation of the countTemples function. The number of temples should be retrieved by itself from the temple_names.txt file in raw

# Message below added in 2024 Mar because I'm seeing recenty some pull requests to this repo: 
Aloha! Thanks for checking out Temples Timeline Android version. Maybe you are a student interested in this app or anyone came across, anyway if you are introduced here by Brother Draper (or any other processors at BYU-H) and/or want to work on this app, please contact me at litian_zhang17@163.com and let me know your email, I can add you to the project! 
