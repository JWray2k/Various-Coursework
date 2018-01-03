def readFile1():
    myFile = open('IMG_1.ppm', 'r')
    for line in myFile:
        print(line.strip())
        
    myFile.close()