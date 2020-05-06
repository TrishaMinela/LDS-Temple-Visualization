import os

#read files names
def file_name(file_dir): 
    for root, dirs, files in os.walk(file_dir):
        #print(root) #当前目录路径
        #print(dirs) #当前路径下所有子目录
        return files #当前路径下所有非目录子文件
        


files = file_name("C:\\Users\\litia\\OneDrive - Brigham Young University Hawaii\\Desktop\\temple_app_resources\\original temples - added new")


#print(files)

namesPre = []
for i in files:
    #i = i[9:-4]
    #print(i)
    namesPre.append(i)

#print(namesPre)
print(len(namesPre))

#for x in namesPre:
    #print(x)


allInfo = []
for line in open("temple_info_complete.txt"): 

    #print(line)
    
    allInfo.append(line)

allTempleNames = []
for y in range(0, len(allInfo)):
    if 3*y < len(allInfo):
        #print(allInfo[3*y])
        allTempleNames.append(allInfo[3*y])

print(len(allTempleNames))
#for x in allTempleNames:
 #   print(x)


for i in range(0, len(allTempleNames)):
    if i < len(namesPre):
        print(namesPre[i] + "---------" + allTempleNames[i])

    