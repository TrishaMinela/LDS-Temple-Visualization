

filepath = "D:/whatsthisD/LDSTempleVirtualizationApp/Raw Materials/temple_app_resources/future temples images names - sort by anounced date.txt"

names = []
for line in open(filepath): 
    names.append(line[0:-1])
    
for name in names:
    print("allTempleInfoFileIds.add(R.raw." + name.lower() + ");") 


