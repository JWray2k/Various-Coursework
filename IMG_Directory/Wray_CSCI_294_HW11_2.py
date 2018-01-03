#def readFile1():
#    myFile = open('IMG_1.ppm', 'r')
#    for line in myFile:
#        return(line.strip())
#        
#    myFile.close()
    
#readFile1()


#def writeFile1():
#    fileName = ('IMG_FINAL.ppm')
#    message = (readFile1())
    
#    myFile = open(fileName, 'w')
#    print ("P3", file = myFile)
#    print ("250 167", file = myFile)
#    print ("255", file = myFile)
#    print (message.strip())
#    for line in message:
#        print (message.strip(), file = myFile)
    
#    myFile.close()
    
#writeFile1()
    
#def main():
#    gb = open('IMG_1.ppm', 'r')
    

#    # save the entire contents of the file to a string called full
#    full = gb.read()
#    gb.close()
    
#    # replace punctuation and new lines with spaces
#    full = full.replace('.', '')
#    full = full.replace(',', '')
#    full = full.replace('\n', '')
#    full = full.replace('--', '')
#    full = full.replace(' ', '')
    
#    print(full)
#    x = 11
#    y = 20
#    while y < len(full):
#        print[int(s) for s in line.split()]
#        x = x+9
#        y = y+9
#main()

def medianFile():
    
    gb1 = open('IMG_1.ppm', 'r')
    gb2 = open('IMG_2.ppm', 'r')
    gb3 = open('IMG_3.ppm', 'r')
    gb4 = open('IMG_4.ppm', 'r')
    gb5 = open('IMG_5.ppm', 'r')
    gb6 = open('IMG_6.ppm', 'r')
    gb7 = open('IMG_7.ppm', 'r')
    gb8 = open('IMG_8.ppm', 'r')
    gb9 = open('IMG_9.ppm', 'r')
    
    # save the entire contents of the file to a string called full
    full1 = gb1.read()
    gb1.close()
    full2 = gb2.read()
    gb2.close()
    full3 = gb3.read()
    gb3.close()
    full4 = gb4.read()
    gb4.close()
    full5 = gb5.read()
    gb5.close()
    full6 = gb6.read()
    gb6.close()     
    full7 = gb7.read()
    gb7.close()
    full8 = gb8.read()
    gb8.close()
    full9 = gb9.read()
    gb9.close()     
    
    # replace punctuation and new lines with spaces
    full1 = full1.replace('\n', ' ')
    full2 = full2.replace('\n', ' ')
    full3 = full3.replace('\n', ' ')
    full4 = full4.replace('\n', ' ')
    full5 = full5.replace('\n', ' ')
    full6 = full6.replace('\n', ' ')
    full7 = full7.replace('\n', ' ')
    full8 = full8.replace('\n', ' ')
    full9 = full9.replace('\n', ' ')
    
#    set = []
#    x = 11
#    y = 20
#    while y < len(full1):
#        print((full1[x:y])+'\n',)
#        x = x+9
#        y = y+9
        
        
        
    fileIn = open('IMG_1.ppm', 'r')
    for line in fileIn:
        firstNum, secondNum = [int(s) for s in line.split()]
        print (firstNum, secondNum)    
        
medianFile()
