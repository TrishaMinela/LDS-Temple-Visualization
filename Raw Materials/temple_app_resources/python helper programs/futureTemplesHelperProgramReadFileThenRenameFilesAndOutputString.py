
names =[]
for line in open("D:/whatsthisD/LDSTempleVirtualizationApp/Raw Materials/temple_app_resources/future temples images names.txt"): 
    #print(line.lower())
    names.append(line[0:-1].lower())


templesNoImages = []
for i in range(0, len(names)):
    if i > 14: 
        print(names[i])
        #print(len(name))
        templesNoImages.append(names[i])
    

'''
for name in names:
    #print(name + " = loadAndScale(res, R.drawable." + name + ", w);")

    print("templesList.add(" + name + ");")

print(len(names))

#print(len(templesNoImages))
'''



path2 = r"D:/whatsthisD/LDSTempleVirtualizationApp/Raw Materials/temple_app_resources/salt lake temple as temporary temple for temples no images/"

import os
f2=os.listdir(path2)


n=0
for file in f2:

    #设置旧文件名（就是路径+文件名）
    oldname=path2+f2[n]

    
    #设置新文件名
    #newname=path2+templesNoImages[n]+'.png'
    newname=path2+templesNoImages[n]+'_large.png'


    #用os模块中的rename方法对文件改名
    os.rename(oldname,newname)
    print(oldname,'======>',newname)
    print(n)
    n+=1
