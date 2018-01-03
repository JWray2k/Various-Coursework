def readFile1():
    myFile = open('IMG_1.ppm', 'r')
    for line in myFile:
        print(line.strip())
        
    myFile.close()
    
def readFile2():
    myFile = open('IMG_1.ppm', 'r')
    firstLine = myFile.readline().strip()
    secondLine = myFile.readline().strip()
    
    print(firstLine)
    print(secondLine)
    
    myFile.close()
    

#readFile2()

def computeAverage1():
    myFile = open('IMG_1.ppm', 'r')
    mySum = 0
    myCount = 0
    
    for line in myFile:
        num = int(line)
        mySum += num
        myCount += 1
        
    print('Sum is {}. Average is {}'.format(mySum, mySum/myCount))
    myFile.close()

#computeAverage1()

def computeAverage2():
    myFile = open('IMG_1.ppm', 'r')
    mySum = 0
    myCount = 0
    
    for line in myFile:
        strList = line.split()
        for item in strList:
            num = int(item)
            mySum += num
            myCount += 1
            
    print('Sum is {}. Average is {}'.format(mySum, mySum/myCount))
    myFile.close()
    
#computeAverage2()

def maxRainfall():
    myFile = open('IMG_1.ppm', 'r')
    maxRain = -1
    maxMonth = ''
    
    for line in myFile:
        lineList = line.split()
        month = lineList[0]
        rain = float(lineList[2])
        
        if rain > maxRain:
            maxRain = rain
            maxMonth = month
            
    print('{} had the most rain'.format(maxMonth))
    myFile.close()
    
#maxRainfall()

def writeFile():
    fileName = input('Enter a file name: ')
    message = input('Enter a message: ')
    
    myFile = open(fileName, 'w')
    print(message, file = myFile)
    
    myFile.close()
    
writeFile()
