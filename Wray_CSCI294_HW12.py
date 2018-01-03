import urllib.request
res = urllib.request.urlopen('http://cis4.sau.edu/lillis/jazz.html')
PageFile = open("JazzHands.txt",'w')
a = 1
for line in res:
    if type(line) == bytes:
        line = line.decode() # convert from binary to a string
        if "<h1>" in line.rstrip():
            s = "{}\n".format(line)
            PageFile.write("1 "+ str(s[4:]))
        elif "<h2>" in line:
            s = "{}\n".format(line)
            PageFile.write((" ")*4+"1."+str(a)+" "+str(s[4:]))
            a = a+1
            b = 1
        elif "<h3>" in line:
            s = "{}\n".format(line)
            PageFile.write((" ")*8+"1."+str(a-1)+"."+str(b)+" "+str(s[4:]))
            b = b+1
            c = 1
        elif "<h4>" in line:
            s = "{}\n".format(line)
            PageFile.write((" ")*12+"1."+str(a-1)+"."+str(b-1)+"."+str(c)+" "+str(s[4:]))
            c = c+1
            d = 1
        elif "<h5>" in line:
            s = "{}\n".format(line)
            PageFile.write((" ")*16+"1."+str(a)+"."+str(b-1)+"."+str(c-1)+"."+str(d)+" "+str(s[4:]))
            d = d+1
            e = 1
        elif "<h6>" in line:
            s = "{}\n".format(line)
            PageFile.write((" ")*20+"1."+str(a-1)+"."+str(b-1)+"."+str(c-1)+"."+str(d-1)+"."+str(e)+" "+str(s[4:]))
            e = e+1

PageFile.close()


    #print(line.rstrip()) # remove end of line char

    
# read a particular line from a file. User provides both the line
# number and the file name

#fileName = input("Open what file: ")
#lineNum = input("Which line (integer): ")

#try:
#    inFile = open(fileName)   # potential user error
#    findLine = int(lineNum)   # potential user error
#    lineCount = 1
    
#    for line in inFile:
#        if lineCount == findLine:
#            print("Line {} of file {} is {}".format(findLine, fileName, line))
#            break
#        lineCount += 1

#    else: # Yes, Python has a for-else structure
        # get here if line sought doesn't exist
#        print("Line {} of file {} not found".format(findLine, fileName))
        
#    inFile.close()

#except IOError:
#    print("The file", fileName, "doesn't exist.")

#except ValueError:
#    print("Line", lineNum, "isn't a legal line number.")

#print("End of the program")