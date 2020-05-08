import os

'''
path=r"D:/whatsthisD/black circles/"   

#获取该目录下所有文件，存入列表中
f=os.listdir(path)

allLetters = "abcdefghijklmnopqrstuvwxyz"
'''


'''
namePre = []
for i in "ab":
    for j in allLetters:
        namePre.append(i + j)
print(namePre)


n=0
for file in f:

    #设置旧文件名（就是路径+文件名）
    oldname=path+f[n]

    #设置新文件名
    newname=path+namePre[n]+'_imnothing.png'

    #用os模块中的rename方法对文件改名
    os.rename(oldname,newname)
    print(oldname,'======>',newname)
    print(n)
    n+=1

'''

 ################################################################################

#read files names
def file_name(file_dir): 
    for root, dirs, files in os.walk(file_dir):
        #print(root) #当前目录路径
        #print(dirs) #当前路径下所有子目录
        return files #当前路径下所有非目录子文件
        


files = file_name("D:\\whatsthisD\\LDSTempleVirtualizationApp\\Raw Materials\\temple_app_resources\\original temples")


#print(files)

namesPre = []
for i in files:
    i = i[9:-4]
    #print(i)
    namesPre.append(i)

print(namesPre)
print(len(namesPre))

for x in namesPre:
    print(x)

'''
#RENAME SMALL CIRCLES JUST RUN ONCE

path2 = r"D:/whatsthisD/LDSTempleVirtualizationApp/Raw Materials/temple_app_resources/small circles - renamed and added new/"

#path2 = r"D:/whatsthisD/LDSTempleVirtualizationApp/Raw Materials/temple_app_resources/small circles/"

f2=os.listdir(path2)


n=0
for file in f2:

    #设置旧文件名（就是路径+文件名）
    oldname=path2+f2[n]

    #设置新文件名
    #newname=path2+namesPre[n]+'_large.webp'
    newname=path2+namesPre[n]+'.webp'


    #用os模块中的rename方法对文件改名
    os.rename(oldname,newname)
    print(oldname,'======>',newname)
    print(n)
    n+=1

    print(f2[n])

'''

    
#RENAME LAGRE CIRCLES RUN TWICE, GET RID OF LARGE, THEM RENAME GAIN. ORDER IS MESSIED UP BECAUSE OF _LARGE THE WORD

path2 = r"D:/whatsthisD/LDSTempleVirtualizationApp/Raw Materials/temple_app_resources/large circles - renamed and added new/"

#path2 = r"D:/whatsthisD/LDSTempleVirtualizationApp/Raw Materials/temple_app_resources/small circles/"

f2=os.listdir(path2)


n=0
for file in f2:

    #设置旧文件名（就是路径+文件名）
    oldname=path2+f2[n]

    
    #设置新文件名
    #run 1
    #newname=oldname[0:-11] + ".webp"
    #run 2
    newname=path2+namesPre[n]+'_large.webp'


    #用os模块中的rename方法对文件改名
    os.rename(oldname,newname)
    print(oldname,'======>',newname)
    print(n)
    n+=1
