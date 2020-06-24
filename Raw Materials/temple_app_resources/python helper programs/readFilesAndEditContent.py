import os


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





