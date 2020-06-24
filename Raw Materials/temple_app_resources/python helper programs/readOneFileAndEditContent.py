import os




def alter(file):
    """
    替换文件中的字符串
    :param file:文件名
    :param old_str:就字符串
    :param new_str:新字符串
    :return:
    
    """

    #each every third line content 2,5,8,11,
    x = 0
    y = 2
    file_data = ""
    with open(file, "r", encoding="utf-8") as f:
        for line in f:
            if x == y:
                line = line[0:4] + "\n"
                y = y + 3
                print("changed line: ")
                print(x)
                print("new line is " + line)
            file_data += line 
            x = x + 1
    with open(file,"w",encoding="utf-8") as f:
        f.write(file_data)


thisfile = "D:\\whatsthisD\\LDSTempleVisualizationApp\\Raw Materials\\temple_app_resources\\" + "temple_info_zh.txt"
alter(thisfile)



