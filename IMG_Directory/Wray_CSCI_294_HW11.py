import os

class Counter():
   def __init__(self):
      self.total = 0
   def add(self, val):
      self.total += val
      
def sizepy(count,place):
   if(os.path.isfile(place) and
      place.endswith(".py")):
      size = os.stat(place).st_size
      count.add(int(size))
      
def accumsizes(count,dirname,fnames):
   for name in fnames:
      fullname = dirname + os.sep + name
      sizepy(count,fullname)
      
C = Counter()
os.path.walk("opt",accumsizes,C)
print C.total
    
 


#def readFile1():
#    myFile = open('IMG_1.ppm', 'r')
#    for line in myFile:
#        print(line.strip())
#        
#    myFile.close()
    
#readFile1()

#def readFiles():
#    for('IMG_'+str(range(8))+'.ppm'):
#        myFile = open('
    

#def writeFile1():
#    fileName = ('IMG_FINAL.ppm')
#    message = (readFile1())
#    
#    myFile = open(fileName, 'w')
#    print (message, file = myFile)
    
#    myFile.close()
    
#writeFile1()

#def median(lst):
#    '''Median of a list of numbers'''
#    lstSorted = sorted(lst)
#    
#    if len(lstSorted) % 2 == 1:
#        # odd length
#        return lstSorted[len(lstSorted) // 2]
    
#    else:
#        # even length
#        indexA = len(lstSorted) // 2
#        indexB = indexA - 1
#        return (lstSorted[indexA] + lstSorted[indexB]) / 2

    
#def getQuakeData1():
#    quakeData = open('quakeData.txt', 'r')
#    quakes = []
#    for line in quakeData:
#        data = int(line.split()[2])
#        quakes.append(data) 
#    
#    quakeData.close()
#    return quakes

#def getQuakeData2():
#    quakeData = open('quakeData.txt', 'r')
#    quakes = [int(line.split()[2]) for line in quakeData]
#    quakeData.close()
#    return quakes
