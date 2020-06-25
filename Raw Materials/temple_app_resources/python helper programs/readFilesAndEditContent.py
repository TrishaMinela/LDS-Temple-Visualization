import os


#read files names
def file_names(file_dir): 
    for root, dirs, files in os.walk(file_dir):
        #print(root) #当前目录路径
        #print(dirs) #当前路径下所有子目录
        return files #当前路径下所有非目录子文件
        


files = file_names("D:\\whatsthisD\\LDSTempleVisualizationApp\\Raw Materials\\temple_app_resources\\temple_info_documents_zh")


#print(files)

names = []
for i in files:
    #i = i[9:-4]
    #i = i[0:-4]
    #print(i)
    names.append(i)

#print(len(names))

x = 0

def alter(file,old_str,new_str):
    """
    替换文件中的字符串
    :param file:文件名
    :param old_str:就字符串
    :param new_str:新字符串
    :return:
    
    """
    file_data = ""
    with open(file, "r", encoding="utf-8") as f:
        for line in f:
            if old_str in line:
                line = line.replace(old_str, new_str)
                print(x)
                print("edited file: " + thisfile)
            file_data += line
    with open(file,"w",encoding="utf-8") as f:
        f.write(file_data)
 

for eachfile in names:
    thisfile = "D:\\whatsthisD\\LDSTempleVisualizationApp\\Raw Materials\\temple_app_resources\\temple_info_documents_zh\\" + eachfile

    # alter(thisfile, "公告", "宣告日")
    # alter(thisfile, "开创性", "动工日")
    # alter(thisfile, "奉献", "奉献日")
    # alter(thisfile, "破土动工", "动工日")
    # alter(thisfile, "重新指定", "再次奉献")
    alter(thisfile, "重新兑换", "再次奉献")

    
    # print(x)
   
    x = x + 1



