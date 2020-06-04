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
def file_names(file_dir): 
    for root, dirs, files in os.walk(file_dir):
        #print(root) #当前目录路径
        #print(dirs) #当前路径下所有子目录
        return files #当前路径下所有非目录子文件
        


files = file_names("D:\\whatsthisD\\LDSTempleVirtualizationApp\\Raw Materials\\temple_app_resources\\new temple images - origina - changes due to permission of use - circles")


#print(files)

names = []
for i in files:
    #i = i[9:-4]
    i = i[0:-4]
    print(i)
    names.append(i)






path2 = r"D:/whatsthisD/LDSTempleVirtualizationApp/Raw Materials/temple_app_resources/new temple images - origina - changes due to permission of use - circles - webp - large/"

f2=os.listdir(path2)

n=0
for file in f2:

    #设置旧文件名（就是路径+文件名）
    oldname=path2+f2[n]

    
    #设置新文件名
    newname=path2+names[n]+'_large.webp'


    #用os模块中的rename方法对文件改名
    os.rename(oldname,newname)
    print(oldname,'======>',newname)
    print(n)
    n+=1
