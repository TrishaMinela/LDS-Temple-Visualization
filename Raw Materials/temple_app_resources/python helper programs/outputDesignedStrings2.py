
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

templesNamesReal = []
for i in templesNames:
    j = i[9:-4]
    templesNamesReal.append(j)


for i in templesNamesReal:
    print(i)
print(len(templesNamesReal))


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

print(fakeNames)


templesNamesLarge = []
for i in fakeNames:
    i = i + "_large"
    templesNamesLarge.append(i)

#print(templesNamesReal)

for i in templesNamesLarge:
    print("allImageIds.add(R.drawable." + i + ");")

#templesNamesLarge = file_name("C:\\Users\\litia\\OneDrive - Brigham Young University Hawaii\\Desktop\\temple_app_images\\temporary - Copy")
'''
'''
t = 0
templesNamesReal = []
for i in templesNamesLarge:
    t = t + 1   
    
    j = i[0:-5]
    print("allImageIds.add(R.drawable." + j + ");")
    print(t)
    #templesNamesReal.append(j)

#print(templesNamesReal)
'''