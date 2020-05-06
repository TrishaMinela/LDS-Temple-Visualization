
x = 1
#for line in open("List of temples of The Church of Jesus Christ of Latter-day Saints - Wikipedia.html"): 
    #do nothing
    
y = 1
FILE_OBJECT= open("temple_info_ii.txt",'r', encoding='UTF-8')

#for line in open("temple information from wiki.txt"): 
for line in FILE_OBJECT: 
    #if (line[0:15]) is "<p><span class=":
    #print(line[0:15])
    #print(line[0:4])
    '''
    if line[0:3] == str(x) + ". ":
        print(x)
        print(line)
        x = x + 1
    elif line[0:4] == str(x) + ". ":
        print(x)
        
        print(line)
        x = x + 1
    elif line[0:5] == str(x) + ". ":
        print(x)
        print(line)
        x = x + 1
'''
    lineList = line.split(" ")
    #print(lineList)
    if len(lineList) >= 4:
        if len(lineList[2]) == 4 and lineList[3] in ["by"]:
            print(y)
            print(line)
            y = y + 1
            












'''    
<p><span class="label">
'''