
import sys


import os
 
def file_name(file_dir): 
    names = []
    for root, dirs, files in os.walk(file_dir):
        #print(root) #当前目录路径
        #print(dirs) #当前路径下所有子目录
        #print(files), #当前路径下所有非目录子文件
        return files 
        


templesNames = file_name("D:\\whatsthisD\\LDSTempleVirtualizationApp\\Raw Materials\\temple_app_resources\\original temples - added new")
#for n in templesNames:
    #print(n)



'''   
s = "aa"
fakeNames = []
for x in range(2, 9):
    for i in "abcdefghijklmnopqrstuvwxyz":
        s = s[0:x]
        s += i
        fakeNames.append(s)

for x in range(0, 21):
    fakeNames.pop()
'''
#print(fakeNames)

#print("fakeNames length is", len(fakeNames))
#print("templesNames length is", len(templesNames))

#for x in range(0, 161):
    #print("private static Bitmap " + templesNames[x][9:-4] + ";")

#for x in range(0, 161):
    #print(templesNames[x][9:-4] +  " = loadAndScale(res, R.drawable." + fakeNames[x] + ", w);")

#for x in range(0, 161):
    #print("templesList.add(" + templesNames[x][9:-4] + ");")


#print(templesNames)

#fo = open("outputDesignedStrings2.txt", "w")

templesNamesReal = []
for i in templesNames:
    j = i[9:-4]
    templesNamesReal.append(j)

'''
for i in templesNamesReal:
    print(i)
    #fo.write( i + ", ")
print(len(templesNamesReal))
'''

'''
for i in templesNamesReal:
    print(i + " = loadAndScale(res, R.drawable." + i + ", w);")
    #fo.write(i)
print(len(templesNamesReal))
'''

'''
for i in templesNamesReal:
    print("templesList.add(" + i + ");")
    #fo.write(i)
print(len(templesNamesReal))
'''

'''
for i in templesNamesReal:
    print("allImageIds.add(R.drawable." + i + "_large);")
    #fo.write(i)
print(len(templesNamesReal))
'''

x = 0 
for i in templesNames:
    x += 1
    print(x)
    print(i)